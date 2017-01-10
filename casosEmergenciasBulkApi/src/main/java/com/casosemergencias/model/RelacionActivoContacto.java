package com.casosemergencias.model;

import java.util.Date;

import com.casosemergencias.dao.vo.AssetVO;
import com.casosemergencias.dao.vo.ContactVO;
import com.casosemergencias.dao.vo.PickListsRelacionActivoVO;

public class RelacionActivoContacto {
	
	private Boolean isDeleted;
	private Date systemDate;
	private String hcLastop;
	private String hcError;
	private Date createdDate;
	private Integer id;
	private String sfid;
	private String name;
	private String contactoId;
	private Boolean principal;
	private String activoId;
	private String tipoRelacionActivoClave;
	private PickListsRelacionActivoVO tipoRelacionActivo;
	private AssetVO activo;
	private ContactVO contacto;
	private Boolean insertActivoBoolean;
	
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
	public Boolean getInsertActivoBoolean() {
		return insertActivoBoolean;
	}
	public void setInsertActivoBoolean(Boolean insertActivoBoolean) {
		this.insertActivoBoolean = insertActivoBoolean;
	}
	
	


}
