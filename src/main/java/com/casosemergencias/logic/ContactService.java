package com.casosemergencias.logic;

import java.util.List;

public interface ContactService {
		
	public int insertContactSfList(List<Object> contactList, String processId);
	
	public int updateContactSfList(List<Object> contactList, String processId);
	
	public int deleteContactSfList(List<Object> contactList, String processId);

}