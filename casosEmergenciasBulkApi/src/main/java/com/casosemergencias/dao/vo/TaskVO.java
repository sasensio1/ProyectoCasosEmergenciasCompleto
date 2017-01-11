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
	private String tasktype__c;

	@Column(name = "activitydate")
	private Date activitydate;
	
	@Column(name = "calldisposition")
	private String calldisposition;
	
	@Column(name = "casephone__c")
	private String casephone__c;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "whoid")
	private String whoid;
	
	/*@Column(name = "account__company__c")
	private String account__company__c;*/
	
	@Column(name = "accountid")
	private String accountid;

	@Column(name = "ownerid")
	private String ownerid;

	@Column(name = "tasksubtype")
	private String tasksubtype;
	
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



	public String getTasktype__c() {
		return tasktype__c;
	}



	public void setTasktype__c(String tasktype__c) {
		this.tasktype__c = tasktype__c;
	}



	public Date getActivitydate() {
		return activitydate;
	}



	public void setActivitydate(Date activitydate) {
		this.activitydate = activitydate;
	}

	public void setActivitydateString(String activitydateString) {
		Date activitydateDate = Utils.parseStringToDate(activitydateString);
		if (activitydateDate != null) {
			setActivitydate(activitydateDate);
		}
	}

	public String getCalldisposition() {
		return calldisposition;
	}



	public void setCalldisposition(String calldisposition) {
		this.calldisposition = calldisposition;
	}



	public String getCasephone__c() {
		return casephone__c;
	}



	public void setCasephone__c(String casephone__c) {
		this.casephone__c = casephone__c;
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



	public Date getCreateddate() {
		return createddate;
	}



	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public void setCreateddateString(String createddateString) {
		Date createddateDate = Utils.parseStringToDate(createddateString);
		if (createddateDate != null) {
			setCreateddate(createddateDate);
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



	public String getWhoid() {
		return whoid;
	}



	public void setWhoid(String whoid) {
		this.whoid = whoid;
	}



	public String getAccountid() {
		return accountid;
	}



	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}



	public String getOwnerid() {
		return ownerid;
	}



	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}



	public String getTasksubtype() {
		return tasksubtype;
	}



	public void setTasksubtype(String tasksubtype) {
		this.tasksubtype = tasksubtype;
	}

	@Override
	public Object instantiateTargetLogic() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
