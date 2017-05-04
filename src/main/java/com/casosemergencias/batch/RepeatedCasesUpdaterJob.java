package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class RepeatedCasesUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(RepeatedCasesUpdaterJob.class);
	
	@Autowired
	RepeatedCasesUpdaterBatch RepeatedCasesUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de RepeatedCases iniciada con fecha " + new Date());
			RepeatedCasesUpdaterBatch.updateRepeatedCasesInfo();
		LOGGER.info("Actualizacion de RepeatedCases completada con fecha " + new Date());		
	}
}
