package com.casosemergencias.batch;

import java.util.Date;

import javax.annotation.Resource;

import com.casosemergencias.util.Utils;

@Resource
public class BulkApiQueriesBatch {
	public static void main(String[] args) {
		boolean restCalling = true;
		Date today = new Date();
		Date tomorrow = Utils.substractDaysToDate(today, 1);
		if (restCalling) {
			SalesforceRestApiInvokerBatch restBatchInvoker = new SalesforceRestApiInvokerBatch();
			restBatchInvoker.getAllBulkApiInfo(tomorrow, today);
		} else {
			SalesforceSoapBulkApiInvokerBatch soapBatchInvoker = new SalesforceSoapBulkApiInvokerBatch();
			soapBatchInvoker.getAllBulkApiInfo(tomorrow, today);
		}
	}
}