package com.casosemergencias.logic;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.DireccionDAO;


//las transacciones se abren y cierran aqui
public class DireccionServiceImpl implements DireccionService{
	
	final static Logger logger = Logger.getLogger(DireccionService.class);
	
	@Autowired
	private DireccionDAO direccionDao;
	
	
	@Override
	public int insertDireccionSfList(List<Object> addressList, String processId){
		int processedRecords = direccionDao.insertDireccionListSf(addressList, processId);
		return processedRecords;
	}
	@Override
	public int updateDireccionSfList(List<Object> addressList, String processId){
		int processedRecords = direccionDao.updateDireccionListSf(addressList, processId);
		return processedRecords;
	}
	@Override
	public int deleteDireccionSfList(List<Object> addressList, String processId){
		int processedRecords = direccionDao.deleteDireccionListSf(addressList, processId);
		return processedRecords;
	}
}