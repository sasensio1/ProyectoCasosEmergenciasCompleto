package com.casosemergencias.logic;

import java.util.List;

public interface DireccionService {

	public int insertDireccionSfList(List<Object> addressList, String processId);
	
	public int updateDireccionSfList(List<Object> addressList, String processId);

	public int deleteDireccionSfList(List<Object> addressList, String processId);
	
}