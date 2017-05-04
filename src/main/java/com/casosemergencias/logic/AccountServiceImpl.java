package com.casosemergencias.logic;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.AccountDAO;

//las transacciones se abren y cierran aqui
public class AccountServiceImpl implements AccountService {

	final static Logger logger = Logger.getLogger(AccountService.class);

	@Autowired
	private AccountDAO accountDao;
	
	@Override
	public int insertAccountSfList(List<Object> accountList, String processId) {
		int processedRecords = accountDao.insertAccountListSf(accountList, processId);
		return processedRecords;
	}
	@Override
	public int updateAccountSfList(List<Object> accountList, String processId) {
		int processedRecords = accountDao.updateAccountListSf(accountList, processId);
		return processedRecords;
	}
	@Override
	public int deleteAccountSfList(List<Object> accountList, String processId) {
		int processedRecords = accountDao.deleteAccountListSf(accountList, processId);
		return processedRecords;
	}
}