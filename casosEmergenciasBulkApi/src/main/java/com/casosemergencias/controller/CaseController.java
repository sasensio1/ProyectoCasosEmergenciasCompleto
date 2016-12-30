package com.casosemergencias.controller;


import java.io.InputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.AccountView;
import com.casosemergencias.controller.views.CaseCommentView;
import com.casosemergencias.controller.views.CaseHistoryView;
import com.casosemergencias.controller.views.CaseView;
import com.casosemergencias.controller.views.ContactView;
import com.casosemergencias.controller.views.DireccionView;
import com.casosemergencias.controller.views.SuministroView;
import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.logic.AccountService;
import com.casosemergencias.logic.CaseCommentService;
import com.casosemergencias.logic.CaseService;
import com.casosemergencias.logic.ContactService;
import com.casosemergencias.logic.DireccionService;
import com.casosemergencias.logic.PickListsService;
import com.casosemergencias.logic.SuministroService;
import com.casosemergencias.model.CaseComment;
import com.casosemergencias.model.CaseHistory;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Cuenta;
import com.casosemergencias.model.Direccion;
import com.casosemergencias.model.HerokuUser;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.PickListByField;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.constants.ConstantesError;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

/**
 * @author mcasas
 * 
 *Clase encargada de controlar las peticiones dels pantallas donde se muestran los Casos
 *En esta clase utilizaremos el objeto CaseView, pero cuando llamemos al Servicio le tendremos que pasar un objeto Caso.
 *Objetos CaseView, son objetos que controlan las pantallas de Casos
 */
@Controller
public class CaseController {
	
	final static Logger logger = Logger.getLogger(CaseController.class);
	
	@Autowired
	private CaseService casoService;

	@Autowired
	private PickListsService pickListsService;
	
	@Autowired
	private SuministroService suministroService;
	
	@Autowired
	private ContactService contactoService;
	
	@Autowired
	private AccountService cuentaService;
	
	@Autowired
	private DireccionService direccionService;

	@Autowired
	private CaseCommentService caseCommentService;
	

	/**
	 * Metodo que recupera una lista con todos los casos que hay creados en BBDD y los muestra en la pantalla homeCasosPage.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/homeCasos", method = RequestMethod.GET)
	public ModelAndView goHomeCasos() {
		
		logger.info("--- Inicio -- listadoCasos ---");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("private/homeCasosPage");
	
		logger.info("--- Fin -- listadoCasos ---");
				
		return model;
	}
	
	@RequestMapping(value = "/private/homeCasosAction", params="goCrearCaso", method = RequestMethod.POST)
	public String goCrearCaso() {
		return "redirect:entidadCasoAlta";
	}
	
	@RequestMapping(value = "/private/entidadCaso", method = RequestMethod.GET)
	public ModelAndView getCaseData(@RequestParam String sfid, @RequestParam String editMode, HttpServletRequest request) {
		logger.info("--- Inicio -- getCaseData ---");
		HttpSession session = request.getSession(true);
		
		//def. variables para controlar el numero de registros de las tablas
		int limiteEntradasHistorial = 10;
		int numeroHistorial;


		ModelAndView model = new ModelAndView();		
		model.addObject("sfid", sfid);
		model.addObject("editMode", editMode);
		
		//List<CaseView> listCaseView = new ArrayList<CaseView>();
		CaseView casoView = new CaseView();
		
		Caso casoBBDD = casoService.readCaseBySfid(sfid, limiteEntradasHistorial);
		if (casoBBDD != null){
			ParserModelVO.parseDataModelVO(casoBBDD, casoView);
		}
		
		//transformamos las fechas con el gmt de sesion
		//y en el historia adaptamos el texto utilizando los properties adecuados
		long offset = (long)session.getAttribute("difGMTUser");	
		if(casoView.getFechaApertura() != null){
			Date fechaApertura = casoView.getFechaApertura();
			fechaApertura = new Date(fechaApertura.getTime() + offset);
			casoView.setFechaApertura(fechaApertura);
		}
		if(casoView.getFechaCierre() != null){
			Date fechaCierre = casoView.getFechaCierre();
			fechaCierre = new Date(fechaCierre.getTime() + offset);
			casoView.setFechaCierre(fechaCierre);
		}
		if(casoView.getFechaEstimadaCierre() != null){
			Date fechaEstimacion = casoView.getFechaEstimadaCierre();
			fechaEstimacion = new Date(fechaEstimacion.getTime() + offset);
			casoView.setFechaEstimadaCierre(fechaEstimacion);
		}
		
		if(casoView.getCommentarioCaso() != null && !casoView.getCommentarioCaso().isEmpty()){
			for(CaseCommentView miComentario : casoView.getCommentarioCaso()){
				if(miComentario.getCreateddate() != null){
					Date fecha = miComentario.getCreateddate();
					fecha = new Date(fecha.getTime() + offset);
					miComentario.setCreateddate(fecha);				
				}
				if(miComentario.getComment() != null){
					String comentarioSaltosLinea = miComentario.getComment();
					comentarioSaltosLinea=comentarioSaltosLinea.replace("\n","<br>");
					miComentario.setComment(comentarioSaltosLinea);
				}
			}	
		}
		if(casoView.getHistorialCaso() != null && !casoView.getHistorialCaso().isEmpty()){
			for(CaseHistoryView miHistorial : casoView.getHistorialCaso()){
				if(miHistorial.getCreateddate() != null){
					Date fecha = miHistorial.getCreateddate();
					fecha = new Date(fecha.getTime() + offset);
					miHistorial.setCreateddate(fecha);
				}
				
				this.prepararFieldHistorial(miHistorial);
			}	
		}
		
		//Si el caso  no esta Cancelado si Cerrado, preparamos la lista de valores del combo de Cancelacion
		if(!(Constantes.COD_CASO_STATUS_CERRADO).equals(casoView.getEstado()) && !(Constantes.COD_CASO_STATUS_CANCELADO).equals(casoView.getEstado())){
			Map<String, String> mapSubstatusCancel = new LinkedHashMap<String, String>();
			mapSubstatusCancel.put(Constantes.PICKLIST_CASO_DEFAULT, " ");
			
			//Comprobar si el caso es alta. (Caso es alta si no tiene numero de inservice)
			if(casoView.getNumeroInservice() != null && !"".equals(casoView.getNumeroInservice())) {
				mapSubstatusCancel.put(Constantes.COD_CASO_SUBSTATUS_ERROR_INGRESO,Constantes.COD_CASO_SUBSTATUS_ERROR_INGRESO_DESC);
				mapSubstatusCancel.put(Constantes.COD_CASO_SUBSTATUS_VERIFICADO_OK,Constantes.COD_CASO_SUBSTATUS_CLIENTE_LUZ_DESC); //En este caso la descripcion es diferente a BBDD	
			}else{
				mapSubstatusCancel.put(Constantes.COD_CASO_SUBSTATUS_COMUNICACION_INTERRUMPIDA,Constantes.COD_CASO_SUBSTATUS_COMUNICACION_INTERRUMPIDA_DESC);
				mapSubstatusCancel.put(Constantes.COD_CASO_SUBSTATUS_PRUEBA_ERROR_INGRESO,Constantes.COD_CASO_SUBSTATUS_PRUEBA_ERROR_INGRESO_DESC);
				mapSubstatusCancel.put(Constantes.COD_CASO_SUBSTATUS_VERIFICADO_OK,Constantes.COD_CASO_SUBSTATUS_CLIENTE_LUZ_DESC); //En este caso la descripcion es diferente a BBDD				
			}	
			casoView.setMapSubStatusCancelacion(mapSubstatusCancel);
		}
		
		
		//comprobamos si tenemos que controlar el numero de entradas del historial
		numeroHistorial = this.casoService.getNumHistorialDeUnCaso(sfid);
		if(numeroHistorial > limiteEntradasHistorial){
			casoView.setControlHistorialEntradas(true);
		}
		
		model.setViewName("private/entidadCasoPage");
		/*Hay que añadir recuperación de label de los picklists si no sale el código solo*/
		model.addObject("caso", casoView);
		
		logger.info("--- Fin -- getCaseData ---");
		return model;
	}

	@RequestMapping(value = "/private/entidadCasoAlta", method = RequestMethod.GET)
	public ModelAndView cargarPaginaAltaCaso(HttpServletRequest request) {
		logger.info("--- Inicio -- cargarPaginaAltaCaso ---");
		
		ModelAndView model = new ModelAndView();	
		CaseView casoView = new CaseView();
		boolean hayCasoAbierto = false;
		CaseView casoSuministro = null;
		SuministroView suministroAsociado = null;
		
		HttpSession session = request.getSession(true);
		String suministroSfid = null;
		String finalDetailPage = (String) session.getAttribute(Constantes.FINAL_DETAIL_PAGE);
		if (finalDetailPage != null && !"".equals(finalDetailPage)) {
			if (!(Constantes.FINAL_DETAIL_PAGE_CONTACTO).equals(finalDetailPage)) {
				logger.info("Se crea el caso desde suministro, se arrastra el id del suministro");
				suministroSfid = (String) session.getAttribute(Constantes.SFID_SUMINISTRO);
			} else {
				logger.info("Se crea el caso desde contacto, no se arrastra el id del suministro");
			}
		} else {
			suministroSfid = (String) session.getAttribute(Constantes.SFID_SUMINISTRO);
		}
		String contactoSfid = (String) session.getAttribute(Constantes.SFID_CONTACTO);
		String cuentaSfid = (String) session.getAttribute(Constantes.SFID_CUENTA);
		String direccionSfid = (String) session.getAttribute(Constantes.SFID_DIRECCION);
		session.setAttribute(Constantes.SFID_DIRECCION, null);

		
		HerokuUser user = (HerokuUser)session.getAttribute(Constantes.SESSION_HEROKU_USER);
		getEntityDataForNewCase(suministroSfid, contactoSfid, cuentaSfid,direccionSfid, user, casoView);
		
		if (casoView.getSuministroJoin() != null) {
			suministroAsociado = casoView.getSuministroJoin();
		} else if (casoView.getSuministro() != null && !"".equals(casoView.getSuministro())) {
			Suministro suministroBD = suministroService.readSuministroBySfid(casoView.getSuministro());
			if (suministroBD != null) {
				ParserModelVO.parseDataModelVO(suministroBD, suministroAsociado);
			}
		}
		
		if (suministroAsociado != null && suministroAsociado.getCasos() != null && !suministroAsociado.getCasos().isEmpty()) {
			logger.info("El suministro tiene casos asociados. Se comprueba si alguno está abierto");
			Iterator<CaseView> iteradorCasos = suministroAsociado.getCasos().iterator();
			do {
				casoSuministro = iteradorCasos.next();
				if (!(Constantes.COD_CASO_STATUS_CERRADO).equals(casoSuministro.getEstado()) && !(Constantes.COD_CASO_STATUS_CANCELADO).equals(casoSuministro.getEstado())) {
					hayCasoAbierto = true;
				}
			} while (iteradorCasos.hasNext() && !hayCasoAbierto);
		}
		
		if (!hayCasoAbierto) {
			logger.info("El suministro no tiene casos abiertos. Se redirecciona al alta del caso");
			fillNewCaseFormInfo(casoView);
			model.addObject("caso", casoView);
			model.addObject("editMode", Constantes.EDIT_MODE_INSERT);
			model.setViewName("private/entidadCasoAltaPage");
		} else {
			logger.info("El caso con id " + casoSuministro.getSfid() + " y número " + casoSuministro.getNumeroCaso() + " está abierto. No se puede crear otro caso hasta que se complete");
			model.addObject("codigoError", ConstantesError.EMERG_ERROR_CODE_005);
			model.addObject("mostrarMensaje", true);
			model.addObject("hayError", true);
			model.addObject("mensajeResultado", "No se puede crear un nuevo caso. Existen casos abiertos pendientes.");
			// Comprobar redirección
			String redirectionPage = checkRedirectionPage(request);
			model.setViewName(redirectionPage);
		}
		logger.info("--- Fin -- cargarPaginaAltaCaso ---");
		return model;
	}
	
	@RequestMapping(value = "/private/cancelAltaCaso",method = RequestMethod.GET)
	public String cancelAltaCaso(HttpServletRequest request) {
		String redirectionPage = checkRedirectionPage(request);
		return redirectionPage;
	}

	@RequestMapping(value = "/private/altaCaso", method = RequestMethod.POST)
	public ModelAndView guardarCaso(CaseView caso, boolean redirectToNewCase, HttpServletRequest request) {
		logger.info("--- Inicio -- guardarCaso ---");
		
		Caso casoInsertado = new Caso();
		ModelAndView model = new ModelAndView();
		
		try {
			verificarPickList(caso);
			ParserModelVO.parseDataModelVO(caso, casoInsertado);
			
			casoInsertado = casoService.insertCase(casoInsertado);
			
			if (casoInsertado != null) {
				logger.info("Caso guardado correctamente con sfid:" + casoInsertado.getSfid());
				
				if (redirectToNewCase) {
					logger.info("Se redirecciona a página de nuevo caso");
					model.addObject("mostrarMensaje", true);
					model.addObject("hayError", false);
					model.addObject("mensajeResultado", "Se ha insertado correctamente el caso con número " + casoInsertado.getNumeroCaso());
					caso = new CaseView();
					fillNewCaseFormInfo(caso);
					model.addObject("caso", caso);
					model.setViewName("private/entidadCasoAltaPage");
				} else {
					logger.info("Se redirecciona a página de detalle del caso");
					model.setViewName("redirect:entidadCaso?sfid=" + casoInsertado.getSfid() + "&editMode=" + Constantes.EDIT_MODE_INSERTED_OK);
				}
			} else {
				logger.info("Se ha producido un error guardando el caso");
				model.addObject("mostrarMensaje", true);
				model.addObject("hayError", true);
				model.addObject("codigoError", ConstantesError.EMERG_ERROR_CODE_004);
				model.addObject("mensajeResultado", ConstantesError.HEROKU_CASE_CREATION_GENERIC_ERROR);
				fillNewCaseFormInfo(caso);
				model.addObject("caso", caso);
				model.setViewName("private/entidadCasoAltaPage");
			}
		} catch(EmergenciasException exception) {
			logger.info("No se ha guardado correctamente el caso");
			model.addObject("mostrarMensaje", true);
			model.addObject("hayError", true);
			model.addObject("codigoError", exception.getCode());
			model.addObject("mensajeResultado", exception.getMessage());
			fillNewCaseFormInfo(caso);
			model.addObject("caso", caso);
			model.setViewName("private/entidadCasoAltaPage");
		}
		
		logger.info("--- Fin -- guardarCaso ---");
		return model;
	}
		
	/**
	 * M&eacute;todo invocado por la tabla de homeCasosPage. Se recoge del body
	 * las propiedades de la tabla, le recupera la lista con todos los casos
	 * utilizando estas propiedades y se envian a la tabla en formato JSON.
	 * 
	 * @param body
	 *            Informaci&oacute;n de la request.
	 * @return String Información devuelta de los casos en formato JSON.
	 */
	@RequestMapping(value = "/listarCasos", method = RequestMethod.POST)
	public @ResponseBody String listadoCasosHome(@RequestBody String body,HttpServletRequest request){
		
		logger.info("--- Inicio -- listadoCasosHome ---");
		
		// Se limpian los ids de las entidades.
		cleanSessionEntityIds(request);	
		
		DataTableProperties dataTableProperties = DataTableParser.parseBodyToDataTable(body);
		List<Caso> listCasos = new ArrayList<Caso>();
		
		JSONObject jsonResult;
		JSONArray jsonArray = new JSONArray();
		
		listCasos = casoService.readAllCase(dataTableProperties);
		
		for (Caso caso : listCasos) {
			jsonResult = new JSONObject();
			jsonResult.put("numeroCaso", caso.getNumeroCaso());
			jsonResult.put("numeroInservice", caso.getNumeroInservice());
			jsonResult.put("canalOrigen", caso.getLabelCanalOrigenPickList());
			jsonResult.put("estado", caso.getLabelEstadoPickList());
			jsonResult.put("subEstado", caso.getLabelSubestadoPickList());
			jsonResult.put("submotivo", caso.getLabelSubmotivoPickList());
			jsonResult.put("sfid", caso.getSfid());
			jsonArray.put(jsonResult);
		}
		
		Integer numCasos = casoService.getNumCasos(dataTableProperties);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("iTotalRecords", numCasos);  //Numero de registros totales en BBDD
		jsonObject.put("iTotalDisplayRecords", numCasos); //numero de registros totales filtrados en BBDD -- este numero lo utiliza el datatable para calcular el numero de paginas
		jsonObject.put("data", jsonArray);
		jsonObject.put("draw", dataTableProperties.getDraw());
		
		logger.info("--- Fin -- listadoCasosHome ---");
		
		return jsonObject.toString();
	}

	/**
	 * Limpia los identificadores de las entidades de la sesi&oacute;n.
	 * @param request Petici&oacute;n donde limpiar los identificadores.
	 */
	private void cleanSessionEntityIds(HttpServletRequest request) {
		//Limpieza de sfid que arrastramos
		HttpSession session = request.getSession(true);	
		session.setAttribute(Constantes.SFID_SUMINISTRO, null);	
		session.setAttribute(Constantes.SFID_CONTACTO, null);	
		session.setAttribute(Constantes.SFID_CUENTA, null);	
		session.setAttribute(Constantes.SFID_DIRECCION, null);
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, null);
	}
	
	/**
	 * M&eacute;todo que actualiza la informaci&oacute;n de un caso.
	 * 
	 * @param casoRequest
	 *            Informaci&oacute;n del caso a actualizar.
	 * @return String Redirecci&oacute;n a la p&aacute;gina con la
	 *         informaci&oacute;n del resultado de la actualizaci&oacute;n.
	 */
	@RequestMapping(value = "/private/actualizarCaso", method = RequestMethod.POST)
	public String actualizarCaso(CaseView casoRequest) {
		logger.info("--- Inicio -- actualizarCaso ---");
		
		Caso caso = new Caso();
		ParserModelVO.parseDataModelVO(casoRequest, caso);
		int updatedCase = casoService.updateCase(caso);
		
		logger.info("--- Fin -- actualizarCaso ---");
		
		return "redirect:entidadCaso?sfid=" + caso.getSfid() + "&editMode=" + (updatedCase == 1 ? Constantes.EDIT_MODE_UPDATED_OK : Constantes.EDIT_MODE_UPDATED_ERROR);
	}

	private void verificarPickList(CaseView caso) {
		if (caso.getSubmotivo() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getSubmotivo())) {
			caso.setSubmotivo(null);
		}
		
		if (caso.getCondicionAgravante() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getCondicionAgravante())) {
			caso.setCondicionAgravante(null);
		}
		
		if (caso.getCanalNotificacion() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getCanalNotificacion())) {
			caso.setCanalNotificacion(null);
		}
		
		if (caso.getFavorabilidadDelCaso() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getFavorabilidadDelCaso())) {
			caso.setFavorabilidadDelCaso(null);
		}
	}
	
	@RequestMapping(value ="/private/cancelarCaso", method = RequestMethod.POST)
	public String cancelarCaso(CaseView casoRequest,  HttpServletRequest request){
			
		logger.info("--- Inicio -- cancelarCaso ---");
		logger.debug("--- cancelarCaso -- sfid del caso: " + casoRequest.getSfid() + "---");
		//Recuperamos el heroku user para concatenarlo al comentario.
		HttpSession session = request.getSession(true);
		HerokuUser user = (HerokuUser)session.getAttribute(Constantes.SESSION_HEROKU_USER);
				
		Caso caso = new Caso();
		ParserModelVO.parseDataModelVO(casoRequest, caso);
		boolean casoCancelado = casoService.cancelarCaso(caso,  user.getName());

		logger.info("--- Fin -- cancelarCaso ---");
		
		return "redirect:entidadCaso?sfid=" + caso.getSfid() + "&editMode=" + (casoCancelado ? Constantes.CANCEL_CASE_OK : Constantes.CANCEL_CASE_ERROR);
	}
	
	/**
	 * Metodo que recupera una lista con el historial asociado a un caso. Devuelve todos o los 10 primeros registros, segun si 
	 * 'entradas' tenemos 'All' o 10.
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/private/listarHistorialCaso", method = RequestMethod.POST)
	public @ResponseBody List<CaseHistoryView> listadoHistorialDeCaso(@RequestBody String body, HttpServletRequest request){
		
		logger.info("--- Inicio -- listadoHistorialDeCaso ---");

		SimpleDateFormat  dateFormat  = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		HttpSession session = request.getSession(true);
		long offset = (long)session.getAttribute("difGMTUser");
		
		String[] param = body.split("&");
		String sfidCaso = "";
		Integer numEntradas = null;
		
		for(String dato : param){
			String[] valor = dato.split("=");
			if("entradas".equals(valor[0]) && !"All".equals(valor[1])){
				numEntradas = Integer.parseInt(valor[1]);
			}
			if("sfid".equals(valor[0])){
				sfidCaso = valor[1];
			}
		}
		
		List<CaseHistory> listHistorial = new ArrayList<CaseHistory>();
		List<CaseHistoryView> listHistorialView = new ArrayList<CaseHistoryView>();
		listHistorial = this.casoService.obtenerListaHistorialDeUnCaso(sfidCaso, numEntradas);
		
		for(CaseHistory historial : listHistorial){
			CaseHistoryView historialView = new CaseHistoryView();
			ParserModelVO.parseDataModelVO(historial, historialView);

			//transformamos las fechas con el gmt de sesion			
			if(historialView.getCreateddate() != null){
				Date fecha = historialView.getCreateddate();
				fecha = new Date(fecha.getTime() + offset);
				historialView.setCreateddate(fecha);
				historialView.setCreateddateString(dateFormat.format(fecha));
			}

			//preparamos el texto que se tiene ue mostrar
			this.prepararFieldHistorial(historialView);
			listHistorialView.add(historialView);
		}
			
		logger.info("--- Fin -- listadoHistorialDeCaso ---");
		
		return listHistorialView;
	}

	
	@RequestMapping(value = "/private/casoComentarioPage", method = RequestMethod.GET)
	public ModelAndView comentarioCaso(@ModelAttribute("sfid") String sfidCase,  HttpServletRequest request) {
		
		logger.info("--- Inicio -- comentarioCaso ---");
		logger.debug("----- comentarioCaso -- sfid del caso: " + sfidCase);
		HttpSession session = request.getSession(true);
		
		ModelAndView model = new ModelAndView();			
		model.setViewName("private/comentarioCasePage");
		

		Caso caso = this.caseCommentService.obtenerDatosCasoParaComentario(sfidCase);

		model.addObject("description", caso.getDescription());
		model.addObject("asunto", caso.getAsunto());
		model.addObject("numeroCaso", caso.getNumeroCaso());
		
		CaseCommentView caseComment = new CaseCommentView();
		
		List<CaseComment> listaComentariosCasos = caseCommentService.obtenerListaComentariosDeUnCaso(sfidCase);

		List<CaseCommentView> listaComentariosCasoView = new ArrayList<>();
		
		if(listaComentariosCasos!=null && !listaComentariosCasos.isEmpty()){
			for(CaseComment comentarioCasoVO: listaComentariosCasos){
				CaseCommentView casoRelacionado = new CaseCommentView();
				ParserModelVO.parseDataModelVO(comentarioCasoVO, casoRelacionado);

				//transformamos las fechas con el gmt de sesion
				long offset = (long)session.getAttribute("difGMTUser");	
				if(casoRelacionado.getCreateddate() != null){
					Date fecha = casoRelacionado.getCreateddate();
					fecha = new Date(fecha.getTime() + offset);
					casoRelacionado.setCreateddate(fecha);
				}
				if(casoRelacionado.getComment()!=null){
					casoRelacionado.setComment(casoRelacionado.getComment().replace("\n","<br>"));					
				}
				listaComentariosCasoView.add(casoRelacionado);
			}
		}
		
		caseComment.setListaOldComment(listaComentariosCasoView);
		caseComment.setCaseid(sfidCase);
		
		model.addObject("caseComment", caseComment);
		
		
		//Recuperamos el heroku user de sesion y lo pasamos a la vista
		
		logger.info("--- Fin -- comentarioCaso ---");
		
		return model;
	}
	
	@RequestMapping(value ="/private/saveComentarioCaso", method = RequestMethod.POST)
	public String saveComentarioCaso(CaseCommentView casoRequest,  HttpServletRequest request){
		
		
		logger.info("--- Inicio -- actualizarCaso ---");
		//Recuperamos el heroku user para concatenarlo al comentario.
		HttpSession session = request.getSession(true);
		HerokuUser user = (HerokuUser)session.getAttribute(Constantes.SESSION_HEROKU_USER);
		String comentario = user.getName() + ": " + casoRequest.getComment();
		casoRequest.setComment(comentario);
		
		CaseComment comentarioCaso = new CaseComment();
		ParserModelVO.parseDataModelVO(casoRequest, comentarioCaso);
		Boolean insertCaseComment = caseCommentService.insertCaseComment(comentarioCaso);
		
		logger.info("--- Fin -- actualizarCaso ---");
		logger.info("UPDATED CASE"+insertCaseComment);
		
		if(insertCaseComment == true){			
			return "redirect:entidadCaso?sfid=" + comentarioCaso.getCaseid() +"&editMode="+Constantes.CREATED_MODE_CREATED_OK;
		}
		else{
			return "redirect:entidadCaso?sfid=" + comentarioCaso.getCaseid() +"&editMode="+Constantes.CREATED_MODE_CREATED_ERROR;
		}		
	}

	
	private void fillNewCaseFormInfo(CaseView casoView) {
		logger.trace("Entrando en fillNewCaseFormInfo()");
		
		logger.debug("Se van a cargar los datos iniciales del formulario de alta de caso");
		//Setteo de datos fijos
		casoView.setCanalOrigen(Constantes.COD_CASO_ORIGEN_CALL_CENTER);
		casoView.setCanalOrigenLabel(Constantes.COD_CASO_ORIGEN_CALL_CENTER_DESC);
		casoView.setType(Constantes.COD_CASO_TYPE_RECLAMO);
		casoView.setTypeLabel(Constantes.COD_CASO_TYPE_RECLAMO_DESC);
		casoView.setEstado(Constantes.COD_CASO_STATUS_INGRESADO);
		
		//Recuperacion mapa picklists
		Map<String, Map<String, String>> mapaGeneral = pickListsService.getPickListPorObjeto("Case");
		casoView.setMapStatus(PickListByField.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_STATUS, false));
		casoView.setMapPeticion(PickListByField.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_PETICION, false));
		//Recupero el RecordTypeId de Emergencia. Cambia por entorno
		if (casoView.getMapPeticion() != null && !casoView.getMapPeticion().isEmpty() 
				&& casoView.getMapPeticion().containsValue(Constantes.PICKLIST_CASO_PETICION_EMERGENCIA_NAME)){
	        for (Entry<String, String> entry : casoView.getMapPeticion().entrySet()) {
	            if (Constantes.PICKLIST_CASO_PETICION_EMERGENCIA_NAME.equalsIgnoreCase(entry.getValue())){
	            	casoView.setPeticion(entry.getKey());
	            	casoView.setPeticionLabel(entry.getValue());
	                break;
	            }
	        }
		}
		casoView.setMapSubMotivo(PickListByField.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_SUBMOTIVO, true));
		casoView.setMapCondicionAgravante(PickListByField.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_CONDICION_AGRAVANTE, true));
		casoView.setMapCanalNotificacion(PickListByField.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_CANAL_NOTIFICACION, true));
		casoView.setMapFavorabilidadCaso(PickListByField.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_FAVORABILIDAD, true));
				
		logger.info("Carga de datos iniciales del formulario de alta de un nuevo caso completa");
		logger.trace("Saliendo de fillNewCaseFormInfo()");
	}
	
	/**
	 * M&eacute;todo para a&ntilde;adir datos de suministro, direcci&oacute;n,
	 * cuenta y contacto.
	 * 
	 * @param request
	 *            Petición de donde obtener los ids. de las entidades.
	 * @param casoView
	 *            Caso donde guardar la informaci&oacute;n.
	 */
	private void getEntityDataForNewCase(String suministroSfid, String contactoSfid, String cuentaSfid,String direccionSfid, HerokuUser user ,CaseView casoView) {
		logger.trace("Entrando en getEntityDataForNewCase()");
				
		if (suministroSfid != null && !"".equals(suministroSfid)) {
			//Obtener el suministro para guardarlo en el formulario
			Suministro suministro = new Suministro();
			SuministroView suministroVista = new SuministroView();
			suministro = suministroService.readSuministroBySfid(suministroSfid);
			ParserModelVO.parseDataModelVO(suministro, suministroVista);
			casoView.setSuministroJoin(suministroVista);
			casoView.setSuministro(suministroSfid);
			casoView.setSuministroString(suministroVista.getName());
			logger.info("Suministro encontrado con id: " + suministroSfid);
			
			if (suministro != null && suministro.getDireccion() != null && !"".equals(suministro.getDireccion())) {
				//Obtener la direccion del suministro para guardarla en el formulario
				Direccion direccion = new Direccion();
				DireccionView direccionVista = new DireccionView();
				String direccionSumSfid = suministro.getDireccion();
				direccion = direccionService.readDireccionBySfid(direccionSumSfid);
				ParserModelVO.parseDataModelVO(direccion, direccionVista);
				casoView.setDireccionJoin(direccionVista);
				casoView.setDireccion(direccionSfid);
				casoView.setDireccionString(direccionVista.getName());
				logger.info("Direccion encontrada con id: " + direccionSfid);
			}
		}
		
		if (contactoSfid != null && !"".equals(contactoSfid)) {
			//Obtener el contacto para guardarlo en el formulario
			Contacto contacto = new Contacto();
			ContactView contactoVista = new ContactView();
			contacto = contactoService.readContactoBySfid(contactoSfid);
			ParserModelVO.parseDataModelVO(contacto, contactoVista);
			casoView.setContactoJoin(contactoVista);
			casoView.setNombreContacto(contactoSfid);
			casoView.setNombreContactoString(contactoVista.getName());
			casoView.setCanalNotificacion(contactoVista.getCanalPreferenteContacto());
			casoView.setTelefonoContacto(contactoVista.getPhone());
			casoView.setEmailNotificacion(contactoVista.getEmail());
			casoView.setFacebook(contactoVista.getSf4twitterFcbkUsername());
			casoView.setTwitter(contactoVista.getSf4twitterTwitterUsername());
			logger.info("Contacto encontrada con id: " + contactoSfid);
		}
		
		if (cuentaSfid != null && !"".equals(cuentaSfid)) {
			//Obtener la cuenta para guardarla en el formulario
			Cuenta cuenta = new Cuenta();
			AccountView cuentaVista = new AccountView();
			cuenta = cuentaService.getAccountBySfid(cuentaSfid, null, null, null);
			ParserModelVO.parseDataModelVO(cuenta, cuentaVista);
			casoView.setCuentaJoin(cuentaVista);
			casoView.setNombreCuenta(cuentaSfid);
			casoView.setNombreCuentaString(cuentaVista.getName());
			logger.info("Cuenta encontrada con id: " + cuentaSfid);
		}
		if (direccionSfid != null && !"".equals(direccionSfid)) {
			//Obtener la direccion para guardarla en el formulario
			Direccion direccion = new Direccion();
			DireccionView direccionVista= new DireccionView();
			direccion=direccionService.readDireccionBySfid(direccionSfid);
			ParserModelVO.parseDataModelVO(direccion, direccionVista);
			casoView.setDireccionString(direccionVista.getName());
			casoView.setDireccion(direccionVista.getSfid());
			logger.info("Direccion encontrada con id: " + direccionSfid);
		}
		
		if (user != null) {
			//Obtener el usuario para guardarlo en el formulario
			casoView.setHerokuUsername(user.getName());
			casoView.setLabelCallCenterPickList(user.getLabelUnidadPickList());
			casoView.setCallCenter(user.getUnidad());
			logger.info("Heroku user name: " + user.getName());
		}
		logger.trace("Saliendo de getEntityDataForNewCase()");
	}
	
	/**
	 * M&eacute;todo que comprueba la página de entidad donde redireccionar.
	 * 
	 * @param request
	 *            Petici&oacute;n HTTP.
	 * @return String ruta de redirecci&oacute;n.
	 */
	private String checkRedirectionPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String suministroSfid = new String();
		String contactoSfid = new String();
		String finalDetailPage = new String();
		String redirectionPage = "";
		
		suministroSfid = (String) session.getAttribute(Constantes.SFID_SUMINISTRO);
		contactoSfid = (String) session.getAttribute(Constantes.SFID_CONTACTO);
		finalDetailPage = (String) session.getAttribute(Constantes.FINAL_DETAIL_PAGE);
		
		if (finalDetailPage != null && Constantes.FINAL_DETAIL_PAGE_CONTACTO.equals(finalDetailPage) && contactoSfid != null && !"".equals(contactoSfid)) {
			redirectionPage = "redirect:entidadContacto?editMode=VIEW&sfid=" + contactoSfid;
		} else if (finalDetailPage != null && Constantes.FINAL_DETAIL_PAGE_SUMINISTRO.equals(finalDetailPage) && suministroSfid != null && !"".equals(suministroSfid)) {
			redirectionPage = "redirect:entidadSuministro?sfid=" + suministroSfid;
		}
		return redirectionPage;
	}
	
	private void prepararFieldHistorial (CaseHistoryView caseHistory){
		
		//Cargamos el fichero de propiedades, para obtener las properties utilizadas en los comentarios
		 Properties propiedades = new Properties();
		 InputStream entrada = null;
		 try{			 
			 //TODO: ADAPTAR SI AÑADIMOS MULTILENGUAJE
			 entrada = Thread.currentThread().getContextClassLoader().getResourceAsStream("text_page_es.properties");
			 if(entrada != null){
				 propiedades.load(entrada);
			 }
		 }catch (Exception ex) {
			 logger.error("--- getCaseData --- problemas al cargar el fichero de propiedades---");
		 } 
		 
		//controlamos el texto que se mostrara en el campo accion
		String field = "";
		if(caseHistory.getLabelFieldPickList() != null){
			field = caseHistory.getLabelFieldPickList();
		}else {
			if(caseHistory.getFieldLabel() != null){
				field = propiedades.getProperty("entidadCaso_texto_label_historia_accion_1", caseHistory.getFieldLabel().getLabel());
				field = MessageFormat.format(field, caseHistory.getFieldLabel().getLabel());
			}else{
				field = propiedades.getProperty("entidadCaso_texto_label_historia_accion_1", caseHistory.getField());	
				field = MessageFormat.format(field, caseHistory.getField());
			}
			if(caseHistory.getLabelOldValuePickList() != null && !"".equals(caseHistory.getLabelOldValuePickList())){
				field += " " + propiedades.getProperty("entidadCaso_texto_label_historia_accion_2", caseHistory.getLabelOldValuePickList());
				field = MessageFormat.format(field, caseHistory.getLabelOldValuePickList());
			}
			if(caseHistory.getLabelNewValuePickList() != null && !"".equals(caseHistory.getLabelNewValuePickList())){
				field += " " + propiedades.getProperty("entidadCaso_texto_label_historia_accion_3", caseHistory.getLabelNewValuePickList());
				field = MessageFormat.format(field, caseHistory.getLabelNewValuePickList());
			}
		}
		caseHistory.setField(field);
	}
}