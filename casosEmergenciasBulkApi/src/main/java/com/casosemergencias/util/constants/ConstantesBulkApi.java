package com.casosemergencias.util.constants;

public class ConstantesBulkApi {
	/** Constantes de conexión al Bulk API de Salesforce. */
	public static final String BULK_API_LOGIN_USER = "herokuintegracion@enellatam.com.emerchdev";
	public static final String BULK_API_LOGIN_PASS = "Del*Alvaro17";
	public static final String BULK_API_LOGIN_TOKEN = "cXAEzrNLD2ZCoOqTfWpez0oP";
	public static final String BULK_API_AUTH_ENDPOINT_URL = "https://test.salesforce.com/services/Soap/u/";
	public static final String API_VERSION = "37.0";
	
	/** Constantes de entidades a obtener. */
	public static final String ENTITY_ACCOUNT = "Account";
	public static final String ENTITY_ADDRESS = "Address__c";
	public static final String ENTITY_ASSET = "Asset";
	public static final String ENTITY_CASE_COMMENT = "CaseComment";
	public static final String ENTITY_CASE_HISTORY = "CaseHistory";
	public static final String ENTITY_CONTACT = "Contact";
	public static final String ENTITY_GROUP = "Group";
	public static final String ENTITY_HEROKU_USER = "HerokuUser__c";
	public static final String ENTITY_POINT_OF_DELIVERY = "PointofDelivery__c";
	public static final String ENTITY_REPEATED_CASES = "RepeatedCases__c";
	public static final String ENTITY_SERVICE_PRODUCT = "ServiceProduct__c";
	public static final String ENTITY_STREET = "Street__c";
	public static final String ENTITY_TASK = "Task";
	public static final String ENTITY_USER = "User";
	
	/** Constantes para la construccion de consultas de cada entidad. */
	/** Fragmentos SELECT de cada entidad. */
	// TODO: RELLENAR CON LOS CAMPOS QUE SE DEBEN OBTENER DE SALESFORCE
	public static final String ENTITY_ACCOUNT_SELECT = "";
	public static final String ENTITY_ADDRESS_SELECT = "";
	public static final String ENTITY_ASSET_SELECT = "";
	public static final String ENTITY_CASE_COMMENT_SELECT = "";
	public static final String ENTITY_CASE_HISTORY_SELECT = "";
	public static final String ENTITY_CONTACT_SELECT = "";
	public static final String ENTITY_GROUP_SELECT = "";
	public static final String ENTITY_HEROKU_USER_SELECT = "";
	public static final String ENTITY_POINT_OF_DELIVERY_SELECT = "";
	public static final String ENTITY_REPEATED_CASES_SELECT = "";
	public static final String ENTITY_SERVICE_PRODUCT_SELECT = "";
	public static final String ENTITY_STREET_SELECT = "";
	public static final String ENTITY_TASK_SELECT = "";
	public static final String ENTITY_USER_SELECT = "";
	
	/** Fragmento FROM, comun para todas las entidades. */
	public static final String ALL_ENTITIES_FROM_CLAUSE = " FROM ";
	
	/** Fragmentos WHERE comunes para todas las entidades. */
	// TODO: RELLENAR CON LA CONDICION QUE DEBEN CUMPLIR LAS CONSULTAS
	public static final String ALL_ENTITIES_WHERE_CLAUSE = " WHERE ";
}