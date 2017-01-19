package com.casosemergencias.logic;

import java.util.Date;
import java.util.List;

import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;
import com.casosemergencias.model.HistoricBatch;
import com.casosemergencias.util.datatables.DataTableProperties;

public interface BatchService {
	public void updateHerokuPickListTable();
	public void updateHerokuFieldLabelTable();
	public void updateCaseCommentTable();
	public void updateHerokuUserTable();
	public void updateObjectsInfoTables(Date processStartDate, Date processEndDate);
	public boolean updateHerokuObjectsFromBulkApi(BulkApiInfoContainerBatch bulkApiInfoContainer, String processId);
	public List<HistoricBatch> readAllHistoricBatch(DataTableProperties propDatatable);
	public Integer getNumHistoricBatchs(DataTableProperties propDatatable);
}