package com.casosemergencias.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.AccountDAO;
import com.casosemergencias.dao.AssetDAO;
import com.casosemergencias.dao.CaseDAO;
import com.casosemergencias.dao.CasosReiteradosDAO;
import com.casosemergencias.dao.RelacionActivoContactoDAO;
import com.casosemergencias.dao.SuministroDAO;
import com.casosemergencias.dao.vo.AccountVO;
import com.casosemergencias.dao.vo.AssetVO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.dao.vo.CasosReiteradosVO;
import com.casosemergencias.dao.vo.RelacionActivoContactoVO;
import com.casosemergencias.dao.vo.SuministroVO;
import com.casosemergencias.logic.ws.clients.ConsultaDatosSuministroWSClient;
import com.casosemergencias.logic.ws.clients.GetEventosRelacionadosWSClient;
import com.casosemergencias.logic.ws.responses.ConsultaDatosSuministroWSResponse;
import com.casosemergencias.logic.ws.responses.GetEventosRelacionadosWSResponse;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Cuenta;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.constants.ConstantesTibcoWS;
import com.casosemergencias.util.datatables.DataTableProperties;


public class SuministroServiceImpl implements SuministroService{

	final static Logger logger = Logger.getLogger(SuministroService.class);
	
	@Autowired
	private SuministroDAO suministroDao;
	
	@Autowired
	private CaseDAO casoDAO;
	
	@Autowired
	private RelacionActivoContactoDAO relacionDAO;
	
	@Autowired
	private ConsultaDatosSuministroWSClient consultaDatosSuministroWSClient;
	
	@Autowired
	private GetEventosRelacionadosWSClient getEventosRelacionadosWSClient;
	
	@Autowired
	private CasosReiteradosDAO casoReiteradosDAO;
	
	@Autowired
	private AssetDAO assetDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public List<Suministro> readAllSuministros() {
		
		logger.debug("--- Inicio -- readAllSuministros ---");
		
		List<Suministro> listSuministro = new ArrayList<>();
		
		List<SuministroVO> listSuministroVO = suministroDao.readAllSuministro();
		logger.debug("--- Inicio -- readAllSuministros cantidad : " + listSuministroVO.size() + " ---");
		
		for(SuministroVO suministroVO : listSuministroVO){
			Suministro suministro = new Suministro();
			ParserModelVO.parseDataModelVO(suministroVO, suministro);
			listSuministro.add(suministro);
			
		}
		
		logger.debug("--- Fin -- readAllSuministros ---:"+listSuministro.size());
		
		return listSuministro;
	}
	
	/**
	 * Metodo que devuelve una lista con todos los suministros que hay en BBDD
	 * 
	 * @return
	 */
	@Override
	public List<Suministro> readAllSuministros(DataTableProperties propDatatable) {
		
		logger.debug("--- Inicio -- readAllSuministros ---");
		List<Suministro> listSuministro = new ArrayList<Suministro>();
		
		List<SuministroVO> listSuministroVO = suministroDao.readSuministroDataTable(propDatatable);
		logger.debug("--- Inicio -- readAllSuministros cantidad: " + listSuministroVO.size() + " ---");
		
		for (SuministroVO suministroVO : listSuministroVO) {
			Suministro suministro = new Suministro();
			ParserModelVO.parseDataModelVO(suministroVO, suministro);
			listSuministro.add(suministro);
		}
		
		logger.debug("--- Fin -- readAllSuministros ---:"+listSuministro.size());
		return listSuministro;
	}

	public Suministro readSuministroBySfid(String sfid){
		SuministroVO suministroVO = suministroDao.readSuministroBySfid(sfid);
		Suministro suministro = new Suministro();
		//Si nos devuelve null, devolvemos null, si no, devolvemos el objeto relleno con los datos que nos devuelve BBDD
		if(suministroVO!=null){
			ParserModelVO.parseDataModelVO(suministroVO, suministro);
			List<CaseVO> listacasosVO = casoDAO.readCaseOfSuministro(sfid);
			List<Caso> casoRelacionado = parseaListaCasos(listacasosVO);
			suministro.setCasos(casoRelacionado);
			List<RelacionActivoContactoVO> listaRelacionVO = relacionDAO.getContactosRelacionadosPorSuministro(sfid);
			List<Contacto> contactosRelacionado = parseaListaContactosRel(listaRelacionVO);
			suministro.setContactosRelacionados(contactosRelacionado);
				//Metodo para obtener cuenta relacionada a través del objeto Asset
				List<AssetVO> listaAssetVO = assetDAO.readAssetBySuministroid(sfid);
				if(listaAssetVO!=null && !listaAssetVO.isEmpty()){
					List<Cuenta> cuentasRelacionadasList=new ArrayList<Cuenta>();
					for(AssetVO activoVO:listaAssetVO){
						Cuenta cuenta=new Cuenta();
						AccountVO accountVO = activoVO.getCuentaJoin();
						if(accountVO!=null){
						ParserModelVO.parseDataModelVO(accountVO, cuenta);		
						cuentasRelacionadasList.add(cuenta);							
						}
					}	
					if(!cuentasRelacionadasList.isEmpty() && cuentasRelacionadasList!=null ){
						suministro.setCuentasRelacionadas(cuentasRelacionadasList);
					}
				}			
			//Se puede añadir dentro del for el calculo de casos abiertos
			if(casoRelacionado != null && !casoRelacionado.isEmpty() && casoRelacionado.size()>0){
				
				//Calculamos si el suministro tiene casosReiterados 
				CasosReiteradosVO casosReiteradosVO = casoReiteradosDAO.readCasosReiteradosByName("Suministro");
				int numCasos = 0;
				int limiteDias = casosReiteradosVO.getNumDias().intValue();
				int numCasosReit = casosReiteradosVO.getNumCasos().intValue();
				boolean hayCasoAbierto = false;
				
				Calendar calendar = Calendar.getInstance();	
				//Definimos el formato para comparar 'fechaApertura' con la fecha actual
				SimpleDateFormat  dateFormat  = new SimpleDateFormat("dd-MM-yyyy");
			
				for(Caso caso : casoRelacionado){
					try {
						Date dateCreadionCaso = caso.getFechaApertura();
						Date dateHoy = new Date();
						if(dateCreadionCaso != null){
							//Fecha apertura del caso le sumamos 'limiteDias'
							calendar.setTime(dateCreadionCaso);
							calendar.add(Calendar.DAY_OF_YEAR, limiteDias);
								
							String stringDate = dateFormat.format(calendar.getTime());
							dateCreadionCaso = dateFormat.parse(stringDate);						
							stringDate = dateFormat.format(dateHoy);
							dateHoy = dateFormat.parse(stringDate);
							
							if(dateCreadionCaso.getTime() > dateHoy.getTime()){
								numCasos ++;
							}
							
							if (!(Constantes.COD_CASO_STATUS_CERRADO).equals(caso.getEstado()) && !(Constantes.COD_CASO_STATUS_CANCELADO).equals(caso.getEstado())) {
								hayCasoAbierto = true;
							}
						}
						
					} catch (ParseException e) {
						logger.error("--- readSuministroBySfid -- error al parsear una fecha ---");
						logger.error(e.getMessage());
					}
	
				}	
				
				if(numCasos >= numCasosReit){
					suministro.setCasosReiterados((double) numCasos);
				}
				
				if (hayCasoAbierto) {
					suministro.setCasosAbiertos(Boolean.valueOf(true));
				}
			}
			
			return suministro;
		}
		return null;
	}

	public Integer getNumSuministros(DataTableProperties propDatatable){
		return suministroDao.countSuministro(propDatatable);
	}

	public List<Suministro> getNumSuministrosDeUnaCuenta(String sfidCuenta) {
		return readSuministrosCuenta(sfidCuenta, null);
	}
	
	public List<Suministro> readSuministrosCuenta(String sfidCuenta, Integer numeroSuministros){
		
		List<Suministro> listaSuministros = new ArrayList<Suministro>();
		List<SuministroVO> listaSuministrosVO = new ArrayList<SuministroVO>();
		
		List<AssetVO> assetsVO = assetDAO.readAssetByAccountId(sfidCuenta);
		if (assetsVO != null && !assetsVO.isEmpty()) {
			for (AssetVO asset : assetsVO) {
				if (asset.getSuministroJoin() != null && !listaSuministrosVO.contains(asset.getSuministroJoin())) {
					listaSuministrosVO.add(asset.getSuministroJoin());
				}
			}
		}
				
		int limiteSuministro = listaSuministrosVO.size();
		
		if (numeroSuministros != null) {
			limiteSuministro = numeroSuministros;
		}
		
		for (int i = 0; i<limiteSuministro; i++) {
			SuministroVO suministro = listaSuministrosVO.get(i);
			Suministro suministroRellenar = new Suministro();
			ParserModelVO.parseDataModelVO(suministro, suministroRellenar);
			listaSuministros.add(suministroRellenar);
		}
		
		return listaSuministros;
		
	}
	
	private List<Caso> parseaListaCasos(List<CaseVO> listacasosVO) {
		if(listacasosVO!=null && !listacasosVO.isEmpty()){
			List<Caso> retorno = new ArrayList<Caso>();
			for(CaseVO casoVO: listacasosVO){
				Caso casoRelacionado = new Caso();
				ParserModelVO.parseDataModelVO(casoVO, casoRelacionado);
				retorno.add(casoRelacionado);
			}
			return retorno;
		}
		return null;
	}
	private List<Contacto> parseaListaContactosRel(List<RelacionActivoContactoVO> listaRelacionVO) {
		if(listaRelacionVO!=null && !listaRelacionVO.isEmpty()){
			List<Contacto> retorno = new ArrayList<Contacto>();
			for(RelacionActivoContactoVO relacion: listaRelacionVO){
				if(relacion.getContacto()!=null ){
					Contacto contactoRelacionado = new Contacto();
					ParserModelVO.parseDataModelVO(relacion.getContacto(), contactoRelacionado);
					if(relacion.getTipoRelacionActivo()!=null)
						contactoRelacionado.setRelacionActivo(relacion.getTipoRelacionActivo().getValor());
					if(relacion.getPrincipal()==null){
						contactoRelacionado.setPrincipal(false);
					}
					else{
					contactoRelacionado.setPrincipal(relacion.getPrincipal());
					}
					retorno.add(contactoRelacionado);
				}
			}
			return retorno;
		}
		return null;
	}

	/**
	 * M&eacute;todo que realiza la llamada a los servicios web de TIBCO para
	 * devolver la informaci&oacute;n del suministro y sus eventos relacionados.
	 * 
	 * @param numSuministro
	 *            N&uacute;mero del suministro.
	 * @return Map<String, Object> Mapa con los objetos de los dos servicios
	 *         web.
	 */
	public Map<String, Object> getDatosSuministroWS(String numSuministro) {
		logger.debug("--- Inicio -- getDatosSuministroWS ---");
		Map<String, Object> datosWS = new HashMap<String, Object>();
		
		logger.info("------>>>>> Llamando al servicio de consulta de datos de suministro ------>>>>>");
		ConsultaDatosSuministroWSResponse datosSumResponse = consultaDatosSuministroWSClient.consultarDatosSuministroWS(numSuministro, ConstantesTibcoWS.TIBCO_WS_SIRES033_ID_EMPRESA);
		if (datosSumResponse != null) {
			if (datosSumResponse.getMapaErrores() != null && !datosSumResponse.getMapaErrores().containsKey("0")) {
				logger.error("Error en la llamada al servicio: ");
				for (Map.Entry<String,String> entry : datosSumResponse.getMapaErrores().entrySet()) {
					logger.error("- Error " + entry.getKey() + ": " + entry.getValue());
				}
			} else {
				logger.info("Peticion procesada correctamente");
			}
			
			if (datosSumResponse.getListadoSuministros() != null && !datosSumResponse.getListadoSuministros().getSuministro().isEmpty()) {
				logger.info("Registros encontrados: " + datosSumResponse.getTotalRegistros());
				datosWS.put(ConstantesTibcoWS.SIRES033_RESPONSE_LIST_NAME, datosSumResponse.getListadoSuministros());
			}
		} else {
			logger.error("El servicio ha devuelto una respuesta vacia");
		}
		logger.info("<<<<<------ Llamada al servicio de consulta de datos de suministro completa <<<<<------");
		logger.info("------>>>>> Llamando al servicio de consulta de eventos relacionados con un suministro ------>>>>>");
		GetEventosRelacionadosWSResponse eventosRelResponse = getEventosRelacionadosWSClient.getEventosRelacionadosWS(numSuministro, ConstantesTibcoWS.TIBCO_WS_SIRES033_ID_EMPRESA);
		if (eventosRelResponse != null) {
			if (eventosRelResponse.getMapaErrores() != null && !eventosRelResponse.getMapaErrores().containsKey("0")) {
				logger.error("Error en la llamada al servicio: ");
				for (Map.Entry<String,String> entry : eventosRelResponse.getMapaErrores().entrySet()) {
					logger.error("- Error " + entry.getKey() + ": " + entry.getValue());
				}
			} else {
				logger.error("Petición procesada correctamente");
			}
			if (eventosRelResponse.getListadoEventos() != null && !eventosRelResponse.getListadoEventos().getEvento().isEmpty()) {
				logger.info("El suministro tiene " + eventosRelResponse.getListadoEventos().getEvento().size() + " eventos relacionados");
				datosWS.put(ConstantesTibcoWS.SIEME009_RESPONSE_LIST_NAME, eventosRelResponse.getListadoEventos());
			}
		} else {
			logger.error("El servicio ha devuelto una respuesta vacia");
		}
		logger.info("<<<<<------ Llamada al servicio de consulta de eventos relacionados con un suministro completa <<<<<------");
		
		logger.debug("--- Fin -- getDatosSuministroWS ---");
		return datosWS;
	}
}
