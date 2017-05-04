package com.casosemergencias.logic;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.SuministroDAO;


public class SuministroServiceImpl implements SuministroService{

	final static Logger logger = Logger.getLogger(SuministroService.class);
	
	@Autowired
	private SuministroDAO suministroDao;
	
	@Override
	public int insertSuministroSfList(List<Object> suministroList, String processId) {
		int processedRecords = suministroDao.insertSuministroListSf(suministroList, processId);
		return processedRecords;
	}
	@Override
	public int updateSuministroSfList(List<Object> suministroList, String processId) {
		int processedRecords = suministroDao.updateSuministroListSf(suministroList, processId);
		return processedRecords;
	}
	@Override
	public int deleteSuministroSfList(List<Object> suministroList, String processId) {
		int processedRecords = suministroDao.deleteSuministroListSf(suministroList, processId);
		return processedRecords;
	}
}
