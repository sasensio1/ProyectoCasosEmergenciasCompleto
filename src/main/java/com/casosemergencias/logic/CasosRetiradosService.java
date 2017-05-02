package com.casosemergencias.logic;

import java.util.List;

public interface CasosRetiradosService {
	
	public int insertCasosReiteradosSfList(List<Object> casoReiteradoList, String processId);
	
	public int updateCasosReiteradosSfList(List<Object> casoReiteradoList, String processId);
	
	public int deleteCasosReiteradosSfList(List<Object> casoReiteradoList, String processId);

}
