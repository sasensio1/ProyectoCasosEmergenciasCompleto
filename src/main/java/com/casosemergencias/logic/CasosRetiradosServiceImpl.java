package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CasosReiteradosDAO;

public class CasosRetiradosServiceImpl implements CasosRetiradosService {
	
	@Autowired
	private CasosReiteradosDAO casoReiteradoDao;

	
	@Override
	public int insertCasosReiteradosSfList(List<Object> casoReiteradoList, String processId) {
		int processedRecords = casoReiteradoDao.insertCasosReiteradosListSf(casoReiteradoList, processId);
		return processedRecords;
	}
	@Override
	public int updateCasosReiteradosSfList(List<Object> casoReiteradoList, String processId) {
		int processedRecords = casoReiteradoDao.updateCasosReiteradosListSf(casoReiteradoList, processId);
		return processedRecords;
	}
	@Override
	public int deleteCasosReiteradosSfList(List<Object> casoReiteradoList, String processId) {
		int processedRecords = casoReiteradoDao.deleteCasosReiteradosListSf(casoReiteradoList, processId);
		return processedRecords;
	}
}