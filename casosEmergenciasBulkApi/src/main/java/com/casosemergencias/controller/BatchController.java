package com.casosemergencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.casosemergencias.logic.BatchService;

@Controller
public class BatchController {
		
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
}