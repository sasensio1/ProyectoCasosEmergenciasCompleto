package com.casosemergencias.logic;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.batch.FieldLabelTableCreatorBatch;
import com.casosemergencias.batch.PicklistTableCreatorBatch;
import com.casosemergencias.batch.SalesforceSoapBulkApiInvokerBatch;
import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;

public class BatchServiceImpl implements BatchService {

	@Autowired
	FieldLabelTableCreatorBatch fieldLabelTableCreatorBatch;
	
	@Autowired
	PicklistTableCreatorBatch picklistTableCreatorBatch;
	
	@Autowired
	SalesforceSoapBulkApiInvokerBatch soapApiQueriesBatch;
	
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
		soapApiQueriesBatch.getAllBulkApiInfo(processStartDate, processEndDate);
	}

	@Override
	public void updateHerokuObjectsFromBulkApi(String objectName, BulkApiInfoContainerBatch bulkApiInfoContainer) {
		//TODO: COMPLETAR CON LLAMADAS A LOS DAOS SEGUN EL OBJETO. HABRÁ QUE INYECTAR LOS DAOS QUE SEAN NECESARIOS
		//TODO: DEVOLVER BOOLEAN CON ESTADO DE PROCESO.
	}
}