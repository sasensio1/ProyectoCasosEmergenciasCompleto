package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class GroupUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(GroupUpdaterJob.class);
	
	@Autowired
	GroupUpdaterBatch GroupUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de Group iniciada con fecha " + new Date());
			GroupUpdaterBatch.updateGroupInfo();
		LOGGER.info("Actualizacion de Group completada con fecha " + new Date());		
	}
}
