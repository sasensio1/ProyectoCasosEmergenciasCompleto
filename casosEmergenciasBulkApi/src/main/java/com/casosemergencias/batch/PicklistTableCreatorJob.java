package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class PicklistTableCreatorJob extends QuartzJobBean {
	final static Logger logger = Logger.getLogger(PicklistTableCreatorJob.class);
	
	@Autowired
	PicklistTableCreatorBatch picklistTableCreatorBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Carga de tabla de picklists iniciada con fecha " + new Date());
		picklistTableCreatorBatch.fillHerokuPicklistTable();
		logger.info("Carga de tabla de picklists completada con fecha " + new Date());		
	}
}