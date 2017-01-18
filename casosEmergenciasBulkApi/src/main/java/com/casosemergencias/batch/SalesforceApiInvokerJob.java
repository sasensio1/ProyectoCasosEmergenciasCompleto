package com.casosemergencias.batch;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.casosemergencias.util.Utils;
import com.casosemergencias.util.constants.ConstantesBulkApi;

public class SalesforceApiInvokerJob extends QuartzJobBean  {
	final static Logger LOGGER = Logger.getLogger(PicklistTableCreatorJob.class);
	
	private Date processStartDate;
	private Date processEndDate;
	
	@Autowired
	SalesforceRestApiInvokerBatch restApiInvokerBatch;
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		LOGGER.info("Actualizacion de objetos desde Salesforce iniciada con fecha " + new Date());
		int dateSearchingRange = 0;
		if (processStartDate != null && processEndDate != null) {
			if (processEndDate.before(processStartDate)) {
				LOGGER.error("Fechas incorrectas. La fecha de fin debe ser mayor que la de inicio");
			} else {
				//int dateSearchingRange = (int) ((processEndDate.getTime() - processStartDate.getTime()) / (1000 * 60 * 60 * 24));
				LocalDateTime localStartDateTime = LocalDateTime.ofInstant(processStartDate.toInstant(), ZoneId.of("UTC"));
				LocalDateTime localEndDateTime = LocalDateTime.ofInstant(processEndDate.toInstant(), ZoneId.of("UTC"));
				dateSearchingRange = (int) ChronoUnit.DAYS.between(localStartDateTime, localEndDateTime);
				if (dateSearchingRange > 0 && ConstantesBulkApi.MAX_SEARCHING_DAYS > 0 && dateSearchingRange <= ConstantesBulkApi.MAX_SEARCHING_DAYS) {
					restApiInvokerBatch.getBulkApiRecordsInfo(processStartDate, processEndDate, null, null);
				} else {
					LOGGER.error("Error al obtener el rango de fechas. Compruebe que el rango es mayor a 0 o que no supera el maximo");
				}
			}
		} else {
			Date yesterday = Utils.substractDaysToDate(new Date(), 1);
			processStartDate = Utils.setHourInDate(yesterday, 0, 0, 0, 0);
			processEndDate = Utils.setHourInDate(yesterday, 23, 59, 59, 999);
			LOGGER.info("No se han indicado fechas de búsqueda. Se establece el día anterior como fecha por defecto");
			restApiInvokerBatch.getBulkApiRecordsInfo(processStartDate, processEndDate, null, null);
		}
		LOGGER.info("Actualizacion de objetos desde Salesforce completada con fecha " + new Date());
	}

	public Date getProcessStartDate() {
		return processStartDate;
	}

	public void setProcessStartDate(Date processStartDate) {
		this.processStartDate = processStartDate;
	}

	public Date getProcessEndDate() {
		return processEndDate;
	}

	public void setProcessEndDate(Date processEndDate) {
		this.processEndDate = processEndDate;
	}
}
