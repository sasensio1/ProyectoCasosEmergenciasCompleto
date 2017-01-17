package com.casosemergencias.batch.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.casosemergencias.dao.vo.AccountVO;
import com.casosemergencias.dao.vo.AssetVO;
import com.casosemergencias.dao.vo.CaseCommentVO;
import com.casosemergencias.dao.vo.CaseHistoryVO;
import com.casosemergencias.dao.vo.CasosReiteradosVO;
import com.casosemergencias.dao.vo.ContactVO;
import com.casosemergencias.dao.vo.DireccionVO;
import com.casosemergencias.dao.vo.GroupVO;
import com.casosemergencias.dao.vo.HerokuUserVO;
import com.casosemergencias.dao.vo.RelacionActivoContactoVO;
import com.casosemergencias.dao.vo.StreetVO;
import com.casosemergencias.dao.vo.SuministroVO;
import com.casosemergencias.dao.vo.TaskVO;
import com.casosemergencias.dao.vo.UserVO;
import com.casosemergencias.util.constants.ConstantesBulkApi;

@Resource
public class BatchObjectsMapper {
	private Map<String, String> accountMap;
	private Map<String, String> contactMap;
	private Map<String, String> assetMap;
	private Map<String, String> addressMap;
	private Map<String, String> caseCommentMap;
	private Map<String, String> caseHistoryMap;
	private Map<String, String> groupMap;
	private Map<String, String> herokuUserMap;
	private Map<String, String> pointOfDeliveryMap;
	private Map<String, String> repeatedCasesMap;
	private Map<String, String> serviceProductMap;
	private Map<String, String> streetMap;
	private Map<String, String> userMap;
	private Map<String, String> taskMap;
	private Map<String, String> objectNamesEquivalenceMap;
	private Map<String, String> objectNamesServicesMap;
	private Map<String, String> objectNamesServicesMethodsMap;
	private LinkedHashMap<String, String> objectSelectsMap;
	
	public BatchObjectsMapper() {
		initObjectSelectsMap();
		initObjectNamesEquivalenceMap();
		initObjectNamesServicesMap();
		initObjectNamesServicesMethodsMap();
		initAccountMap();
		initContactMap();
		initAssetMap();
		initAddressMap();
		initCaseCommentMap();
		initCaseHistoryMap();
		initHerokuUserMap();
		initGroupMap();
		initPointOfDeliveryMap();
		initRepeatedCasesMap();
		initServiceProductMap();
		initStreetMap();
		initUserMap();
		initTaskMap();
	}
	
	private void initAccountMap() {
		accountMap = new HashMap<String, String>();
		accountMap.put("Id", "Sfid");
		accountMap.put("Name", "Name");
		accountMap.put("FathersLastName__c", "ApellidoPaterno");
		accountMap.put("MothersLastName__c", "ApellidoMaterno");
		accountMap.put("IdentityType__c", "TipoIdentidad");
		accountMap.put("IdentityNumber__c", "Run");
		accountMap.put("BirthDate__c", "FechaNacimientoString");
		accountMap.put("Phone", "Phone");
		accountMap.put("MainPhone__c", "TelefonoPrincipal");
		accountMap.put("SecondaryPhone__c", "TelefonoSecundario");
		accountMap.put("PrimaryEmail__c", "EmailPrincipal");
		accountMap.put("SecondaryEmail__c", "EmailSecundario");
		accountMap.put("Address__c", "Direccion");
		accountMap.put("AccountSource", "Accountsource");
		accountMap.put("CompanyID__c", "IdEmpresa");
		accountMap.put("Type", "Tipo");
		accountMap.put("ParentId", "Parentid");
		/* ---- NO EXISTEN EN SALESFORCE ---- */
		//accountMap.put("parent__identityNumber__c", "ParentRutEmpresa");
		//accountMap.put("masterrecord__identitynumber__c", "AccountRun");
	}
	
	private void initContactMap() {
		contactMap = new HashMap<String, String>();
		contactMap.put("Id", "Sfid");
		contactMap.put("Name", "Name");
		contactMap.put("Birthdate", "FechaNacimientoString");
		contactMap.put("PreferredChannelContact__c", "CanalPreferenteContacto");
		contactMap.put("AssociatedAccountType__c", "TipoCuentaAsociado");
		contactMap.put("MothersLastName__c", "ApellidoMaterno");
		contactMap.put("IdentityType__c", "TipoIdentidad");
		contactMap.put("SecondaryPhone__c", "TelefonoSecundario");
		contactMap.put("SecondaryEmail__c", "EmailSecundario");
		contactMap.put("sf4twitter__Fcbk_Username__c", "Sf4twitterFcbkUsername");
		contactMap.put("RepeatedCases__c", "CasosReiteradosString");
		contactMap.put("Email", "Email");
		contactMap.put("IdentityNumber__c", "Run");
		contactMap.put("ConcatenateContacAddress__c", "DirContacto");
		contactMap.put("sf4twitter__Twitter_User_Id__c", "Sf4twitterTwitterUserId");
		contactMap.put("sf4twitter__Fcbk_User_Id__c", "Sf4twitterFcbkUserId");
		contactMap.put("sf4twitter__Twitter_Username__c", "Sf4twitterTwitterUsername");
		contactMap.put("ContactType__c", "TipoContacto");
		contactMap.put("Phone", "Phone");
		contactMap.put("FathersLastName__c", "ApellidoPaterno");
		contactMap.put("sf4twitter__Influencer__c", "Influencer");
		contactMap.put("sf4twitter__Twitter_Bio__c", "TwitterBio");
		contactMap.put("sf4twitter__Influencer_Type__c", "InfluencerType");
		contactMap.put("sf4twitter__Twitter_Follower_Count__c", "SeguidoresTwitter");
		contactMap.put("AccountId", "Accountid");
		contactMap.put("FirstName", "Firstname");
		contactMap.put("ContactAddress__c", "IdDirContacto");
	}
	
	private void initAssetMap() {
		assetMap = new HashMap<String, String>();
		assetMap.put("Id", "Sfid");
		assetMap.put("Name", "Name");
		assetMap.put("ContactId", "Contactid");
		assetMap.put("AccountId", "Accountid");
		assetMap.put("PointofDelivery__c", "Pointofdelivery__c");
	}
	
	private void initAddressMap() {
		addressMap = new HashMap<String, String>();
		addressMap.put("Id", "Sfid");
		addressMap.put("CreatedDate", "CreateddateString");
		addressMap.put("Region__c", "Region");
		addressMap.put("Municipality__c", "Comuna");
		addressMap.put("Street_type__c", "TipoCalle");
		addressMap.put("StreetMD__c", "Calle");
		addressMap.put("Number__c", "Numero");
		addressMap.put("Department__c", "Departamento");
		addressMap.put("Name", "Name");
		addressMap.put("ConcatenatedAddress__c", "DireccionConcatenada");
		addressMap.put("Corner__c", "Esquina");
	}
	
	private void initCaseCommentMap() {
		caseCommentMap = new HashMap<String, String>();
		caseCommentMap.put("Id", "Sfid");
		caseCommentMap.put("CreatedById", "Createdbyid");
		caseCommentMap.put("CreatedDate", "CreateddateString");
		caseCommentMap.put("IsPublished", "IspublishedString");
		caseCommentMap.put("ParentId", "Caseid");
		caseCommentMap.put("CommentBody", "Comment");
		caseCommentMap.put("LastModifiedDate", "LastmodifieddateString");
		caseCommentMap.put("LastModifiedById", "Lastmodifiedbyid");
		/* ---- NO EXISTEN EN SALESFORCE ---- */
		//caseCommentMap.put("Name", "Name");
	}
	
	private void initCaseHistoryMap() {
		caseHistoryMap = new HashMap<String, String>();
		caseHistoryMap.put("Id", "Sfid");
		caseHistoryMap.put("CreatedById", "Createdbyid");
		caseHistoryMap.put("CreatedDate", "CreateddateString");
		caseHistoryMap.put("NewValue", "Newvalue");
		caseHistoryMap.put("OldValue", "Oldvalue");
		caseHistoryMap.put("Field", "Field");
		caseHistoryMap.put("CaseId", "Caseid");
	}
	
	private void initGroupMap() {
		groupMap = new HashMap<String, String>();
		groupMap.put("Id", "Sfid");
		groupMap.put("Name", "Name");
		groupMap.put("CreatedDate", "CreateddateString");
		/* ---- NO EXISTEN EN SALESFORCE ---- */
		//groupMap.put("label", "Label");
	}
	
	private void initHerokuUserMap() {
		herokuUserMap = new HashMap<String, String>();
		herokuUserMap.put("Id", "Sfid");
		herokuUserMap.put("Name", "Name");
		herokuUserMap.put("Username__c", "Username");
		herokuUserMap.put("Password__c", "Password");
		herokuUserMap.put("Mail__c", "Email");
		herokuUserMap.put("SentMail__c", "EnvioMailString");
		herokuUserMap.put("Active__c", "si");
		herokuUserMap.put("Country__c", "Country");
		herokuUserMap.put("Unity__c", "Unidad");
	}
	
	private void initPointOfDeliveryMap() {
		pointOfDeliveryMap = new HashMap<String, String>();
		pointOfDeliveryMap.put("Id", "Sfid");
		pointOfDeliveryMap.put("Name", "Name");
		pointOfDeliveryMap.put("FullElectric__c", "FullElectric");
		pointOfDeliveryMap.put("OpenCases__c", "CasosAbiertosString");
		pointOfDeliveryMap.put("TransformerType__c", "TipoTransformador");
		pointOfDeliveryMap.put("CuttingDebt__c", "CortePorDeudaString");
		pointOfDeliveryMap.put("ReadingType__c", "TipoLectura");
		pointOfDeliveryMap.put("ReadingProcess__c", "ProcesoLectura");
		pointOfDeliveryMap.put("ConnectionStatus__c", "EstadoConexion");
		pointOfDeliveryMap.put("MeterType__c", "TipoMedida");
		pointOfDeliveryMap.put("MunicipalityAllocation__c", "ComunaReparto");
		pointOfDeliveryMap.put("Municipality__c", "Comuna");
		pointOfDeliveryMap.put("MeterNumber__c", "NumeroMedidor");
		pointOfDeliveryMap.put("MeterModel__c", "ModeloMedidor");
		pointOfDeliveryMap.put("PointofDeliveryNumber__c", "NumeroSuministro");
		pointOfDeliveryMap.put("TransformerNumber__c", "NumeroTransformador");
		pointOfDeliveryMap.put("PointofDeliveryStatus__c", "EstadoSuministro");
		pointOfDeliveryMap.put("MeterBrand__c", "MarcaMedidor");
		pointOfDeliveryMap.put("CutoffDate__c", "FechaCorteString");
		pointOfDeliveryMap.put("MeterProperty__c", "PropiedadMedidor");
		pointOfDeliveryMap.put("CompanyID__c", "IdEmpresa");
		pointOfDeliveryMap.put("DetailAddress__c", "Direccion");
		pointOfDeliveryMap.put("PaymentProcess__c", "PagoEnProcesoString");
		pointOfDeliveryMap.put("BallotName__c", "NombreDuenoBoleta");
		pointOfDeliveryMap.put("Block__c", "Bloque");
		pointOfDeliveryMap.put("ConnectionType__c", "TipoConexion");
		pointOfDeliveryMap.put("Electrodependant__c", "Electrodependiente");
		pointOfDeliveryMap.put("DisciplinaryMeasure__c", "MedidaDisciplina");
		pointOfDeliveryMap.put("RationingSchedule__c", "HorarioRacionamiento");
		pointOfDeliveryMap.put("RepeatedCases__c", "CasosReiteradosString");
		pointOfDeliveryMap.put("Rate__c", "Tarifa");
		pointOfDeliveryMap.put("FeederNumber__c", "Alimentador");
		pointOfDeliveryMap.put("DistributionAddress__c", "DireccionBoleta");
		pointOfDeliveryMap.put("ElectricalSubstationConnection__c", "SubestacionElectricaConexion");
		pointOfDeliveryMap.put("Route__c", "Ruta");
		pointOfDeliveryMap.put("SegmentType__c", "TipoSegmento");
		pointOfDeliveryMap.put("PointofDeliveryAddress__c", "DireccionConcatenada");
	}
	
	private void initRepeatedCasesMap() {
		repeatedCasesMap = new HashMap<String, String>();
		repeatedCasesMap.put("Id", "Sfid");
		repeatedCasesMap.put("Name", "Name");
		repeatedCasesMap.put("NumberCases__c", "NumCasosString");
		repeatedCasesMap.put("NumberDays__c", "NumDiasString");
		repeatedCasesMap.put("CreatedDate", "CreatedDateString");
	}
	
	private void initServiceProductMap() {
		serviceProductMap = new HashMap<String, String>();
		serviceProductMap.put("Id", "Sfid");
		serviceProductMap.put("Name", "Name");
		serviceProductMap.put("Contact__c", "ContactoId");
		serviceProductMap.put("Principal__c", "PrincipalString");
		serviceProductMap.put("Asset__c", "ActivoId");
		serviceProductMap.put("TypeofRelationship__c ", "TipoRelacionActivoClave");
	}
	
	private void initStreetMap() {
		streetMap = new HashMap<String, String>();
		streetMap.put("Id", "Sfid");
		streetMap.put("Name", "Name");
		streetMap.put("RecordTypeId", "RecordTypeId");
		streetMap.put("CurrencyIsoCode", "CurrencyIsoCode");
		streetMap.put("Region__c", "Region");
		streetMap.put("Literal_region__c", "LiteralRegion");
		streetMap.put("Municipality__c", "Municipality");
		streetMap.put("Literal_Municipality__c", "LiteralMunicipality");
		streetMap.put("Street__c", "Street");
		streetMap.put("Street_Type__c", "StreetType");
		streetMap.put("Literal_Street_type__c", "LiteralStreetType");
		streetMap.put("LastModifiedById", "LastModifiedById");
		streetMap.put("CreatedById", "CreatedById");
		streetMap.put("OwnerId", "OwnerId");
		streetMap.put("Country__c", "Country");
		streetMap.put("Company__c", "Company");
	}
	
	private void initUserMap() {
		userMap = new HashMap<String, String>();
		userMap.put("Id", "Sfid");
		userMap.put("Name", "Name");		
	}
	
	private void initTaskMap() {
		taskMap = new HashMap<String, String>();
		taskMap.put("Id", "Sfid");
		taskMap.put("TaskType__c", "TaskType");
		taskMap.put("ActivityDate", "ActivityDateString");
		taskMap.put("CallDisposition", "CallDisposition");
		taskMap.put("CasePhone__c", "CasePhone");
		taskMap.put("Status", "Status");
		taskMap.put("Description", "Description");
		taskMap.put("CreatedDate", "CreatedDateString");
		taskMap.put("Subject", "Subject");
		taskMap.put("Priority", "Priority");
		taskMap.put("WhoId", "WhoId");
		taskMap.put("AccountId", "AccountId");
		taskMap.put("OwnerId", "OwnerId");
		taskMap.put("TaskSubtype", "TaskSubtype");
		/* ---- NO EXISTEN EN SALESFORCE ---- */
		//taskMap.put("account__company__c", "Account__company__c");
	}
	
	private void initObjectSelectsMap() {
		objectSelectsMap = new LinkedHashMap<String, String>();
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_STREET, ConstantesBulkApi.ENTITY_STREET_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_ADDRESS, ConstantesBulkApi.ENTITY_ADDRESS_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_POINT_OF_DELIVERY, ConstantesBulkApi.ENTITY_POINT_OF_DELIVERY_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_ACCOUNT, ConstantesBulkApi.ENTITY_ACCOUNT_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_CONTACT, ConstantesBulkApi.ENTITY_CONTACT_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_ASSET, ConstantesBulkApi.ENTITY_ASSET_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_SERVICE_PRODUCT, ConstantesBulkApi.ENTITY_SERVICE_PRODUCT_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_REPEATED_CASES, ConstantesBulkApi.ENTITY_REPEATED_CASES_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_GROUP, ConstantesBulkApi.ENTITY_GROUP_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_USER, ConstantesBulkApi.ENTITY_USER_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_HEROKU_USER, ConstantesBulkApi.ENTITY_HEROKU_USER_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_TASK, ConstantesBulkApi.ENTITY_TASK_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_CASE_HISTORY, ConstantesBulkApi.ENTITY_CASE_HISTORY_SELECT);
	}
	
	private void initObjectNamesEquivalenceMap() {
		objectNamesEquivalenceMap = new HashMap<String, String>();
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_ACCOUNT, "AccountVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_ADDRESS, "DireccionVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_ASSET, "AssetVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_CASE_COMMENT, "CaseCommentVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_CASE_HISTORY, "CaseHistoryVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_CONTACT, "ContactVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_GROUP, "GroupVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_HEROKU_USER, "HerokuUserVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_POINT_OF_DELIVERY, "SuministroVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_REPEATED_CASES, "CasosReiteradosVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_SERVICE_PRODUCT, "RelacionActivoContactoVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_STREET, "StreetVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_TASK, "TaskVO");
		objectNamesEquivalenceMap.put(ConstantesBulkApi.ENTITY_USER, "UserVO");
	}
	
	private void initObjectNamesServicesMap() {
		objectNamesServicesMap = new HashMap<String, String>();
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_ACCOUNT, "AccountServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_ADDRESS, "DireccionServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_ASSET, "AssetServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_CASE_COMMENT, "CaseCommentServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_CASE_HISTORY, "CaseHistoryServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_CONTACT, "ContactServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_GROUP, "GroupServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_HEROKU_USER, "HerokuUserServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_POINT_OF_DELIVERY, "SuministroServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_REPEATED_CASES, "CasosRetiradosServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_SERVICE_PRODUCT, "RelacionActivoContactoServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_STREET, "StreetServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_TASK, "TaskServiceImpl");
		objectNamesServicesMap.put(ConstantesBulkApi.ENTITY_USER, "UserServiceImpl");
	}
	
	private void initObjectNamesServicesMethodsMap() {
		objectNamesServicesMethodsMap = new HashMap<String, String>();
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_ACCOUNT, "Account");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_ADDRESS, "Direccion");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_ASSET, "Asset");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_CASE_COMMENT, "CaseComment");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_CASE_HISTORY, "CaseHistory");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_CONTACT, "Contact");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_GROUP, "Group");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_HEROKU_USER, "HerokuUser");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_POINT_OF_DELIVERY, "Suministro");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_REPEATED_CASES, "CasosReiterados");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_SERVICE_PRODUCT, "RelacionActivoContacto");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_STREET, "Street");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_TASK, "Task");
		objectNamesServicesMethodsMap.put(ConstantesBulkApi.ENTITY_USER, "User");
	}
	
	public Map<String, String> getAccountMap() {
		return accountMap;
	}
	
	public Map<String, String> getContactMap() {
		return contactMap;
	}
	
	public Map<String, String> getAssetMap() {
		return assetMap;
	}
	
	public Map<String, String> getAddressMap() {
		return addressMap;
	}
	
	public Map<String, String> getCaseCommentMap() {
		return caseCommentMap;
	}
	
	public Map<String, String> getCaseHistoryMap() {
		return caseHistoryMap;
	}
	
	public Map<String, String> getGroupMap() {
		return groupMap;
	}
	
	public Map<String, String> getHerokuUserMap() {
		return herokuUserMap;
	}
	
	public Map<String, String> getPointOfDeliveryMap() {
		return pointOfDeliveryMap;
	}
	
	public Map<String, String> getRepeatedCasesMap() {
		return repeatedCasesMap;
	}
	
	public Map<String, String> getServiceProductMap() {
		return serviceProductMap;
	}
	
	public Map<String, String> getStreetMap() {
		return streetMap;
	}
	
	public Map<String, String> getUserMap() {
		return userMap;
	}
	
	public Map<String, String> getTaskMap() {
		return taskMap;
	}
	
	public Map<String, String> getObjectSelectsMap() {
		return objectSelectsMap;
	}
	
	public Map<String, String> getObjectNamesEquivalenceMap() {
		return objectNamesEquivalenceMap;
	}
	
	public Map<String, String> getObjectNamesServicesMap() {
		return objectNamesServicesMap;
	}
	
	public Map<String, String> getObjectNamesServicesMethodsMap() {
		return objectNamesServicesMethodsMap;
	}
	
	public Map<String, String> getParamsMap(Object object) {
		Map<String, String> map = null;
		if (object instanceof ContactVO) {
			map = contactMap;
		} else if (object instanceof AccountVO) {
			map = accountMap;
		} else if (object instanceof AssetVO) {
			map = assetMap;
		} else if (object instanceof DireccionVO) {
			map = addressMap;
		} else if (object instanceof CaseCommentVO) {
			map = caseCommentMap;
		} else if (object instanceof CaseHistoryVO) {
			map = caseHistoryMap;
		} else if (object instanceof GroupVO) {
			map = groupMap;
		} else if (object instanceof HerokuUserVO) {
			map = herokuUserMap;
		} else if (object instanceof SuministroVO) {
			map = pointOfDeliveryMap;
		} else if (object instanceof CasosReiteradosVO) {
			map = repeatedCasesMap;
		} else if (object instanceof RelacionActivoContactoVO) {
			map = serviceProductMap;
		} else if (object instanceof StreetVO) {
			map = streetMap;
		} else if (object instanceof UserVO) {
			map = userMap;
		} else if (object instanceof TaskVO) {
			map = taskMap;
		}
		return map;
	} 
}