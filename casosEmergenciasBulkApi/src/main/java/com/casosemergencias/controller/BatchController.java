package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.logic.BatchService;
import com.casosemergencias.model.HistoricBatch;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

@Controller
public class BatchController {
	
	final static Logger logger = Logger.getLogger(BatchController.class);
		
	@Autowired
	private BatchService batchService;
	
	@RequestMapping(value = "/private/updateHerokuPickListTable", method = RequestMethod.GET)
	public void updateHerokuPickListHome() {
		batchService.updateHerokuPickListTable();
	}
	
	@RequestMapping(value = "/private/updateHerokuFieldLabelTable", method = RequestMethod.GET)
	public void updateHerokuFieldLabelHome() {
		batchService.updateHerokuFieldLabelTable();
	}
	
	@RequestMapping(value = "/private/updateHerokuCaseCommentTable", method = RequestMethod.GET)
	public void updateHerokuCaseCommentsHome() {
		batchService.updateCaseCommentTable();	
	}
	
	@RequestMapping(value = "/private/updateHerokuUserTable", method = RequestMethod.GET)
	public void updateHerokuUserHome() {
		batchService.updateHerokuUserTable();	
	}
	
	@RequestMapping(value = "/private/updateObjectTablesFromSalesforceApi", method = RequestMethod.GET)
//	public void updateObjectTablesFromSalesforceApi(@RequestParam Date processStartDate, @RequestParam Date processEndDate) {
//		batchService.updateObjectsInfoTables(processStartDate, processEndDate);
	public void updateObjectTablesFromSalesforceApi() {
		batchService.updateObjectsInfoTables(null, null);
	}
	
	/**
	 * Metodo que recupera una lista con todos los historicos que hay creados en BBDD y los muestra en la pantalla homeHistoricBatchPage.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/homeHistoricBatch", method = RequestMethod.GET)
	public ModelAndView goHomeHistoricBatch() {
		
		logger.info("--- Inicio -- listadoHistoricBatch ---");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("private/homeHistoricBatchPage");
	
		logger.info("--- Fin -- listadoHistoricBatch ---");
				
		return model;
	}
	
	/**
	 * M&eacute;todo invocado por la tabla de homeHistoricBatchsPage. Se recoge del body
	 * las propiedades de la tabla, le recupera la lista con todos los historicBatchs
	 * utilizando estas propiedades y se envian a la tabla en formato JSON.
	 * 
	 * @param body
	 *            Informaci&oacute;n de la request.
	 * @return String Información devuelta de los historicBatchs en formato JSON.
	 */
	@RequestMapping(value = "/listarHistoricBatchs", method = RequestMethod.POST)
	public @ResponseBody String listadoHistoricBatchsHome(@RequestBody String body,HttpServletRequest request){
		
		logger.info("--- Inicio -- listadoHistoricBatchsHome ---");
		
		// Se limpian los ids de las entidades.
		cleanSessionEntityIds(request);	
		
		DataTableProperties dataTableProperties = DataTableParser.parseBodyToDataTable(body);
		List<HistoricBatch> listHistoricBatchs = new ArrayList<HistoricBatch>();
		
		JSONObject jsonResult;
		JSONArray jsonArray = new JSONArray();
		
		listHistoricBatchs = batchService.readAllHistoricBatch(dataTableProperties);
		
		for (HistoricBatch historicBatch : listHistoricBatchs) {
			jsonResult = new JSONObject();
			jsonResult.put("object", historicBatch.getObject());
			jsonResult.put("operation", historicBatch.getOperation());
			jsonResult.put("startDate", historicBatch.getStartDate());
			jsonResult.put("sfidRecord", historicBatch.getSfidRecord());
			jsonResult.put("success", historicBatch.getSuccess());
			jsonResult.put("errorCause", historicBatch.getErrorCause());
			jsonResult.put("endDate", historicBatch.getEndDate());
			jsonArray.put(jsonResult);
		}
		
		Integer numHistoricBatchs = batchService.getNumHistoricBatchs(dataTableProperties);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("iTotalRecords", numHistoricBatchs);  //Numero de registros totales en BBDD
		jsonObject.put("iTotalDisplayRecords", numHistoricBatchs); //numero de registros totales filtrados en BBDD -- este numero lo utiliza el datatable para calcular el numero de paginas
		jsonObject.put("data", jsonArray);
		jsonObject.put("draw", dataTableProperties.getDraw());
		
		logger.info("--- Fin -- listadoHistoricBatchsHome ---");
		
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
	
	
	
}