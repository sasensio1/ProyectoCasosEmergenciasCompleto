package com.casosemergencias.controller.views;

import com.casosemergencias.model.Group;


public class GroupView extends ObjectView {

	/*ID*/    private Integer id;
	/*SFID*/  private String sfid;
	/*Name*/  private String name;
	
	
	/* Getters y Setters */
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
		Group group = new Group();
		return group;
	}
	
}