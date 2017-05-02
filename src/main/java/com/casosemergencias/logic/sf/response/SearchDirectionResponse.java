package com.casosemergencias.logic.sf.response;

public class SearchDirectionResponse {
	private String idDireccion;
	private String nameDireccion; 
	private String idCalle; 
	private ControlErrores controlErrores;
	
	public String getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(String idDireccion) {
		this.idDireccion = idDireccion;
	}	
	public ControlErrores getControlErrores() {
		return controlErrores;
	}
	public void setControlErrores(ControlErrores controlErrores) {
		this.controlErrores = controlErrores;
	}
	public String getNameDireccion() {
		return nameDireccion;
	}
	public void setNameDireccion(String nameDireccion) {
		this.nameDireccion = nameDireccion;
	}
	public String getIdCalle() {
		return idCalle;
	}
	public void setIdCalle(String idCalle) {
		this.idCalle = idCalle;
	}
	
	

	
}