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

import org.hibernate.annotations.Where;

import com.casosemergencias.model.Calle;

@Entity
@Table(name = "salesforce.street__c")
public class StreetVO extends ObjectVO implements Serializable {
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

	@Column(name = "createddate")
	private Date createdDate;

	@Column(name = "lastmodifieddate")
	private Date lastModifiedDate;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "sfid")
	private String sfid;

	@Column(name = "name")
	private String name;

	@Column(name = "recordtypeid")
	private String recordTypeId;

	@Column(name = "currencyisocode")
	private String currencyIsoCode;

	@Column(name = "region__c")
	private String region;

	@Column(name = "literal_region__c")
	private String literalRegion;

	@Column(name = "municipality__c")
	private String municipality;

	@Column(name = "literal_municipality__c")
	private String literalMunicipality;

	@Column(name = "street__c")
	private String street;

	@Column(name = "street_type__c")
	private String streetType;

	@Column(name = "literal_street_type__c")
	private String literalStreetType;

	@Column(name = "lastmodifiedbyid")
	private String lastModifiedById;

	@Column(name = "createdbyid")
	private String createdById;

	@Column(name = "ownerid")
	private String ownerId;

	@Column(name = "country__c")
	private String country;

	@Column(name = "company__c")
	private String company;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "municipality__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@Where(clause = "objeto='street__c'  AND campo='Municipality__c'")
	private PickListsStreetMunicipalityVO municipalityPickList;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "region__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@Where(clause = "objeto='street__c'  AND campo='Region__c'")
	private PickListsStreetRegionVO regionPickList;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "street_type__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@Where(clause = "objeto='street__c'  AND campo='Street_Type__c'")
	private PickListsStreetTypeVO streetTypePickList;
	
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

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
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

	public String getRecordTypeId() {
		return recordTypeId;
	}

	public void setRecordTypeId(String recordTypeId) {
		this.recordTypeId = recordTypeId;
	}

	public String getCurrencyIsoCode() {
		return currencyIsoCode;
	}

	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLiteralRegion() {
		return literalRegion;
	}

	public void setLiteralRegion(String literalRegion) {
		this.literalRegion = literalRegion;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getLiteralMunicipality() {
		return literalMunicipality;
	}

	public void setLiteralMunicipality(String literalMunicipality) {
		this.literalMunicipality = literalMunicipality;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public String getLiteralStreetType() {
		return literalStreetType;
	}

	public void setLiteralStreetType(String literalStreetType) {
		this.literalStreetType = literalStreetType;
	}

	public String getLastModifiedById() {
		return lastModifiedById;
	}

	public void setLastModifiedById(String lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setMunicipalityPickList(PickListsStreetMunicipalityVO municipalityPickList) {
		this.municipalityPickList = municipalityPickList;
	}
	
	public PickListsStreetMunicipalityVO getMunicipalityPickList() {
		return municipalityPickList;
	}
	
	public String getLabelMunicipalityPickList() {
		String result = this.getMunicipality();
		if (this.getMunicipalityPickList() != null) {
			result = this.getMunicipalityPickList().getValor();
		}
		return result;
	}

	public void setRegionPickList(PickListsStreetRegionVO regionPickList) {
		this.regionPickList = regionPickList;
	}
	
	public PickListsStreetRegionVO getRegionPickList() {
		return regionPickList;
	}

	public String getLabelRegionPickList() {
		String result = this.getRegion();
		if (this.getRegionPickList() != null) {
			result = this.getRegionPickList().getValor();
		}
		return result;
	}
	
	public void setStreetTypePickList(PickListsStreetTypeVO streetTypePickList) {
		this.streetTypePickList = streetTypePickList;
	}
	
	public PickListsStreetTypeVO getStreetTypePickList() {
		return streetTypePickList;
	}
	
	public String getLabelStreetTypePickList() {
		String result = this.getStreetType();
		if (this.getStreetTypePickList() != null) {
			result = this.getStreetTypePickList().getValor();
		}
		return result;
	}

	@Override
	public Object instantiateTargetLogic() {
		Calle calle = new Calle();
		return calle;
	}
}