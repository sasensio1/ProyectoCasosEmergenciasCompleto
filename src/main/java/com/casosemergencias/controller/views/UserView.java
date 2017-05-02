package com.casosemergencias.controller.views;

import com.casosemergencias.model.HerokuUser;

public class UserView extends ObjectView {
	
	
 private Integer id;
 private String sfid;
 private String name;
 

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
	public Object instantiateTargetLogic() {
		HerokuUser usuario = new HerokuUser();
		return usuario;
	}
}