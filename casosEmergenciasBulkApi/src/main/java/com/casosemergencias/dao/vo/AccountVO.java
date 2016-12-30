package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.collection.internal.PersistentBag;

import com.casosemergencias.model.Cuenta;

@Entity
@Table(name = "salesforce.account")
public class AccountVO extends ObjectVO implements Serializable {

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

	@Column(name = "name")
	private String name;

	@Column(name = "fatherslastname__c")
	private String apellidoPaterno;

	@Column(name = "motherslastname__c")
	private String apellidoMaterno;

	@Column(name = "identitytype__c")
	private String tipoIdentidad;

	@Column(name = "parent__identityNumber__c")
	private String parentRutEmpresa;

	@Column(name = "masterrecord__identitynumber__c")
	private String accountRun;
	
	@Column(name = "identitynumber__c")
	private String run;

	@Column(name = "birthdate__c")
	private Date fechaNacimiento;

	@Column(name = "phone")
	private String phone;

	@Column(name = "mainphone__c")
	private String telefonoPrincipal;
	
	@Column(name = "secondaryphone__c")
	private String telefonoSecundario;

	@Column(name = "primaryemail__c")
	private String emailPrincipal;

	@Column(name = "secondaryemail__c")
	private String emailSecundario;

	@Column(name = "address__c")
	private String direccion;

	@Column(name = "accountsource")
	private String accountsource;

	@Column(name = "companyid__c")
	private String idEmpresa;
	
	@Column(name = "type")
	private String tipo;
	

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "parentid", referencedColumnName = "sfid", insertable = false, updatable = false)
	private AccountVO parent;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "address__c", referencedColumnName = "sfid", insertable = false, updatable = false)
	private DireccionVO direccionJoin;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid", referencedColumnName = "sfid", insertable = false, updatable = false, nullable = true)
	private List<SuministroVO> suministros;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid", referencedColumnName = "sfid", insertable = false, updatable = false, nullable = true)
	private List<ContactVO> contactos;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid", referencedColumnName = "sfid", insertable = false, updatable = false, nullable = true)
	private List<CaseVO> casos;

	/*Joins con picklist*/
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "identitytype__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsAccountTipoIdentidadVO tipoIdentidadPickList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "type", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsAccountTipoVO tipoPickList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "companyid__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsAccountIdEmpresaVO idEmpresaPickList;
	
	// Tipo de registro de cuenta
	public AccountVO(Boolean isDeleted, Date systemDate, String hcLastop, String hcError, Integer id, String sfid,
			String name, String apellidoPaterno, String apellidoMaterno, String tipoIdentidad, String parentRutEmpresa,
			String accountRun, Date fechaNacimiento, String phone, String telefonoPrincipal, String telefonoSecundario,
			String email, String emailSecundario, String direccion, String accountsource, String idEmpresa,
			List<SuministroVO> suministros, List<ContactVO> contactos,List<CaseVO> casos,
			PickListsAccountTipoIdentidadVO tipoIdentidadPickList, PickListsAccountIdEmpresaVO idEmpresaPickList,PickListsAccountTipoVO tipoPickList,String tipo) {
		super();
		this.isDeleted = isDeleted;
		this.systemDate = systemDate;
		this.hcLastop = hcLastop;
		this.hcError = hcError;
		this.id = id;
		this.sfid = sfid;
		this.name = name;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.tipoIdentidad = tipoIdentidad;
		this.parentRutEmpresa = parentRutEmpresa;
		this.accountRun = accountRun;
		this.fechaNacimiento = fechaNacimiento;
		this.phone = phone;
		this.telefonoPrincipal = telefonoPrincipal;
		this.telefonoSecundario = telefonoSecundario;
		this.emailPrincipal = email;
		this.emailSecundario = emailSecundario;
		this.direccion = direccion;
		this.accountsource = accountsource;
		this.idEmpresa = idEmpresa;
		this.suministros = suministros;
		this.contactos = contactos;
		this.casos=casos;
		this.tipoIdentidadPickList = tipoIdentidadPickList;
		this.idEmpresaPickList = idEmpresaPickList;
		this.tipoPickList=tipoPickList;
		this.tipo=tipo;
	}

	public AccountVO() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTipoIdentidad() {
		return tipoIdentidad;
	}

	public void setTipoIdentidad(String tipoIdentidad) {
		this.tipoIdentidad = tipoIdentidad;
	}

	public String getParentRutEmpresa() {
		return parentRutEmpresa;
	}

	public void setParentRutEmpresa(String parentRutEmpresa) {
		this.parentRutEmpresa = parentRutEmpresa;
	}

	public String getAccountRun() {
		return accountRun;
	}

	public void setAccountRun(String accountRun) {
		this.accountRun = accountRun;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}

	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}
	
	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}

	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
	}

	public String getEmailPrincipal() {
		return emailPrincipal;
	}

	public void setEmailPrincipal(String email) {
		this.emailPrincipal = email;
	}

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getAccountsource() {
		return accountsource;
	}

	public void setAccountsource(String accountsource) {
		this.accountsource = accountsource;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<SuministroVO> getSuministros() {
		if (suministros instanceof PersistentBag) {
			PersistentBag bag = (PersistentBag) suministros;
			if (bag.getStoredSnapshot() == null) {
				return null;
			}
		}
		return suministros;
	}

	public void setSuministros(List<SuministroVO> suministros) {
		this.suministros = suministros;
	}

	public List<ContactVO> getContactos() {
		if (contactos instanceof PersistentBag) {
			PersistentBag bag = (PersistentBag) contactos;
			if (bag.getStoredSnapshot() == null) {
				return null;
			}
		}
		return contactos;
	}

	public void setContactos(List<ContactVO> contactos) {
		this.contactos = contactos;
	}
	
	public List<CaseVO> getCasos() {
		if (casos instanceof PersistentBag) {
			PersistentBag bag = (PersistentBag) casos;
			if (bag.getStoredSnapshot() == null) {
				return null;
			}
		}
		return casos;
	}
	
	public void setCasos(List<CaseVO> casos) {
		this.casos= casos;
	}

	@Override
	public Object instantiateTargetLogic() {
		Cuenta cuenta = new Cuenta();
		return cuenta;
	}

	public PickListsAccountTipoIdentidadVO getTipoIdentidadPickList() {
		return tipoIdentidadPickList;
	}

	public void setTipoIdentidadPickList(PickListsAccountTipoIdentidadVO tipoIdentidadPickList) {
		this.tipoIdentidadPickList = tipoIdentidadPickList;
	}

	public PickListsAccountIdEmpresaVO getIdEmpresaPickList() {
		return idEmpresaPickList;
	}

	public void setIdEmpresaPickList(PickListsAccountIdEmpresaVO idEmpresaPickList) {
		this.idEmpresaPickList = idEmpresaPickList;
	}
	
	public String getLabelTipoIdentidadPickList() {
		String result = this.getTipoIdentidad();
		if (this.getTipoIdentidadPickList() != null) {
			result = this.getTipoIdentidadPickList().getValor();
		}
		return result;
	}
	
	
	public String getLabelTipoPickList() {
		String result = this.getTipo();
		if (this.getTipoPickList() != null) {
			result = this.getTipoPickList().getValor();
		}
		return result;
	}
	
	public String getLabelIdEmpresaPickList() {
		String result = this.getIdEmpresa();
		if (this.getIdEmpresaPickList() != null) {
			result = this.getIdEmpresaPickList().getValor();
		}
		return result;
	}
	
	

	public AccountVO getParent() {
		return parent;
	}

	public void setParent(AccountVO parent) {
		this.parent = parent;
	}

	public DireccionVO getDireccionJoin() {
		return direccionJoin;
	}

	public void setDireccionJoin(DireccionVO direccionJoin) {
		this.direccionJoin = direccionJoin;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public PickListsAccountTipoVO getTipoPickList() {
		return tipoPickList;
	}

	public void setTipoPickList(PickListsAccountTipoVO tipoPickList) {
		this.tipoPickList = tipoPickList;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}