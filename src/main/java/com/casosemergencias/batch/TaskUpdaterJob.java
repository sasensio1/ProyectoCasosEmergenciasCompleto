package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TaskUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(TaskUpdaterJob.class);
	
	@Autowired
	TaskUpdaterBatch TaskUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de Task iniciada con fecha " + new Date());
			TaskUpdaterBatch.updateTaskInfo();
		LOGGER.info("Actualizacion de Task completada con fecha " + new Date());		
	}
}
