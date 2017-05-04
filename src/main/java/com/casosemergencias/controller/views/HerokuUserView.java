package com.casosemergencias.controller.views;

import com.casosemergencias.model.HerokuUser;

//Datos de un usuario que se necesitan en la vista, y datos de ayuda en la pantalla
public class HerokuUserView extends ObjectView {

	private Integer id;
	private String sfid;
	private String name;
	private String user;
	private String pass;
	private String email;
	private String mensajeError;
	private String mensaje;
	private String country;
	private String labelUnidadPickList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLabelUnidadPickList() {
		return labelUnidadPickList;
	}
	public void setLabelUnidadPickList(String labelUnidadPickList) {
		this.labelUnidadPickList = labelUnidadPickList;
	}
	
	@Override
	public Object instantiateTargetLogic() {
		HerokuUser usuario = new HerokuUser();
		return usuario;
	}
}