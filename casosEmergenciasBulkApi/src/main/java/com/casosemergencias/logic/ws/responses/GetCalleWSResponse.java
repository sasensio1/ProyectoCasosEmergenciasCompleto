package com.casosemergencias.logic.ws.responses;

import java.util.Map;

import org.example.sieme002_schema.ListadoCallesType;

public class GetCalleWSResponse {
	ListadoCallesType listadoCalles;
	private Map<String, String> mapaErrores;
	private boolean resultadoErroneo = false;

	public ListadoCallesType getListadoCalles() {
		return listadoCalles;
	}

	public void setListadoCalles(ListadoCallesType listadoCalles) {
		this.listadoCalles = listadoCalles;
	}

	public Map<String, String> getMapaErrores() {
		return mapaErrores;
	}

	public void setMapaErrores(Map<String, String> mapaErrores) {
		this.mapaErrores = mapaErrores;
	}

	public boolean isResultadoErroneo() {
		return resultadoErroneo;
	}

	public void setResultadoErroneo(boolean resultadoErroneo) {
		this.resultadoErroneo = resultadoErroneo;
	}
}
