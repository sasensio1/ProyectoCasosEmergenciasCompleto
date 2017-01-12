package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CalleDAO;


public class StreetServiceImpl implements StreetService{
	
	@Autowired
	private CalleDAO calleDao;
	
	@Override
	public void insertCalleSfList(List<Object> calleList) {
		calleDao.insertStreetListSf(calleList);
	}
	@Override
	public void updateCalleSfList(List<Object> calleList) {
		calleDao.deleteStreetListSf(calleList);
	}
	@Override
	public void deleteCalleSfList(List<Object> calleList) {
		calleDao.updateStreetListSf(calleList);
	}

}
