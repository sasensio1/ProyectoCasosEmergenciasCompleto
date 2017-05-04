package com.casosemergencias.logic;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.HerokuUserDAO;


//las transacciones se abren y cierran aqui
public class HerokuUserServiceImpl implements HerokuUserService{
	
	final static Logger logger = Logger.getLogger(HerokuUserService.class);
	
	@Autowired
	private HerokuUserDAO herokuUserDao;
	
	@Override
	public int insertHerokuUserSfList(List<Object> herokuUserList, String processId) {
		int processedRecords = herokuUserDao.insertHerokuUserListSf(herokuUserList, processId);
		return processedRecords;
	}
	@Override
	public int updateHerokuUserSfList(List<Object> herokuUserList, String processId) {
		int processedRecords = herokuUserDao.updateHerokuUserListSf(herokuUserList, processId);
		return processedRecords;
	}
	@Override
	public int deleteHerokuUserSfList(List<Object> herokuUserList, String processId) {
		int processedRecords = herokuUserDao.deleteHerokuUserListSf(herokuUserList, processId);
		return processedRecords;
	}
}