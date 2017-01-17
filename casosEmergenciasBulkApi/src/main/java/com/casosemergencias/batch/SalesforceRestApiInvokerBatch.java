package com.casosemergencias.batch;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.batch.util.BatchObjectsMapper;
import com.casosemergencias.dao.HistoricBatchDAO;
import com.casosemergencias.logic.BatchService;
import com.casosemergencias.util.constants.ConstantesBulkApi;
import com.sforce.async.AsyncApiException;
import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

@Resource
public class SalesforceRestApiInvokerBatch {
	@Autowired
	BatchService batchService;

	@Autowired
	HistoricBatchDAO historicBatchDao;

	static PartnerConnection connection;
	final static BatchObjectsMapper OBJECTS_MAPPER = new BatchObjectsMapper();
	final static Logger LOGGER = Logger.getLogger(SalesforceRestApiInvokerBatch.class);

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
// 			BulkApiInfoContainerBatch containerList = null;
			if (OBJECTS_MAPPER.getObjectSelectsMap() != null && !OBJECTS_MAPPER.getObjectSelectsMap().isEmpty()) {
				//1. Se realiza el login contra Salesforce Bulk API.
				salesforceRestApiLogin();
				queryAllRecords(ConstantesBulkApi.ENTITY_CONTACT, ConstantesBulkApi.ENTITY_CONTACT_SELECT, processStartDate, processEndDate);
				
				//2. Se recorre el mapa de objetos para realizar las llamadas al API.
//				Iterator<Entry<String, String>> objectsIterator = OBJECTS_MAPPER.getObjectSelectsMap().entrySet().iterator();
//				while (objectsIterator.hasNext()) {
//					Entry<String, String> object = objectsIterator.next();
					//3. Para cada objeto, deben obtenerse los que se deben actualizar desde Salesforce a Heroku
//					queryAllRecords(object.getKey(), object.getValue(), processStartDate, processEndDate);
					
//					//4. Se envia el objeto al DAO para tratar la lista
//					if (containerList != null) {
//						if (containerList.getTotalObjects() > 0) {
//							batchService.updateHerokuObjectsFromBulkApi(object.getKey(), containerList);
//						} else {
//							LOGGER.info("No hay registros que actualizar para el objeto '" + object.getKey() + "'");
//						}
//					} else {
//						LOGGER.error("No hay datos de registros a cargar. No se realiza ninguna accion en base de datos");
//					}	
//				}
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
	private void salesforceRestApiLogin() throws ConnectionException, AsyncApiException {
		LOGGER.trace("Entrando en salesforceBulkApiLogin para realizar la conexion con Bulk API");
		ConnectorConfig connectionConfig = new ConnectorConfig();
		connectionConfig.setUsername(ConstantesBulkApi.BULK_API_LOGIN_USER);
		connectionConfig.setPassword(ConstantesBulkApi.BULK_API_LOGIN_PASS + ConstantesBulkApi.BULK_API_LOGIN_TOKEN);
		connectionConfig.setAuthEndpoint(ConstantesBulkApi.BULK_API_AUTH_ENDPOINT_URL + ConstantesBulkApi.API_VERSION);
		connectionConfig.setTraceMessage(true);
		connection = Connector.newConnection(connectionConfig);
		LOGGER.info("Conexion realizada correctamente");
		System.out.println("Auth EndPoint: "+connectionConfig.getAuthEndpoint());
		System.out.println("Service EndPoint: "+connectionConfig.getServiceEndpoint());
		System.out.println("Username: "+connectionConfig.getUsername());
		System.out.println("SessionId: "+connectionConfig.getSessionId());
	}
	
	public void queryAllRecords(String entityName, String selectQueryFragment, Date startDate, Date endDate) throws ConnectionException {
		connection.setQueryOptions(250);
		try {
			StringBuilder completeQuery = new StringBuilder("");
			completeQuery.append(selectQueryFragment);
			completeQuery.append(ConstantesBulkApi.ALL_ENTITIES_FROM_CLAUSE);
			completeQuery.append(entityName);
			completeQuery.append(ConstantesBulkApi.ALL_ENTITIES_BASIC_WHERE_CLAUSE);
 			completeQuery.append("AND (").append(ConstantesBulkApi.OBJECT_LAST_MODIFIED_DATE_WHERE_CLAUSE);
// 			completeQuery.append(" >= ").append(Utils.parseDateToString(startDate));
 			completeQuery.append(" >= ").append("2017-01-01T00:00:00Z");
			completeQuery.append(" AND ").append(ConstantesBulkApi.OBJECT_LAST_MODIFIED_DATE_WHERE_CLAUSE);
//			completeQuery.append(" <= ").append(Utils.parseDateToString(endDate)).append(")");
			completeQuery.append(" <= ").append("2017-01-16T00:00:00Z").append(")");
			LOGGER.debug("Consulta a realizar: " + completeQuery);
			
//			SessionHeader_element sessionHeader = new SessionHeader_element();
//			CallOptions_element callOptions = new CallOptions_element();
//			QueryOptions_element queryOptions = new QueryOptions_element();
						
			QueryResult queryResult = connection.queryAll(completeQuery.toString());
			
			boolean done = false;
			if (queryResult.getSize() > 0) {
				LOGGER.debug("Total registros visualizados (eliminados incluidos) " + queryResult.getSize());
				while (!done) {
					SObject[] records = queryResult.getRecords();
//					for (int i = 0; i < records.length; i++) {
					for (SObject record : records) {
						LOGGER.info("Entidad recuperada" + record.getType());
//						boolean isDel = record.getIsDeleted();
//						System.out.println("Account " + (i + 1) + ": " + account.getName() + " isDeleted = " + account.getIsDeleted());
					}
					if (queryResult.isDone()) {
						done = true;
					} else {
						queryResult = connection.queryMore(queryResult.getQueryLocator());
					}
				}
			} else {
				System.out.println("No records found.");
			}
		} catch (Exception ce) {
			ce.printStackTrace();
		}
		connection.logout();
	}
}