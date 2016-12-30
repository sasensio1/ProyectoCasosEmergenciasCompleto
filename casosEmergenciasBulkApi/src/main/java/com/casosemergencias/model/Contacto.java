package com.casosemergencias.model;

import java.util.Date;
import java.util.List;

import com.casosemergencias.controller.views.ContactView;
import com.casosemergencias.dao.vo.ContactVO;

//Objeto que tiene el modelo de un contacto, se utiliza en el Servicio


public class Contacto extends ObjectLogic {

	/*ID*/                                  private Integer id;
	/*SFID*/                               	private String sfid;
	/*Nombre*/                              private String name;
	/*Firstname*/ 							private String firstname;
	/*Apellido Paterno*/                    private String apellidoPaterno;
	/*Apellido Materno*/                    private String apellidoMaterno;
	/*Tipo de Identidad*/                   private String tipoIdentidad;
	/*AccounRun*/                           private String accountRun;
	/*Run*/									private String run;
	/*Canal Preferente de Contacto*/        private String canalPreferenteContacto;
	/*Teléfono Principal*/                  private String phone;
	/*Teléfono Secundario*/                 private String telefonoSecundario;
	/*Email Principal*/                     private String email;
	/*Fecha nacimiento*/                    private Date fechaNacimiento;
	/*Nombre de la cuenta/*
	/*Dirección Contacto*/                  private String dirContacto;
	/*Email secundario*/                    private String emailSecundario;
	/*Nombre de usuario de Twitter*/        private String sf4twitterTwitterUsername;
	/*Recuento de seguidores de Twitter*/ 
	/*Influencer*/
	/*Influencer Tipo*/
	/*Biografía de Twitter*/
	/*Id. de usuario de Twitter*/           private String sf4twitterTwitterUserId;
	/*Nombre de usuario de Facebook*/       private String sf4twitterFcbkUsername;
	/*Id. de usuario de Facebook*/          private String sf4twitterFcbkUserId; 
	/*Tipo de contacto*/                    private String tipoContacto;
	/*Casos reiterados*/                    private Boolean casosReiterados;
	/*Tipo cuenta asociadas*/               private String tipoCuentaAsociado;
	
	private String influencer;
	
	private String twitterBio;
	
	private String influencerType;
	
	private Integer seguidoresTwitter;
	
	private Direccion dirContactoJoin;
	
	/*Lista de suministros relacionados, se obtienend e una consulta extra a relacion activo contacto*/
	private List<Suministro> suministros;
	
	private Cuenta cuentaJoin;
	
	private List<Caso> casos;
	//Tipo relacion que viene de la Relación activo contacto
	private String relacionActivo;
	private Boolean principal;
	
	/*Joins con picklist*/
	private String labelCanalPreferenteContactoPickList;
	private String labelTipoIdentidadPickList;
	private String labelTipoContactoPickList;
											

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public String getAccountRun() {
		return accountRun;
	}

	public void setAccountRun(String accountRun) {
		this.accountRun = accountRun;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getCanalPreferenteContacto() {
		return canalPreferenteContacto;
	}

	public void setCanalPreferenteContacto(String canalPreferenteContacto) {
		this.canalPreferenteContacto = canalPreferenteContacto;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}

	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDirContacto() {
		return dirContacto;
	}

	public void setDirContacto(String dirContacto) {
		this.dirContacto = dirContacto;
	}

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public String getSf4twitterTwitterUsername() {
		return sf4twitterTwitterUsername;
	}

	public void setSf4twitterTwitterUsername(String sf4twitterTwitterUsername) {
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
	}

	public String getSf4twitterTwitterUserId() {
		return sf4twitterTwitterUserId;
	}

	public void setSf4twitterTwitterUserId(String sf4twitterTwitterUserId) {
		this.sf4twitterTwitterUserId = sf4twitterTwitterUserId;
	}

	public String getSf4twitterFcbkUsername() {
		return sf4twitterFcbkUsername;
	}

	public void setSf4twitterFcbkUsername(String sf4twitterFcbkUsername) {
		this.sf4twitterFcbkUsername = sf4twitterFcbkUsername;
	}

	public String getSf4twitterFcbkUserId() {
		return sf4twitterFcbkUserId;
	}

	public void setSf4twitterFcbkUserId(String sf4twitterFcbkUserId) {
		this.sf4twitterFcbkUserId = sf4twitterFcbkUserId;
	}

	public String getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public Boolean getCasosReiterados() {
		return casosReiterados;
	}

	public void setCasosReiterados(Boolean casosReiterados) {
		this.casosReiterados = casosReiterados;
	}

	public String getTipoCuentaAsociado() {
		return tipoCuentaAsociado;
	}

	public void setTipoCuentaAsociado(String tipoCuentaAsociado) {
		this.tipoCuentaAsociado = tipoCuentaAsociado;
	}

	@Override
	public Object instantiateTargetView() {
		ContactView contacto = new ContactView();
		return contacto;
	}
	
	@Override
	public Object instantiateTargetVO() {
		ContactVO contacto = new ContactVO();
		return contacto;
	}

	public List<Suministro> getSuministros() {
		return suministros;
	}

	public void setSuministros(List<Suministro> suministros) {
		this.suministros = suministros;
	}

	public Cuenta getCuentaJoin() {
		return cuentaJoin;
	}

	public void setCuentaJoin(Cuenta cuentaJoin) {
		this.cuentaJoin = cuentaJoin;
	}

	public List<Caso> getCasos() {
		return casos;
	}

	public void setCasos(List<Caso> casos) {
		this.casos = casos;
	}

	public String getRelacionActivo() {
		return relacionActivo;
	}

	public void setRelacionActivo(String relacionActivo) {
		this.relacionActivo = relacionActivo;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	public String getLabelCanalPreferenteContactoPickList() {
		return labelCanalPreferenteContactoPickList;
	}

	public void setLabelCanalPreferenteContactoPickList(String labelCanalPreferenteContactoPickList) {
		this.labelCanalPreferenteContactoPickList = labelCanalPreferenteContactoPickList;
	}

	public String getLabelTipoIdentidadPickList() {
		return labelTipoIdentidadPickList;
	}

	public void setLabelTipoIdentidadPickList(String labelTipoIdentidadPickList) {
		this.labelTipoIdentidadPickList = labelTipoIdentidadPickList;
	}

	public String getLabelTipoContactoPickList() {
		return labelTipoContactoPickList;
	}

	public void setLabelTipoContactoPickList(String labelTipoContactoPickList) {
		this.labelTipoContactoPickList = labelTipoContactoPickList;
	}

	public String getInfluencer() {
		return influencer;
	}

	public void setInfluencer(String influencer) {
		this.influencer = influencer;
	}

	public String getTwitterBio() {
		return twitterBio;
	}

	public void setTwitterBio(String twitterBio) {
		this.twitterBio = twitterBio;
	}

	public String getInfluencerType() {
		return influencerType;
	}

	public void setInfluencerType(String influencerType) {
		this.influencerType = influencerType;
	}

	public Integer getSeguidoresTwitter() {
		return seguidoresTwitter;
	}

	public void setSeguidoresTwitter(Integer seguidoresTwitter) {
		this.seguidoresTwitter = seguidoresTwitter;
	}

	public Direccion getDirContactoJoin() {
		return dirContactoJoin;
	}

	public void setDirContactoJoin(Direccion dirContactoJoin) {
		this.dirContactoJoin = dirContactoJoin;
	}
}