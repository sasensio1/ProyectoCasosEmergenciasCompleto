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

import com.casosemergencias.model.Caso;

@Entity
@Table(name = "salesforce.case")
public class CaseVO extends ObjectVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// campo de Heroku
	// Used to track the IsDeleted field from Salesforce allowing Heroku Connect
	// to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isdeleted;
	// campo de Heroku
	// Used to track the IsDeleted field from Salesforce allowing Heroku Connect
	// to handle deletes when polling for updates
	@Column(name = "systemmodstamp")
	private Date systemmodstamp;
	// campo de Heroku
	@Column(name = "_hc_lastop")
	private String _hc_lastop;
	// campo de Heroku
	@Column(name = "_hc_err")
	private String _hc_err;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "sfid")
	private String sfid;

	@Column(name = "createddate")
	private Date fechaApertura;

	@Column(name = "subject")
	private String asunto;

	@Column(name = "estimatedstandardizationtime__c")
	private Date fechaEstimadaCierre;

	@Column(name = "accountid")
	private String nombreCuenta;

	@Column(name = "casefavorability__c")
	private String favorabilidadDelCaso;

	@Column(name = "secflag__c")
	private String flagSec;

	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;

	@Column(name = "electrodependantvalidate__c")
	private Boolean validarElectrodependiente;

	@Column(name = "sf4twitter__twitter_username__c")
	private String sf4twitterTwitterUsername;

	@Column(name = "ownerid")
	private String propietarioCaso;

	@Column(name = "subcause__c")
	private String submotivo;

	@Column(name = "unity__c")
	private String callCenter;

	@Column(name = "validationsenterror__c")
	private Boolean falloEnvioValidacion;

	@Column(name = "literalmunicipality__c")
	private String literalComuna;

	@Column(name = "updatecontact__c")
	private Boolean actDatosContacto;

	@Column(name = "creationobservationerror__c")
	private String falloCreacionObservacion;

	@Column(name = "preadmissionstatus__c")
	private Boolean estadoPreingreso;

	@Column(name = "notificationemail__c")
	private String emailNotificacion;

	@Column(name = "aphour__c")
	private Double horaap;

	@Column(name = "inservicenumber__c")
	private String numeroInservice;

	@Column(name = "suppliedphone")
	private String suppliedphone;

	@Column(name = "meternumber__c")
	private String numeroMedidor;

	@Column(name = "mailbody__c")
	private String cuerpoMail;

	@Column(name = "contactphone")
	private String telefonoContacto;

	@Column(name = "traceerrorinservice__c")
	private String trazaFalloInservice;

	@Column(name = "notificationchannel__c")
	private String canalNotificacion;

	@Column(name = "createdbyid")
	private String createdbyid;

	@Column(name = "category__c")
	private String categoria;

	@Column(name = "flag__c")
	private String flag;

	@Column(name = "observations__c")
	private String observaciones;

	@Column(name = "casenumber")
	private String numeroCaso;

	@Column(name = "url__c")
	private String url;

	@Column(name = "status")
	private String estado;

	@Column(name = "sf4twitter__twitterid__c")
	private String sf4twitterTwitterid;

	@Column(name = "customerresponse__c")
	private String respuestaAlCliente;

	@Column(name = "apcasenumber__c")
	private String numeroCasoAp;

	@Column(name = "isescalated")
	private Boolean isescalated;

	@Column(name = "interaction__c")
	private String interaccion;

	@Column(name = "typesecattention__c")
	private String tipoAtencionSEC;

	@Column(name = "substatus__c")
	private String subEstado;

	@Column(name = "sechour__c")
	private Date horaSec;

	@Column(name = "pendingvalidationaggcond__c")
	private Boolean pendienteValidacionCondagr;

	@Column(name = "previousexecutive__c")
	private String ejecutivoAnterior;

	@Column(name = "suppliedcompany")
	private String suppliedCompany;

	@Column(name = "aggravatedconditionstatus__c")
	private String estadoCondicionAgravante;

	@Column(name = "cancelhour__c")
	private Date horaCancelado;

	@Column(name = "pointofdelivery__c")
	private String suministro;

	@Column(name = "parentid")
	private String parent;

	@Column(name = "ui__c")
	private Boolean ui;

	@Column(name = "pointofdeliverynumber__c")
	private String numSum;

	@Column(name = "twitter__c")
	private String twitter;

	@Column(name = "suppliedname")
	private String suppliedName;

	@Column(name = "closeddate")
	private Date fechaCierre;

	@Column(name = "inservicesenterror__c")
	private Boolean falloEnvioInservice;

	@Column(name = "description")
	private String description;

	@Column(name = "arrivedhour__c")
	private Date horaArribado;

	@Column(name = "origin")
	private String canalOrigen;

	@Column(name = "statusdescription__c")
	private String descripcionEstado;

	@Column(name = "sf4twitter__author_external_id__c")
	private String sf4twitterAuthorExternalId;

	@Column(name = "closedhour__c")
	private Date horaCerrado;

	@Column(name = "literalaggravatedcondition__c")
	private String literalCondicionAgravante;

	@Column(name = "type")
	private String type;

	@Column(name = "pointofdeliveryaddress__c")
	private String direccionSuministro;

	@Column(name = "pendinghour__c")
	private Date horaPendiente;

	@Column(name = "ani__c")
	private String ani;

	@Column(name = "idfacebook__c")
	private String facebook;

	@Column(name = "reason")
	private String peticion;

	@Column(name = "address__c")
	private String direccion;

	@Column(name = "asignedhour__c")
	private Date horaAsignado;

	@Column(name = "contactid")
	private String nombreContacto;

	@Column(name = "predispatchinghour__c")
	private Date horaPredespacho;

	@Column(name = "onroutehour__c")
	private Date horaEnruta;

	@Column(name = "companyid__c")
	private String idEmpresa;

	@Column(name = "programmedhour__c")
	private Date horaProgramado;

	@Column(name = "followersnumber__c")
	private Double numeroSeguidoresDel;

	@Column(name = "literalcategory__c")
	private String literalCategorias;

	@Column(name = "recordtypeid")
	private String recordtypeId;

	@Column(name = "municipality__c")
	private String comuna;

	@Column(name = "priority")
	private String prioridad;

	@Column(name = "substatusinsvalue__c")
	private String valorSubestadoins;

	@Column(name = "electrodependantcontrol__c")
	private Boolean controlElectrodependiente;
	
	@Column(name = "cancel__c")
	private Boolean cancelar;
	
	@Column(name = "aggravatedcondition__c")
	private String condicionAgravante;
	
	@Column(name = "heroku_user__c")
	private String herokuUsername;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "reason", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'Reason' and objeto = 'Case'")
	private PickListsCaseVO peticionPickList;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'Status' and objeto = 'Case'")
	private PickListsCaseVO estadoPickList;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "substatus__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'SubStatus__c' and objeto = 'Case'")
	private PickListsCaseVO subestadoPickList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "subcause__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'SubCause__c' and objeto = 'Case'")
	private PickListsCaseVO submotivoPickList;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "origin", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'Origin' and objeto = 'Case'")
	private PickListsCaseOriginVO canalOrigenPickList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "aggravatedcondition__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'AggravatedCondition__c' and objeto = 'Case'")
	private PickListsCaseVO condicionAgravantePickList;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "notificationchannel__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'NotificationChannel__c' and objeto = 'Case'")
	private PickListsCaseCanalNotificacionVO canalNotificacionPickList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "casefavorability__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'CaseFavorability__c' and objeto = 'Case'")
	private PickListsCaseVO favorabilidadDelCasoPickList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "type", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'Type' and objeto = 'Case'")
	private PickListsCaseTypeVO typeCasoPickList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "unity__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'Unity__c' and objeto = 'Case'")
	private PickListsCaseCallCenterVO callCenterPickList;
	
	// vamos a recuperar los datos de Cuenta,Contacto,Suministro y Usuario
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contactid", referencedColumnName = "sfid", insertable = false, updatable = false)
	private ContactVO contactoJoin;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid", referencedColumnName = "sfid", insertable = false, updatable = false)
	private AccountVO cuentaJoin;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pointofdelivery__c", referencedColumnName = "sfid", insertable = false, updatable = false)
	private SuministroVO suministroJoin;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address__c", referencedColumnName = "sfid", insertable = false, updatable = false)
	private DireccionVO direccionJoin;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ownerid", referencedColumnName = "sfid", insertable = false, updatable = false)
	private UserVO userJoin;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentid", referencedColumnName = "sfid", insertable = false, updatable = false)
	private CaseVO casoPrincipalJoin;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ownerid", referencedColumnName = "sfid", insertable = false, updatable = false)
	private GroupVO groupJoin;

	public CaseVO(Boolean isdeleted, Date systemmodstamp, String _hc_lastop, String _hc_err, Integer id, String sfid,
			Date fechaApertura, String asunto, Date fechaEstimadaCierre, String nombreCuenta,
			String favorabilidadDelCaso, String flagSec, String lastmodifiedbyid, Boolean validarElectrodependiente,
			String sf4twitterTwitterUsername, String propietarioCaso, String submotivo, String callCenter,
			Boolean falloEnvioValidacion, String literalComuna, Boolean actDatosContacto,
			String falloCreacionObservacion, Boolean estadoPreingreso, String emailNotificacion, Double horaap,
			String numeroInservice, String suppliedphone, String numeroMedidor, String cuerpoMail,
			String telefonoContacto, String trazaFalloInservice, Date horaSec, String canalNotificacion,
			String createdbyid, String categoria, String flag, String observaciones, String numeroCaso, String url,
			String estado, String sf4twitterTwitterid, String respuestaAlCliente, String numeroCasoAp,
			Boolean isescalated, String interaccion, String tipoAtencionSEC, String subEstado,
			Boolean pendienteValidacionCondagr, String ejecutivoAnterior, String suppliedCompany,
			String estadoCondicionAgravante, Date horaCancelado, String suministro, String parent, Boolean ui,
			String numSum, String twitter, String suppliedName, Date closedDate, Boolean falloEnvioInservice,
			String description, Date horaArribado, String canalOrigen, String descripcionEstado,
			String sf4twitterAuthorExternalId, Date horaCerrado, String literalCondicionAgravante, String type,
			String direccionSuministro, Date horaPendiente, String ani, String facebook, String peticion,
			String direccion, Date horaAsignado, String nombreContacto, Date horaPredespacho, Date horaEnruta,
			String idEmpresa, Date horaProgramado, Double numeroSeguidoresDel, String literalCategorias,
			String recordtypeId, String comuna, String prioridad, String valorSubestadoins,
			Boolean controlElectrodependiente, Boolean cancelar, String condicionAgravante, String herokuUsername,
			PickListsCaseVO subestadoPickList, PickListsCaseVO submotivoPickList, PickListsCaseVO peticionPickList,
			PickListsCaseOriginVO canalOrigenPickList, PickListsCaseVO condicionAgravantePickList,
			PickListsCaseCanalNotificacionVO canalNotificacionPickList, PickListsCaseVO favorabilidadDelCasoPickList,
			PickListsCaseTypeVO typeCasoPickList, ContactVO contactoJoin, AccountVO cuentaJoin,
			SuministroVO suministroJoin, DireccionVO direccionJoin, UserVO userJoin, CaseVO casoPrincipalJoin,
			GroupVO groupJoin, Date fechaCierre) {
		super();
		this.isdeleted = isdeleted;
		this.systemmodstamp = systemmodstamp;
		this._hc_lastop = _hc_lastop;
		this._hc_err = _hc_err;
		this.id = id;
		this.sfid = sfid;
		this.fechaApertura = fechaApertura;
		this.asunto = asunto;
		this.fechaEstimadaCierre = fechaEstimadaCierre;
		this.nombreCuenta = nombreCuenta;
		this.favorabilidadDelCaso = favorabilidadDelCaso;
		this.flagSec = flagSec;
		this.lastmodifiedbyid = lastmodifiedbyid;
		this.validarElectrodependiente = validarElectrodependiente;
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
		this.propietarioCaso = propietarioCaso;
		this.submotivo = submotivo;
		this.callCenter = callCenter;
		this.falloEnvioValidacion = falloEnvioValidacion;
		this.literalComuna = literalComuna;
		this.actDatosContacto = actDatosContacto;
		this.falloCreacionObservacion = falloCreacionObservacion;
		this.estadoPreingreso = estadoPreingreso;
		this.emailNotificacion = emailNotificacion;
		this.horaap = horaap;
		this.numeroInservice = numeroInservice;
		this.suppliedphone = suppliedphone;
		this.numeroMedidor = numeroMedidor;
		this.cuerpoMail = cuerpoMail;
		this.telefonoContacto = telefonoContacto;
		this.trazaFalloInservice = trazaFalloInservice;
		this.canalNotificacion = canalNotificacion;
		this.createdbyid = createdbyid;
		this.categoria = categoria;
		this.flag = flag;
		this.observaciones = observaciones;
		this.numeroCaso = numeroCaso;
		this.url = url;
		this.estado = estado;
		this.sf4twitterTwitterid = sf4twitterTwitterid;
		this.respuestaAlCliente = respuestaAlCliente;
		this.numeroCasoAp = numeroCasoAp;
		this.isescalated = isescalated;
		this.interaccion = interaccion;
		this.tipoAtencionSEC = tipoAtencionSEC;
		this.subEstado = subEstado;
		this.horaSec = horaSec;
		this.pendienteValidacionCondagr = pendienteValidacionCondagr;
		this.ejecutivoAnterior = ejecutivoAnterior;
		this.suppliedCompany = suppliedCompany;
		this.estadoCondicionAgravante = estadoCondicionAgravante;
		this.horaCancelado = horaCancelado;
		this.suministro = suministro;
		this.parent = parent;
		this.ui = ui;
		this.numSum = numSum;
		this.twitter = twitter;
		this.suppliedName = suppliedName;
		this.fechaCierre = fechaCierre;
		this.falloEnvioInservice = falloEnvioInservice;
		this.description = description;
		this.horaArribado = horaArribado;
		this.canalOrigen = canalOrigen;
		this.descripcionEstado = descripcionEstado;
		this.sf4twitterAuthorExternalId = sf4twitterAuthorExternalId;
		this.horaCerrado = horaCerrado;
		this.literalCondicionAgravante = literalCondicionAgravante;
		this.type = type;
		this.direccionSuministro = direccionSuministro;
		this.horaPendiente = horaPendiente;
		this.ani = ani;
		this.facebook = facebook;
		this.peticion = peticion;
		this.direccion = direccion;
		this.horaAsignado = horaAsignado;
		this.nombreContacto = nombreContacto;
		this.horaPredespacho = horaPredespacho;
		this.horaEnruta = horaEnruta;
		this.idEmpresa = idEmpresa;
		this.horaProgramado = horaProgramado;
		this.numeroSeguidoresDel = numeroSeguidoresDel;
		this.literalCategorias = literalCategorias;
		this.recordtypeId = recordtypeId;
		this.comuna = comuna;
		this.prioridad = prioridad;
		this.valorSubestadoins = valorSubestadoins;
		this.controlElectrodependiente = controlElectrodependiente;
		this.cancelar = cancelar;
		this.condicionAgravante = condicionAgravante;
		this.herokuUsername=herokuUsername;
		this.subestadoPickList = subestadoPickList;
		this.submotivoPickList = submotivoPickList;
		this.canalOrigenPickList = canalOrigenPickList;
		this.peticionPickList = peticionPickList;
		this.condicionAgravantePickList = condicionAgravantePickList;
		this.canalNotificacionPickList = canalNotificacionPickList;
		this.favorabilidadDelCasoPickList = favorabilidadDelCasoPickList;
		this.typeCasoPickList=typeCasoPickList;
		this.contactoJoin = contactoJoin;
		this.cuentaJoin = cuentaJoin;
		this.suministroJoin = suministroJoin;
		this.direccionJoin = direccionJoin;
		this.userJoin= userJoin;
		this.casoPrincipalJoin=casoPrincipalJoin;
		this.groupJoin=groupJoin;
	}

	public CaseVO() {
		super();
	}

	public Boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Date getSystemmodstamp() {
		return systemmodstamp;
	}

	public void setSystemmodstamp(Date systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
	}

	public String get_hc_lastop() {
		return _hc_lastop;
	}

	public void set_hc_lastop(String _hc_lastop) {
		this._hc_lastop = _hc_lastop;
	}

	public String get_hc_err() {
		return _hc_err;
	}

	public void set_hc_err(String _hc_err) {
		this._hc_err = _hc_err;
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

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Date getFechaEstimadaCierre() {
		return fechaEstimadaCierre;
	}

	public void setFechaEstimadaCierre(Date fechaEstimadaCierre) {
		this.fechaEstimadaCierre = fechaEstimadaCierre;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public String getFavorabilidadDelCaso() {
		return favorabilidadDelCaso;
	}

	public void setFavorabilidadDelCaso(String favorabilidadDelCaso) {
		this.favorabilidadDelCaso = favorabilidadDelCaso;
	}

	public String getFlagSec() {
		return flagSec;
	}

	public void setFlagSec(String flagSec) {
		this.flagSec = flagSec;
	}

	public String getLastmodifiedbyid() {
		return lastmodifiedbyid;
	}

	public void setLastmodifiedbyid(String lastmodifiedbyid) {
		this.lastmodifiedbyid = lastmodifiedbyid;
	}
	
	public Boolean getValidarElectrodependiente() {
		return validarElectrodependiente;
	}

	public void setValidarElectrodependiente(Boolean validarElectrodependiente) {
		this.validarElectrodependiente = validarElectrodependiente;
	}

	public String getSf4twitterTwitterUsername() {
		return sf4twitterTwitterUsername;
	}

	public void setSf4twitterTwitterUsername(String sf4twitterTwitterUsername) {
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
	}

	public String getPropietarioCaso() {
		return propietarioCaso;
	}

	public void setPropietarioCaso(String propietarioCaso) {
		this.propietarioCaso = propietarioCaso;
	}
	
	public String getSubmotivo() {
		return submotivo;
	}

	public void setSubmotivo(String submotivo) {
		this.submotivo = submotivo;
	}

	public String getCallCenter() {
		return callCenter;
	}

	public void setCallCenter(String callCenter) {
		this.callCenter = callCenter;
	}

	public Boolean getFalloEnvioValidacion() {
		return falloEnvioValidacion;
	}

	public void setFalloEnvioValidacion(Boolean falloEnvioValidacion) {
		this.falloEnvioValidacion = falloEnvioValidacion;
	}

	public String getLiteralComuna() {
		return literalComuna;
	}

	public void setLiteralComuna(String literalComuna) {
		this.literalComuna = literalComuna;
	}

	public Boolean getActDatosContacto() {
		return actDatosContacto;
	}

	public void setActDatosContacto(Boolean actDatosContacto) {
		this.actDatosContacto = actDatosContacto;
	}

	public String getFalloCreacionObservacion() {
		return falloCreacionObservacion;
	}

	public void setFalloCreacionObservacion(String falloCreacionObservacion) {
		this.falloCreacionObservacion = falloCreacionObservacion;
	}

	public Boolean getEstadoPreingreso() {
		return estadoPreingreso;
	}

	public void setEstadoPreingreso(Boolean estadoPreingreso) {
		this.estadoPreingreso = estadoPreingreso;
	}

	public String getEmailNotificacion() {
		return emailNotificacion;
	}

	public void setEmailNotificacion(String emailNotificacion) {
		this.emailNotificacion = emailNotificacion;
	}

	public Double getHoraap() {
		return horaap;
	}

	public void setHoraap(Double horaap) {
		this.horaap = horaap;
	}

	public String getNumeroInservice() {
		return numeroInservice;
	}

	public void setNumeroInservice(String numeroInservice) {
		this.numeroInservice = numeroInservice;
	}

	public String getSuppliedphone() {
		return suppliedphone;
	}

	public void setSuppliedphone(String suppliedphone) {
		this.suppliedphone = suppliedphone;
	}

	public String getNumeroMedidor() {
		return numeroMedidor;
	}

	public void setNumeroMedidor(String numeroMedidor) {
		this.numeroMedidor = numeroMedidor;
	}

	public String getCuerpoMail() {
		return cuerpoMail;
	}

	public void setCuerpoMail(String cuerpoMail) {
		this.cuerpoMail = cuerpoMail;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getTrazaFalloInservice() {
		return trazaFalloInservice;
	}

	public void setTrazaFalloInservice(String trazaFalloInservice) {
		this.trazaFalloInservice = trazaFalloInservice;
	}

	public String getCanalNotificacion() {
		return canalNotificacion;
	}

	public void setCanalNotificacion(String canalNotificacion) {
		this.canalNotificacion = canalNotificacion;
	}

	public String getCreatedbyid() {
		return createdbyid;
	}

	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getNumeroCaso() {
		return numeroCaso;
	}

	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSf4twitterTwitterid() {
		return sf4twitterTwitterid;
	}

	public void setSf4twitterTwitterid(String sf4twitterTwitterid) {
		this.sf4twitterTwitterid = sf4twitterTwitterid;
	}

	public String getRespuestaAlCliente() {
		return respuestaAlCliente;
	}

	public void setRespuestaAlCliente(String respuestaAlCliente) {
		this.respuestaAlCliente = respuestaAlCliente;
	}

	public String getNumeroCasoAp() {
		return numeroCasoAp;
	}

	public void setNumeroCasoAp(String numeroCasoAp) {
		this.numeroCasoAp = numeroCasoAp;
	}

	public Boolean getIsescalated() {
		return isescalated;
	}

	public void setIsescalated(Boolean isescalated) {
		this.isescalated = isescalated;
	}

	public String getInteraccion() {
		return interaccion;
	}

	public void setInteraccion(String interaccion) {
		this.interaccion = interaccion;
	}

	public String getTipoAtencionSEC() {
		return tipoAtencionSEC;
	}

	public void setTipoAtencionSEC(String tipoAtencionSEC) {
		this.tipoAtencionSEC = tipoAtencionSEC;
	}

	public String getSubEstado() {
		return subEstado;
	}

	public void setSubEstado(String subEstado) {
		this.subEstado = subEstado;
	}

	public Date getHoraSec() {
		return horaSec;
	}

	public void setHoraSec(Date horaSec) {
		this.horaSec = horaSec;
	}

	public Boolean getPendienteValidacionCondagr() {
		return pendienteValidacionCondagr;
	}

	public void setPendienteValidacionCondagr(Boolean pendienteValidacionCondagr) {
		this.pendienteValidacionCondagr = pendienteValidacionCondagr;
	}

	public String getEjecutivoAnterior() {
		return ejecutivoAnterior;
	}

	public void setEjecutivoAnterior(String ejecutivoAnterior) {
		this.ejecutivoAnterior = ejecutivoAnterior;
	}

	public String getSuppliedCompany() {
		return suppliedCompany;
	}

	public void setSuppliedCompany(String suppliedCompany) {
		this.suppliedCompany = suppliedCompany;
	}

	public String getEstadoCondicionAgravante() {
		return estadoCondicionAgravante;
	}

	public void setEstadoCondicionAgravante(String estadoCondicionAgravante) {
		this.estadoCondicionAgravante = estadoCondicionAgravante;
	}

	public Date getHoraCancelado() {
		return horaCancelado;
	}

	public void setHoraCancelado(Date horaCancelado) {
		this.horaCancelado = horaCancelado;
	}

	public String getSuministro() {
		return suministro;
	}

	public void setSuministro(String suministro) {
		this.suministro = suministro;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Boolean getUi() {
		return ui;
	}

	public void setUi(Boolean ui) {
		this.ui = ui;
	}

	public String getNumSum() {
		return numSum;
	}

	public void setNumSum(String numSum) {
		this.numSum = numSum;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getSuppliedName() {
		return suppliedName;
	}

	public void setSuppliedName(String suppliedName) {
		this.suppliedName = suppliedName;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Boolean getFalloEnvioInservice() {
		return falloEnvioInservice;
	}

	public void setFalloEnvioInservice(Boolean falloEnvioInservice) {
		this.falloEnvioInservice = falloEnvioInservice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getHoraArribado() {
		return horaArribado;
	}

	public void setHoraArribado(Date horaArribado) {
		this.horaArribado = horaArribado;
	}

	public String getCanalOrigen() {
		return canalOrigen;
	}

	public void setCanalOrigen(String canalOrigen) {
		this.canalOrigen = canalOrigen;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public String getSf4twitterAuthorExternalId() {
		return sf4twitterAuthorExternalId;
	}

	public void setSf4twitterAuthorExternalId(String sf4twitterAuthorExternalId) {
		this.sf4twitterAuthorExternalId = sf4twitterAuthorExternalId;
	}

	public Date getHoraCerrado() {
		return horaCerrado;
	}

	public void setHoraCerrado(Date horaCerrado) {
		this.horaCerrado = horaCerrado;
	}

	public String getLiteralCondicionAgravante() {
		return literalCondicionAgravante;
	}

	public void setLiteralCondicionAgravante(String literalCondicionAgravante) {
		this.literalCondicionAgravante = literalCondicionAgravante;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDireccionSuministro() {
		return direccionSuministro;
	}

	public void setDireccionSuministro(String direccionSuministro) {
		this.direccionSuministro = direccionSuministro;
	}

	public Date getHoraPendiente() {
		return horaPendiente;
	}

	public void setHoraPendiente(Date horaPendiente) {
		this.horaPendiente = horaPendiente;
	}

	public String getAni() {
		return ani;
	}

	public void setAni(String ani) {
		this.ani = ani;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getPeticion() {
		return peticion;
	}

	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getHoraAsignado() {
		return horaAsignado;
	}

	public void setHoraAsignado(Date horaAsignado) {
		this.horaAsignado = horaAsignado;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public Date getHoraPredespacho() {
		return horaPredespacho;
	}

	public void setHoraPredespacho(Date horaPredespacho) {
		this.horaPredespacho = horaPredespacho;
	}

	public Date getHoraEnruta() {
		return horaEnruta;
	}

	public void setHoraEnruta(Date horaEnruta) {
		this.horaEnruta = horaEnruta;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Date getHoraProgramado() {
		return horaProgramado;
	}

	public void setHoraProgramado(Date horaProgramado) {
		this.horaProgramado = horaProgramado;
	}

	public Double getNumeroSeguidoresDel() {
		return numeroSeguidoresDel;
	}

	public void setNumeroSeguidoresDel(Double numeroSeguidoresDel) {
		this.numeroSeguidoresDel = numeroSeguidoresDel;
	}

	public String getLiteralCategorias() {
		return literalCategorias;
	}

	public void setLiteralCategorias(String literalCategorias) {
		this.literalCategorias = literalCategorias;
	}

	public String getRecordtypeId() {
		return recordtypeId;
	}

	public void setRecordtypeId(String recordtypeId) {
		this.recordtypeId = recordtypeId;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getValorSubestadoins() {
		return valorSubestadoins;
	}

	public void setValorSubestadoins(String valorSubestadoins) {
		this.valorSubestadoins = valorSubestadoins;
	}

	public Boolean getControlElectrodependiente() {
		return controlElectrodependiente;
	}

	public void setControlElectrodependiente(Boolean controlElectrodependiente) {
		this.controlElectrodependiente = controlElectrodependiente;
	}

	public Boolean getCancelar() {
		return cancelar;
	}

	public void setCancelar(Boolean cancelar) {
		this.cancelar = cancelar;
	}

	public String getCondicionAgravante() {
		return condicionAgravante;
	}

	public void setCondicionAgravante(String condicionAgravante) {
		this.condicionAgravante = condicionAgravante;
	}
	
	public String getHerokuUsername() {
		return herokuUsername;
	}

	public void setHerokuUsername(String herokuUsername) {
		this.herokuUsername = herokuUsername;
	}

	public PickListsCaseVO getSubestadoPickList() {
		return subestadoPickList;
	}

	public void setSubestadoPickList(PickListsCaseVO subestadoPickList) {
		this.subestadoPickList = subestadoPickList;
	}

	public PickListsCaseVO getSubmotivoPickList() {
		return submotivoPickList;
	}

	public void setSubmotivoPickList(PickListsCaseVO submotivoPickList) {
		this.submotivoPickList = submotivoPickList;
	}

	public PickListsCaseOriginVO getCanalOrigenPickList() {
		return canalOrigenPickList;
	}

	public void setCanalOrigenPickList(PickListsCaseOriginVO canalOrigenPickList) {
		this.canalOrigenPickList = canalOrigenPickList;
	}
	
	public PickListsCaseVO getCondicionAgravantePickList() {
		return condicionAgravantePickList;
	}

	public void setCondicionAgravantePickList(PickListsCaseVO condicionAgravantePickList) {
		this.condicionAgravantePickList = condicionAgravantePickList;
	}
	
	public PickListsCaseCanalNotificacionVO getCanalNotificacionPickList() {
		return canalNotificacionPickList;
	}

	public void setCanalNotificacionPickList(PickListsCaseCanalNotificacionVO canalNotificacionPickList) {
		this.canalNotificacionPickList = canalNotificacionPickList;
	}

	public PickListsCaseVO getFavorabilidadDelCasoPickList() {
		return favorabilidadDelCasoPickList;
	}

	public void setFavorabilidadDelCasoPickList(PickListsCaseVO favorabilidadDelCasoPickList) {
		this.favorabilidadDelCasoPickList = favorabilidadDelCasoPickList;
	}
	
	public PickListsCaseTypeVO getTypeCasoPickList() {
		return typeCasoPickList;
	}

	public void setTypeCasoPickList(PickListsCaseTypeVO typeCasoPickList) {
		this.typeCasoPickList = typeCasoPickList;
	}
	public PickListsCaseCallCenterVO getCallCenterPickList() {
		return callCenterPickList;
	}
	public void setCallCenterPickList(PickListsCaseCallCenterVO callCenterPickList) {
		this.callCenterPickList = callCenterPickList;
	}
	

	@Override
	public Object instantiateTargetLogic() {
		Caso caso = new Caso();
		return caso;
	}

	public String getLabelSubmotivoPickList() {
		String result = this.getSubmotivo();
		if (this.getSubmotivoPickList() != null) {
			result = this.getSubmotivoPickList().getValor();
		}
		return result;
	}

	public String getLabelSubestadoPickList() {
		String result = this.getSubEstado();
		if (this.getSubestadoPickList() != null) {
			result = this.getSubestadoPickList().getValor();
		}
		return result;
	}

	public String getLabelCanalOrigenPickList() {
		String result = this.getCanalOrigen();
		if (this.getCanalOrigenPickList() != null) {
			result = this.getCanalOrigenPickList().getValor();
		}
		return result;
	}
	
	public String getLabelEstadoPickList() {
		String result = this.getEstado();
		if (this.getEstadoPickList() != null) {
			result = this.getEstadoPickList().getValor();
		}
		return result;
	}
	
	public String getLabelPeticionPickList() {
		String result = this.getPeticion();
		if (this.getPeticionPickList() != null) {
			result = this.getPeticionPickList().getValor();
		}
		return result;
	}

	public String getLabelCondicionAgravantePickList() {
		String result = this.getCondicionAgravante();
		if (this.getCondicionAgravantePickList() != null) {
			result = this.getCondicionAgravantePickList().getValor();
		}
		return result;
	}
	
	public String getLabelFavorabilidadDelCasoPickList() {
		String result = this.getFavorabilidadDelCaso();
		if (this.getFavorabilidadDelCasoPickList() != null) {
			result = this.getFavorabilidadDelCasoPickList().getValor();
		}
		return result;
	}
	
	public String getLabelTypeCasoPickList() {
		String result = this.getType();
		if (this.getTypeCasoPickList() != null) {
			result = this.getTypeCasoPickList().getValor();
		}
		return result;
	}
	
	public String getLabelCanalNotificacionPickList() {
		String result = this.getCanalNotificacion();
		if (this.getCanalNotificacionPickList() != null) {
			result = this.getCanalNotificacionPickList().getValor();
		}
		return result;
	}
	
	public String getLabelCallCenterPickList(){
		String result = this.getCallCenter();
		if (this.getCallCenterPickList() != null) {
			result = this.getCallCenterPickList().getValor();
		}
		return result;
	}
	
	public PickListsCaseVO getPeticionPickList() {
		return peticionPickList;
	}

	public void setPeticionPickList(PickListsCaseVO peticionPickList) {
		this.peticionPickList = peticionPickList;
	}

	public AccountVO getCuentaJoin() {
		return cuentaJoin;
	}

	public void setCuentaJoin(AccountVO cuentaJoin) {
		this.cuentaJoin = cuentaJoin;
	}

	public SuministroVO getSuministroJoin() {
		return suministroJoin;
	}

	public void setSuministroJoin(SuministroVO suministroJoin) {
		this.suministroJoin = suministroJoin;
	}

	public DireccionVO getDireccionJoin() {
		return direccionJoin;
	}
	
	public void setDireccionJoin(DireccionVO direccionJoin) {
		this.direccionJoin = direccionJoin;
	}
	
	public UserVO getUserJoin(){
		return userJoin;
	}
	
	public void setUserJoin(UserVO userJoin) {
		this.userJoin = userJoin;
	}

	public ContactVO getContactoJoin() {
		return contactoJoin;
	}

	public void setContactoJoin(ContactVO contactoJoin) {
		this.contactoJoin = contactoJoin;
	}

	public PickListsCaseVO getEstadoPickList() {
		return estadoPickList;
	}

	public void setEstadoPickList(PickListsCaseVO estadoPickList) {
		this.estadoPickList = estadoPickList;
	}

	public CaseVO getCasoPrincipalJoin() {
		return casoPrincipalJoin;
	}

	public void setCasoPrincipalJoin(CaseVO casoPrincipalJoin) {
		this.casoPrincipalJoin = casoPrincipalJoin;
	}

	public GroupVO getGroupJoin() {
		return groupJoin;
	}

	public void setGroupJoin(GroupVO groupJoin) {
		this.groupJoin = groupJoin;
	}
	
	
	
	
}