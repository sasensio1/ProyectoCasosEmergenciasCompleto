package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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

import com.casosemergencias.controller.views.DireccionView;
import com.casosemergencias.controller.views.PickListView;
import com.casosemergencias.logic.DireccionService;
import com.casosemergencias.logic.PickListsService;
import com.casosemergencias.model.Direccion;
import com.casosemergencias.model.PickList;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

@Controller
public class DireccionController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private DireccionService direccionService;
	
	@Autowired
	private PickListsService picklistService;
	
	@RequestMapping(value = "/private/homeDirecciones", method = RequestMethod.GET)
	public ModelAndView listadoDirecciones() {
		logger.info("--- Inicio -- listadoDirecciones ---");

		ModelAndView model = new ModelAndView();
		
		List<PickListView> picklistsComuna = new ArrayList<PickListView>();
		
		String objetoPicklistComuna = "address__c";
		String campoPicklistComuna = "municipality__c";
		
		List<PickList> picklistsLogic = picklistService.getPickListPorObjetoYCampo(objetoPicklistComuna, campoPicklistComuna);
		
		if (picklistsLogic != null && !picklistsLogic.isEmpty()) {
			for (PickList picklistLogic : picklistsLogic) {
				PickListView picklistComuna = new PickListView();
				ParserModelVO.parseDataModelVO(picklistLogic, picklistComuna);
				picklistsComuna.add(picklistComuna);
			}
		}
		
		model.addObject("picklistsComuna", picklistsComuna);
		model.setViewName("private/homeDireccionesPage");
	
		logger.info("--- Fin -- listadoDirecciones ---");
		
		return model;
	}
	
	@RequestMapping(value = "/private/entidadDireccion", method = RequestMethod.GET)
	public ModelAndView getDireccionData(@RequestParam String sfid) {
		logger.debug("Ejecutar consulta");
		ModelAndView model = new ModelAndView();		
		model.addObject("sfid", sfid);

		DireccionView direccionView = new DireccionView();		
		Direccion direccionBBDD = direccionService.readDireccionBySfid(sfid);
		if (direccionBBDD != null){
			ParserModelVO.parseDataModelVO(direccionBBDD, direccionView);
		}
		model.setViewName("private/entidadDireccionPage");
		model.addObject("direccion", direccionView);
		
		return model;
	}
	
	/**
	 * M&eacute;todo para recuperar los datos del listado principal de direcciones.
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/listarDireccionesHome", method = RequestMethod.POST)
	public @ResponseBody String listadoDireccionesHome(@RequestBody String body){
		
		logger.info("--- Inicio -- listadoDireccionesHome ---");
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		List<Direccion> listDirecciones = new ArrayList<Direccion>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray array = new JSONArray();
		
		listDirecciones = direccionService.readAllDirecciones(propDataTable);

		for (Direccion direccion : listDirecciones) {
			jsonResult = new JSONObject();
			jsonResult.put("name", direccion.getName());
			jsonResult.put("calle", direccion.getCalleJoin().getStreet());
			jsonResult.put("number__c", direccion.getNumero());
			jsonResult.put("municipality__c", direccion.getComuna());
			jsonResult.put("concatenatedaddress__c", direccion.getDireccionConcatenada());
			jsonResult.put("sfid", direccion.getSfid());
			array.put(jsonResult);
		}
		
		Integer numDirecciones = direccionService.getNumDirecciones(propDataTable);
		
		JSONObject json = new JSONObject();
		json.put("iTotalRecords", numDirecciones); 
		json.put("iTotalDisplayRecords", numDirecciones); 
		json.put("data", array);
		
		logger.info("--- Fin -- listadoDireccionesHome ---");
		
		return json.toString();	
	}
	
	/**
	 * M&eacute;todo para recuperar los datos de la ventana modal de direcciones.
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/listarDireccionesPopUp", method = RequestMethod.POST)
	public @ResponseBody String listadoDireccionesPopUp(@RequestBody String body){
		
		logger.info("--- Inicio -- listadoDireccionesPopUp ---");
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		List<Direccion> listDirecciones = new ArrayList<Direccion>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray array = new JSONArray();
		
		listDirecciones = direccionService.readAllDirecciones(propDataTable);

		for(Direccion direccion : listDirecciones) {
			jsonResult = new JSONObject();
			jsonResult.put("name", (direccion.getName() != null ? direccion.getName() : ""));
			jsonResult.put("numero", (direccion.getNumero() != null ? direccion.getNumero() : ""));
			jsonResult.put("comuna", (direccion.getComuna() != null ? direccion.getComuna() : ""));
			jsonResult.put("direccionConcatenada", (direccion.getDireccionConcatenada()!= null ? direccion.getDireccionConcatenada(): ""));
			jsonResult.put("departamento", (direccion.getDepartamento() != null ? direccion.getDepartamento() : ""));
			jsonResult.put("sfid", (direccion.getSfid() != null ? direccion.getSfid() : ""));
			array.put(jsonResult);
		}
		
		Integer numCasos = direccionService.getNumDirecciones(propDataTable);
		
		JSONObject json = new JSONObject();
		json.put("iTotalRecords", numCasos); 
		json.put("iTotalDisplayRecords", numCasos); 
		json.put("data", array);
		
		logger.info("--- Fin -- listadoDireccionesPopUp ---");
		
		return json.toString();	
	}
}