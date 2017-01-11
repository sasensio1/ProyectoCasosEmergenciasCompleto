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
	// TODO: RELLENAR CON LOS CAMPOS QUE SE DEBEN OBTENER DE SALESFORCE. AÑADIR CreatedDate, LastModifiedDate y IsDeleted
	public static final String ENTITY_ACCOUNT_SELECT = "SELECT Id, Name, FathersLastName__c, MothersLastName__c"
												          + ", IdentityType__c, IdentityNumber__c, BirthDate__c, Phone"
												          + ", MainPhone__c, SecondaryPhone__c, PrimaryEmail__c, SecondaryEmail__c"
												          + ", Address__c, AccountSource, CompanyID__c, Type, ParentId"
												          + ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_ADDRESS_SELECT = "SELECT Id, Name, Region__c, Municipality__c"
													      + ", Street_type__c, StreetMD__c, Number__c"
													      + ", Department__c, ConcatenatedAddress__c, Corner__c"
													      + ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_ASSET_SELECT = "SELECT Id, Name, ContactId, AccountId, PointofDelivery__c"
														+ ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_CASE_COMMENT_SELECT = "SELECT Id, CreatedById, IsPublished, ParentId, CommentBody, LastModifiedById"
															   + ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_CASE_HISTORY_SELECT = "SELECT Id, CreatedById, NewValue, OldValue, Field, CaseId"
															   + ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_CONTACT_SELECT = "SELECT Id, Name, Birthdate, PreferredChannelContact__c"
														+ ", AssociatedAccountType__c, MothersLastName__c, IdentityType__c, SecondaryPhone__c"
														+ ", SecondaryEmail__c, RepeatedCases__c, Email, ContactAddress__c"
														+ ", AccountId, FirstName, ContactType__c, Phone, FathersLastName__c"
														+ ", IdentityNumber__c, ConcatenateContacAddress__c, sf4twitter__Twitter_User_Id__c"
														+ ", sf4twitter__Fcbk_User_Id__c, sf4twitter__Fcbk_Username__c, sf4twitter__Twitter_Username__c"
														+ ", sf4twitter__Influencer__c, sf4twitter__Twitter_Bio__c"
														+ ", sf4twitter__Influencer_Type__c, sf4twitter__Twitter_Follower_Count__c"
														+ ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_GROUP_SELECT = "SELECT Id, Name"
														+ ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_HEROKU_USER_SELECT = "SELECT Id, Name, Username__c, Password__c"
															  + ", Mail__c, SentMail__c, Active__c, Country__c, Unity__c"
															  + ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_POINT_OF_DELIVERY_SELECT = "SELECT Id, Name, FullElectric__c, OpenCases__c"
																	+ ", TransformerType__c, CuttingDebt__c, ReadingType__c"
																	+ ", ReadingProcess__c, ConnectionStatus__c, MeterType__c"
																	+ ", MunicipalityAllocation__c, Municipality__c, MeterNumber__c"
																	+ ", MeterModel__c, PointofDeliveryNumber__c, TransformerNumber__c"
																	+ ", PointofDeliveryStatus__c, MeterBrand__c, MeterProperty__c"
																	+ ", CutoffDate__c, CompanyID__c, DetailAddress__c, PaymentProcess__c"
																	+ ", BallotName__c, Block__c, ConnectionType__c, Electrodependant__c"
																	+ ", DisciplinaryMeasure__c, RationingSchedule__c, RepeatedCases__c"
																	+ ", Rate__c,  FeederNumber__c, DistributionAddress__c, Route__c"
																	+ ", ElectricalSubstationConnection__c, SegmentType__c, PointofDeliveryAddress__c"
																	+ ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_REPEATED_CASES_SELECT = "SELECT Id, Name, NumberCases__c, NumberDays__c"
																 + ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_SERVICE_PRODUCT_SELECT = "SELECT Id, Name, Contact__c"
																  + ", Principal__c, Asset__c, TypeofRelationship__c"
																  + ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_STREET_SELECT = "SELECT Id, Name, RecordTypeId, CurrencyIsoCode, Region__c"
														 + ", Literal_region__c, Municipality__c"
														 + ", Literal_Municipality__c, Street__c, Street_Type__c"
														 + ", Literal_Street_type__c, LastModifiedById, CreatedById"
														 + ", OwnerId, Country__c, Company__c"
														 + ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_TASK_SELECT = "SELECT Id, "
													   + ", CreatedDate, LastModifiedDate, IsDeleted";
	
	public static final String ENTITY_USER_SELECT = "SELECT Id, Name"
													   + ", CreatedDate, LastModifiedDate, IsDeleted";
	
	/** Fragmento FROM, comun para todas las entidades. */
	public static final String ALL_ENTITIES_FROM_CLAUSE = " FROM ";
	
	/** Fragmentos WHERE comunes para todas las entidades. */
	// TODO: RELLENAR CON LA CONDICION QUE DEBEN CUMPLIR LAS CONSULTAS
	public static final String ALL_ENTITIES_WHERE_CLAUSE = " WHERE ";
}