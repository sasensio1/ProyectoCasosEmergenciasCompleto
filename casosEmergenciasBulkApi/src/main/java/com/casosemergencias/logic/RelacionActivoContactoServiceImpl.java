package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.RelacionActivoContactoDAO;


public class RelacionActivoContactoServiceImpl implements RelacionActivoContactoService {
	
	@Autowired
	private RelacionActivoContactoDAO relacionActivoContactoDao;
	
	@Override
	public void insertRelacionActivoContactoSfList(List<Object> relacionActivoContactoList) {
		relacionActivoContactoDao.insertRelacionActivoContactoListSf(relacionActivoContactoList);
	}
	@Override
	public void updateRelacionActivoContactoSfList(List<Object> relacionActivoContactoList) {
		relacionActivoContactoDao.updateRelacionActivoContactoListSf(relacionActivoContactoList);
	}
	@Override
	public void deleteRelacionActivoContactoSfList(List<Object> relacionActivoContactoList) {
		relacionActivoContactoDao.deleteRelacionActivoContactoListSf(relacionActivoContactoList);
	}

}
