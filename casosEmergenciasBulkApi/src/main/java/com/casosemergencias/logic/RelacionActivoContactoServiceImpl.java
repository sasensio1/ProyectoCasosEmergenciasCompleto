package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.RelacionActivoContactoDAO;


public class RelacionActivoContactoServiceImpl implements RelacionActivoContactoService {
	
	@Autowired
	private RelacionActivoContactoDAO relacionActivoContactoDao;
	
	@Override
	public int insertRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId) {
		int resultOk = relacionActivoContactoDao.insertRelacionActivoContactoListSf(relacionActivoContactoList, processId);
		return resultOk;
	}
	@Override
	public int updateRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId) {
		int resultOk = relacionActivoContactoDao.updateRelacionActivoContactoListSf(relacionActivoContactoList, processId);
		return resultOk;
	}
	@Override
	public int deleteRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId) {
		int resultOk = relacionActivoContactoDao.deleteRelacionActivoContactoListSf(relacionActivoContactoList, processId);
		return resultOk;
	}

}
