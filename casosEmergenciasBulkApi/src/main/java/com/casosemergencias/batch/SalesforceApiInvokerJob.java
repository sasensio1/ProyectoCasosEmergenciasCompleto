package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SalesforceApiInvokerJob extends QuartzJobBean  {
	final static Logger LOGGER = Logger.getLogger(PicklistTableCreatorJob.class);
	
	@Autowired
	SalesforceRestApiInvokerBatch restApiInvokerBatch;
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de objetos desde Salesforce iniciada con fecha " + new Date());
		restApiInvokerBatch.updateObjectsWithRestApiInfo();
		LOGGER.info("Actualizacion de objetos desde Salesforce completada con fecha " + new Date());
	}
}
