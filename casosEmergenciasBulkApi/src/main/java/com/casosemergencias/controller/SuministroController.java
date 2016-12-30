package com.casosemergencias.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.example.sieme009_schema.ListadoEventosType;
import org.example.sires033_schema.ListadoSuministrosType;
import org.example.sires033_schema.SuministroType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.CaseView;
import com.casosemergencias.controller.views.SuministroView;
import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.logic.CaseService;
import com.casosemergencias.logic.SuministroService;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.HerokuUser;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.constants.ConstantesError;
import com.casosemergencias.util.constants.ConstantesTibcoWS;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

@Controller
public class SuministroController {
	
	final static Logger logger = Logger.getLogger(SuministroController.class);
	
	@Autowired
	private SuministroService suministroService;

	@Autowired
	private CaseService casoService;
	
	@RequestMapping(value = "/private/homeSuministros", method = RequestMethod.GET)
	public ModelAndView listadoSuministros() {
		logger.info("--- Inicio -- listadoSuministros ---");
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("private/homeSuministrosPage");
			
		logger.info("--- Fin -- listadoSuministros ---");
		
		return model;
	}
	
	@RequestMapping(value = "/private/entidadSuministro", method = RequestMethod.GET)
	public ModelAndView getSuministroData(@RequestParam String sfid, HttpServletRequest request) {
		
		logger.info("Ejecutar consulta");
		HttpSession session = request.getSession(true);
		
		session.setAttribute(Constantes.SFID_SUMINISTRO, sfid);	
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, Constantes.FINAL_DETAIL_PAGE_SUMINISTRO);

		ModelAndView model = new ModelAndView();		
		model.addObject("sfid", sfid);
	
		SuministroView suministroView = new SuministroView();
		
		Suministro suministroBBDD = suministroService.readSuministroBySfid(sfid);
		if (suministroBBDD != null){
			ParserModelVO.parseDataModelVO(suministroBBDD, suministroView);
		}
		
		//Almacenamos sfid de contactos relacionados en caso de que el suministro seleccionado tenga solo uno asociado.
		if(suministroView.getContactosRelacionados()!=null && !suministroView.getContactosRelacionados().isEmpty()  && suministroView.getContactosRelacionados().size()==1 && session.getAttribute(Constantes.SFID_CONTACTO)==null){
			session.setAttribute(Constantes.SFID_CONTACTO, suministroView.getContactosRelacionados().get(0).getSfid());					
		}
		if(suministroView.getCuentaJoin()!=null && session.getAttribute(Constantes.SFID_CUENTA)==null){
			session.setAttribute(Constantes.SFID_CUENTA, suministroView.getCuentaJoin().getSfid());					
		}
		
		//transformamos las fechas con el gmt de sesion
		long offset = (long)session.getAttribute("difGMTUser");
		if(suministroView.getCasos() != null && !suministroView.getCasos().isEmpty()){
			for(CaseView miCase : suministroView.getCasos()){
				if(miCase.getFechaApertura() != null){
					Date fechaApertura = miCase.getFechaApertura();
					fechaApertura = new Date(fechaApertura.getTime() + offset);
					miCase.setFechaApertura(fechaApertura);
				}
				if(miCase.getFechaEstimadaCierre() != null){
					Date fechaEstimacion = miCase.getFechaEstimadaCierre();
					fechaEstimacion = new Date(fechaEstimacion.getTime() + offset);
					miCase.setFechaEstimadaCierre(fechaEstimacion);
				}
			}	
		}
		
		/* Llamada a los servicios web de Tibco para obtener datos y eventos del suministro para los indicadores */
		Map<String, Object> datosWS = suministroService.getDatosSuministroWS(suministroView.getNumeroSuministro());
		
		if (datosWS.get(ConstantesTibcoWS.SIRES033_RESPONSE_LIST_NAME) != null) {
			suministroView.setListadoSuministros((ListadoSuministrosType) datosWS.get(ConstantesTibcoWS.SIRES033_RESPONSE_LIST_NAME));
			for (SuministroType suministro : suministroView.getListadoSuministros().getSuministro()) {
				if (suministro.getFechaCorteSuministro() != null) {
					Date fechaActual = new Date();
					Date fechaCorteSuministro = suministro.getFechaCorteSuministro().toGregorianCalendar().getTime();
					suministroView.setFechaCorte(fechaCorteSuministro);
					logger.info("La fecha de corte del suministro es " + fechaCorteSuministro);
					if (fechaActual.getTime() > fechaCorteSuministro.getTime()) {
						logger.info("Se ha superado la fecha de corte, por lo que se marca que es corte por deuda");
						suministroView.setCortePorDeuda(true);
					} else {
						suministroView.setCortePorDeuda(false);
					}
				} else {
					suministroView.setFechaCorte(null);
					suministroView.setCortePorDeuda(false);
				}
			}
		} else {
			// Estos datos se deben rellenar solo desde el WS. Si no, no se muiestra informacion
			suministroView.setFechaCorte(null);
			suministroView.setCortePorDeuda(null);
		}
		
		if (datosWS.get(ConstantesTibcoWS.SIEME009_RESPONSE_LIST_NAME) != null) {
			logger.info("Se envían los eventos a la vista");
			suministroView.setListadoEventos((ListadoEventosType) datosWS.get(ConstantesTibcoWS.SIEME009_RESPONSE_LIST_NAME));
		}
		
		logger.info("SFID_CUENTA: " + session.getAttribute(Constantes.SFID_CUENTA));
		logger.info("SFID_CONTACTO: " + session.getAttribute(Constantes.SFID_CONTACTO));
		logger.info("SFID_SUMINISTRO: " + session.getAttribute(Constantes.SFID_SUMINISTRO));
		logger.info("FINAL_DETAIL_PAGE: " + session.getAttribute(Constantes.FINAL_DETAIL_PAGE));
		
		model.setViewName("private/entidadSuministroPage");
		model.addObject("suministro", suministroView);

		return model;
	}

	/**
	 * M&eacute;todo para recuperar los datos de la ventana modal de suministross.
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/listarSuministrosPopUp", method = RequestMethod.POST)
	public @ResponseBody String listadoSuministrosPopUp(@RequestBody String body){
		
		logger.info("--- Inicio -- listadoSuministrosPopUp ---");
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		List<Suministro> listSuministros = new ArrayList<Suministro>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray array = new JSONArray();
		
		listSuministros = suministroService.readAllSuministros(propDataTable);
		for(Suministro suministro : listSuministros){
			jsonResult = new JSONObject();
			jsonResult.put("name", suministro.getName());
			jsonResult.put("idEmpresa", suministro.getIdEmpresa());
			jsonResult.put("comuna", suministro.getComuna());
			jsonResult.put("direccionConcatenada", suministro.getDireccionConcatenada());
			if(suministro.getDirSuministroJoin() != null) {
				jsonResult.put("direccionSfid", suministro.getDirSuministroJoin().getSfid());
				jsonResult.put("direccionName", suministro.getDirSuministroJoin().getName());	
			}
			jsonResult.put("sfid", suministro.getSfid());
			array.put(jsonResult);
		}
		
		Integer numCasos = suministroService.getNumSuministros(propDataTable);
		
		JSONObject json = new JSONObject();
		json.put("iTotalRecords", numCasos); 
		json.put("iTotalDisplayRecords", numCasos); 
		json.put("data", array);
		
		logger.info("--- Fin -- listadoSuministrosPopUp ---");
		
		return json.toString();
	}
	/**
	 * Metodo que recupera una lista con los suministros asociados a una cuenta. Devuelve todos o los 10 primeros, segun si 
	 * numSuministros es 'All' o 10.
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/private/listarSuministrosCuenta", method = RequestMethod.POST)
	public @ResponseBody List<SuministroView> listadoSuministrosParaCuenta(@RequestBody String body, HttpServletRequest request){
		
		logger.info("--- Inicio -- listarSuministrosCuenta ---");

		SimpleDateFormat  dateFormat  = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		HttpSession session = request.getSession(true);
		long offset = (long)session.getAttribute("difGMTUser");
		
		String[] param = body.split("&");
		String sfidCuenta = "";
		Integer numSuministor = null;
		
		for(String dato : param){
			String[] valor = dato.split("=");
			if("numSuministros".equals(valor[0]) && !"All".equals(valor[1])){
				numSuministor = Integer.parseInt(valor[1]);
			}
			if("sfidCuenta".equals(valor[0])){
				sfidCuenta = valor[1];
			}
		}
	
		List<Suministro> listSuministros = new ArrayList<Suministro>();
		List<SuministroView> listSuministrosView = new ArrayList<SuministroView>();
		
		listSuministros = suministroService.readSuministrosCuenta(sfidCuenta, numSuministor);
		for(Suministro suministro : listSuministros){
			SuministroView suministroView = new SuministroView();
			ParserModelVO.parseDataModelVO(suministro, suministroView);
			
			//transformamos las fechas con el gmt de sesion			
			if(suministroView.getFechaCorte() != null){
				Date fechaCorte = suministroView.getFechaCorte();
				fechaCorte = new Date(fechaCorte.getTime() + offset);
				suministroView.setFechaCorte(fechaCorte);
				suministroView.setFechaCorteString(dateFormat.format(fechaCorte));
			}
			
			
			listSuministrosView.add(suministroView);
		}
		
		logger.info("--- Fin -- listarSuministrosCuenta ---");
		
		return listSuministrosView;
	}
	
	
	/**
	 * M&eacute;todo para recuperar los datos del listado de suministros.
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/listarSuministros", method = RequestMethod.POST)
	public @ResponseBody String listadoSuministros(@RequestBody String body,HttpServletRequest request){
		
		logger.info("--- Inicio -- listadoSuministrosHome ---");
				
		//Limpieza de sfid que arrastramos
		
		HttpSession session = request.getSession(true);	
		
		session.setAttribute(Constantes.SFID_SUMINISTRO, null);	
		session.setAttribute(Constantes.SFID_CONTACTO, null);	
		session.setAttribute(Constantes.SFID_CUENTA, null);
		session.setAttribute(Constantes.SFID_DIRECCION, null);
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, null);	
		
		//Limpieza de sfid que arrastramos
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		List<Suministro> listSuministros = new ArrayList<Suministro>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray array = new JSONArray();
		
		listSuministros = suministroService.readAllSuministros(propDataTable);

		for (Suministro suministro : listSuministros) {
			jsonResult = new JSONObject();
			jsonResult.put("name", suministro.getName());
			jsonResult.put("estadoConexion", suministro.getLabelEstadoConexionPickList());
			jsonResult.put("estadoSuministro", suministro.getLabelEstadoSuministroPickList());
			jsonResult.put("direccionConcatenada", suministro.getDireccionConcatenada());
			jsonResult.put("comuna", suministro.getComuna());
			jsonResult.put("sfid", suministro.getSfid());
			array.put(jsonResult);
		}
		
		Integer numSuministros = suministroService.getNumSuministros(propDataTable);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("iTotalRecords", numSuministros); 
		jsonObject.put("iTotalDisplayRecords", numSuministros); 
		jsonObject.put("data", array);
		jsonObject.put("draw", propDataTable.getDraw());
		
		logger.info("SFID_CUENTA" + session.getAttribute(Constantes.SFID_CUENTA));
		logger.info("SFID_CONTACTO" + session.getAttribute(Constantes.SFID_CONTACTO));
		logger.info("SFID_SUMINISTRO" + session.getAttribute(Constantes.SFID_SUMINISTRO));
		
		logger.info("--- Fin -- listadoSuministrosHome ---");
		
		return jsonObject.toString();
	}
	
	//Crear Caso nuevo con Suministro asociado.
	
	@RequestMapping(value = "/private/goCrearCasoBySuministro", method = RequestMethod.GET)
	public ModelAndView crearCasoBySuministro() {
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:entidadCasoAlta");
		
		return model;
	}
	
	@RequestMapping(value = "/private/goCrearCasoBySuministroAndCorte", method = RequestMethod.POST)
	public @ResponseBody String goCrearCasoBySuministroAndCorte(@RequestBody String body, HttpServletRequest request) {
	
		logger.info("--- Inicio -- goCrearCasoBySuministroAndCorte ---");
		logger.debug("--- Creamos el objeto Caso con los datos necesarios para insertar ---");
		
		// Obtenemos sfid y causa del body (peticion ajax)
		String causa="";
		String sfidSum="";
		String[] bodyArray = body.split("&");
		for(String miArray : bodyArray){
			String[] componente  = miArray.split("=");
			if("causa".equals(componente[0])){
				causa = componente[1];
			}
			if("sfidSum".equals(componente[0])){
				sfidSum = componente[1];
			}	
		}		

		// Rellenamos los datos del caso a insertar 
		if (sfidSum != null && !"".equals(sfidSum)) {
			//Obtener el suministro para guardarlo en el formulario
			
				HttpSession session = request.getSession(true);
		
				Suministro suministro = new Suministro();
				Caso caso= new Caso();
				
				HerokuUser user = (HerokuUser)session.getAttribute(Constantes.SESSION_HEROKU_USER);
				
				suministro = suministroService.readSuministroBySfid(sfidSum);	
				
				if (suministro != null) {		
					//Set de info de Suministro					
					caso.setSuministro(sfidSum);
					caso.setSuministroJoin(suministro);	
				
					//Set de info de Direccion					
					if(suministro.getDireccion()!=null){			
						caso.setDireccion(suministro.getDireccion());
						logger.debug("Direccion encontrada con id: " + suministro.getDireccion());	
					}		
					
					//Set de info de Contacto				
					if(suministro.getContactosRelacionados()!=null && suministro.getContactosRelacionados().isEmpty()==false  && suministro.getContactosRelacionados().size()==1){						
						caso.setNombreContacto(suministro.getContactosRelacionados().get(0).getSfid());
						
						logger.debug("Contacto encontrada con id: " + suministro.getContactosRelacionados().get(0).getSfid());
					}	
					
					//Set de info Cuenta 
					if(suministro.getCuentaJoin() != null){
						caso.setNombreCuenta(suministro.getCuenta());
					}
					
					//Set de info de HerokuUser					
					if(user != null && user.getName() != null && !"".equals(user.getName())){									
						String unidad=user.getUnidad();
						String username=user.getName();
						caso.setHerokuUsername(username);						
						caso.setCallCenter(unidad);
						logger.info("Heroku user name: " + user.getName());
					}	
					
					//Set campos de Caso comunes en ambos tipos de corte
					caso.setCanalOrigen(Constantes.COD_CASO_ORIGEN_CALL_CENTER);
					caso.setPeticion(Constantes.COD_CASO_MOTIVO_EMERGENCIA);
					caso.setEstado(Constantes.COD_CASO_STATUS_CERRADO);
					caso.setType(Constantes.COD_CASO_TYPE_RECLAMO_DESC);
					
					//Set campos con valores especificos para cada corte de Caso 
					if(causa!=null){
						if("deuda".equals(causa)){							
							caso.setSubmotivo(Constantes.COD_CASO_SUBMOTIVO_CORTE_DEUDA);
							caso.setDescription(Constantes.COD_CASO_DESC_DEUDA);
						}
						if("progr".equals(causa)){
							caso.setSubmotivo(Constantes.COD_CASO_SUBMOTIVO_CORTE_PROGRAMADO);
							caso.setDescription(Constantes.COD_CASO_DESC_PROGRAMADO);
						}
					}
				}				

				logger.debug("--- Insertamos el nuevo caso en BBDD ---");
						
				try{
					
					caso = casoService.insertCase(caso);	
					if(caso != null){
						
						logger.info("Caso guardado correctamente con sfid:" + caso.getSfid());
						logger.debug("Se redirecciona a página de detalle del caso");
						logger.info("--- Fin -- goCrearCasoBySuministroAndCorte ---");
						return "../private/entidadCaso?sfid=" + caso.getSfid() + "&editMode=" + Constantes.EDIT_MODE_INSERTED_OK;
					}
					
					else {
						logger.debug("Se ha producido un error guardando el caso");
						String codigoError=new String();
						String mensajeError=new String();
						codigoError=ConstantesError.EMERG_ERROR_CODE_004;		
						mensajeError=ConstantesError.HEROKU_CASE_CREATION_GENERIC_ERROR;
						logger.info("--- Fin -- goCrearCasoBySuministroAndCorte ---");
						return codigoError+"$"+mensajeError;
					}
				}
				catch(EmergenciasException exception){	
					logger.info("No se ha guardado correctamente el caso");
					String codigoError=new String();
					String mensajeError=new String();
					codigoError=exception.getCode();	
					mensajeError=exception.getMessage();
					logger.info("--- Fin -- goCrearCasoBySuministroAndCorte ---");
					return codigoError+"$"+mensajeError;
				}				
			}
			return null;	
		}
		
}