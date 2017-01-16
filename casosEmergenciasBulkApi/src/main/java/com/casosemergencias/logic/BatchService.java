package com.casosemergencias.logic;

import java.util.Date;

import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;

public interface BatchService {
	public void updateHerokuPickListTable();
	public void updateHerokuFieldLabelTable();
	public void getInfoToUpdateFromBulkApi(Date processStartDate, Date processEndDate);
	public void updateHerokuObjectsFromBulkApi(String objectName, BulkApiInfoContainerBatch bulkApiInfoContainer);
}