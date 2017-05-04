package com.casosemergencias.logic;

import java.util.List;

public interface SuministroService {
		
	public int insertSuministroSfList(List<Object> suministroList, String processId);
	
	public int updateSuministroSfList(List<Object> suministroList, String processId);
	
	public int deleteSuministroSfList(List<Object> suministroList, String processId);
	
}