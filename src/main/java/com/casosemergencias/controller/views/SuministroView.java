package com.casosemergencias.controller.views;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.example.sieme009_schema.ListadoEventosType;
import org.example.sires033_schema.ListadoSuministrosType;

import com.casosemergencias.model.Suministro;

public class SuministroView extends ObjectView {

	private Integer id;
	private String sfid;
	private String name;
	private String fullElectric;
	private Boolean casosAbiertos;
	private String tipoTransformador;
	private Boolean cortePorDeuda;
	private String tipoLectura;
	private String procesoLectura;
	private String estadoConexion;
	private String tipoMedida;
	private String comunaReparto;
	private String comuna;
	private String numeroMedidor;
	private String modeloMedidor;
	private String numeroSuministro;
	private String numeroTransformador;
	private String estadoSuministro;
	private String marcaMedidor;
	private Date fechaCorte;
	private String propiedadMedidor;
	private String idEmpresa;
	private String direccion;
	private String runRut;
	private Boolean pagoEnProceso;
	private String nombreDuenoBoleta;
	private String bloque;
	private String tipoConexion;
	private String direccionCliente;
	private String electrodependiente;
	private String medidaDisciplina;
	private String horarioRacionamiento;
	private Double casosReiterados;
	private String tarifa;
	private String alimentador;
	private String direccionBoleta;
	private String cuenta;
	private String subestacionElectricaConexion;
	private String ruta;
	private String tipoCuenta;
	private String tipoSegmento;
	private String relacionActivo;
	private String direccionConcatenada;
	
	private String labelEmpresaPickList;
	private String labelEstadoConexionPickList;
	private String labelEstadoSuministroPickList;
	private String tipoEvento;
	private Boolean suministroAfectado;
	
	private AccountView cuentaJoin;	
	private DireccionView dirSuministroJoin;
	
	private List<CaseView> casos;	
	private List<ContactView> contactosRelacionados;
	private List<AccountView> cuentasRelacionadas;

	
	private String labelProcesoLecturaPickList;
	private String labelTipoMedidaPickList;	
	private String labelTipoSegmentoPickList;
	private String labelSubestacionElecPickList;	
	private String labelPropMedidorPickList;
	private String labelTipoConexionPickList;	
	private String labelTipoLecturaPickList;
	private String labelTipoTransformadorPickList;	
	private String labelComunaRepartoPickList;
	private String labelFullElectricPickList;		
	private String labelMedidaDisciplinaPickList;	
	private String labelElectrodependientePickList;
	
	private ListadoSuministrosType listadoSuministros;	
	private ListadoEventosType listadoEventos;

	private String fechaCorteString;
	private String sfidContAsociado;
	
	/*Mapas para mostrar los combos de Suministro*/
	private Map<String, String> mapComuna;
	private Map<String, String> mapRegion;

	public SuministroView() {
	}

	

	public SuministroView(Integer id, String sfid, String name, String fullElectric, Boolean casosAbiertos,
			String tipoTransformador, Boolean cortePorDeuda, String tipoLectura, String procesoLectura,
			String estadoConexion, String tipoMedida, String comunaReparto, String comuna, String numeroMedidor,
			String modeloMedidor, String numeroSuministro, String numeroTransformador, String estadoSuministro,
			String marcaMedidor, Date fechaCorte, String propiedadMedidor, String idEmpresa, String direccion,
			String runRut, Boolean pagoEnProceso, String nombreDuenoBoleta, String bloque, String tipoConexion,
			String direccionCliente, String electrodependiente, String medidaDisciplina, String horarioRacionamiento,
			Double casosReiterados, String tarifa, String alimentador, String direccionBoleta, String cuenta,
			String subestacionElectricaConexion, String ruta, String tipoCuenta, String tipoSegmento,
			String relacionActivo, String direccionConcatenada, String labelEmpresaPickList,
			String labelEstadoConexionPickList, String labelEstadoSuministroPickList, String tipoEvento,
			Boolean suministroAfectado, AccountView cuentaJoin, List<CaseView> casos,
			List<ContactView> contactosRelacionados, String labelProcesoLecturaPickList, String labelTipoMedidaPickList,
			String labelTipoSegmentoPickList, String labelSubestacionElecPickList, String labelPropMedidorPickList,
			String labelTipoConexionPickList, String labelTipoLecturaPickList, String labelTipoTransformadorPickList,
			String labelComunaRepartoPickList, String labelFullElectricPickList, String labelElectrodependientePickList,
			ListadoSuministrosType listadoSuministros, ListadoEventosType listadoEventos, String fechaCorteString,Map<String, String> mapComuna,
			Map<String, String> mapRegion,List<AccountView> cuentasRelacionadas) {
		super();
		this.id = id;
		this.sfid = sfid;
		this.name = name;
		this.fullElectric = fullElectric;
		this.casosAbiertos = casosAbiertos;
		this.tipoTransformador = tipoTransformador;
		this.cortePorDeuda = cortePorDeuda;
		this.tipoLectura = tipoLectura;
		this.procesoLectura = procesoLectura;
		this.estadoConexion = estadoConexion;
		this.tipoMedida = tipoMedida;
		this.comunaReparto = comunaReparto;
		this.comuna = comuna;
		this.numeroMedidor = numeroMedidor;
		this.modeloMedidor = modeloMedidor;
		this.numeroSuministro = numeroSuministro;
		this.numeroTransformador = numeroTransformador;
		this.estadoSuministro = estadoSuministro;
		this.marcaMedidor = marcaMedidor;
		this.fechaCorte = fechaCorte;
		this.propiedadMedidor = propiedadMedidor;
		this.idEmpresa = idEmpresa;
		this.direccion = direccion;
		this.runRut = runRut;
		this.pagoEnProceso = pagoEnProceso;
		this.nombreDuenoBoleta = nombreDuenoBoleta;
		this.bloque = bloque;
		this.tipoConexion = tipoConexion;
		this.direccionCliente = direccionCliente;
		this.electrodependiente = electrodependiente;
		this.medidaDisciplina = medidaDisciplina;
		this.horarioRacionamiento = horarioRacionamiento;
		this.casosReiterados = casosReiterados;
		this.tarifa = tarifa;
		this.alimentador = alimentador;
		this.direccionBoleta = direccionBoleta;
		this.cuenta = cuenta;
		this.subestacionElectricaConexion = subestacionElectricaConexion;
		this.ruta = ruta;
		this.tipoCuenta = tipoCuenta;
		this.tipoSegmento = tipoSegmento;
		this.relacionActivo = relacionActivo;
		this.direccionConcatenada = direccionConcatenada;
		this.labelEmpresaPickList = labelEmpresaPickList;
		this.labelEstadoConexionPickList = labelEstadoConexionPickList;
		this.labelEstadoSuministroPickList = labelEstadoSuministroPickList;
		this.tipoEvento = tipoEvento;
		this.suministroAfectado = suministroAfectado;
		this.cuentaJoin = cuentaJoin;
		this.casos = casos;
		this.contactosRelacionados = contactosRelacionados;
		this.labelProcesoLecturaPickList = labelProcesoLecturaPickList;
		this.labelTipoMedidaPickList = labelTipoMedidaPickList;
		this.labelTipoSegmentoPickList = labelTipoSegmentoPickList;
		this.labelSubestacionElecPickList = labelSubestacionElecPickList;
		this.labelPropMedidorPickList = labelPropMedidorPickList;
		this.labelTipoConexionPickList = labelTipoConexionPickList;
		this.labelTipoLecturaPickList = labelTipoLecturaPickList;
		this.labelTipoTransformadorPickList = labelTipoTransformadorPickList;
		this.labelComunaRepartoPickList = labelComunaRepartoPickList;
		this.labelFullElectricPickList = labelFullElectricPickList;
		this.labelElectrodependientePickList=labelElectrodependientePickList;
		this.listadoSuministros = listadoSuministros;
		this.listadoEventos = listadoEventos;
		this.fechaCorteString = fechaCorteString;
		this.mapComuna=mapComuna;
		this.mapRegion=mapRegion;
		this.cuentasRelacionadas=cuentasRelacionadas;
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

	public String getFullElectric() {
		return fullElectric;
	}

	public void setFullElectric(String fullElectric) {
		this.fullElectric = fullElectric;
	}

	public Boolean getCasosAbiertos() {
		return casosAbiertos;
	}

	public void setCasosAbiertos(Boolean casosAbiertos) {
		this.casosAbiertos = casosAbiertos;
	}

	public String getTipoTransformador() {
		return tipoTransformador;
	}

	public void setTipoTransformador(String tipoTransformador) {
		this.tipoTransformador = tipoTransformador;
	}

	public Boolean getCortePorDeuda() {
		return cortePorDeuda;
	}

	public void setCortePorDeuda(Boolean cortePorDeuda) {
		this.cortePorDeuda = cortePorDeuda;
	}

	public String getTipoLectura() {
		return tipoLectura;
	}

	public void setTipoLectura(String tipoLectura) {
		this.tipoLectura = tipoLectura;
	}

	public String getProcesoLectura() {
		return procesoLectura;
	}

	public void setProcesoLectura(String procesoLectura) {
		this.procesoLectura = procesoLectura;
	}

	public String getEstadoConexion() {
		return estadoConexion;
	}

	public void setEstadoConexion(String estadoConexion) {
		this.estadoConexion = estadoConexion;
	}

	public String getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(String tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public String getComunaReparto() {
		return comunaReparto;
	}

	public void setComunaReparto(String comunaReparto) {
		this.comunaReparto = comunaReparto;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getNumeroMedidor() {
		return numeroMedidor;
	}

	public void setNumeroMedidor(String numeroMedidor) {
		this.numeroMedidor = numeroMedidor;
	}

	public String getModeloMedidor() {
		return modeloMedidor;
	}

	public void setModeloMedidor(String modeloMedidor) {
		this.modeloMedidor = modeloMedidor;
	}

	public String getNumeroSuministro() {
		return numeroSuministro;
	}

	public void setNumeroSuministro(String numeroSuministro) {
		this.numeroSuministro = numeroSuministro;
	}

	public String getNumeroTransformador() {
		return numeroTransformador;
	}

	public void setNumeroTransformador(String numeroTransformador) {
		this.numeroTransformador = numeroTransformador;
	}

	public String getEstadoSuministro() {
		return estadoSuministro;
	}

	public void setEstadoSuministro(String estadoSuministro) {
		this.estadoSuministro = estadoSuministro;
	}

	public String getMarcaMedidor() {
		return marcaMedidor;
	}

	public void setMarcaMedidor(String marcaMedidor) {
		this.marcaMedidor = marcaMedidor;
	}

	public Date getFechaCorte() {
		return fechaCorte;
	}

	public void setFechaCorte(Date fechaCorte) {
		this.fechaCorte = fechaCorte;
	}

	public String getPropiedadMedidor() {
		return propiedadMedidor;
	}

	public void setPropiedadMedidor(String propiedadMedidor) {
		this.propiedadMedidor = propiedadMedidor;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRunRut() {
		return runRut;
	}

	public void setRunRut(String runRut) {
		this.runRut = runRut;
	}

	public Boolean getPagoEnProceso() {
		return pagoEnProceso;
	}

	public void setPagoEnProceso(Boolean pagoEnProceso) {
		this.pagoEnProceso = pagoEnProceso;
	}

	public String getNombreDuenoBoleta() {
		return nombreDuenoBoleta;
	}

	public void setNombreDuenoBoleta(String nombreDuenoBoleta) {
		this.nombreDuenoBoleta = nombreDuenoBoleta;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getElectrodependiente() {
		return electrodependiente;
	}

	public void setElectrodependiente(String electrodependiente) {
		this.electrodependiente = electrodependiente;
	}

	public String getMedidaDisciplina() {
		return medidaDisciplina;
	}

	public void setMedidaDisciplina(String medidaDisciplina) {
		this.medidaDisciplina = medidaDisciplina;
	}

	public String getHorarioRacionamiento() {
		return horarioRacionamiento;
	}

	public void setHorarioRacionamiento(String horarioRacionamiento) {
		this.horarioRacionamiento = horarioRacionamiento;
	}

	public Double getCasosReiterados() {
		return casosReiterados;
	}

	public void setCasosReiterados(Double casosReiterados) {
		this.casosReiterados = casosReiterados;
	}

	public String getTarifa() {
		return tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}

	public String getAlimentador() {
		return alimentador;
	}
	public void setAlimentador(String alimentador) {
		this.alimentador = alimentador;
	}
	public String getDireccionBoleta() {
		return direccionBoleta;
	}
	public void setDireccionBoleta(String direccionBoleta) {
		this.direccionBoleta = direccionBoleta;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getSubestacionElectricaConexion() {
		return subestacionElectricaConexion;
	}
	public void setSubestacionElectricaConexion(String subestacionElectricaConexion) {
		this.subestacionElectricaConexion = subestacionElectricaConexion;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getTipoSegmento() {
		return tipoSegmento;
	}
	public void setTipoSegmento(String tipoSegmento) {
		this.tipoSegmento = tipoSegmento;
	}
	public String getDireccionConcatenada() {
		return direccionConcatenada;
	}
	public void setDireccionConcatenada(String direccionConcatenada) {
		this.direccionConcatenada = direccionConcatenada;
	}
	public String getRelacionActivo() {
		return relacionActivo;
	}
	public void setRelacionActivo(String relacionActivo) {
		this.relacionActivo = relacionActivo;
	}
	public String getLabelEmpresaPickList() {
		return labelEmpresaPickList;
	}
	public void setLabelEmpresaPickList(String labelEmpresaPickList) {
		this.labelEmpresaPickList = labelEmpresaPickList;
	}
	public String getLabelEstadoConexionPickList() {
		return labelEstadoConexionPickList;
	}
	public void setLabelEstadoConexionPickList(String labelEstadoConexionPickList) {
		this.labelEstadoConexionPickList = labelEstadoConexionPickList;
	}
	public String getLabelEstadoSuministroPickList() {
		return labelEstadoSuministroPickList;
	}
	public void setLabelEstadoSuministroPickList(String labelEstadoSuministroPickList) {
		this.labelEstadoSuministroPickList = labelEstadoSuministroPickList;
	}
	public List<CaseView> getCasos() {
		return casos;
	}
	public void setCasos(List<CaseView> casos) {
		this.casos = casos;
	}
	public AccountView getCuentaJoin() {
		return cuentaJoin;
	}
	public void setCuentaJoin(AccountView cuentaJoin) {
		this.cuentaJoin = cuentaJoin;
	}
	
	public DireccionView getDirSuministroJoin() {
		return dirSuministroJoin;
	}
	public void setDirSuministroJoin(DireccionView dirSuministroJoin) {
		this.dirSuministroJoin = dirSuministroJoin;
	}

	public List<ContactView> getContactosRelacionados() {
		return contactosRelacionados;
	}
	public void setContactosRelacionados(List<ContactView> contactosRelacionados) {
		this.contactosRelacionados = contactosRelacionados;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public Boolean getSuministroAfectado() {
		return suministroAfectado;
	}
	public void setSuministroAfectado(Boolean suministroAfectado) {
		this.suministroAfectado = suministroAfectado;
	}
	public String getLabelProcesoLecturaPickList() {
		return labelProcesoLecturaPickList;
	}
	public void setLabelProcesoLecturaPickList(String labelProcesoLecturaPickList) {
		this.labelProcesoLecturaPickList = labelProcesoLecturaPickList;
	}
	public String getLabelTipoMedidaPickList() {
		return labelTipoMedidaPickList;
	}
	public void setLabelTipoMedidaPickList(String labelTipoMedidaPickList) {
		this.labelTipoMedidaPickList = labelTipoMedidaPickList;
	}
	public String getLabelTipoSegmentoPickList() {
		return labelTipoSegmentoPickList;
	}
	public void setLabelTipoSegmentoPickList(String labelTipoSegmentoPickList) {
		this.labelTipoSegmentoPickList = labelTipoSegmentoPickList;
	}
	public String getLabelSubestacionElecPickList() {
		return labelSubestacionElecPickList;
	}
	public void setLabelSubestacionElecPickList(String labelSubestacionElecPickList) {
		this.labelSubestacionElecPickList = labelSubestacionElecPickList;
	}
	public String getLabelPropMedidorPickList() {
		return labelPropMedidorPickList;
	}
	public void setLabelPropMedidorPickList(String labelPropMedidorPickList) {
		this.labelPropMedidorPickList = labelPropMedidorPickList;
	}
	public String getLabelTipoConexionPickList() {
		return labelTipoConexionPickList;
	}
	public void setLabelTipoConexionPickList(String labelTipoConexionPickList) {
		this.labelTipoConexionPickList = labelTipoConexionPickList;
	}
	public String getLabelTipoLecturaPickList() {
		return labelTipoLecturaPickList;
	}
	public void setLabelTipoLecturaPickList(String labelTipoLecturaPickList) {
		this.labelTipoLecturaPickList = labelTipoLecturaPickList;
	}
	public String getLabelTipoTransformadorPickList() {
		return labelTipoTransformadorPickList;
	}
	public void setLabelTipoTransformadorPickList(String labelTipoTransformadorPickList) {
		this.labelTipoTransformadorPickList = labelTipoTransformadorPickList;
	}
	public String getLabelComunaRepartoPickList() {
		return labelComunaRepartoPickList;
	}
	public void setLabelComunaRepartoPickList(String labelComunaRepartoPickList) {
		this.labelComunaRepartoPickList = labelComunaRepartoPickList;
	}
	public String getLabelFullElectricPickList() {
		return labelFullElectricPickList;
	}
	public void setLabelFullElectricPickList(String labelFullElectricPickList) {
		this.labelFullElectricPickList = labelFullElectricPickList;
	}
	public String getLabelMedidaDisciplinaPickList() {
		return labelMedidaDisciplinaPickList;
	}
	public void setLabelMedidaDisciplinaPickList(String labelMedidaDisciplinaPickList) {
		this.labelMedidaDisciplinaPickList = labelMedidaDisciplinaPickList;
	}
	public String getLabelElectrodependientePickList() {
		return labelElectrodependientePickList;
	}
	public void setLabelElectrodependientePickList(String labelElectrodependientePickList) {
		this.labelElectrodependientePickList = labelElectrodependientePickList;
	}

	public ListadoSuministrosType getListadoSuministros() {
		return listadoSuministros;
	}

	public void setListadoSuministros(ListadoSuministrosType listadoSuministros) {
		this.listadoSuministros = listadoSuministros;
	}

	public ListadoEventosType getListadoEventos() {
		return listadoEventos;
	}

	public void setListadoEventos(ListadoEventosType listadoEventos) {
		this.listadoEventos = listadoEventos;
	}
	
	public String getFechaCorteString() {
		return fechaCorteString;
	}
	public void setFechaCorteString(String fechaCorteString) {
		this.fechaCorteString = fechaCorteString;
	}
	public String getSfidContAsociado() {
		return sfidContAsociado;
	}

	public void setSfidContAsociado(String sfidContAsociado) {
		this.sfidContAsociado = sfidContAsociado;
	}
	
	public Map<String, String> getMapComuna() {
		return mapComuna;
	}
	public void setMapComuna(Map<String, String> mapComuna) {
		this.mapComuna = mapComuna;
	}	
	public Map<String, String> getMapRegion() {
		return mapRegion;
	}
	public void setMapRegion(Map<String, String> mapRegion) {
		this.mapRegion = mapRegion;
	}	
	public List<AccountView> getCuentasRelacionadas() {
		return cuentasRelacionadas;
	}
	public void setCuentasRelacionadas(List<AccountView> cuentasRelacionadas) {
		this.cuentasRelacionadas = cuentasRelacionadas;
	}



	@Override
	public Object instantiateTargetLogic() {
		Suministro suministro = new Suministro();
		return suministro;
	}

}