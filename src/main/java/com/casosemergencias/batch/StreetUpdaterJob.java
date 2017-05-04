package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class StreetUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(StreetUpdaterJob.class);
	
	@Autowired
	StreetUpdaterBatch StreetUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de Street iniciada con fecha " + new Date());
			StreetUpdaterBatch.updateStreetInfo();
		LOGGER.info("Actualizacion de Street completada con fecha " + new Date());		
	}
}
