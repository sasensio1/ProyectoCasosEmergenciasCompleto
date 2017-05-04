package com.casosemergencias.controller.views;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.casosemergencias.model.Caso;

public class CaseView extends ObjectView {
	private Integer id;
	private String sfid;
	private String numeroCaso;
	private String estado;
	private String numeroInservice;
	private String submotivo;
	private Date fechaApertura;
	private String subestado;
	private String nombreContacto;
	private String nombreContactoString;
	private String direccionSuministro;
	private String comuna;
	private String canalOrigen;
	private String canalOrigenLabel;
	private String nombreCuenta;
	private String nombreCuentaString;
	private String suministro;
	private String suministroString;
	private String direccion;
	private String direccionString;
	private String estadoSuministro;
	private String peticion;
	private String peticionLabel;
	private String callCenter;
	private String editMode;
	private String type;
	private String typeLabel;
	private String description;
	private String condicionAgravante;
	private String canalNotificacion;
	private String telefonoContacto;
	private String emailNotificacion;
	private String facebook;
	private String twitter;
	private boolean actDatosContacto;
	private String respuestaAlCliente;
	private String favorabilidadDelCaso;
	private Date fechaEstimadaCierre;
	private String parent;
	private String propietarioCaso;	//owner
	private Date fechaCierre;
	private String tipoAtencionInterna;
	private ContactView contactoJoin;
	private String numeroMedidor;
	private DireccionView direccionJoin;
	private AccountView cuentaJoin;
	private SuministroView suministroJoin;
	private String cuerpoMail;	
	private String asunto;	//subject
	private String tipoAtencionSEC;
	private String ani;
	private String descripcionEstado;
	private UserView userJoin;
	private String herokuUsername;
	private CaseView casoPrincipalJoin;
	private GroupView groupJoin;
	private List<CaseHistoryView> historialCaso;
	private List<CaseCommentView> commentarioCaso;
	private String recordtypeId;

	
	/*Joins con picklist*/
	private String labelSubmotivoPickList;
	private String labelEstadoPickList;
	private String labelSubestadoPickList;
	private String labelCanalOrigenPickList;
	private String labelPeticionPickList;
	private String labelCondicionAgravantePickList;
	private String labelCanalNotificacionPickList;
	private String labelFavorabilidadDelCasoPickList;
	private String labelTypeCasoPickList;
	private String labelCallCenterPickList;
	
	/*Mapas para mostrar los combos de caso*/
	private Map<String, String> mapStatus;
	private Map<String, String> mapSubStatus;
	private Map<String, String> mapPeticion;
	private Map<String, String> mapOrigin;
	private Map<String, String> mapCallCenter;
	private Map<String, String> mapSubMotivo;
	private Map<String, String> mapCondicionAgravante;
	private Map<String, String> mapCanalNotificacion;
	private Map<String, String> mapFavorabilidadCaso;	
	private Map<String, String> mapSubStatusCancelacion;
	

	//variables para controlar numero de entradas de las tablas
	private boolean controlHistorialEntradas;
	private boolean controlCometarioEntradas;
	
	/**/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumeroCaso() {
		return numeroCaso;
	}

	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumeroInservice() {
		return numeroInservice;
	}
	public void setNumeroInservice(String numeroInservice) {
		this.numeroInservice = numeroInservice;
	}
	public String getSubmotivo() {
		return submotivo;
	}
	public void setSubmotivo(String submotivo) {
		this.submotivo = submotivo;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public String getSubestado() {
		return subestado;
	}
	public void setSubestado(String subestado) {
		this.subestado = subestado;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public String getDireccionSuministro() {
		return direccionSuministro;
	}
	public void setDireccionSuministro(String direccionSuministro) {
		this.direccionSuministro = direccionSuministro;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getCanalOrigen() {
		return canalOrigen;
	}
	public void setCanalOrigen(String canalOrigen) {
		this.canalOrigen = canalOrigen;
	}
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public String getEstadoSuministro() {
		return estadoSuministro;
	}
	public void setEstadoSuministro(String estadoSuministro) {
		this.estadoSuministro = estadoSuministro;
	}
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	public String getCallCenter() {
		return callCenter;
	}
	public void setCallCenter(String callCenter) {
		this.callCenter = callCenter;
	}

	public String getEditMode() {
		return editMode;
	}
	public void setEditMode(String editMode) {
		this.editMode = editMode;
	}
	
	public String getPeticionLabel() {
		return peticionLabel;
	}
	public void setPeticionLabel(String peticionLabel) {
		this.peticionLabel = peticionLabel;
	}
	
	public String getCanalOrigenLabel() {
		return canalOrigenLabel;
	}
	public void setCanalOrigenLabel(String canalOrigenLabel) {
		this.canalOrigenLabel = canalOrigenLabel;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getTypeLabel() {
		return typeLabel;
	}
	public void setTypeLabel(String typeLabel) {
		this.typeLabel = typeLabel;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCondicionAgravante() {
		return condicionAgravante;
	}
	public void setCondicionAgravante(String condicionAgravante) {
		this.condicionAgravante = condicionAgravante;
	}
	
	public String getCanalNotificacion() {
		return canalNotificacion;
	}
	public void setCanalNotificacion(String canalNotificacion) {
		this.canalNotificacion = canalNotificacion;
	}
	
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	
	public String getEmailNotificacion() {
		return emailNotificacion;
	}
	public void setEmailNotificacion(String emailNotificacion) {
		this.emailNotificacion = emailNotificacion;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	public boolean getActDatosContacto() {
		return actDatosContacto;
	}
	public void setActDatosContacto(boolean actDatosContacto) {
		this.actDatosContacto = actDatosContacto;
	}
	
	public String getSuministro() {
		return suministro;
	}
	public void setSuministro(String suministro) {
		this.suministro = suministro;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRespuestaAlCliente() {
		return respuestaAlCliente;
	}
	public void setRespuestaAlCliente(String respuestaAlCliente) {
		this.respuestaAlCliente = respuestaAlCliente;
	}
	public String getFavorabilidadDelCaso() {
		return favorabilidadDelCaso;
	}
	public void setFavorabilidadDelCaso(String favorabilidadDelCaso) {
		this.favorabilidadDelCaso = favorabilidadDelCaso;
	}
	
	public Date getFechaEstimadaCierre() {
		return fechaEstimadaCierre;
	}
	public void setFechaEstimadaCierre(Date fechaEstimadaCierre) {
		this.fechaEstimadaCierre = fechaEstimadaCierre;
	}
	
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public String getPropietarioCaso() {
		return propietarioCaso;
	}
	public void setPropietarioCaso(String propietarioCaso) {
		this.propietarioCaso = propietarioCaso;
	}
	public Date getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getTipoAtencionInterna() {
		return tipoAtencionInterna;
	}
	public void setTipoAtencionInterna(String tipoAtencionInterna) {
		this.tipoAtencionInterna = tipoAtencionInterna;
	}
	public ContactView getContactoJoin() {
		return contactoJoin;
	}
	public void setContactoJoin(ContactView contactoJoin) {
		this.contactoJoin = contactoJoin;
	}
	public UserView getUserJoin() {
		return userJoin;
	}
	public void setUserJoin(UserView userJoin) {
		this.userJoin = userJoin;
	}
	public String getNumeroMedidor() {
		return numeroMedidor;
	}
	public void setNumeroMedidor(String numeroMedidor) {
		this.numeroMedidor = numeroMedidor;
	}
	public DireccionView getDireccionJoin() {
		return direccionJoin;
	}
	public void setDireccionJoin(DireccionView direccionJoin) {
		this.direccionJoin = direccionJoin;
	}
	public AccountView getCuentaJoin() {
		return cuentaJoin;
	}
	public void setCuentaJoin(AccountView cuentaJoin) {
		this.cuentaJoin = cuentaJoin;
	}
	public SuministroView getSuministroJoin() {
		return suministroJoin;
	}
	public void setSuministroJoin(SuministroView suministroJoin) {
		this.suministroJoin = suministroJoin;
	}
	public String getCuerpoMail() {
		return cuerpoMail;
	}
	public void setCuerpoMail(String cuerpoMail) {
		this.cuerpoMail = cuerpoMail;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getTipoAtencionSEC() {
		return tipoAtencionSEC;
	}
	public void setTipoAtencionSEC(String tipoAtencionSEC) {
		this.tipoAtencionSEC = tipoAtencionSEC;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}		
	public CaseView getCasoPrincipalJoin() {
		return casoPrincipalJoin;
	}
	public void setCasoPrincipalJoin(CaseView casoPrincipalJoin) {
		this.casoPrincipalJoin = casoPrincipalJoin;
	}
	public GroupView getGroupJoin() {
		return groupJoin;
	}
	public void setGroupJoin(GroupView groupJoin) {
		this.groupJoin = groupJoin;
	}
	/*Joins con picklist*/	
	public String getLabelSubmotivoPickList() {
		return labelSubmotivoPickList;
	}
	public String getLabelSubestadoPickList() {
		return labelSubestadoPickList;
	}
	public void setLabelSubestadoPickList(String labelSubestadoPickList) {
		this.labelSubestadoPickList = labelSubestadoPickList;
	}
	public void setLabelSubmotivoPickList(String labelSubmotivoPickList) {
		this.labelSubmotivoPickList = labelSubmotivoPickList;
	}	
	public String getLabelEstadoPickList() {
		return labelEstadoPickList;
	}
	public void setLabelEstadoPickList(String labelEstadoPickList) {
		this.labelEstadoPickList = labelEstadoPickList;
	}
	public String getLabelCanalOrigenPickList() {
		return labelCanalOrigenPickList;
	}
	public void setLabelCanalOrigenPickList(String labelCanalOrigenPickList) {
		this.labelCanalOrigenPickList = labelCanalOrigenPickList;
	}
	public String getLabelCondicionAgravantePickList() {
		return labelCondicionAgravantePickList;
	}
	public void setLabelCondicionAgravantePickList(String labelCondicionAgravantePickList) {
		this.labelCondicionAgravantePickList = labelCondicionAgravantePickList;
	}
	/*Mapas combos*/
	public Map<String, String> getMapStatus() {
		return mapStatus;
	}
	public void setMapStatus(Map<String, String> mapStatus) {
		this.mapStatus = mapStatus;
	}
	public Map<String, String> getMapSubStatus() {
		return mapSubStatus;
	}
	public void setMapSubStatus(Map<String, String> mapSubStatus) {
		this.mapSubStatus = mapSubStatus;
	}
	public Map<String, String> getMapPeticion() {
		return mapPeticion;
	}
	public void setMapPeticion(Map<String, String> mapPeticion) {
		this.mapPeticion = mapPeticion;
	}
	public Map<String, String> getMapOrigin() {
		return mapOrigin;
	}
	public void setMapOrigin(Map<String, String> mapOrigin) {
		this.mapOrigin = mapOrigin;
	}
	public Map<String, String> getMapCallCenter() {
		return mapCallCenter;
	}
	public void setMapCallCenter(Map<String, String> mapCallCenter) {
		this.mapCallCenter = mapCallCenter;
	}
	public Map<String, String> getMapSubMotivo() {
		return mapSubMotivo;
	}
	public void setMapSubMotivo(Map<String, String> mapSubMotivo) {
		this.mapSubMotivo = mapSubMotivo;
	}
	public Map<String, String> getMapCondicionAgravante() {
		return mapCondicionAgravante;
	}
	public void setMapCondicionAgravante(Map<String, String> mapCondicionAgravante) {
		this.mapCondicionAgravante = mapCondicionAgravante;
	}
	public Map<String, String> getMapCanalNotificacion() {
		return mapCanalNotificacion;
	}
	public void setMapCanalNotificacion(Map<String, String> mapCanalNotificacion) {
		this.mapCanalNotificacion = mapCanalNotificacion;
	}
	public Map<String, String> getMapFavorabilidadCaso() {
		return mapFavorabilidadCaso;
	}
	public void setMapFavorabilidadCaso(Map<String, String> mapFavorabilidadCaso) {
		this.mapFavorabilidadCaso = mapFavorabilidadCaso;
	}

	public String getLabelPeticionPickList() {
		return labelPeticionPickList;
	}
	public void setLabelPeticionPickList(String labelPeticionPickList) {
		this.labelPeticionPickList = labelPeticionPickList;
	}
	public String getLabelCanalNotificacionPickList() {
		return labelCanalNotificacionPickList;
	}
	public void setLabelCanalNotificacionPickList(String labelCanalNotificacionPickList) {
		this.labelCanalNotificacionPickList = labelCanalNotificacionPickList;
	}
	public String getLabelFavorabilidadDelCasoPickList() {
		return labelFavorabilidadDelCasoPickList;
	}
	public void setLabelFavorabilidadDelCasoPickList(String labelFavorabilidadDelCasoPickList) {
		this.labelFavorabilidadDelCasoPickList = labelFavorabilidadDelCasoPickList;
	}
	public String getLabelTypeCasoPickList() {
		return labelTypeCasoPickList;
	}
	public void setLabelTypeCasoPickList(String labelTypeCasoPickList) {
		this.labelTypeCasoPickList = labelTypeCasoPickList;
	}
	public String getLabelCallCenterPickList() {
		return labelCallCenterPickList;
	}
	public void setLabelCallCenterPickList(String labelCallCenterPickList) {
		this.labelCallCenterPickList = labelCallCenterPickList;
	}
	
	public String getHerokuUsername() {
		return herokuUsername;
	}
	public void setHerokuUsername(String herokuUsername) {
		this.herokuUsername = herokuUsername;
	}
	public List<CaseHistoryView> getHistorialCaso() {
		return historialCaso;
	}
	public void setHistorialCaso(List<CaseHistoryView> historialCaso) {
		this.historialCaso = historialCaso;
	}
	public List<CaseCommentView> getCommentarioCaso() {
		return commentarioCaso;
	}
	public void setCommentarioCaso(List<CaseCommentView> commentarioCaso) {
		this.commentarioCaso = commentarioCaso;
	}
	public Map<String, String> getMapSubStatusCancelacion() {
		return mapSubStatusCancelacion;
	}
	public void setMapSubStatusCancelacion(Map<String, String> mapSubStatusCancelacion) {
		this.mapSubStatusCancelacion = mapSubStatusCancelacion;
	}	
	public boolean isControlHistorialEntradas() {
		return controlHistorialEntradas;
	}
	public void setControlHistorialEntradas(boolean controlHistorialEntradas) {
		this.controlHistorialEntradas = controlHistorialEntradas;
	}
	public boolean isControlCometarioEntradas() {
		return controlCometarioEntradas;
	}
	public void setControlCometarioEntradas(boolean controlCometarioEntradas) {
		this.controlCometarioEntradas = controlCometarioEntradas;
	}
	
	@Override
	public Object instantiateTargetLogic() {
		Caso caso = new Caso();
		return caso;
	}
	public String getNombreContactoString() {
		return nombreContactoString;
	}
	public void setNombreContactoString(String nombreContactoString) {
		this.nombreContactoString = nombreContactoString;
	}
	public String getNombreCuentaString() {
		return nombreCuentaString;
	}
	public void setNombreCuentaString(String nombreCuentaString) {
		this.nombreCuentaString = nombreCuentaString;
	}
	public String getSuministroString() {
		return suministroString;
	}
	public void setSuministroString(String suministroString) {
		this.suministroString = suministroString;
	}
	public String getDireccionString() {
		return direccionString;
	}
	public void setDireccionString(String direccionString) {
		this.direccionString = direccionString;
	}
	public String getRecordtypeId() {
		return recordtypeId;
	}
	public void setRecordtypeId(String recordtypeId) {
		this.recordtypeId = recordtypeId;
	}
	
}
