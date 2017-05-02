package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class PointOfDeliveryUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(PointOfDeliveryUpdaterJob.class);
	
	@Autowired
	PointOfDeliveryUpdaterBatch PointOfDeliveryUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de PointOfDelivery iniciada con fecha " + new Date());
			PointOfDeliveryUpdaterBatch.updatePointOfDeliveryInfo();
		LOGGER.info("Actualizacion de PointOfDelivery completada con fecha " + new Date());		
	}
}
