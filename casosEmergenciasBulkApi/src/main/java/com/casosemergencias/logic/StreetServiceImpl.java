package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CalleDAO;


public class StreetServiceImpl implements StreetService{
	
	@Autowired
	private CalleDAO calleDao;
	
	@Override
	public int insertCalleSfList(List<Object> calleList, String processId) {
		int resultOk = calleDao.insertStreetListSf(calleList, processId);
		return resultOk;
	}
	@Override
	public int updateCalleSfList(List<Object> calleList, String processId) {
		int resultOk = calleDao.deleteStreetListSf(calleList, processId);
		return resultOk;
	}
	@Override
	public int deleteCalleSfList(List<Object> calleList, String processId) {
		int resultOk = calleDao.updateStreetListSf(calleList, processId);
		return resultOk;
	}

}
