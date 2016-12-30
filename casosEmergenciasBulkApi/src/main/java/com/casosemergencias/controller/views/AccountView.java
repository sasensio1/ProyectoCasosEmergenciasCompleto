package com.casosemergencias.controller.views;

import java.util.Date;
import java.util.List;

import com.casosemergencias.model.Cuenta;

public class AccountView extends ObjectView {
	/* ID */ private Integer id;
	/* SFID */ private String sfid;
	/* Nombre de la cuenta */ private String name;
	/* Apellido Paterno */ private String apellidoPaterno;
	/* Apellido Materno */ private String apellidoMaterno;
	/* Tipo de Identidad */ private String tipoIdentidad;
	/* RUT empresa */ private String parentRutEmpresa;
	/* RUN */ private String accountRun;
	/* RUN */ private String run;	
	/* Fecha nacimiento */ private Date fechaNacimiento;
	/* Teléfono */ private String phone;
	/* Teléfono principal*/ private String telefonoPrincipal;
	/* Teléfono Secundario */ private String telefonoSecundario;
	/* Email Principal */ private String emailPrincipal;
	/* Email secundario */ private String emailSecundario;
	/* Dirección */ private String direccion;
	/* Cuenta principal */ private String accountsource;
	/* Id Empresa */ private String idEmpresa;
	/* Suministros asociados */ private List<SuministroView> suministros;
	/* Contactos asociados */ private List<ContactView> contactos;
	/* Casos asociados */ private List<CaseView> casos;
	// Tipo de registro de cuenta

	/*Joins con picklist*/
	private String labelTipoIdentidadPickList;
	private String labelIdEmpresaPickList;
	private String labelTipoPickList;
	
	private AccountView parent;
	
	private DireccionView direccionJoin;
	
	//variables con las que controlamos si las tablas tienen mas de 10 registros. Si los tienen en el jsp se dara la opcion de 
	//mostrar todos los registros
	private boolean controlNumSuministros;
	private boolean controlNumCasos;
	private boolean controlNumContactos;
	
	
	/* Getters y Setters */
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

	public void setEmailPrincipal(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
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

	public List<SuministroView> getSuministros() {
		return suministros;
	}

	public void setSuministros(List<SuministroView> suministros) {
		this.suministros = suministros;
	}

	public List<ContactView> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactView> contactos) {
		this.contactos = contactos;
	}
	
	public List<CaseView> getCasos() {
		return casos;
	}

	public void setCasos(List<CaseView> casos) {
		this.casos = casos;
	}

	@Override
	public Object instantiateTargetLogic() {
		Cuenta cuenta = new Cuenta();
		return cuenta;
	}

	public String getLabelTipoIdentidadPickList() {
		return labelTipoIdentidadPickList;
	}

	public void setLabelTipoIdentidadPickList(String labelTipoIdentidadPickList) {
		this.labelTipoIdentidadPickList = labelTipoIdentidadPickList;
	}

	public String getLabelIdEmpresaPickList() {
		return labelIdEmpresaPickList;
	}

	public void setLabelIdEmpresaPickList(String labelIdEmpresaPickList) {
		this.labelIdEmpresaPickList = labelIdEmpresaPickList;
	}

	public AccountView getParent() {
		return parent;
	}

	public void setParent(AccountView parent) {
		this.parent = parent;
	}

	public DireccionView getDireccionJoin() {
		return direccionJoin;
	}

	public void setDireccionJoin(DireccionView direccionJoin) {
		this.direccionJoin = direccionJoin;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public boolean isControlNumSuministros() {
		return controlNumSuministros;
	}

	public void setControlNumSuministros(boolean controlNumSuministros) {
		this.controlNumSuministros = controlNumSuministros;
	}

	public boolean isControlNumCasos() {
		return controlNumCasos;
	}

	public void setControlNumCasos(boolean controlNumCasos) {
		this.controlNumCasos = controlNumCasos;
	}

	public boolean isControlNumContactos() {
		return controlNumContactos;
	}

	public void setControlNumContactos(boolean controlNumContactos) {
		this.controlNumContactos = controlNumContactos;
	}

	public String getLabelTipoPickList() {
		return labelTipoPickList;
	}

	public void setLabelTipoPickList(String labelTipoPickList) {
		this.labelTipoPickList = labelTipoPickList;
	}
	
	
	
}