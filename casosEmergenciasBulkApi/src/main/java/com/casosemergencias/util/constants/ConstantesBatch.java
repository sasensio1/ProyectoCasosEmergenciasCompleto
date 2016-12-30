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
	
	/** Valores de los campos para el login con SalesForce. */
	public static final String SF_CLIENT_ID_VALUE = "3MVG9jfQT7vUue.G57q9YxkeioLB1AE02bGctQ09wjCAcxfXK1OFwgt1YXFGm8HdTaXvIRCmF1pG259r4SsTz";
	public static final String SF_CLIENT_SECRET_VALUE = "4907478524393614560";
	public static final String SF_USER_NAME_VALUE = "herokuintegracion@enellatam.com.emerchdev";
	public static final String SF_PASSWORD_VALUE = "Del*Alvaro16";
	public static final String SF_USER_TOKEN_VALUE = "ZHmyxlWZa8Hfkjga1jCYiXsA";
	public static final String SF_GRANT_TYPE_VALUE = "password";
	public static final String SF_AUTH_URI_VALUE = "https://test.salesforce.com/services/oauth2/token";
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
	
}