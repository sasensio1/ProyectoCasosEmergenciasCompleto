package com.casosemergencias.batch;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
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
	@Autowired
	BatchService batchService;

	@Autowired
	HistoricBatchDAO historicBatchDao;

	@Autowired
	SalesforceLoginChecker salesforceLoginChecker;
	
	static PartnerConnection connection;
	//FIXME: Añadir con autowired
	final static BatchObjectsMapper OBJECTS_MAPPER = new BatchObjectsMapper();
	final static Logger LOGGER = Logger.getLogger(SalesforceRestApiInvokerBatch.class);

	//FIXME: Quitar una vez probado para cambiar a llamada por Quartz
	public static void main(String[] args) {
		SalesforceRestApiInvokerBatch invoker = new SalesforceRestApiInvokerBatch();
		Date today = new Date();
		Date yesterday = Utils.substractDaysToDate(today, 30);
		invoker.getAllBulkApiInfo(today, yesterday);
	}
	
	/**
	 * Gets all objects to update in Heroku from the Salesforce Bulk API,
	 * between the given starting and ending dates.
	 * 
	 * @param processStartDate
	 *            Starting date to search the updated objects.
	 * @param processEndDate
	 *            Ending date to search the updated objects.
	 */
	public void getAllBulkApiInfo(Date processStartDate, Date processEndDate) {
		LOGGER.trace("Entrando en getAllBulkApiInfo para obtener los registros actualizados en Salesforce");
		LOGGER.info("Búsqueda desde " + processStartDate);
		LOGGER.info("Búsqueda hasta " + processEndDate);
		try {
 			BulkApiInfoContainerBatch containerList = null;
			if (OBJECTS_MAPPER.getObjectSelectsMap() != null && !OBJECTS_MAPPER.getObjectSelectsMap().isEmpty()) {
				//1. Se realiza el login contra Salesforce REST API.
				//FIXME: Cambiar al loginChecker cuando se acaben las pruebas iniciales
				UserSessionInfo userInfo = new UserSessionInfo();
				userInfo.setUsername(ConstantesBulkApi.BULK_API_LOGIN_USER);
				userInfo.setPassword(ConstantesBulkApi.BULK_API_LOGIN_PASS);
				userInfo.setAccessToken(ConstantesBulkApi.BULK_API_LOGIN_TOKEN);
				salesforceLogin(userInfo);
				
				//2. Se recorre el mapa de objetos para realizar las llamadas al API.
				Iterator<Entry<String, String>> objectsIterator = OBJECTS_MAPPER.getObjectSelectsMap().entrySet().iterator();
				while (objectsIterator.hasNext()) {
					Entry<String, String> object = objectsIterator.next();
					//3. Para cada objeto, deben obtenerse los que se deben actualizar desde Salesforce a Heroku
					containerList = getAllRecordsFromRestApi(object.getKey(), object.getValue(), processStartDate, processEndDate, userInfo);
					
					//4. Se envia el objeto al DAO para tratar la lista
					if (containerList != null) {
						if (containerList.getTotalRecords() > 0) {
							LOGGER.info("Recuperados " + containerList.getTotalRecords() + " registros del objeto " + object.getKey());
							//batchService.updateHerokuObjectsFromBulkApi(object.getKey(), containerList);
						} else {
							LOGGER.info("No hay registros que actualizar para el objeto '" + object.getKey() + "'");
						}
					} else {
						LOGGER.error("No hay datos de registros a cargar. No se realiza ninguna accion en base de datos");
					}	
				}
			} else {
				LOGGER.error("No hay datos de registros a cargar. No se realiza ninguna llamada");
			}
		} catch (Exception exception) {
			LOGGER.error("Error realizando la carga de registros desde Bulk API: ", exception);
		}
	}
	
	//FIXME: Quitar y llamar al loginChecker
	public void salesforceLogin(UserSessionInfo userSessionInfo) throws JSONException, HttpException, IOException {
		LOGGER.trace("Entrando a salesforceLogin() para hacer el login contra SalesForce");
		
		String tokenRequestUri = ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_LOGIN_URI + ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_TOKEN_PATH_URI; 
		org.apache.commons.httpclient.HttpClient httpclient = new org.apache.commons.httpclient.HttpClient();
		PostMethod post = new PostMethod(tokenRequestUri);
		
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_GRANT_TYPE_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_GRANT_TYPE_VALUE);
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_ID_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_ID_VALUE);
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_SECRET_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_SECRET_VALUE);
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_USER_NAME_KEY, userSessionInfo.getUsername());
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_USER_PASS_KEY, userSessionInfo.getPassword() + userSessionInfo.getAccessToken());
		
//		LOGGER.info("Intento de llamada POST al servicio " + tokenRequestUri + " para obtener el sessionId del usuario");
//		LOGGER.info("Petición: " + post.getRequestEntity());
			
		httpclient.executeMethod(post);
		
		InputStreamReader inputStreamReader = new InputStreamReader(post.getResponseBodyAsStream());
		JSONTokener jsonTokener = new JSONTokener(inputStreamReader);
		JSONObject authResponse = new JSONObject(jsonTokener);
//		LOGGER.info("Respuesta: " + authResponse.toString(2));
		Date currentDate = new Date();
		userSessionInfo.setSessionId(authResponse.getString(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_ACCESS_TOKEN_KEY));
		userSessionInfo.setLastConnection(currentDate);
		
//		LOGGER.info("Id de sesión: " + userSessionInfo.getSessionId());
//		LOGGER.info("Hora de conexión: " + userSessionInfo.getLastConnection());
		LOGGER.trace("Login completado");
		post.releaseConnection();
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
	private static BulkApiInfoContainerBatch getAllRecordsFromRestApi(String entityName, String selectQueryFragment, Date startDate, Date endDate, UserSessionInfo userInfo) throws Exception {
		LOGGER.trace("Entrando en getAllRecordsFromRestApi para obtener los registros del objeto " + entityName);
		//FIXME: Añadir con autowired
		BatchObjectsParser objectsParser = new BatchObjectsParser();
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
					//TODO: QUITAR ESTA TRAZA CUANDO TERMINEN LAS PRUEBAS INICIALES
					//LOGGER.info("Respuesta: " + entityResponse);
					bulkApiContainer = objectsParser.populateObjectListFromJsonObject(entityResponse, OBJECTS_MAPPER);
				} else {
					LOGGER.error("Datos de la respuesta vacios. No es posible actualizar el objeto");
				}
			} else {
				LOGGER.info("Error en la peticion. Status: " + response.getStatusLine());
			}
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
	//TODO: Descomentar líneas una vez se terminen las pruebas
	private static String buildSoqlQuery(String entityName, String selectQueryFragment, Date startDate, Date endDate) {
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
// 		completeQuery.append(" >= ").append(Utils.parseDateToString(startDate));
		completeQuery.append(" >= ").append("2017-01-01T00:00:00Z");
		if (ConstantesBulkApi.ENTITY_CASE_HISTORY.equals(entityName)) {
			completeQuery.append(" AND ").append(ConstantesBulkApi.OBJECT_CREATED_DATE_WHERE_CLAUSE);
		} else {
			completeQuery.append(" AND ").append(ConstantesBulkApi.OBJECT_LAST_MODIFIED_DATE_WHERE_CLAUSE);
		}
//		completeQuery.append(" <= ").append(Utils.parseDateToString(endDate)).append(")");
		completeQuery.append(" <= ").append("2017-01-31T23:59:59Z").append(")");
		LOGGER.debug("Consulta a realizar: " + completeQuery);
		return completeQuery.toString();
	}
}