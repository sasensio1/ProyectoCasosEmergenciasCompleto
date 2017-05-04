package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class AccountUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(AccountUpdaterJob.class);
	
	@Autowired
	AccountUpdaterBatch AccountUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de Account iniciada con fecha " + new Date());
			AccountUpdaterBatch.updateAccountInfo();
		LOGGER.info("Actualizacion de Account completada con fecha " + new Date());		
	}
}
