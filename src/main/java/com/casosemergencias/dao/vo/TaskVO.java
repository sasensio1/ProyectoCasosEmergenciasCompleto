package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.casosemergencias.util.Utils;

@Entity
@Table(name = "salesforce.task")
public class TaskVO extends ObjectVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// campo de Heroku
	// Used to track the IsDeleted field from Salesforce allowing Heroku Connect
	// to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	// campo de Heroku
	// Used to track the IsDeleted field from Salesforce allowing Heroku Connect
	// to handle deletes when polling for updates
	@Column(name = "systemmodstamp")
	private Date systemDate;
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

	@Column(name = "tasktype__c")
	private String taskType;

	@Column(name = "activitydate")
	private Date activityDate;

	@Column(name = "calldisposition")
	private String callDisposition;

	@Column(name = "casephone__c")
	private String casePhone;

	@Column(name = "status")
	private String status;

	@Column(name = "description")
	private String description;

	@Column(name = "createddate")
	private Date createdDate;

	@Column(name = "subject")
	private String subject;

	@Column(name = "priority")
	private String priority;

	@Column(name = "whoid")
	private String whoId;

	/*
	 * NO ESTÁ EN SALESFORCE
	 * @Column(name = "account__company__c")
	 * private String account__company__c;
	 */

	@Column(name = "accountid")
	private String accountId;

	@Column(name = "ownerid")
	private String ownerId;

	@Column(name = "tasksubtype")
	private String taskSubtype;

	public TaskVO() {
		super();
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(Date systemDate) {
		this.systemDate = systemDate;
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

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public void setActivityDateString(String activityDateString) {
		Date activityDateDate = Utils.parseStringToDate(activityDateString);
		if (activityDateDate != null) {
			setActivityDate(activityDateDate);
		}
	}

	public String getCallDisposition() {
		return callDisposition;
	}

	public void setCallDisposition(String callDisposition) {
		this.callDisposition = callDisposition;
	}

	public String getCasePhone() {
		return casePhone;
	}

	public void setCasePhone(String casePhone) {
		this.casePhone = casePhone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createddate) {
		this.createdDate = createddate;
	}

	public void setCreatedDateString(String createdDateString) {
		Date createdDateDate = Utils.parseStringToDate(createdDateString);
		if (createdDateDate != null) {
			setCreatedDate(createdDateDate);
		}
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getWhoId() {
		return whoId;
	}

	public void setWhoId(String whoId) {
		this.whoId = whoId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getTaskSubtype() {
		return taskSubtype;
	}

	public void setTaskSubtype(String taskSubtype) {
		this.taskSubtype = taskSubtype;
	}

	@Override
	public Object instantiateTargetLogic() {
		return null;
	}
}