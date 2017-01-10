package com.casosemergencias.batch.util;

import java.util.HashMap;
import java.util.Map;

import com.casosemergencias.dao.vo.AccountVO;
import com.casosemergencias.dao.vo.ContactVO;

public class BatchObjectsMapper {
	private Map<String, String> accountMap;
	private Map<String, String> contactMap;
	
	public BatchObjectsMapper() {
		initAccountMap();
		initContactMap();
	}
	
	private void initAccountMap() {
		accountMap = new HashMap<String, String>();
		accountMap.put("Id", "Sfid");
		accountMap.put("Name", "Name");
		accountMap.put("SecondaryPhone__c", "TelefonoSecundario");
	}
	
	private void initContactMap() {
		contactMap = new HashMap<String, String>();
		contactMap.put("Id", "Sfid");
		contactMap.put("Name", "Name");
		contactMap.put("SecondaryPhone__c", "TelefonoSecundario");
		contactMap.put("Birthdate", "FechaNacimientoString");
	}
	
	public Map<String, String> getAccountMap() {
		return accountMap;
	}
	
	public Map<String, String> getContactMap() {
		return contactMap;
	}
	
	public Map<String, String> getMapFromType(Object object) {
		Map<String, String> map = null;
		if (object instanceof ContactVO) {
			map = contactMap;
		} else if (object instanceof AccountVO) {
			map = accountMap;
		}
		return map;
	}
}