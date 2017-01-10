package com.casosemergencias.logic.sf.response;

public class CreateRelacionActivoContactoResponse {
	
	private String tipoRelacionActivoClave ;
	private ControlErrores controlErrores;
	private String  activoId;
	private Boolean insertActivoBoolean;
	private String  relacionActivoId;
	
	public String getTipoRelacionActivoClave() {
		return tipoRelacionActivoClave;
	}
	public void setTipoRelacionActivoClave(String tipoRelacionActivoClave) {
		this.tipoRelacionActivoClave = tipoRelacionActivoClave;
	}
	public ControlErrores getControlErrores() {
		return controlErrores;
	}
	public void setControlErrores(ControlErrores controlErrores) {
		this.controlErrores = controlErrores;
	}
	public String getActivoId() {
		return activoId;
	}
	public void setActivoId(String activoId) {
		this.activoId = activoId;
	}
	public Boolean getInsertActivoBoolean() {
		return insertActivoBoolean;
	}
	public void setInsertActivoBoolean(Boolean insertActivoBoolean) {
		this.insertActivoBoolean = insertActivoBoolean;
	}
	public String getRelacionActivoId() {
		return relacionActivoId;
	}
	public void setRelacionActivoId(String relacionActivoId) {
		this.relacionActivoId = relacionActivoId;
	}
	
	
	
}
