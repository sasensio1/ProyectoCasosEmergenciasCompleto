package com.casosemergencias.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.casosemergencias.logic.BatchService;
import com.casosemergencias.util.Utils;
import com.casosemergencias.util.constants.ConstantesBatch;
import com.casosemergencias.util.constants.ConstantesBulkApi;

@Controller
public class APITestController {
	@Autowired
	private BatchService batchService;
	
	final static Logger LOGGER = Logger.getLogger(APITestController.class);
	
	@RequestMapping(value = "/private/test/account", method = RequestMethod.GET)
	private void testAccount(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_ACCOUNT + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_ACCOUNT)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_ACCOUNT + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_ACCOUNT + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_ACCOUNT + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/asset", method = RequestMethod.GET)
	private void testAsset(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_ASSET + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_ASSET)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_ASSET + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_ASSET + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_ASSET + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/street", method = RequestMethod.GET)
	private void testStreet(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_STREET + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_STREET)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_STREET + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_STREET + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_STREET + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/casecomment", method = RequestMethod.GET)
	private void testCaseComment(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_CASE_COMMENT + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_CASE_COMMENT)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_CASE_COMMENT + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_CASE_COMMENT + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_CASE_COMMENT + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/casehistory", method = RequestMethod.GET)
	private void testCaseHistory(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_CASE_HISTORY + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_CASE_HISTORY)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_CASE_HISTORY + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_CASE_HISTORY + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_CASE_HISTORY + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/repeatedcases", method = RequestMethod.GET)
	private void testRepeatedCases(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_REPEATED_CASES + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_REPEATED_CASES)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_REPEATED_CASES + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_REPEATED_CASES + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_REPEATED_CASES + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/contact", method = RequestMethod.GET)
	private void testContact(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_CONTACT + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_CONTACT)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_CONTACT + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_CONTACT + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_CONTACT + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/address", method = RequestMethod.GET)
	private void testAddress(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_ADDRESS + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_ADDRESS)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_ADDRESS + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_ADDRESS + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_ADDRESS + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/group", method = RequestMethod.GET)
	private void testGroup(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_GROUP + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_GROUP)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_GROUP + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_GROUP + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_GROUP + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/herokuuser", method = RequestMethod.GET)
	private void testHerokuUser(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_HEROKU_USER + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_HEROKU_USER)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_HEROKU_USER + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_HEROKU_USER + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_HEROKU_USER + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/serviceproduct", method = RequestMethod.GET)
	private void testServiceProduct(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_SERVICE_PRODUCT + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_SERVICE_PRODUCT)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_SERVICE_PRODUCT + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_SERVICE_PRODUCT + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_SERVICE_PRODUCT + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/pointofdelivery", method = RequestMethod.GET)
	private void testPointOfDelivery(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_POINT_OF_DELIVERY + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_POINT_OF_DELIVERY)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_POINT_OF_DELIVERY + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_POINT_OF_DELIVERY + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_POINT_OF_DELIVERY + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/task", method = RequestMethod.GET)
	private void testTask(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_TASK + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_TASK)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_TASK + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_TASK + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_TASK + " >>>>> Test finalizado");
	}
	
	@RequestMapping(value = "/private/test/user", method = RequestMethod.GET)
	private void testUser(@RequestParam String startDateString, @RequestParam String endDateString) {
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_USER + " >>>>> Test iniciado");
		Date startDate = Utils.parseStringToDate(startDateString);
		Date endDate = Utils.parseStringToDate(endDateString);
		if (batchService.updateObjectsInfoTables(startDate, endDate, ConstantesBulkApi.ENTITY_USER)) {
			LOGGER.info(">>>>> " + ConstantesBatch.OBJECT_USER + " >>>>> Test ok");
		} else {
			LOGGER.error(">>>>> " + ConstantesBatch.OBJECT_USER + " >>>>> Test error");
		}
		LOGGER.trace(">>>>> " + ConstantesBatch.OBJECT_USER + " >>>>> Test finalizado");
	}
}