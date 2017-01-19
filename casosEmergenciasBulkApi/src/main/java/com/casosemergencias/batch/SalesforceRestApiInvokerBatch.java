package com.casosemergencias.batch;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;
import com.casosemergencias.batch.util.BatchObjectsMapper;
import com.casosemergencias.batch.util.BatchObjectsParser;
import com.casosemergencias.dao.HistoricBatchDAO;
import com.casosemergencias.logic.BatchService;
import com.casosemergencias.logic.sf.util.SalesforceLoginChecker;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.Utils;
import com.casosemergencias.util.constants.ConstantesBulkApi;
import com.casosemergencias.util.constants.ConstantesSalesforceLogin;
import com.sforce.soap.partner.PartnerConnection;

@Resource
public class SalesforceRestApiInvokerBatch {
	final static Logger LOGGER = Logger.getLogger(SalesforceRestApiInvokerBatch.class);
	
	@Autowired
	BatchService batchService;

	@Autowired
	HistoricBatchDAO historicBatchDao;

	@Autowired
	SalesforceLoginChecker salesforceLoginChecker;
	
	@Autowired
	BatchObjectsParser objectsParser;
	
	@Autowired
	BatchObjectsMapper objectsMapper;
	
	static PartnerConnection connection;
	private Date processStartDate;
	private Date processEndDate;
	private String objectName;

	public void updateObjectsWithRestApiInfo() {
		int dateSearchingRange = 0;
		if (processStartDate != null && processEndDate != null) {
			if (processEndDate.before(processStartDate)) {
				LOGGER.error("Fechas incorrectas. La fecha de fin debe ser mayor que la de inicio");
			} else {
				//int dateSearchingRange = (int) ((processEndDate.getTime() - processStartDate.getTime()) / (1000 * 60 * 60 * 24));
				LocalDateTime localStartDateTime = LocalDateTime.ofInstant(processStartDate.toInstant(), ZoneId.of("UTC"));
				LocalDateTime localEndDateTime = LocalDateTime.ofInstant(processEndDate.toInstant(), ZoneId.of("UTC"));
				dateSearchingRange = (int) ChronoUnit.DAYS.between(localStartDateTime, localEndDateTime);
				if (dateSearchingRange <= ConstantesBulkApi.MAX_SEARCHING_DAYS) {
					getBulkApiRecordsInfo(processStartDate, processEndDate, objectName);
				} else {
					LOGGER.error("Error al obtener el rango de fechas. Compruebe que el rango es mayor a 0 o que no supera el maximo");
				}
			}
		} else {
			Date yesterday = Utils.substractDaysToDate(new Date(), 1);
			processStartDate = Utils.setHourInDate(yesterday, 0, 0, 0, 0);
			processEndDate = Utils.setHourInDate(yesterday, 23, 59, 59, 999);
			LOGGER.info("No se han indicado fechas de búsqueda. Se establece el día anterior como fecha por defecto");
			getBulkApiRecordsInfo(processStartDate, processEndDate, objectName);
		}
	}
	
	/**
	 * Gets all r to update in Heroku from the Salesforce Bulk API, between the
	 * given starting and ending dates.
	 * 
	 * @param processStartDate
	 *            Starting date to search the updated objects.
	 * @param processEndDate
	 *            Ending date to search the updated objects.
	 * @param objectName
	 *            Object name to update, if it's only necessary to update one
	 *            object.
	 */
	private void getBulkApiRecordsInfo(Date processStartDate, Date processEndDate, String objectName) {
		LOGGER.trace("Entrando en getAllBulkApiInfo para obtener los registros actualizados en Salesforce");
		LOGGER.info("Búsqueda desde " + processStartDate);
		LOGGER.info("Búsqueda hasta " + processEndDate);
		try {
 			BulkApiInfoContainerBatch containerList = null;
 			UserSessionInfo userInfo = Utils.getUserSessionInfoFromProperties();
			if (!Utils.isNullOrEmptyString(objectName)) {
				//1. Se realiza el login contra Salesforce REST API.
				userInfo = salesforceLoginChecker.getUserSessionInfo(userInfo);
				//2. Se recorre el mapa de objetos para realizar las llamadas al API.
				containerList = getAllRecordsFromRestApi(objectName, objectsMapper.getObjectSelectsMap().get(objectName), processStartDate, processEndDate, userInfo);
				
				//4. Se envia el objeto al DAO para tratar la lista
				insertRecordsInfo(containerList);
			} else if (objectsMapper.getObjectSelectsMap() != null && !objectsMapper.getObjectSelectsMap().isEmpty()) {
				//1. Se realiza el login contra Salesforce REST API.
				userInfo = salesforceLoginChecker.getUserSessionInfo(userInfo);
				
				//2. Se recorre el mapa de objetos para realizar las llamadas al API.
				Iterator<Entry<String, String>> objectsIterator = objectsMapper.getObjectSelectsMap().entrySet().iterator();
				while (objectsIterator.hasNext()) {
					Entry<String, String> object = objectsIterator.next();
					//3. Para cada objeto, deben obtenerse los que se deben actualizar desde Salesforce a Heroku
					if (!ConstantesBulkApi.ENTITY_HEROKU_USER.equals(object.getKey()) && !ConstantesBulkApi.ENTITY_CASE_COMMENT.equals(object.getKey())) {
						//3.1. No se recorren los objetos CaseComment y HerokuUser porque tienen su propio Job programado
						containerList = getAllRecordsFromRestApi(object.getKey(), object.getValue(), processStartDate, processEndDate, userInfo);
						
						//4. Se envia el objeto al DAO para tratar la lista
						insertRecordsInfo(containerList);
					}
				}
			} else {
				LOGGER.error("No hay datos de registros a cargar. No se realiza ninguna llamada");
			}
		} catch (Exception exception) {
			LOGGER.error("Error realizando la carga de registros desde Bulk API: ", exception);
		}
	}

	/**
	 * Sends the info obtained from Salesforce to update the Heroku database.
	 * 
	 * @param containerList
	 *            All object and records info.
	 */
	private void insertRecordsInfo(BulkApiInfoContainerBatch containerList) {
		if (containerList != null) {
			if (containerList.getTotalRecords() > 0) {
				LOGGER.info("Recuperados " + containerList.getTotalRecords() + " registros del objeto " + containerList.getEntityName());
				batchService.updateHerokuObjectsFromBulkApi(containerList);
			} else {
				LOGGER.info("No hay registros que actualizar para el objeto '" + containerList.getEntityName() + "'");
			}
		} else {
			LOGGER.error("No hay datos de registros a cargar. No se realiza ninguna accion en base de datos");
		}
	}
		
	/**
	 * Gets the list of objects to update from the Salesforce API to Heroku.
	 * 
	 * @param entityName
	 *            Entity name to check.
	 * @param selectQueryFragment
	 *            Query to execute.
	 * @param startDate
	 *            Query start date.
	 * @param endDate
	 *            Query end date.
	 * @param userInfo
	 *            Logged user info.
	 * @return BulkApiInfoContainerBatch All the modified object records to
	 *         update.
	 * @throws Exception
	 *             Exception thrown if it has occurred any problem getting the
	 *             information.
	 */
	private BulkApiInfoContainerBatch getAllRecordsFromRestApi(String entityName, String selectQueryFragment, Date startDate, Date endDate, UserSessionInfo userInfo) throws Exception {
		LOGGER.trace("Entrando en getAllRecordsFromRestApi para obtener los registros del objeto " + entityName);
		BulkApiInfoContainerBatch bulkApiContainer = null;
		HttpClient httpClient = null;
		HttpGet get = null;
				
		if (userInfo.getSessionId() != null) {
			String completeQuery = buildSoqlQuery(entityName, selectQueryFragment, startDate, endDate);
			StringBuilder queryAllUrl = new StringBuilder("");
			queryAllUrl.append(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_INSTANCE_URL);
			queryAllUrl.append(ConstantesBulkApi.REST_API_QUERY_ALL_URL);
			queryAllUrl.append("?q=");
			queryAllUrl.append(Utils.parseSqlQueryToUrlQuery(completeQuery.toString()));
			
			URI uri = new URI(queryAllUrl.toString());
			httpClient = HttpClientBuilder.create().build();
			get = new HttpGet(uri);
			get.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_AUTHORIZATION_HEADER_KEY, "Bearer " + userInfo.getSessionId());
			get.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_CONTENT_TYPE_HEADER_KEY, ConstantesSalesforceLogin.DEV_REST_SALESFORCE_JSON_CONTENT_TYPE);
			get.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_ACCEPT_HEADER_KEY, ConstantesSalesforceLogin.DEV_REST_SALESFORCE_JSON_CONTENT_TYPE);
			
			HttpResponse response = httpClient.execute(get);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				LOGGER.info("Respuesta del servidor correcta");
				HttpEntity entity = response.getEntity();
				String entityResponse = EntityUtils.toString(entity);
				if (!Utils.isNullOrEmptyString(entityResponse)) {
					bulkApiContainer = objectsParser.populateObjectListFromJsonObject(entityName, entityResponse, objectsMapper);
				} else {
					LOGGER.error("Datos de la respuesta vacios. No es posible actualizar el objeto");
				}
			} else {
				LOGGER.info("Error en la peticion. Status: " + response.getStatusLine());
			}
			get.releaseConnection();
		}
		return bulkApiContainer;
	}

	/**
	 * Builds the query to call the Salesforce API.
	 * 
	 * @param entityName
	 *            Reference query object.
	 * @param selectQueryFragment
	 *            Select query fragment.
	 * @return String the complete query.
	 */
	private String buildSoqlQuery(String entityName, String selectQueryFragment, Date startDate, Date endDate) {
		StringBuilder completeQuery = new StringBuilder("");
		completeQuery.append(selectQueryFragment);
		completeQuery.append(ConstantesBulkApi.ALL_ENTITIES_FROM_CLAUSE);
		completeQuery.append(entityName);
		
		switch (entityName) {
			case ConstantesBulkApi.ENTITY_ADDRESS:
				completeQuery.append(ConstantesBulkApi.ADDRESS_ENTITY_WHERE_CLAUSE);
				break;
			case ConstantesBulkApi.ENTITY_REPEATED_CASES:
				completeQuery.append(ConstantesBulkApi.WITHOUT_COUNTRY_ENTITIES_WHERE_CLAUSE);
				break;
			case ConstantesBulkApi.ENTITY_GROUP:
				completeQuery.append(ConstantesBulkApi.WITHOUT_COUNTRY_ENTITIES_WHERE_CLAUSE);
				break;
			case ConstantesBulkApi.ENTITY_CASE_COMMENT:
				completeQuery.append(ConstantesBulkApi.CASE_COMMENT_ENTITY_WHERE_CLAUSE);
				break;
			case ConstantesBulkApi.ENTITY_CASE_HISTORY:
				completeQuery.append(ConstantesBulkApi.CASE_HISTORY_ENTITY_WHERE_CLAUSE);
				break;
			case ConstantesBulkApi.ENTITY_TASK:
				completeQuery.append(ConstantesBulkApi.TASK_ENTITY_WHERE_CLAUSE);
				break;
			default:
				completeQuery.append(ConstantesBulkApi.ALL_ENTITIES_BASIC_WHERE_CLAUSE);
				break;
		}
		
		if (ConstantesBulkApi.ENTITY_CASE_HISTORY.equals(entityName)) {
			completeQuery.append("AND (").append(ConstantesBulkApi.OBJECT_CREATED_DATE_WHERE_CLAUSE);
		} else if (ConstantesBulkApi.ENTITY_REPEATED_CASES.equals(entityName) || ConstantesBulkApi.ENTITY_GROUP.equals(entityName)) {
			completeQuery.append(" (").append(ConstantesBulkApi.OBJECT_CREATED_DATE_WHERE_CLAUSE);
		} else {
			completeQuery.append("AND (").append(ConstantesBulkApi.OBJECT_LAST_MODIFIED_DATE_WHERE_CLAUSE);
		}
 		completeQuery.append(" >= ").append(Utils.parseDateToString(startDate));
		if (ConstantesBulkApi.ENTITY_CASE_HISTORY.equals(entityName)) {
			completeQuery.append(" AND ").append(ConstantesBulkApi.OBJECT_CREATED_DATE_WHERE_CLAUSE);
		} else {
			completeQuery.append(" AND ").append(ConstantesBulkApi.OBJECT_LAST_MODIFIED_DATE_WHERE_CLAUSE);
		}
		completeQuery.append(" <= ").append(Utils.parseDateToString(endDate)).append(")");
		LOGGER.debug("Consulta a realizar: " + completeQuery);
		return completeQuery.toString();
	}
	
	public Date getProcessStartDate() {
		return processStartDate;
	}

	public void setProcessStartDate(Date processStartDate) {
		this.processStartDate = processStartDate;
	}

	public Date getProcessEndDate() {
		return processEndDate;
	}

	public void setProcessEndDate(Date processEndDate) {
		this.processEndDate = processEndDate;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
}