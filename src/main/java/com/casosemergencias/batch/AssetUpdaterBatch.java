package com.casosemergencias.batch;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.util.Utils;
import com.casosemergencias.util.constants.ConstantesBulkApi;

@Resource
public class AssetUpdaterBatch {
	final static Logger LOGGER = Logger.getLogger(AssetUpdaterBatch.class);
	
	@Autowired
	SalesforceRestApiInvokerBatch restApiInvokerBatch;
	
	public void updateAssetInfo() {
		LOGGER.trace("Comienzo del proceso de actualizacion de Asset de SalesForce a la base de datos de Heroku");
		Date processEndDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(processEndDate);
		cal.add(Calendar.MINUTE, -30);
		Date processStartDate = cal.getTime();
		LOGGER.info("Hora inicial: " + processStartDate);
		LOGGER.info("Hora final: " + processEndDate);
		//FIXME: Comprobar zona horaria.
		restApiInvokerBatch.setProcessStartDate(processStartDate);
		restApiInvokerBatch.setProcessEndDate(processEndDate);
		restApiInvokerBatch.setObjectName(ConstantesBulkApi.ENTITY_ASSET);
		restApiInvokerBatch.updateObjectsWithRestApiInfo();
		LOGGER.trace("Proceso de actualizacion  de Asset de SalesForce a la base de datos de Heroku completado");
	}
}