package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class BorradoHistoricoCargasJob extends QuartzJobBean {
	final static Logger logger = Logger.getLogger(BorradoHistoricoCargasJob.class);
	
	@Autowired
	BorradoHistoricoCargasBatch borradoHistoricoCargasBatch;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Borrado del historico de cargas iniciada con fecha " + new Date());
		borradoHistoricoCargasBatch.borraHistoricoAntiguo();
		logger.info("Borrado del historico de cargas completada con fecha " + new Date());
	}
}