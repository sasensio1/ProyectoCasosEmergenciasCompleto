package com.casosemergencias.controller.views;

import java.util.Date;

import com.casosemergencias.model.Calle;

public class StreetView extends ObjectView {
	private Boolean isDeleted;
	private Date systemDate;
	private String hcLastop;
	private String hcError;
	private Date createdDate;
	private Date lastModifiedDate;
	private Integer id;
	private String sfid;
	private String name;
	private String recordTypeId;
	private String currencyIsoCode;
	private String region;
	private String literalRegion;
	private String municipality;
	private String literalMunicipality;
	private String street;
	private String streetType;
	private String literalStreetType;
	private String lastModifiedById;
	private String createdById;
	private String ownerId;
	private String country;
	private String company;
	private String labelMunicipalityPickList;
	private String labelRegionPickList;
	private String labelStreetTypePickList;

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

	public String getLabelMunicipalityPickList() {
		return labelMunicipalityPickList;
	}

	public void setLabelMunicipalityPickList(String labelMunicipalityPickList) {
		this.labelMunicipalityPickList = labelMunicipalityPickList;
	}

	public String getLabelRegionPickList() {
		return labelRegionPickList;
	}

	public void setLabelRegionPickList(String labelRegionPickList) {
		this.labelRegionPickList = labelRegionPickList;
	}

	public String getLabelStreetTypePickList() {
		return labelStreetTypePickList;
	}

	public void setLabelStreetTypePickList(String labelStreetTypePickList) {
		this.labelStreetTypePickList = labelStreetTypePickList;
	}

	@Override
	public Object instantiateTargetLogic() {
		Calle calle = new Calle();
		return calle;
	}
}