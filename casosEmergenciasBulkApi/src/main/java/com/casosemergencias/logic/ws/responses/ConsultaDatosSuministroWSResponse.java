package com.casosemergencias.logic.ws.responses;

import java.util.Map;

import org.example.sires033_schema.ListadoSuministrosType;

public class ConsultaDatosSuministroWSResponse {
	ListadoSuministrosType listadoSuministros;
	private String totalRegistros;
	private Map<String, String> mapaErrores;
	private boolean resultadoErroneo = false;

	public ListadoSuministrosType getListadoSuministros() {
		return listadoSuministros;
	}

	public void setListadoSuministros(ListadoSuministrosType listadoSuministros) {
		this.listadoSuministros = listadoSuministros;
	}

	public String getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(String totalRegistros) {
		this.totalRegistros = totalRegistros;
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