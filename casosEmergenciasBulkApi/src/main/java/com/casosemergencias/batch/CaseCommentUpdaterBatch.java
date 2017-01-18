package com.casosemergencias.batch;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.util.constants.ConstantesBulkApi;

@Resource
public class CaseCommentUpdaterBatch {
	final static Logger LOGGER = Logger.getLogger(CaseCommentUpdaterBatch.class);
	
	@Autowired
	SalesforceRestApiInvokerBatch restApiInvokerBatch;
	
	public void getCaseCommentRecordsInfo() {
		Date processStartDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(processStartDate);
		cal.add(Calendar.HOUR, -2);
		Date processEndDate = cal.getTime();
		restApiInvokerBatch.getBulkApiRecordsInfo(processStartDate, processEndDate, ConstantesBulkApi.ENTITY_CASE_COMMENT, ConstantesBulkApi.ENTITY_CASE_COMMENT_SELECT);
	}
}