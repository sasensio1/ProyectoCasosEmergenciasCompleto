package com.casosemergencias.batch;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;
import com.casosemergencias.batch.util.BatchObjectsMapper;
import com.casosemergencias.batch.util.BatchObjectsParser;
import com.casosemergencias.dao.HistoricBatchDAO;
import com.casosemergencias.logic.BatchService;
import com.casosemergencias.util.Utils;
import com.casosemergencias.util.constants.ConstantesBulkApi;
import com.sforce.async.AsyncApiException;
import com.sforce.async.BatchInfo;
import com.sforce.async.BatchStateEnum;
import com.sforce.async.BulkConnection;
import com.sforce.async.ConcurrencyMode;
import com.sforce.async.ContentType;
import com.sforce.async.JobInfo;
import com.sforce.async.OperationEnum;
import com.sforce.async.QueryResultList;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SalesforceSoapBulkApiInvokerBatch {
	@Autowired
	BatchService batchService;
	
	@Autowired
	HistoricBatchDAO historicBatchDao;
	
	@Autowired
	BatchObjectsParser objectsParser;
	
	static BulkConnection connection;
	final static BatchObjectsMapper OBJECTS_MAPPER = new BatchObjectsMapper();
	final static Logger LOGGER = Logger.getLogger(SalesforceSoapBulkApiInvokerBatch.class);

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
		try {
 			BulkApiInfoContainerBatch containerList = null;
			if (OBJECTS_MAPPER.getObjectSelectsMap() != null && !OBJECTS_MAPPER.getObjectSelectsMap().isEmpty()) {
				//1. Se realiza el login contra Salesforce Bulk API.
				salesforceBulkApiLogin();
				
				//2. Se recorre el mapa de objetos para realizar las llamadas al API.
				JobInfo job = new JobInfo();
				job.setOperation(OperationEnum.query);
				job.setConcurrencyMode(ConcurrencyMode.Serial);
				job.setContentType(ContentType.XML);
				
				Iterator<Entry<String, String>> objectsIterator = OBJECTS_MAPPER.getObjectSelectsMap().entrySet().iterator();
				while (objectsIterator.hasNext()) {
					Entry<String, String> object = objectsIterator.next();
					//3. Para cada objeto, deben obtenerse los que se deben actualizar desde Salesforce a Heroku
					containerList = getSalesforceObjectsToUpdate(object.getKey(), object.getValue(), processStartDate, processEndDate, job);
					
					//4. Se envia el objeto al DAO para tratar la lista
					if (containerList != null) {
						if (containerList.getTotalRecords() > 0) {
							batchService.updateHerokuObjectsFromBulkApi(object.getKey(), containerList);
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

	/**
	 * Establishes the connection with the Salesforce Bulk API.
	 * 
	 * @throws ConnectionException
	 *             It there is any problem with the connection.
	 * @throws AsyncApiException
	 *             If there is any problem with the API synchronization.
	 */
	private void salesforceBulkApiLogin() throws Exception {
		LOGGER.trace("Entrando en salesforceBulkApiLogin para realizar la conexion con Bulk API");
		ConnectorConfig partnerConfig = new ConnectorConfig();
		partnerConfig.setUsername(ConstantesBulkApi.BULK_API_LOGIN_USER);
		partnerConfig.setPassword(ConstantesBulkApi.BULK_API_LOGIN_PASS + ConstantesBulkApi.BULK_API_LOGIN_TOKEN);
		partnerConfig.setAuthEndpoint(ConstantesBulkApi.BULK_API_AUTH_ENDPOINT_URL + ConstantesBulkApi.API_VERSION);
		// Al crear la conexion automaticamente, se maneja el login y se guarda la sesion en partnerConfig
		new PartnerConnection(partnerConfig);
		// When PartnerConnection is instantiated, a login is implicitly executed and, if successful,
		// a valid session is stored in the ConnectorConfig instance. Use this key to initialize a BulkConnection
		ConnectorConfig config = new ConnectorConfig();
		String soapEndpoint = partnerConfig.getServiceEndpoint();
		String apiEndpoint = soapEndpoint.substring(0, soapEndpoint.indexOf("Soap/")) + "async/" + ConstantesBulkApi.API_VERSION;
		config.setSessionId(partnerConfig.getSessionId());
		config.setRestEndpoint(apiEndpoint);
		config.setCompression(true);
		// Indica si se muestra la info que devuelve Salesforce sobre la peticion
		config.setTraceMessage(false);
		config.setPrettyPrintXml(true);
		connection = new BulkConnection(config);
		LOGGER.info("Conexion realizada correctamente");
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
	 * @param job
	 *            Job to execute in the Salesforce API call.
	 * @return BulkApiInfoContainerBatch All the modified objects to update.
	 * @throws AsyncApiException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public BulkApiInfoContainerBatch getSalesforceObjectsToUpdate(String entityName, String selectQueryFragment, Date startDate, Date endDate, JobInfo job) throws Exception {
		LOGGER.trace("Entrando en getSalesforceObjectsToUpdate. Objeto a tratar: " + entityName);
		BulkApiInfoContainerBatch bulkApiContainer = null;
		BatchInfo info = null;
		String[] queryResults = null;
		try {
			job.setObject(entityName);
			job = connection.createJob(job);
			if (job.getId() != null) {
				job = connection.getJobStatus(job.getId());
				
				StringBuilder completeQuery = new StringBuilder("");
				completeQuery.append(selectQueryFragment);
				completeQuery.append(ConstantesBulkApi.ALL_ENTITIES_FROM_CLAUSE);
				completeQuery.append(entityName);
				completeQuery.append(ConstantesBulkApi.ALL_ENTITIES_BASIC_WHERE_CLAUSE);
				completeQuery.append(" AND (").append(ConstantesBulkApi.OBJECT_LAST_MODIFIED_DATE_WHERE_CLAUSE);
				completeQuery.append(" >= ").append(Utils.parseDateToString(startDate));
				completeQuery.append(" AND ").append(ConstantesBulkApi.OBJECT_LAST_MODIFIED_DATE_WHERE_CLAUSE);
				completeQuery.append(" <= ").append(Utils.parseDateToString(endDate)).append(")");
				LOGGER.debug("Consulta a realizar: " + completeQuery);
				
				ByteArrayInputStream queryInputStream = new ByteArrayInputStream(completeQuery.toString().getBytes());
				info = connection.createBatchFromStream(job, queryInputStream);
				
				for (int i = 0; i < 10000; i++) {
					Thread.sleep(5000);
					info = connection.getBatchInfo(job.getId(), info.getId());
					if (info.getState() == BatchStateEnum.Completed) {
						LOGGER.info("Peticion completada: " + info);
						QueryResultList list = connection.getQueryResultList(job.getId(), info.getId());
				        queryResults = list.getResult();
				        break;
					} else if (info.getState() == BatchStateEnum.Failed) {
						LOGGER.error("Peticion erronea: " + info);
						break;
					} else {
						LOGGER.info("Peticion en espera: " + info);
					}
				}
				
				if (queryResults != null) {
					for (String resultId : queryResults) {
						bulkApiContainer = objectsParser.populateObjectListFromXmlStream(connection.getQueryResultStream(job.getId(), info.getId(), resultId), OBJECTS_MAPPER);
				    }
					connection.closeJob(job.getId());
				}
			} else {
				LOGGER.error("No se ha devuelto Id. de Job. No se pueden obtener los registros del objeto " + entityName);
			}
		} catch (Exception exception) {
			LOGGER.error("Error obteniendo los registros del objeto " + entityName, exception);
		}
		return bulkApiContainer;
	}
}
