package com.casosemergencias.batch;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.util.constants.ConstantesBulkApi;

@Resource
public class CaseCommentUpdaterBatch {
	final static Logger LOGGER = Logger.getLogger(CaseCommentUpdaterBatch.class);
	
	@Autowired
	SalesforceRestApiInvokerBatch restApiInvokerBatch;
	
	public void updateCaseCommentInfo() {
		LOGGER.trace("Comienzo del proceso de actualizacion de los comentarios de los casos de SalesForce a la base de datos de Heroku");
		Date processEndDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(processEndDate);
		cal.add(Calendar.HOUR, -2);
		Date processStartDate = cal.getTime();
		LOGGER.info("Hora inicial: " + processStartDate);
		LOGGER.info("Hora final: " + processEndDate);
		//FIXME: Comprobar zona horaria.
		restApiInvokerBatch.setProcessStartDate(processStartDate);
		restApiInvokerBatch.setProcessEndDate(processEndDate);
		restApiInvokerBatch.setObjectName(ConstantesBulkApi.ENTITY_CASE_COMMENT);
		restApiInvokerBatch.setObjectSelect(ConstantesBulkApi.ENTITY_CASE_COMMENT_SELECT);
		restApiInvokerBatch.updateObjectsWithRestApiInfo();
		LOGGER.trace("Proceso de actualizacion de los comentarios de los casos de SalesForce a la base de datos de Heroku completado");
	}
}