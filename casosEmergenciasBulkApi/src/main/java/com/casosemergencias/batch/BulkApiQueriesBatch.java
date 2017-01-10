package com.casosemergencias.batch;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.casosemergencias.batch.util.BatchObjectsParser;
import com.casosemergencias.dao.vo.AccountVO;
import com.casosemergencias.dao.vo.ContactVO;
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

public class BulkApiQueriesBatch {
	static BulkConnection connection;
	private static final String API_VERSION = "37.0";
	private static final String LOGIN_USER = "herokuintegracion@enellatam.com.emerchdev";
	private static final String LOGIN_PASS = "Del*Alvaro17";
	private static final String LOGIN_TOKEN = "cXAEzrNLD2ZCoOqTfWpez0oP";
	private static final String AUTH_ENDPOINT_URL = "https://test.salesforce.com/services/Soap/u/";
	private static final String API_CONTACT = "Contact";
	private static final String API_ACCOUNT = "Account";

	final static Logger logger = Logger.getLogger(BulkApiQueriesBatch.class);
	
	public static void main(String[] args) throws IOException {
		salesforceBulkApiLogin();
		//List<ContactVO> contacts = getUpdatedContactsLastDay();
		List<AccountVO> accounts = getUpdatedAccountsLastDay();
		//System.out.println("Contactos a actualizar: " + contacts.size());
	}

	/**
	 * Establishes the connection with the Salesforce Bulk API.
	 * 
	 * @throws ConnectionException
	 * @throws AsyncApiException
	 */
	private static void salesforceBulkApiLogin() {
		try {
			System.out.println("Se realiza la conexion con Bulk API");
			ConnectorConfig partnerConfig = new ConnectorConfig();
			partnerConfig.setUsername(LOGIN_USER);
			partnerConfig.setPassword(LOGIN_PASS + LOGIN_TOKEN);
			partnerConfig.setAuthEndpoint(AUTH_ENDPOINT_URL + API_VERSION);
			System.out.println("URL de login: " + AUTH_ENDPOINT_URL + API_VERSION);
			// Creating the connection automatically handles login and stores the session in partnerConfig
			new PartnerConnection(partnerConfig);
			// When PartnerConnection is instantiated, a login is implicitly executed and, if successful,
			// a valid session is stored in the ConnectorConfig instance. Use this key to initialize a BulkConnection
			ConnectorConfig config = new ConnectorConfig();
			config.setSessionId(partnerConfig.getSessionId());
			String soapEndpoint = partnerConfig.getServiceEndpoint();
			String apiEndpoint = soapEndpoint.substring(0, soapEndpoint.indexOf("Soap/")) + "async/" + API_VERSION;
			config.setRestEndpoint(apiEndpoint);
			System.out.println("URL de API: " + apiEndpoint);
			// Cambiar a false solo para debug
			config.setCompression(true);
			// Indica si se tracea la info de la peticion o no
			config.setTraceMessage(true);
			config.setPrettyPrintXml(true);
			connection = new BulkConnection(config);
			System.out.println("Login realizado correctamente");
		} catch (ConnectionException | AsyncApiException exception) {
			//logger.error("Exception realizando la conexión a Salesforce Bulk API: ", exception.getMessage());
			System.out.println("Exception realizando la conexión a Salesforce Bulk API: " + exception.getMessage());
		}
	}

	public static List<ContactVO> getUpdatedContactsLastDay() {
		List<ContactVO> contactsList = null;
		try {
			JobInfo job = new JobInfo();
			job.setObject(API_CONTACT);
			job.setOperation(OperationEnum.query);
			job.setConcurrencyMode(ConcurrencyMode.Parallel);
			job.setContentType(ContentType.XML);
			job = connection.createJob(job);
			if (job.getId() != null) {
				job = connection.getJobStatus(job.getId());
				
				String query = "SELECT Id, Name, SecondaryPhone__c, Birthdate FROM " + API_CONTACT;
				System.out.println("Se realiza la consulta: " + query);
				Calendar time = Calendar.getInstance();
				System.out.println("Query started on object " + API_CONTACT + " at time: " + time.get(Calendar.HOUR_OF_DAY) + ":"
						+ time.get(Calendar.MINUTE) + ":" + time.getGreatestMinimum(Calendar.SECOND) + ".");

				BatchInfo info = null;
				ByteArrayInputStream bout = new ByteArrayInputStream(query.getBytes());
				info = connection.createBatchFromStream(job, bout);
				String[] queryResults = null;
				
				for (int i = 0; i < 10000; i++) {
					info = connection.getBatchInfo(job.getId(), info.getId());
					if (info.getState() == BatchStateEnum.Completed) {
				        QueryResultList list = connection.getQueryResultList(job.getId(), info.getId());
				        queryResults = list.getResult();
				        break;
				      } else if (info.getState() == BatchStateEnum.Failed) {
				        System.out.println("-------------- failed ----------" + info);
				        break;
				      } else {
				        System.out.println("-------------- waiting ----------" + info);
				      }
				}
				
				if (queryResults != null) {
					for (String resultId : queryResults) {
						BatchObjectsParser objectsParser = new BatchObjectsParser();
						contactsList = objectsParser.convertApiBatchResultIntoList(connection.getQueryResultStream(job.getId(), info.getId(), resultId));
						//connection.getQueryResultStream(job.getId(), info.getId(), resultId);
				    }
					// notify user of job complete
					System.out.println("Output complete on object " + API_CONTACT + " at time: " + time.get(Calendar.HOUR_OF_DAY) + ":"
							+ time.get(Calendar.MINUTE) + ":" + time.getGreatestMinimum(Calendar.SECOND) + ", processung results.");
					// return number of records complete for data check and close job
					int out = info.getNumberRecordsProcessed();
					System.out.println("Records processed: " + out);
					connection.closeJob(job.getId());
				}
			} else {
				System.out.println("No se ha devuelto Id de Job. No se pueden obtener datos");
			}
		//} catch (AsyncApiException exception) {
		} catch (AsyncApiException | ParserConfigurationException | SAXException | IOException exception) {
			//logger.error("Exception obteniendo los datos del objeto " + API_OBJECT + " de Salesforce Bulk API: ", exception.getMessage());
			System.out.println("Exception obteniendo los datos del objeto " + API_CONTACT + " de Salesforce Bulk API: " + exception.getMessage());
			exception.printStackTrace();
		}
		return contactsList;
	}
	
	
	public static List<AccountVO> getUpdatedAccountsLastDay() {
		List<AccountVO> accountsList = null;
		try {
			JobInfo job = new JobInfo();
			job.setObject(API_ACCOUNT);
			job.setOperation(OperationEnum.query);
			job.setConcurrencyMode(ConcurrencyMode.Parallel);
			job.setContentType(ContentType.XML);
			job = connection.createJob(job);
			if (job.getId() != null) {
				job = connection.getJobStatus(job.getId());
				
				String query = "SELECT Id, Name, SecondaryPhone__c FROM " + API_ACCOUNT;
				System.out.println("Se realiza la consulta: " + query);
				Calendar time = Calendar.getInstance();
				System.out.println("Query started on object " + API_ACCOUNT + " at time: " + time.get(Calendar.HOUR_OF_DAY) + ":"
						+ time.get(Calendar.MINUTE) + ":" + time.getGreatestMinimum(Calendar.SECOND) + ".");

				BatchInfo info = null;
				ByteArrayInputStream bout = new ByteArrayInputStream(query.getBytes());
				info = connection.createBatchFromStream(job, bout);
				String[] queryResults = null;
				
				for (int i = 0; i < 10000; i++) {
					info = connection.getBatchInfo(job.getId(), info.getId());
					if (info.getState() == BatchStateEnum.Completed) {
				        QueryResultList list = connection.getQueryResultList(job.getId(), info.getId());
				        queryResults = list.getResult();
				        break;
				      } else if (info.getState() == BatchStateEnum.Failed) {
				        System.out.println("-------------- failed ----------" + info);
				        break;
				      } else {
				        System.out.println("-------------- waiting ----------" + info);
				      }
				}
				
				if (queryResults != null) {
					for (String resultId : queryResults) {
						BatchObjectsParser objectsParser = new BatchObjectsParser();
						accountsList = objectsParser.convertApiBatchResultIntoList1(connection.getQueryResultStream(job.getId(), info.getId(), resultId));
						//connection.getQueryResultStream(job.getId(), info.getId(), resultId);
				    }
					// notify user of job complete
					System.out.println("Output complete on object " + API_ACCOUNT + " at time: " + time.get(Calendar.HOUR_OF_DAY) + ":"
							+ time.get(Calendar.MINUTE) + ":" + time.getGreatestMinimum(Calendar.SECOND) + ", processung results.");
					// return number of records complete for data check and close job
					int out = info.getNumberRecordsProcessed();
					System.out.println("Records processed: " + out);
					connection.closeJob(job.getId());
				}
			} else {
				System.out.println("No se ha devuelto Id de Job. No se pueden obtener datos");
			}
		//} catch (AsyncApiException exception) {
		} catch (AsyncApiException | ParserConfigurationException | SAXException | IOException exception) {
			//logger.error("Exception obteniendo los datos del objeto " + API_OBJECT + " de Salesforce Bulk API: ", exception.getMessage());
			System.out.println("Exception obteniendo los datos del objeto " + API_ACCOUNT + " de Salesforce Bulk API: " + exception.getMessage());
			exception.printStackTrace();
		}
		return accountsList;
	}
	
}