package com.casosemergencias.batch;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.util.Utils;
import com.casosemergencias.util.constants.ConstantesBulkApi;

@Resource
public class GroupUpdaterBatch {
	final static Logger LOGGER = Logger.getLogger(GroupUpdaterBatch.class);
	
	@Autowired
	SalesforceRestApiInvokerBatch restApiInvokerBatch;
	
	public void updateGroupInfo() {
		LOGGER.trace("Comienzo del proceso de actualizacion de Group de SalesForce a la base de datos de Heroku");
		Date yesterday = Utils.substractDaysToDate(new Date(), 1);
		Date processStartDate = Utils.setHourInDate(yesterday, 0, 0, 0, 0);
		Date processEndDate = Utils.setHourInDate(yesterday, 23, 59, 59, 999);
		//FIXME: Comprobar zona horaria.
		restApiInvokerBatch.setProcessStartDate(processStartDate);
		restApiInvokerBatch.setProcessEndDate(processEndDate);
		restApiInvokerBatch.setObjectName(ConstantesBulkApi.ENTITY_GROUP);
		restApiInvokerBatch.updateObjectsWithRestApiInfo();
		LOGGER.trace("Proceso de actualizacion  de Group de SalesForce a la base de datos de Heroku completado");
	}
}