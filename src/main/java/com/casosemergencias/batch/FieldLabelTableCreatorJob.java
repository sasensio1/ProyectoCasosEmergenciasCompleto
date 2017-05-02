package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class FieldLabelTableCreatorJob extends QuartzJobBean {
	final static Logger logger = Logger.getLogger(FieldLabelTableCreatorJob.class);
	
	@Autowired
	FieldLabelTableCreatorBatch fieldLabelTableCreatorBatch;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Carga de tabla de labels de campo iniciada con fecha " + new Date());
		fieldLabelTableCreatorBatch.fillHerokuFieldLabelTable();
		logger.info("Carga de tabla de labels de campo completada con fecha " + new Date());
	}
}