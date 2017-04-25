package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ContactUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(ContactUpdaterJob.class);
	
	@Autowired
	ContactUpdaterBatch ContactUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de Contact iniciada con fecha " + new Date());
			ContactUpdaterBatch.updateContactInfo();
		LOGGER.info("Actualizacion de Contact completada con fecha " + new Date());		
	}
}
