package com.casosemergencias.logic.ws.responses;

import java.util.Map;

import org.example.sieme009_schema.ListadoEventosType;

public class GetEventosRelacionadosWSResponse {
	ListadoEventosType listadoEventos;
	private Map<String, String> mapaErrores;
	private boolean resultadoErroneo = false;

	public ListadoEventosType getListadoEventos() {
		return listadoEventos;
	}

	public void setListadoEventos(ListadoEventosType listadoEventos) {
		this.listadoEventos = listadoEventos;
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