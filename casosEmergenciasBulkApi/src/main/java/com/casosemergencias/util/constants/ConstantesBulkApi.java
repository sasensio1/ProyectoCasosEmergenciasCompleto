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
	public static final String ENTITY_ACCOUNT_SELECT = "SELECT Id, Name, fatherslastname__c, motherslastname__c, "
			+ "identitytype__c, identitynumber__c, birthdate__c, phone, mainphone__c, SecondaryPhone__c, "
			+ "primaryemail__c, secondaryemail__c, address__c, accountsource, companyid__c, type, parentid";
	public static final String ENTITY_ADDRESS_SELECT = "SELECT Id, createddate, region__c, municipality__c, "
			+ "street_type__c, streetmd__c, number__c, department__c, name, concatenatedaddress__c, corner__c";
	public static final String ENTITY_ASSET_SELECT = "SELECT Id, name, contactid, accountid, pointofdelivery__c";
	public static final String ENTITY_CASE_COMMENT_SELECT = "SELECT Id, name, createdbyid, createddate, "
			+ "ispublished, parentid, commentbody, lastmodifieddate, lastmodifiedbyid";
	public static final String ENTITY_CASE_HISTORY_SELECT = "SELECT Id, createdbyid, createddate, newvalue, "
			+ "oldvalue, field, caseid";
	public static final String ENTITY_CONTACT_SELECT = "SELECT Id, Name, Birthdate, preferredchannelcontact__c, "
			+ "associatedaccounttype__c, motherslastname__c, identitytype__c, SecondaryPhone__c, secondaryemail__c, "
			+ "sf4twitter__fcbk_username__c, repeatedcases__c, email, identitynumber__c, concatenatecontacaddress__c, "
			+ "sf4twitter__twitter_user_id__c, sf4twitter__fcbk_user_id__c, sf4twitter__twitter_username__c, "
			+ "contacttype__c, phone, fatherslastname__c, sf4twitter__influencer__c, sf4twitter__twitter_bio__c, "
			+ "sf4twitter__influencer_type__c, sf4twitter__twitter_follower_count__c, accountid, firstname, "
			+ "contactaddress__c";
	public static final String ENTITY_GROUP_SELECT = "SELECT Id, name, createddate, label";
	public static final String ENTITY_HEROKU_USER_SELECT = "SELECT Id, name, username__c, "
			+ "password__c, mail__c, sentmail__c, active__c, country__c, unity__c";
	public static final String ENTITY_POINT_OF_DELIVERY_SELECT = "SELECT Id, name, fullelectric__c, "
			+ "opencases__c, transformertype__c, cuttingdebt__c, readingtype__c, readingprocess__c, "
			+ "connectionstatus__c, metertype__c, municipalityallocation__c, municipality__c, meternumber__c, "
			+ "metermodel__c, pointofdeliverynumber__c, transformernumber__c, pointofdeliverystatus__c, "
			+ "meterbrand__c, cutoffdate__c, detailaddress__c, paymentprocess__c, ballotname__c, block__c, "
			+ "connectiontype__c, electrodependant__c, disciplinarymeasure__c, rationingschedule__c, repeatedcases__c, "
			+ "rate__c,  feedernumber__c, distributionaddress__c, electricalsubstationconnection__c, route__c, "
			+ "segmenttype__c, pointofdeliveryaddress__c";
	public static final String ENTITY_REPEATED_CASES_SELECT = "SELECT Id, name, numbercases__c, numberdays__c";
	public static final String ENTITY_SERVICE_PRODUCT_SELECT = "SELECT Id, name, contact__c, principal__c, asset__c, typeofrelationship__c";
	public static final String ENTITY_STREET_SELECT = "SELECT Id, name, recordtypeid, currencyisocode, region__c, "
			+ "literal_region__c, municipality__c, literal_municipality__c, street__c, street_type__c, "
			+ "literal_street_type__c, lastmodifiedbyid, createdbyid, ownerid, country__c, company__c";
	public static final String ENTITY_TASK_SELECT = "";
	public static final String ENTITY_USER_SELECT = "SELECT Id, name";
	
	/** Fragmento FROM, comun para todas las entidades. */
	public static final String ALL_ENTITIES_FROM_CLAUSE = " FROM ";
	
	/** Fragmentos WHERE comunes para todas las entidades. */
	// TODO: RELLENAR CON LA CONDICION QUE DEBEN CUMPLIR LAS CONSULTAS
	public static final String ALL_ENTITIES_WHERE_CLAUSE = " WHERE ";
}