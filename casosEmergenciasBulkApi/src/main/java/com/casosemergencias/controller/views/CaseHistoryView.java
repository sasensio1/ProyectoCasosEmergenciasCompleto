package com.casosemergencias.controller.views;

import java.util.Date;

import com.casosemergencias.model.CaseHistory;

public class CaseHistoryView extends ObjectView {
	
	private Integer id;
	private String sfid;
	private String caseid;
	private String field;
	private String oldvalue;
	private String newvalue;
	private Date createddate;
	private String createdbyid;
	private UserView userJoin;
	private FieldLabelView fieldLabel;
	
	//Campos que almacenan el valor de los picklist de los campos: field, oldvalue, newvalue	
	private String labelFieldPickList;
	private String labelNewValuePickList;
	private String labelOldValuePickList;
	
	private String createddateString;
		
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
	public UserView getUserJoin() {
		return userJoin;
	}
	public void setUserJoin(UserView userJoin) {
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
	public void setLabelOldValuePickList(String labelOldValuePickList) {
		this.labelOldValuePickList = labelOldValuePickList;
	}
	public String getLabelOldValuePickList() {
		return labelOldValuePickList;
	}
	public FieldLabelView getFieldLabel() {
		return fieldLabel;
	}
	public void setFieldLabel(FieldLabelView fieldLabel) {
		this.fieldLabel = fieldLabel;
	}	
	public String getCreateddateString() {
		return createddateString;
	}
	public void setCreateddateString(String createddateString) {
		this.createddateString = createddateString;
	}	
	
	@Override
	public Object instantiateTargetLogic() {
		CaseHistory caseHistory = new CaseHistory();
		return caseHistory;
	}

}
