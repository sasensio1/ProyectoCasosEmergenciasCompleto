package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class HerokuUserUpdaterJob extends QuartzJobBean {
final static Logger LOGGER = Logger.getLogger(CaseCommentUpdaterJob.class);
	
	@Autowired
	HerokuUserUpdaterBatch herokuUserUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de usuarios de heroku iniciada con fecha " + new Date());
			herokuUserUpdaterBatch.updateHerokuUserInfo();
		LOGGER.info("Actualizacion de usuarios de heroku completada con fecha " + new Date());		
	}
}
