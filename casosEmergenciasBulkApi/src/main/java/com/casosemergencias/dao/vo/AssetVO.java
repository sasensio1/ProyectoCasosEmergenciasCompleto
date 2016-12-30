package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salesforce.asset")
public class AssetVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3202872535791690551L;
	
	//campo de Heroku
		//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
		@Column(name = "isdeleted")
		private Boolean isDeleted;
		//campo de Heroku
		//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
		@Column(name = "systemmodstamp")
		private Date systemDate;
		//campo de Heroku
		@Column(name = "_hc_lastop")
		private String hcLastop;
		//campo de Heroku
		@Column(name = "_hc_err")
		private String hcError;
		//campo de Heroku
		@Column(name="createddate")
		private Date createdDate;

		@Id
		@Column(name = "id")
		private String id;
		
		@Column(name = "sfid")
		private String sfid;

		@Column(name = "name")
		private String name;
		
		@Column(name = "contactid")
		private String contactid;
		
		@Column(name = "accountid")
		private String accountid;
		
		@Column(name = "pointofdelivery__c")
		private String suministroid;

		@OneToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="contactid", referencedColumnName="sfid", insertable = false, updatable=false)
		private ContactVO contactoJoin;
		
		@OneToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="pointofdelivery__c", referencedColumnName="sfid", insertable = false, updatable=false)
		private SuministroVO suministroJoin;
		
		@OneToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="accountid", referencedColumnName="sfid", insertable = false, updatable=false)
		private AccountVO cuentaJoin;

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

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
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

		public String getContactid() {
			return contactid;
		}

		public void setContactid(String contactid) {
			this.contactid = contactid;
		}

		public String getAccountid() {
			return accountid;
		}

		public void setAccountid(String accountid) {
			this.accountid = accountid;
		}
		
		public SuministroVO getSuministroJoin() {
			return suministroJoin;
		}

		public void setSuministroJoin(SuministroVO suministroJoin) {
			this.suministroJoin = suministroJoin;
		}

		public AccountVO getCuentaJoin() {
			return cuentaJoin;
		}

		public void setCuentaJoin(AccountVO cuentaJoin) {
			this.cuentaJoin = cuentaJoin;
		}
}
