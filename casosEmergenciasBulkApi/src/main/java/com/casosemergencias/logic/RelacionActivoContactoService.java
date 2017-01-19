package com.casosemergencias.logic;

import java.util.List;

public interface RelacionActivoContactoService {

	public int insertRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId);
	
	public int updateRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId);
	
	public int deleteRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId);
}
