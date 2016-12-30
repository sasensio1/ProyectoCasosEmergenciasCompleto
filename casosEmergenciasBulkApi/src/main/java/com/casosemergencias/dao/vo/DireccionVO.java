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

import com.casosemergencias.model.Direccion;


@Entity
@Table(name="salesforce.address__c")
public class DireccionVO extends ObjectVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isDeleted")
	private Boolean isDeleted;
	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "systemmodstamp")
	private Date systemmodstamp;
	//campo de Heroku
	@Column(name = "_hc_lastop")
	private String hcLastop;
	//campo de Heroku
	@Column(name = "_hc_err")
	private String hcError;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;
	
	@Column(name = "createddate")
	private Date createddate;
			
	@Column(name = "region__c")
	private String region;
	
	@Column(name = "municipality__c")
	private String comuna;
	
	@Column(name = "street_type__c")
	private String tipoCalle;

	@Column(name = "streetmd__c")
	private String calle;
	
	@Column(name = "number__c")
	private String numero;
	
	@Column(name = "department__c")
	private String departamento;
	
	@Column(name = "name")
	private String name;
		
	@Column(name = "concatenatedaddress__c")
	private String direccionConcatenada;
	
	@Column(name = "corner__c")
	private String esquina;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "street_type__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'Tipo_de_Calle__c' and objeto = 'Direccion__c'")
	private PickListsDireccionTipoCalleVO tipoCallePickList;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "region__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'Regi_n__c' and objeto = 'Direccion__c'")
	private PickListsDireccionRegionVO regionPickList;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "streetmd__c", referencedColumnName = "sfid", insertable = false, updatable = false)
	private StreetVO calleJoin;
	
	public DireccionVO(Boolean isdeleted, Date systemmodstamp, String hcLastop, String hcError, Integer id, String sfid,
			Date createddate, String region, String comuna, String tipoCalle, String calle, String numero,
			String departamento, String name, String direccionConcatenada, String esquina,
			PickListsDireccionTipoCalleVO tipoCallePickList, PickListsDireccionRegionVO regionPickList, StreetVO calleJoin) {
		super();
		this.isDeleted = isdeleted;
		this.systemmodstamp = systemmodstamp;
		this.hcLastop = hcLastop;
		this.hcError = hcError;
		this.id = id;
		this.sfid = sfid;
		this.createddate = createddate;
		this.region = region;
		this.comuna = comuna;
		this.tipoCalle = tipoCalle;
		this.calle = calle;
		this.numero = numero;
		this.departamento = departamento;
		this.name = name;
		this.direccionConcatenada = direccionConcatenada;
		this.esquina = esquina;
		this.tipoCallePickList = tipoCallePickList;
		this.regionPickList = regionPickList;
		this.calleJoin = calleJoin;
	}

	public DireccionVO() {
		super();
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isdeleted) {
		this.isDeleted = isdeleted;
	}

	public Date getSystemmodstamp() {
		return systemmodstamp;
	}

	public void setSystemmodstamp(Date systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
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

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getTipoCalle() {
		return tipoCalle;
	}

	public void setTipoCalle(String tipoCalle) {
		this.tipoCalle = tipoCalle;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDireccionConcatenada() {
		return direccionConcatenada;
	}

	public void setDireccionConcatenada(String direccionConcatenada) {
		this.direccionConcatenada = direccionConcatenada;
	}

	public String getEsquina() {
		return esquina;
	}

	public void setEsquina(String esquina) {
		this.esquina = esquina;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Object instantiateTargetLogic() {
		Direccion direccion = new Direccion();
		return direccion;
	}

	public PickListsDireccionTipoCalleVO getTipoCallePickList() {
		return tipoCallePickList;
	}

	public void setTipoCallePickList(PickListsDireccionTipoCalleVO tipoCallePickList) {
		this.tipoCallePickList = tipoCallePickList;
	}

	public PickListsDireccionRegionVO getRegionPickList() {
		return regionPickList;
	}

	public void setRegionPickList(PickListsDireccionRegionVO regionPickList) {
		this.regionPickList = regionPickList;
	}
	
	public String getLabelTipoCallePickList() {
		String result = this.getTipoCalle();
		if (this.getTipoCallePickList() != null) {
			result = this.getTipoCallePickList().getValor();
		}
		return result;
	}
	
	public String getLabelRegionPickList() {
		String result = this.getRegion();
		if (this.getRegionPickList() != null) {
			result = this.getRegionPickList().getValor();
		}
		return result;
	}

	public StreetVO getCalleJoin() {
		return calleJoin;
	}

	public void setCalleJoin(StreetVO calleJoin) {
		this.calleJoin = calleJoin;
	}
}