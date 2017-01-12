package com.casosemergencias.batch;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;
import com.casosemergencias.batch.util.BatchObjectsMapper;
import com.casosemergencias.batch.util.BatchObjectsParser;
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

@Resource
public class BulkApiQueriesBatch {
	@Autowired
	BatchService batchService;
	
	static BulkConnection connection;
	final static BatchObjectsMapper OBJECTS_MAPPER = new BatchObjectsMapper();
	final static Logger LOGGER = Logger.getLogger(BulkApiQueriesBatch.class);
	
	public static void main(String[] args) {
		Date today = new Date();
		Date tomorrow = Utils.substractDaysToDate(today, 1);
		BulkApiQueriesBatch batch = new BulkApiQueriesBatch();
		batch.getAllBulkApiInfo(tomorrow, today);
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
		try {
			List<BulkApiInfoContainerBatch> containerList = null;
			if (OBJECTS_MAPPER.getObjectSelectsMap() != null && !OBJECTS_MAPPER.getObjectSelectsMap().isEmpty()) {
				//1. Se realiza el login contra Salesforce Bulk API.
				salesforceBulkApiLogin();
				
				//2. Se recorre el mapa de objetos para realizar las llamadas al API.
				Iterator<Entry<String, String>> objectsIterator = OBJECTS_MAPPER.getObjectSelectsMap().entrySet().iterator();
				while (objectsIterator.hasNext()) {
					Entry<String, String> object = objectsIterator.next();
					//3. Para cada objeto, deben obtenerse los que se deben actualizar desde Salesforce a Heroku
					
//					Calendar time = Calendar.getInstance();
//					System.out.println("Query started on object " + entityName + " at time: " + time.get(Calendar.HOUR_OF_DAY) + ":"
//							+ time.get(Calendar.MINUTE) + ":" + time.getGreatestMinimum(Calendar.SECOND) + ".");
					containerList = getSalesforceObjectsToUpdate(object.getKey(), object.getValue(), processStartDate, processEndDate);
//					System.out.println("Output complete on object " + entityName + " at time: " + time.get(Calendar.HOUR_OF_DAY) + ":"
//							+ time.get(Calendar.MINUTE) + ":" + time.getGreatestMinimum(Calendar.SECOND) + ", processung results.");
					
					//4. Enviar el objeto al DAO para tratar la lista
					batchService.updateHerokuObjectsFromBulkApi(object.getKey(), containerList);
				}
			} else {
				LOGGER.error("No hay datos de objetos a cargar. No se realiza ninguna llamada");
			}
		} catch (Exception exception) {
			LOGGER.error("Error realizando la carga de datos desde Bulk API: ", exception);
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
	private void salesforceBulkApiLogin() throws ConnectionException, AsyncApiException {
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
		// Indica si se tracea la info de la peticion o no
		// TODO: MARCAR A FALSE CUANDO SE HAYA COMPLETADO EL DESARROLLO. SACA DEMASIADO LOG
		config.setTraceMessage(true);
		config.setPrettyPrintXml(true);
		connection = new BulkConnection(config);
		LOGGER.info("Conexion realizada correctamente");
	}
	
	public List<BulkApiInfoContainerBatch> getSalesforceObjectsToUpdate(String entityName, String selectQueryFragment, Date startDate,
			Date endDate) throws AsyncApiException, ParserConfigurationException, SAXException, IOException, InterruptedException {
		LOGGER.trace("Entrando en getSalesforceObjectsToUpdate. Objeto a comprobar: " + entityName);
		
		BatchObjectsParser objectsParser = new BatchObjectsParser();
		List<BulkApiInfoContainerBatch> bulkApiContainer = null;
		BatchInfo info = null;
		String[] queryResults = null;
		JobInfo job = new JobInfo();
		try {
			job.setObject(entityName);
			job.setOperation(OperationEnum.query);
			job.setConcurrencyMode(ConcurrencyMode.Serial);
			job.setContentType(ContentType.XML);
			job = connection.createJob(job);
			if (job.getId() != null) {
				job = connection.getJobStatus(job.getId());
				
				//TODO: Construir la consulta en base a la select, el objeto (from) y la condicion de fechas (where).
				// --------------------------------------------------------
				StringBuilder completeQuery = new StringBuilder("");
				completeQuery.append(selectQueryFragment);
				completeQuery.append(ConstantesBulkApi.ALL_ENTITIES_FROM_CLAUSE);
				completeQuery.append(entityName);
				//completeQuery.append(ConstantesBulkApi.ALL_ENTITIES_WHERE_CLAUSE);
				LOGGER.debug("Consulta a realizar: " + completeQuery);
				// --------------------------------------------------------
				
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
				LOGGER.error("No se ha devuelto Id. de Job. No se pueden obtener los datos del objeto " + entityName);
			}
		} catch (Exception exception) {
			LOGGER.error("Error obteniendo los datos del objeto " + entityName, exception);
		}
		return bulkApiContainer;
	}
}