package com.casosemergencias.model;

import java.util.Date;

import com.casosemergencias.controller.views.CaseHistoryView;
import com.casosemergencias.dao.vo.CaseHistoryVO;

//Objeto que tiene el modelo de un CaseHistory, se utiliza en el Servicio
public class CaseHistory extends ObjectLogic{
	
	/*ID*/                                  private Integer id;
	/*SFID*/                                private String sfid;
	/*Case ID*/                				private String caseid;
	/*Campo Modificado */                   private String field;
	/*Valor Anterior*/                      private String oldvalue;
	/*Valor Nuevo*/                 		private String newvalue;
	/*Fecha de Creacion*/                   private Date createddate;
	/*Creado por el Id*/                 	private String createdbyid;
	
	private User userJoin;
	private FieldLabel fieldLabel;
	
	//Campos que almacenan el valor de los picklist de los campos: field, oldvalue, newvalue	
	private String labelFieldPickList;
	private String labelNewValuePickList;
	private String labelOldValuePickList;
		
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
	public String getCaseid() {
		return caseid;
	}
	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getOldvalue() {
		return oldvalue;
	}
	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}
	public String getNewvalue() {
		return newvalue;
	}
	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public String getCreatedbyid() {
		return createdbyid;
	}
	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}
	public User getUserJoin() {
		return userJoin;
	}
	public void setUserJoin(User userJoin) {
		this.userJoin = userJoin;
	}
	public String getLabelFieldPickList() {
		return labelFieldPickList;
	}
	public void setLabelFieldPickList(String labelFieldPickList) {
		this.labelFieldPickList = labelFieldPickList;
	}	
	public String getLabelNewValuePickList() {
		return labelNewValuePickList;
	}
	public void setLabelNewValuePickList(String labelNewValuePickList) {
		this.labelNewValuePickList = labelNewValuePickList;
	}	
	public String getLabelOldValuePickList() {
		return labelOldValuePickList;
	}
	public void setLabelOldValuePickList(String labelOldValuePickList) {
		this.labelOldValuePickList = labelOldValuePickList;
	}	
	public FieldLabel getFieldLabel() {
		return fieldLabel;
	}
	public void setFieldLabel(FieldLabel fieldLabel) {
		this.fieldLabel = fieldLabel;
	}
	
	@Override
	public Object instantiateTargetVO() {
		CaseHistoryVO caseHistory = new CaseHistoryVO();
		return caseHistory;
	}
	@Override
	public Object instantiateTargetView() {
		CaseHistoryView caseHistory = new CaseHistoryView();
		return caseHistory;
	}

	
}
