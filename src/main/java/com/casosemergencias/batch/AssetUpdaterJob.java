package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class AssetUpdaterJob extends QuartzJobBean {
	final static Logger LOGGER = Logger.getLogger(AssetUpdaterJob.class);
	
	@Autowired
	AssetUpdaterBatch AssetUpdaterBatch;
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de Asset iniciada con fecha " + new Date());
			AssetUpdaterBatch.updateAssetInfo();
		LOGGER.info("Actualizacion de Asset completada con fecha " + new Date());		
	}
}
