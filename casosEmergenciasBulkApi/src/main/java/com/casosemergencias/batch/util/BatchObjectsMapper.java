package com.casosemergencias.batch.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
import com.casosemergencias.dao.vo.UserVO;
import com.casosemergencias.util.constants.ConstantesBulkApi;

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
	private LinkedHashMap<String, String> objectSelectsMap;
	
	public BatchObjectsMapper() {
		initObjectSelectsMap();
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
	}
	
	private void initAccountMap() {
		accountMap = new HashMap<String, String>();
		accountMap.put("Id", "Sfid");
		accountMap.put("Name", "Name");
		accountMap.put("fatherslastname__c", "ApellidoPaterno");
		accountMap.put("motherslastname__c", "ApellidoMaterno");
		accountMap.put("identitytype__c", "TipoIdentidad");
		accountMap.put("parent__identityNumber__c", "ParentRutEmpresa");
		accountMap.put("masterrecord__identitynumber__c", "AccountRun");
		accountMap.put("identitynumber__c", "Run");
		accountMap.put("birthdate__c", "FechaNacimientoString");
		accountMap.put("phone", "Phone");
		accountMap.put("mainphone__c", "TelefonoPrincipal");
		accountMap.put("secondaryPhone__c", "TelefonoSecundario");
		accountMap.put("primaryemail__c", "EmailPrincipal");
		accountMap.put("secondaryemail__c", "EmailSecundario");
		accountMap.put("address__c", "Direccion");
		accountMap.put("accountsource", "Accountsource");
		accountMap.put("companyid__c", "IdEmpresa");
		accountMap.put("type", "Tipo");
		accountMap.put("parentid", "Parentid");
	}
	
	private void initContactMap() {
		contactMap = new HashMap<String, String>();
		contactMap.put("Id", "Sfid");
		contactMap.put("Name", "Name");
		contactMap.put("Birthdate", "FechaNacimientoString");
		contactMap.put("preferredchannelcontact__c", "CanalPreferenteContacto");
		contactMap.put("associatedaccounttype__c", "TipoCuentaAsociado");
		contactMap.put("motherslastname__c", "ApellidoMaterno");
		contactMap.put("identitytype__c", "TipoIdentidad");
		contactMap.put("SecondaryPhone__c", "TelefonoSecundario");
		contactMap.put("secondaryemail__c", "EmailSecundario");
		contactMap.put("sf4twitter__fcbk_username__c", "Sf4twitterFcbkUsername");
		contactMap.put("repeatedcases__c", "CasosReiteradosString");
		contactMap.put("email", "Email");
		contactMap.put("identitynumber__c", "Run");
		contactMap.put("concatenatecontacaddress__c", "DirContacto");
		contactMap.put("sf4twitter__twitter_user_id__c", "Sf4twitterTwitterUserId");
		contactMap.put("sf4twitter__fcbk_user_id__c", "Sf4twitterFcbkUserId");
		contactMap.put("sf4twitter__twitter_username__c", "Sf4twitterTwitterUsername");
		contactMap.put("contacttype__c", "TipoContacto");
		contactMap.put("phone", "Phone");
		contactMap.put("fatherslastname__c", "ApellidoPaterno");
		contactMap.put("sf4twitter__influencer__c", "Influencer");
		contactMap.put("sf4twitter__twitter_bio__c", "TwitterBio");
		contactMap.put("sf4twitter__influencer_type__c", "InfluencerType");
		contactMap.put("sf4twitter__twitter_follower_count__c", "SeguidoresTwitter");
		contactMap.put("accountid", "Accountid");
		contactMap.put("firstname", "Firstname");
		contactMap.put("contactaddress__c", "IdDirContacto");
	}
	
	private void initAssetMap() {
		assetMap = new HashMap<String, String>();
		assetMap.put("Id", "Sfid");
		assetMap.put("name", "Name");
		assetMap.put("contactid", "Contactid");
		assetMap.put("accountid", "Accountid");
		assetMap.put("pointofdelivery__c", "Pointofdelivery__c");
	}
	
	private void initAddressMap() {
		addressMap = new HashMap<String, String>();
		addressMap.put("Id", "Sfid");
		addressMap.put("createddate", "CreateddateString");
		addressMap.put("region__c", "Region");
		addressMap.put("municipality__c", "Comuna");
		addressMap.put("street_type__c", "TipoCalle");
		addressMap.put("streetmd__c", "Calle");
		addressMap.put("number__c", "Numero");
		addressMap.put("department__c", "Departamento");
		addressMap.put("name", "Name");
		addressMap.put("concatenatedaddress__c", "DireccionConcatenada");
		addressMap.put("corner__c", "Esquina");
	}
	
	private void initCaseCommentMap() {
		caseCommentMap = new HashMap<String, String>();
		caseCommentMap.put("Id", "Sfid");
		caseCommentMap.put("name", "Name");
		caseCommentMap.put("createdbyid", "Createdbyid");
		caseCommentMap.put("createddate", "CreateddateString");
		caseCommentMap.put("ispublished", "IspublishedString");
		caseCommentMap.put("parentid", "Caseid");
		caseCommentMap.put("commentbody", "Comment");
		caseCommentMap.put("lastmodifieddate", "Lastmodifieddate");
		caseCommentMap.put("lastmodifiedbyid", "Lastmodifiedbyid");
	}
	
	private void initCaseHistoryMap() {
		caseHistoryMap = new HashMap<String, String>();
		caseHistoryMap.put("Id", "Sfid");
		caseHistoryMap.put("createdbyid", "Createdbyid");
		caseHistoryMap.put("createddate", "CreateddateString");
		caseHistoryMap.put("newvalue", "Newvalue");
		caseHistoryMap.put("oldvalue", "Oldvalue");
		caseHistoryMap.put("field", "Field");
		caseHistoryMap.put("caseid", "Caseid");
	}
	
	private void initGroupMap() {
		groupMap = new HashMap<String, String>();
		groupMap.put("Id", "Sfid");
		groupMap.put("name", "Name");
		groupMap.put("createddate", "CreateddateString");
		groupMap.put("label", "Label");
	}
	
	private void initHerokuUserMap() {
		herokuUserMap = new HashMap<String, String>();
		herokuUserMap.put("Id", "Sfid");
		herokuUserMap.put("name", "Name");
		herokuUserMap.put("username__c", "Username");
		herokuUserMap.put("password__c", "Password");
		herokuUserMap.put("mail__c", "Email");
		herokuUserMap.put("sentmail__c", "EnvioMailString");
		herokuUserMap.put("active__c", "si");
		herokuUserMap.put("country__c", "Country");
		herokuUserMap.put("unity__c", "Unidad");
	}
	
	private void initPointOfDeliveryMap() {
		pointOfDeliveryMap = new HashMap<String, String>();
		pointOfDeliveryMap.put("Id", "Sfid");
		pointOfDeliveryMap.put("name", "Name");
		pointOfDeliveryMap.put("fullelectric__c", "FullElectric");
		pointOfDeliveryMap.put("opencases__c", "CasosAbiertosString");
		pointOfDeliveryMap.put("transformertype__c", "TipoTransformador");
		pointOfDeliveryMap.put("cuttingdebt__c", "CortePorDeudaString");
		pointOfDeliveryMap.put("readingtype__c", "TipoLectura");
		pointOfDeliveryMap.put("readingprocess__c", "ProcesoLectura");
		pointOfDeliveryMap.put("connectionstatus__c", "EstadoConexion");
		pointOfDeliveryMap.put("metertype__c", "TipoMedida");
		pointOfDeliveryMap.put("municipalityallocation__c", "ComunaReparto");
		pointOfDeliveryMap.put("municipality__c", "Comuna");
		pointOfDeliveryMap.put("meternumber__c", "NumeroMedidor");
		pointOfDeliveryMap.put("metermodel__c", "ModeloMedidor");
		pointOfDeliveryMap.put("pointofdeliverynumber__c", "NumeroSuministro");
		pointOfDeliveryMap.put("transformernumber__c", "NumeroTransformador");
		pointOfDeliveryMap.put("pointofdeliverystatus__c", "EstadoSuministro");
		pointOfDeliveryMap.put("meterbrand__c", "MarcaMedidor");
		pointOfDeliveryMap.put("cutoffdate__c", "FechaCorteString");
		pointOfDeliveryMap.put("meterproperty__c", "PropiedadMedidor");
		pointOfDeliveryMap.put("companyid__c", "IdEmpresa");
		pointOfDeliveryMap.put("detailaddress__c", "Direccion");
		pointOfDeliveryMap.put("paymentprocess__c", "PagoEnProcesoString");
		pointOfDeliveryMap.put("ballotname__c", "NombreDuenoBoleta");
		pointOfDeliveryMap.put("block__c", "Bloque");
		pointOfDeliveryMap.put("connectiontype__c", "TipoConexion");
		pointOfDeliveryMap.put("electrodependant__c", "Electrodependiente");
		pointOfDeliveryMap.put("disciplinarymeasure__c", "MedidaDisciplina");
		pointOfDeliveryMap.put("rationingschedule__c", "HorarioRacionamiento");
		pointOfDeliveryMap.put("repeatedcases__c", "CasosReiteradosString");
		pointOfDeliveryMap.put("rate__c", "Tarifa");
		pointOfDeliveryMap.put("feedernumber__c", "Alimentador");
		pointOfDeliveryMap.put("distributionaddress__c", "DireccionBoleta");
		pointOfDeliveryMap.put("electricalsubstationconnection__c", "SubestacionElectricaConexion");
		pointOfDeliveryMap.put("route__c", "Ruta");
		pointOfDeliveryMap.put("segmenttype__c", "TipoSegmento");
		pointOfDeliveryMap.put("pointofdeliveryaddress__c", "DireccionConcatenada");
	}
	
	private void initRepeatedCasesMap() {
		repeatedCasesMap = new HashMap<String, String>();
		repeatedCasesMap.put("Id", "Sfid");
		repeatedCasesMap.put("name", "Name");
		repeatedCasesMap.put("numbercases__c", "NumCasosString");
		repeatedCasesMap.put("numberdays__c", "NumDiasString");
	}
	
	private void initServiceProductMap() {
		serviceProductMap = new HashMap<String, String>();
		serviceProductMap.put("Id", "Sfid");
		serviceProductMap.put("name", "Name");
		serviceProductMap.put("contact__c", "ContactoId");
		serviceProductMap.put("principal__c", "PrincipalString");
		serviceProductMap.put("asset__c", "ActivoId");
		serviceProductMap.put("typeofrelationship__c", "TipoRelacionActivoClave");
	}
	
	private void initStreetMap() {
		streetMap = new HashMap<String, String>();
		streetMap.put("Id", "Sfid");
		streetMap.put("name", "Name");
		streetMap.put("recordtypeid", "RecordTypeId");
		streetMap.put("currencyisocode", "CurrencyIsoCode");
		streetMap.put("region__c", "Region");
		streetMap.put("literal_region__c", "LiteralRegion");
		streetMap.put("municipality__c", "Municipality");
		streetMap.put("literal_municipality__c", "LiteralMunicipality");
		streetMap.put("street__c", "Street");
		streetMap.put("street_type__c", "StreetType");
		streetMap.put("literal_street_type__c", "LiteralStreetType");
		streetMap.put("lastmodifiedbyid", "LastModifiedById");
		streetMap.put("createdbyid", "CreatedById");
		streetMap.put("ownerid", "OwnerId");
		streetMap.put("country__c", "Country");
		streetMap.put("company__c", "Company");
	}
	
	private void initUserMap() {
		userMap = new HashMap<String, String>();
		userMap.put("Id", "Sfid");
		userMap.put("name", "Name");
	}
	
	public LinkedHashMap<String, String> setobjectSelectsMap() {
		return objectSelectsMap;
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
	
	public Map<String, String> getMapFromType(Object object) {
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
		}
		return map;
	}
	
	private void initObjectSelectsMap() {
		objectSelectsMap = new LinkedHashMap<String, String>();
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_ACCOUNT, ConstantesBulkApi.ENTITY_ACCOUNT_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_ADDRESS, ConstantesBulkApi.ENTITY_ADDRESS_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_ASSET, ConstantesBulkApi.ENTITY_ASSET_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_CASE_COMMENT, ConstantesBulkApi.ENTITY_CASE_COMMENT_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_CASE_HISTORY, ConstantesBulkApi.ENTITY_CASE_HISTORY_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_CONTACT, ConstantesBulkApi.ENTITY_CONTACT_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_GROUP, ConstantesBulkApi.ENTITY_GROUP_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_HEROKU_USER, ConstantesBulkApi.ENTITY_HEROKU_USER_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_POINT_OF_DELIVERY, ConstantesBulkApi.ENTITY_POINT_OF_DELIVERY_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_REPEATED_CASES, ConstantesBulkApi.ENTITY_REPEATED_CASES_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_SERVICE_PRODUCT, ConstantesBulkApi.ENTITY_SERVICE_PRODUCT_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_STREET, ConstantesBulkApi.ENTITY_STREET_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_TASK, ConstantesBulkApi.ENTITY_TASK_SELECT);
		objectSelectsMap.put(ConstantesBulkApi.ENTITY_USER, ConstantesBulkApi.ENTITY_USER_SELECT);
	} 
}