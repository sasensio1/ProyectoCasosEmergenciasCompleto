package com.casosemergencias.logic;

import java.util.List;

public interface StreetService {
	
	public int insertStreetSfList(List<Object> streetList, String processId);
	
	public int updateStreetSfList(List<Object> streetList, String processId);
	
	public int deleteStreetSfList(List<Object> streetList, String processId);
}