package com.casosemergencias.logic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.batch.BulkApiQueriesBatch;
import com.casosemergencias.batch.FieldLabelTableCreatorBatch;
import com.casosemergencias.batch.PicklistTableCreatorBatch;
import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;

public class BatchServiceImpl implements BatchService {

	@Autowired
	FieldLabelTableCreatorBatch fieldLabelTableCreatorBatch;
	
	@Autowired
	PicklistTableCreatorBatch picklistTableCreatorBatch;
	
	@Autowired
	BulkApiQueriesBatch bulkApiQueriesBatch;
	
	@Override
	public void updateHerokuPickListTable() {
		picklistTableCreatorBatch.fillHerokuPicklistTable();
	}
	
	@Override
	public void updateHerokuFieldLabelTable() {
		fieldLabelTableCreatorBatch.fillHerokuFieldLabelTable();
	}
	
	@Override
	public void getInfoToUpdateFromBulkApi(Date processStartDate, Date processEndDate) {
		bulkApiQueriesBatch.getAllBulkApiInfo(processStartDate, processEndDate);
	}

	@Override
	public void updateHerokuObjectsFromBulkApi(String objectName, List<BulkApiInfoContainerBatch> bulkApiInfoContainer) {
		//TODO: COMPLETAR CON LLAMADAS A LOS DAOS SEGUN EL OBJETO. HABRÁ QUE INYECTAR LOS DAOS QUE SEAN NECESARIOS
	}
}