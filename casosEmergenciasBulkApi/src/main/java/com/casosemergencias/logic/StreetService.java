package com.casosemergencias.logic;

import java.util.List;

public interface StreetService {
	
	public boolean insertCalleSfList(List<Object> streetList, String processId);
	
	public boolean updateCalleSfList(List<Object> streetList, String processId);
	
	public boolean deleteCalleSfList(List<Object> streetList, String processId);

}
