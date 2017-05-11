package com.casosemergencias.batch;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.util.Utils;
import com.casosemergencias.util.constants.ConstantesBulkApi;

@Resource
public class ServiceProductUpdaterBatch {
	final static Logger LOGGER = Logger.getLogger(ServiceProductUpdaterBatch.class);
	
	@Autowired
	SalesforceRestApiInvokerBatch restApiInvokerBatch;
	
	public void updateServiceProductInfo() {
		LOGGER.trace("Comienzo del proceso de actualizacion de ServiceProduct de SalesForce a la base de datos de Heroku");
		Date processEndDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(processEndDate);
		cal.add(Calendar.HOUR, -1);
		Date processStartDate = cal.getTime();
		LOGGER.info("Hora inicial: " + processStartDate);
		LOGGER.info("Hora final: " + processEndDate);
		//FIXME: Comprobar zona horaria.
		restApiInvokerBatch.setProcessStartDate(processStartDate);
		restApiInvokerBatch.setProcessEndDate(processEndDate);
		restApiInvokerBatch.setObjectName(ConstantesBulkApi.ENTITY_SERVICE_PRODUCT);
		restApiInvokerBatch.updateObjectsWithRestApiInfo();
		LOGGER.trace("Proceso de actualizacion  de ServiceProduct de SalesForce a la base de datos de Heroku completado");
	}
}
