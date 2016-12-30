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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.WhereJoinTable;

@Entity
@Table(name="salesforce.serviceproduct__c")
public class RelacionActivoContactoVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;

	@Column(name = "name")
	private String name;
	
	@Column(name = "contact__c")
	private String contactoId;
	
	@Column(name = "principal__c")
	private Boolean principal;
	
	@Column(name = "asset__c")
	private String activoId;
	
	@Column(name = "typeofrelationship__c")
	private String tipoRelacionActivoClave;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="typeofrelationship__c", referencedColumnName="codigo", insertable = false, updatable=false)
	@WhereJoinTable(clause = "campo ='TypeofRelationship__c' and objeto='ServiceProduct__c'")
	private PickListsRelacionActivoVO tipoRelacionActivo;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="asset__c", referencedColumnName="sfid", insertable = false, updatable=false)
	private AssetVO activo;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="contact__c", referencedColumnName="sfid", insertable = false, updatable=false)
	private ContactVO contacto;

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

	public String getContactoId() {
		return contactoId;
	}

	public void setContactoId(String contactoId) {
		this.contactoId = contactoId;
	}

	public PickListsRelacionActivoVO getTipoRelacionActivo() {
		return tipoRelacionActivo;
	}

	public void setTipoRelacionActivo(PickListsRelacionActivoVO tipoRelacionActivo) {
		this.tipoRelacionActivo = tipoRelacionActivo;
	}

	public AssetVO getActivo() {
		return activo;
	}

	public void setActivo(AssetVO activo) {
		this.activo = activo;
	}

	public ContactVO getContacto() {
		return contacto;
	}

	public void setContacto(ContactVO contacto) {
		this.contacto = contacto;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	public String getActivoId() {
		return activoId;
	}

	public void setActivoId(String activoId) {
		this.activoId = activoId;
	}

	public String getTipoRelacionActivoClave() {
		return tipoRelacionActivoClave;
	}

	public void setTipoRelacionActivoClave(String tipoRelacionActivoClave) {
		this.tipoRelacionActivoClave = tipoRelacionActivoClave;
	}
	
	
	
	

}