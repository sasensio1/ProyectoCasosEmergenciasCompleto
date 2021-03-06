package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.RelacionActivoContactoDAO;


public class RelacionActivoContactoServiceImpl implements RelacionActivoContactoService {
	
	@Autowired
	private RelacionActivoContactoDAO relacionActivoContactoDao;
	
	@Override
	public int insertRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId) {
		int processedRecords = relacionActivoContactoDao.insertRelacionActivoContactoListSf(relacionActivoContactoList, processId);
		return processedRecords;
	}
	@Override
	public int updateRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId) {
		int processedRecords = relacionActivoContactoDao.updateRelacionActivoContactoListSf(relacionActivoContactoList, processId);
		return processedRecords;
	}
	@Override
	public int deleteRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId) {
		int processedRecords = relacionActivoContactoDao.deleteRelacionActivoContactoListSf(relacionActivoContactoList, processId);
		return processedRecords;
	}
}