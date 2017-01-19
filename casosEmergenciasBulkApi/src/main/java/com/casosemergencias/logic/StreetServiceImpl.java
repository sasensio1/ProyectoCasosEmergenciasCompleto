package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CalleDAO;


public class StreetServiceImpl implements StreetService{
	
	@Autowired
	private CalleDAO calleDao;
	
	@Override
	public boolean insertCalleSfList(List<Object> calleList, String processId) {
		boolean resultOk = calleDao.insertStreetListSf(calleList, processId);
		return resultOk;
	}
	@Override
	public boolean updateCalleSfList(List<Object> calleList, String processId) {
		boolean resultOk = calleDao.deleteStreetListSf(calleList, processId);
		return resultOk;
	}
	@Override
	public boolean deleteCalleSfList(List<Object> calleList, String processId) {
		boolean resultOk = calleDao.updateStreetListSf(calleList, processId);
		return resultOk;
	}

}
