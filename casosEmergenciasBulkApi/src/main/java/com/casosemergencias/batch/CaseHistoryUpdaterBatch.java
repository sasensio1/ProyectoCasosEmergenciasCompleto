package com.casosemergencias.batch;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.util.constants.ConstantesBulkApi;

@Resource
public class CaseHistoryUpdaterBatch {
	final static Logger LOGGER = Logger.getLogger(CaseHistoryUpdaterBatch.class);
	
	@Autowired
	SalesforceRestApiInvokerBatch restApiInvokerBatch;
	
	public void updateCaseHistoryInfo() {
		LOGGER.trace("Comienzo del proceso de actualizacion de caseHistory de SalesForce a la base de datos de Heroku");
		Date processEndDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(processEndDate);
		cal.add(Calendar.MINUTE, -15);
		Date processStartDate = cal.getTime();
		LOGGER.info("Hora inicial: " + processStartDate);
		LOGGER.info("Hora final: " + processEndDate);
		//FIXME: Comprobar zona horaria.
		restApiInvokerBatch.setProcessStartDate(processStartDate);
		restApiInvokerBatch.setProcessEndDate(processEndDate);
		restApiInvokerBatch.setObjectName(ConstantesBulkApi.ENTITY_CASE_HISTORY);
		restApiInvokerBatch.updateObjectsWithRestApiInfo();
		LOGGER.trace("Proceso de actualizacion de caseHistory de SalesForce a la base de datos de Heroku completado");
	}
}
