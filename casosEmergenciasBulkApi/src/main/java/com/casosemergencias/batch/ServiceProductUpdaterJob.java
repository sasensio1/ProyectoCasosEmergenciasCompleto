package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ServiceProductUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(ServiceProductUpdaterJob.class);
	
	@Autowired
	ServiceProductUpdaterBatch ServiceProductUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de ServiceProduct iniciada con fecha " + new Date());
			ServiceProductUpdaterBatch.updateServiceProductInfo();
		LOGGER.info("Actualizacion de ServiceProduct completada con fecha " + new Date());		
	}
}
