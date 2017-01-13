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
import com.casosemergencias.model.Caso;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

@Controller
public class BatchController {
	
	final static Logger logger = Logger.getLogger(BatchController.class);
		
	@Autowired
	private BatchService batchService;
	
	@RequestMapping(value = "/updateHerokuPickListTable", method = RequestMethod.GET)
	public void listadoCasosHome() {
		batchService.updateHerokuPickListTable();
	}
	
	@RequestMapping(value = "/updateHerokuFieldLabelTable", method = RequestMethod.GET)
	public void fieldLabelHome() {
		batchService.updateHerokuFieldLabelTable();
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
	
	
	
}