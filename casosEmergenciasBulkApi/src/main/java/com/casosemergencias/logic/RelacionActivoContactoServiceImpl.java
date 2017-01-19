package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.RelacionActivoContactoDAO;


public class RelacionActivoContactoServiceImpl implements RelacionActivoContactoService {
	
	@Autowired
	private RelacionActivoContactoDAO relacionActivoContactoDao;
	
	@Override
	public boolean insertRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId) {
		boolean resultOk = relacionActivoContactoDao.insertRelacionActivoContactoListSf(relacionActivoContactoList, processId);
		return resultOk;
	}
	@Override
	public boolean updateRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId) {
		boolean resultOk = relacionActivoContactoDao.updateRelacionActivoContactoListSf(relacionActivoContactoList, processId);
		return resultOk;
	}
	@Override
	public boolean deleteRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId) {
		boolean resultOk = relacionActivoContactoDao.deleteRelacionActivoContactoListSf(relacionActivoContactoList, processId);
		return resultOk;
	}

}
