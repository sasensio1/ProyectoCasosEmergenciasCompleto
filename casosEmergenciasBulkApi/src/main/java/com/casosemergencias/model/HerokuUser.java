package com.casosemergencias.model;

import com.casosemergencias.controller.views.HerokuUserView;
import com.casosemergencias.dao.vo.HerokuUserVO;

/**
 * @author MPC
 * 
 *         Clase que contiene el modelo de un Usuario. Esta clase es la que
 *         utilizaremos en el Servicio.
 *
 */
public class HerokuUser extends ObjectLogic {

	private Integer id;
	private String name;
	private String user;
	private String pass;
	private String email;
	private String sfid;
	private Boolean envioEmail;
	private String country;
	private String unidad;
	private String labelUnidadPickList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getSfid() {
		return sfid;
	}

	public void setSfid(String sfid) {
		this.sfid = sfid;
	}

	public Boolean isEnvioEmail() {
		return envioEmail;
	}

	public void setEnvioEmail(Boolean envioEmail) {
		this.envioEmail = envioEmail;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getLabelUnidadPickList() {
		return labelUnidadPickList;
	}

	public void setLabelUnidadPickList(String labelUnidadPickList) {
		this.labelUnidadPickList = labelUnidadPickList;
	}

	@Override
	public Object instantiateTargetView() {
		HerokuUserView usuario = new HerokuUserView();
		return usuario;
	}
	
	@Override
	public Object instantiateTargetVO() {
		HerokuUserVO usuario = new HerokuUserVO();
		return usuario;
	}
}