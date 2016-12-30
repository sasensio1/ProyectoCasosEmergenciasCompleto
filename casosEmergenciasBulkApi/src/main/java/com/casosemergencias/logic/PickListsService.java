package com.casosemergencias.logic;

import java.util.List;
import java.util.Map;

import com.casosemergencias.model.PickList;

public interface PickListsService {
	public Map<String, Map<String, String>> getPickListPorObjeto(String objeto);
	
//	public Map<String, String> getPickListPorCampo(String objeto, String campo);
	
	public List<PickList> getPickListPorObjetoYCampo(String objeto, String campo);
}