package com.casosemergencias.model;
import com.casosemergencias.controller.views.GroupView;
import com.casosemergencias.dao.vo.GroupVO;

public class Group extends ObjectLogic {
	
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
	public Object instantiateTargetView() {
		GroupView group = new GroupView();
		return group;
	}
	
	@Override
	public Object instantiateTargetVO() {
		GroupVO group = new GroupVO();
		return group;
	}
}
	