package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.util.datatables.DataTableProperties;

public interface AccountService {
	
	public int insertAccountSfList(List<Object> accountList, String processId);
	
	public int updateAccountSfList(List<Object> accountList, String processId);
	
	public int deleteAccountSfList(List<Object> accountList, String processId);

}