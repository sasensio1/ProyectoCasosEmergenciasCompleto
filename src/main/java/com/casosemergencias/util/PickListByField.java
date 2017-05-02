package com.casosemergencias.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.casosemergencias.util.constants.Constantes;

public class PickListByField {
	
	
	
	public static Map<String, String> getPickListPorCampo(Map<String, Map<String, String>> mapaGeneral, String campo, Boolean anniadirDefault){
		Map<String, String> returnMap = null;
		if (mapaGeneral != null && !mapaGeneral.isEmpty() && mapaGeneral.containsKey(campo)){
				returnMap = new LinkedHashMap<String, String>();
			if(anniadirDefault){
				returnMap.put(Constantes.PICKLIST_CASO_DEFAULT, "");
			}
				returnMap.putAll(mapaGeneral.get(campo));
		}
		return returnMap;
	}

}
