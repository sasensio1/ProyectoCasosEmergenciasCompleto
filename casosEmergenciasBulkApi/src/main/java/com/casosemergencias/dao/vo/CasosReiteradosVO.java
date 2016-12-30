package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.casosemergencias.model.CasosReiterados;



@Entity
@Table(name="salesforce.repeatedcases__c")
public class CasosReiteradosVO extends ObjectVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "numbercases__c")
	private Double numCasos;
	
	@Column(name = "numberdays__c")
	private Double numDias;
	
	@Column(name = "sfid")
	private String sfid;
	
	//campo de Heroku
	@Column(name = "_hc_err")
	private String hcError;

	//campo de Heroku
	@Column(name = "_hc_lastop")
	private String hcLastop;
	
	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	
	//campo de Heroku
	//The date and time (in the UTC time zone) that the Salesforce object was last modified and used by Heroku Connect when polling for updates
	@Column(name="systemmodstamp")
	private Date systemDate;
	
	@Column(name="createddate")
	private Date createdDate;

	
	public CasosReiteradosVO() {
		super();
	}

	public CasosReiteradosVO(Integer id, String name, Double numCasos, Double numDias, String sfid, String hcError,
			String hcLastop, Boolean isDeleted, Date systemDate, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.numCasos = numCasos;
		this.numDias = numDias;
		this.sfid = sfid;
		this.hcError = hcError;
		this.hcLastop = hcLastop;
		this.isDeleted = isDeleted;
		this.systemDate = systemDate;
		this.createdDate = createdDate;
	}


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


	public Double getNumCasos() {
		return numCasos;
	}


	public void setNumCasos(Double numCasos) {
		this.numCasos = numCasos;
	}


	public Double getNumDias() {
		return numDias;
	}


	public void setNumDias(Double numDias) {
		this.numDias = numDias;
	}


	public String getSfid() {
		return sfid;
	}


	public void setSfid(String sfid) {
		this.sfid = sfid;
	}


	public String getHcError() {
		return hcError;
	}


	public void setHcError(String hcError) {
		this.hcError = hcError;
	}


	public String getHcLastop() {
		return hcLastop;
	}


	public void setHcLastop(String hcLastop) {
		this.hcLastop = hcLastop;
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


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public Object instantiateTargetLogic() {
		CasosReiterados casoReit = new CasosReiterados();
		return casoReit;
	}


	
}
