package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CaseCommentUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(CaseCommentUpdaterJob.class);
	
	@Autowired
	CaseCommentUpdaterBatch caseCommentUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de comentarios de casos iniciada con fecha " + new Date());
		caseCommentUpdaterBatch.updateCaseCommentInfo();
		LOGGER.info("Actualizacion de comentarios de casos completada con fecha " + new Date());		
	}
}
