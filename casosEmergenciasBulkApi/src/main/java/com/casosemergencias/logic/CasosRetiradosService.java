package com.casosemergencias.logic;

import java.util.List;

public interface CasosRetiradosService {
	
	public boolean insertCasosReiteradosSfList(List<Object> casoReiteradoList, String processId);
	
	public boolean updateCasosReiteradosSfList(List<Object> casoReiteradoList, String processId);
	
	public boolean deleteCasosReiteradosSfList(List<Object> casoReiteradoList, String processId);

}
