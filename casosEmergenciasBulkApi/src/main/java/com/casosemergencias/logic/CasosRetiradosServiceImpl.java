package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CasosReiteradosDAO;

public class CasosRetiradosServiceImpl implements CasosRetiradosService {
	
	@Autowired
	private CasosReiteradosDAO casoReiteradoDao;

	
	@Override
	public void insertCasosReiteradosSfList(List<Object> casoReiteradoList) {
		casoReiteradoDao.insertCasosReiteradosListSf(casoReiteradoList);
	}
	@Override
	public void updateCasosReiteradosSfList(List<Object> casoReiteradoList) {
		casoReiteradoDao.updateCasosReiteradosListSf(casoReiteradoList);
	}
	@Override
	public void deleteCasosReiteradosSfList(List<Object> casoReiteradoList) {
		casoReiteradoDao.deleteCasosReiteradosListSf(casoReiteradoList);
	}
}
