package com.casosemergencias.model;

import com.casosemergencias.controller.views.UserView;
import com.casosemergencias.dao.vo.UserVO;

//Objeto que tiene el modelo de un Usuario, se utiliza en el Servicio
public class User extends ObjectLogic{

	/*ID*/                                  private Integer id;
	/*SFID*/                                private String sfid;
	/*Nombre de la cuenta*/                 private String name;
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
	@Override
	public Object instantiateTargetVO() {
		UserVO user = new UserVO();
		return user;
	}
	@Override
	public Object instantiateTargetView() {
		//Cambiar el tipo de dato cuando creemos el objeto view
		UserView userview = new UserView();
		return userview;
	}
	
	
}
