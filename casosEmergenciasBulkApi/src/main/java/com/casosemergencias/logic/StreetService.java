package com.casosemergencias.logic;

import java.util.List;

public interface StreetService {
	
	public int insertCalleSfList(List<Object> streetList, String processId);
	
	public int updateCalleSfList(List<Object> streetList, String processId);
	
	public int deleteCalleSfList(List<Object> streetList, String processId);

}
