package com.casosemergencias.logic;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.ContactDAO;


//las transacciones se abren y cierran aqui
public class ContactServiceImpl implements ContactService{
	
	final static Logger logger = Logger.getLogger(ContactService.class);
	
	@Autowired
	private ContactDAO contactDao;
	
			
	@Override
	public int insertContactSfList(List<Object> contactList, String processId) {
		int processedRecords = contactDao.insertContactListSf(contactList, processId);
		return processedRecords;
	}
	@Override
	public int updateContactSfList(List<Object> contactList, String processId) {
		int processedRecords = contactDao.updateContactListSf(contactList, processId);
		return processedRecords;
	}
	@Override
	public int deleteContactSfList(List<Object> contactList, String processId) {
		int processedRecords = contactDao.deleteContactListSf(contactList, processId);
		return processedRecords;
	}
}