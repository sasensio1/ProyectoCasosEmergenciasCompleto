package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.WhereJoinTable;

import com.casosemergencias.model.CaseHistory;

@Entity
@Table(name = "salesforce.casehistory")
public class CaseHistoryVO extends ObjectVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	
	// campo de Heroku
	@Column(name = "_hc_lastop")
	private String hcLastop;
	// campo de Heroku
	@Column(name = "_hc_err")
	private String hcError;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;
	
	@Column(name = "createdbyid")
	private String createdbyid;

	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "newvalue")
	private String newvalue;
	
	@Column(name = "oldvalue")
	private String oldvalue;
	
	@Column(name = "field")
	private String field;
	
	@Column(name = "caseid")
	private String caseid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdbyid", referencedColumnName = "sfid", insertable = false, updatable = false)
	private UserVO userJoin;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "field", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'Field' and objeto = 'CaseHistory'")
	private PickListsCaseHistoryFieldVO fieldPickList;


	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumns({
		@JoinColumn(name = "field", referencedColumnName = "campo", insertable = false, updatable = false),
		@JoinColumn(name = "newvalue", referencedColumnName = "codigo", insertable = false, updatable = false)
	})	
	@WhereJoinTable(clause = "objeto = 'Case'")
	private PickListsVO newValuePickList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumns({
		@JoinColumn(name = "field", referencedColumnName = "campo", insertable = false, updatable = false),
		@JoinColumn(name = "oldvalue", referencedColumnName = "codigo", insertable = false, updatable = false)
	})	
	@WhereJoinTable(clause = "objeto = 'Case'")
	private PickListsVO oldValuePickList;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "field", referencedColumnName = "campo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "objeto = 'Case'")
	private FieldLabelVO fieldLabel;

	public CaseHistoryVO(Boolean isDeleted, String hcLastop, String hcError, Integer id, String sfid,
			String createdbyid, Date createddate, String newvalue, String oldvalue, String field, String caseid,
			PickListsCaseHistoryFieldVO fieldPickList) {
		super();
		this.isDeleted = isDeleted;
		this.hcLastop = hcLastop;
		this.hcError = hcError;
		this.id = id;
		this.sfid = sfid;
		this.createdbyid = createdbyid;
		this.createddate = createddate;
		this.newvalue = newvalue;
		this.oldvalue = oldvalue;
		this.field = field;
		this.caseid = caseid;
		this.fieldPickList = fieldPickList;
	}


	public CaseHistoryVO() {
		super();
	}

	


	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getHcLastop() {
		return hcLastop;
	}
	public void setHcLastop(String hcLastop) {
		this.hcLastop = hcLastop;
	}
	public String getHcError() {
		return hcError;
	}
	public void setHcError(String hcError) {
		this.hcError = hcError;
	}
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
	public String getCreatedbyid() {
		return createdbyid;
	}
	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public String getNewvalue() {
		return newvalue;
	}
	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}
	public String getOldvalue() {
		return oldvalue;
	}
	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getCaseid() {
		return caseid;
	}
	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}
	public UserVO getUserJoin() {
		return userJoin;
	}
	public void setUserJoin(UserVO userJoin) {
		this.userJoin = userJoin;
	}
	public PickListsCaseHistoryFieldVO getFieldPickList() {
		return fieldPickList;
	}
	public void setFieldPickList(PickListsCaseHistoryFieldVO fieldPickList) {
		this.fieldPickList = fieldPickList;
	}	
	public PickListsVO getNewValuePickList() {
		return newValuePickList;
	}
	public void setNewValuePickList(PickListsVO newValuePickList) {
		this.newValuePickList = newValuePickList;
	}
	public PickListsVO getOldValuePickList() {
		return oldValuePickList;
	}
	public void setOldValuePickList(PickListsVO oldValuePickList) {
		this.oldValuePickList = oldValuePickList;
	}
	public FieldLabelVO getFieldLabel() {
		return fieldLabel;
	}
	public void setFieldLabel(FieldLabelVO fieldLabel) {
		this.fieldLabel = fieldLabel;
	}


	public String getLabelFieldPickList(){
		String result = "";
		if (this.getFieldPickList() != null) {
			result = this.getFieldPickList().getValor();
		}
		return result;
	}	
	public String getLabelNewValuePickList(){
		String result = this.getNewvalue();
		if (this.getNewValuePickList() != null) {
			result = this.getNewValuePickList().getValor();
		}
		return result;
	}
	public String getLabelOldValuePickList(){
		String result = this.getOldvalue();
		if (this.getOldValuePickList() != null) {
			result = this.getOldValuePickList().getValor();
		}
		return result;
	}
	public String getLabelFieldLabel(){
		String result = this.getField();
		if (this.getFieldLabel() != null) {
			result = this.getFieldLabel().getLabel();
		}
		return result;
	}
	
	@Override
	public Object instantiateTargetLogic() {
		CaseHistory caseHistory = new CaseHistory();
		return caseHistory;
	}
	
	
}
