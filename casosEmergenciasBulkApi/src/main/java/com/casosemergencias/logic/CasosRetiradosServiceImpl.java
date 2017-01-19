package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CasosReiteradosDAO;

public class CasosRetiradosServiceImpl implements CasosRetiradosService {
	
	@Autowired
	private CasosReiteradosDAO casoReiteradoDao;

	
	@Override
	public boolean insertCasosReiteradosSfList(List<Object> casoReiteradoList, String processId) {
		boolean resultOk = casoReiteradoDao.insertCasosReiteradosListSf(casoReiteradoList, processId);
		return resultOk;
	}
	@Override
	public boolean updateCasosReiteradosSfList(List<Object> casoReiteradoList, String processId) {
		boolean resultOk = casoReiteradoDao.updateCasosReiteradosListSf(casoReiteradoList, processId);
		return resultOk;
	}
	@Override
	public boolean deleteCasosReiteradosSfList(List<Object> casoReiteradoList, String processId) {
		boolean resultOk = casoReiteradoDao.deleteCasosReiteradosListSf(casoReiteradoList, processId);
		return resultOk;
	}
}
