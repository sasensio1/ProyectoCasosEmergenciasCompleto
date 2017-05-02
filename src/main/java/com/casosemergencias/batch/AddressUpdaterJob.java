package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class AddressUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(AddressUpdaterJob.class);
	
	@Autowired
	AddressUpdaterBatch AddressUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de address iniciada con fecha " + new Date());
			AddressUpdaterBatch.updateAddressInfo();
		LOGGER.info("Actualizacion de address completada con fecha " + new Date());		
	}
}
