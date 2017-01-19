package com.casosemergencias.logic;

import java.util.List;

public interface RelacionActivoContactoService {

	public boolean insertRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId);
	
	public boolean updateRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId);
	
	public boolean deleteRelacionActivoContactoSfList(List<Object> relacionActivoContactoList, String processId);
}
