package com.casosemergencias.util.constants;

public class ConstantesBatch {
	/** Nombres de campos de la peticion a SalesForce. */
	public static final String SF_GRANT_TYPE_PARAMETER = "grant_type";
	public static final String SF_CLIENT_ID_PARAMETER = "client_id";
	public static final String SF_CLIENT_SECRET_PARAMETER = "client_secret";
	public static final String SF_REDIRECT_URI_PARAMETER = "redirect_uri";
	public static final String SF_USER_NAME_PARAMETER = "username";
	public static final String SF_PASSWORD_PARAMETER = "password";
	public static final String SF_ACCESS_TOKEN_PARAMETER = "access_token";
	public static final String SF_INSTANCE_URL_PARAMETER = "instance_url";
	
	/** Valores de los campos para el login con SalesForce DESA. */
	/*public static final String SF_CLIENT_ID_VALUE = "3MVG9jfQT7vUue.G57q9YxkeioLB1AE02bGctQ09wjCAcxfXK1OFwgt1YXFGm8HdTaXvIRCmF1pG259r4SsTz";
	public static final String SF_CLIENT_SECRET_VALUE = "4907478524393614560";
	public static final String SF_USER_NAME_VALUE = "herokuintegracion@enellatam.com.emerchdev";
	public static final String SF_PASSWORD_VALUE = "Del*Alvaro16";
	public static final String SF_USER_TOKEN_VALUE = "ZHmyxlWZa8Hfkjga1jCYiXsA";
	public static final String SF_GRANT_TYPE_VALUE = "password";
	public static final String SF_AUTH_URI_VALUE = "https://test.salesforce.com/services/oauth2/token";
	public static final String SF_REDIRECT_URI_VALUE = "https://localhost:8443/_callback";*/
	
	/** Valores de los campos para el login con SalesForce PROD. */
	public static final String SF_CLIENT_ID_VALUE = "3MVG9jfQT7vUue.G57q9YxkeioLB1AE02bGctQ09wjCAcxfXK1OFwgt1YXFGm8HdTaXvIRCmF1pG259r4SsTz";
	public static final String SF_CLIENT_SECRET_VALUE = "4907478524393614560";
	public static final String SF_USER_NAME_VALUE = "emergencias_heroku@enellatam.com";
	public static final String SF_PASSWORD_VALUE = "deloitteEnelPeruHeroku2";
	public static final String SF_USER_TOKEN_VALUE = " m9cZKmmUvcRR2AiGEfqfnnF1";
	public static final String SF_GRANT_TYPE_VALUE = "password";
	public static final String SF_AUTH_URI_VALUE = "https://login.salesforce.com/services/oauth2/token";
	public static final String SF_REDIRECT_URI_VALUE = "https://localhost:8443/_callback";
	
	/** Valores de propiedades para recuperar Picklists desde SalesForce. */
	public static final String PICKLIST_PROPERTIES_ARCHIVE_NAME = "picklist.properties";
	public static final String PICKLIST_PROPERTIES_INVOLVED_PICKLISTS_PROPERTY = "pickList.implicados";
	public static final String FIELD_LABEL_PROPERTIES_ARCHIVE_NAME = "fieldlabel.properties";
	public static final String FIELD_LABEL_PROPERTIES_INVOLVED_OBJECTS_PROPERTY = "fieldLabel.implicados";
	
	/** Datos de conexión a la base de datos de Heroku. 
	LAs tenemos que recuperar de las variables de entorno
	
	public static final String HEROKU_DATABASE_URL = "jdbc:postgresql://localhost:5432/";
	public static final String HEROKU_DATABASE_SID = "enel";
	public static final String HEROKU_DATABASE_USER_NAME = "postgres";
	public static final String HEROKU_DATABASE_PASSWORD = "deloitte12";*/
	public static final String HEROKU_DATABASE_DRIVER_CLASS = "org.postgresql.Driver";
	
	/**Util batch*/
	public static final String UTIL_TYPE_REFERENCE = "reference";
	public static final String UTIL_FIELD_OWNER = "owner";
	
	/** Valores de tipos de operaciones para HistoricBatch. */
	public static final String BATCH_MAIN_PROCESS = "BATCH_MAIN_PROCESS";
	public static final String OBJECT_LOADING = "OBJECT_LOADING_PROCESS";
	public static final String API_QUERY_PROCESS = "API_QUERY_PROCESS";
	public static final String API_RESPONSE_PARSE_PROCESS = "API_RESPONSE_PARSE_PROCESS";
	public static final String OBJECT_PROCESS = "ALL_RECORDS_PROCESS";
	public static final String INSERT_PROCESS = "INSERT_ALL_RECORDS_PROCESS";
	public static final String INSERT_RECORD = "INSERT_RECORD_PROCESS";
	public static final String UPDATE_PROCESS = "UPDATE_ALL_RECORDS_PROCESS";
	public static final String UPDATE_RECORD = "UPDATE_RECORD_PROCESS";
	public static final String DELETE_PROCESS = "DELETE_PROCESS";
	public static final String DELETE_RECORD = "DELETE_ALL_RECORDS_RECORD_PROCESS";
	
	/** Valores de tipos de ERROR para HistoricBatch. */
	public static final String ERROR_INSERT_PROCESS = "ERROR_INSERT_PROCESS";
	public static final String ERROR_UPDATE_PROCESS = "ERROR_UPDATE_PROCESS";
	public static final String ERROR_DELETE_PROCESS = "ERROR_DELETE_PROCESS";
	public static final String ERROR_INSERT_PROCESS_EXCEPTION_REFLECTION = "ERROR_INSERT_PROCESS_EXCEPTION_REFLECTION";
	public static final String ERROR_UPDATE_PROCESS_EXCEPTION_REFLECTION = "ERROR_UPDATE_PROCESS_EXCEPTION_REFLECTION";
	public static final String ERROR_DELETE_PROCESS_EXCEPTION_REFLECTION = "ERROR_DELETE_PROCESS_EXCEPTION_REFLECTION";
	public static final String ERROR_INSERT_PROCESS_LIST_NULL = "ERROR_INSERT_PROCESS_LIST_NULL";
	public static final String ERROR_UPDATE_PROCESS_LIST_NULL = "ERROR_UPDATE_PROCESS_LIST_NULL";
	public static final String ERROR_DELETE_PROCESS_LIST_NULL = "ERROR_DELETE_PROCESS_LIST_NULL";
	public static final String ERROR_INSERT_RECORD = "ERROR_INSERT_RECORD";
	public static final String ERROR_UPDATE_RECORD = "ERROR_UPDATE_RECORD";
	public static final String ERROR_DELETE_RECORD = "ERROR_DELETE_RECORD";
	public static final String ERROR_OBJECT_RECORDS_NULL = "OBJECT_RECORDS_LIST_NULL";
	public static final String ERROR_MAIN_PROCESS = "BATCH_MAIN_PROCESS_INTERNAL_ERROR";
	public static final String ERROR_SALESFORCE_NULL_RESPONSE = "SALESFORCE_NULL_RESPONSE";
	public static final String ERROR_SALESFORCE_RESPONSE_STATUS_NO_OK = "SALESFORCE_RESPONSE_STATUS_CODE_";
	public static final String ERROR_SALESFORCE_NULL_USER_SESSION_ID = "SALESFORCE_NULL_USER_SESSION_ID";
	public static final String ERROR_RESPONSE_UNDONE = "SALESFORCE_API_RESPONSE_WITH_RESULT_UNDONE";
	public static final String ERROR_RESPONSE_EMPTY = "SALESFORCE_API_RESPONSE_EMPTY";
	public static final String ERROR_PROCESS_OBJECT = "ERROR_PROCESS_OBJECT";
	public static final String ERROR_PROCESS_OBJECT_NULL_RECORDS = "ERROR_PROCESS_OBJECT_NULL_RECORDS";
	/** Valores de tipos de OBJETOS para HistoricBatch. */
	public static final String OBJECT_ACCOUNT = "ACCOUNT";
	public static final String OBJECT_ASSET = "ASSET";
	public static final String OBJECT_STREET = "STREET";
	public static final String OBJECT_CASE_COMMENT = "CASE_COMMENT";
	public static final String OBJECT_CASE_HISTORY = "CASE_HISTORY";
	public static final String OBJECT_REPEATED_CASES = "REPEATED_CASES";
	public static final String OBJECT_CONTACT = "CONTACT";
	public static final String OBJECT_ADDRESS = "ADDRESS";
	public static final String OBJECT_GROUP = "GROUP";
	public static final String OBJECT_HEROKU_USER = "HEROKU_USER";
	public static final String OBJECT_SERVICE_PRODUCT = "SERVICE_PRODUCT";
	public static final String OBJECT_POINT_OF_DELIVERY = "POINT_OF_DELIVERY";
	public static final String OBJECT_TASK = "TASK";
	public static final String OBJECT_USER = "USER";
		
	/**Valores para el batch Borrado del historico HistoricBatch*/
	public static final int NUM_DIAS_ANTES_DE_BORRADO = 30;
	
	/**Mensaje de cargas batch Bulk Api*/	
	public static final String HEROKU_BULK_API_BATCH_CALL_OK = "Proceso Batch ejecutado correctamente";
	public static final String HEROKU_BULK_REST_API_CALL_ERROR = "Error en la ejecuci&oacuten del proceso Batch";

}