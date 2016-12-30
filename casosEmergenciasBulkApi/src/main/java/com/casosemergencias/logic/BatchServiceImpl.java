package com.casosemergencias.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.batch.FieldLabelTableCreatorBatch;
import com.casosemergencias.batch.PicklistTableCreatorBatch;

public class BatchServiceImpl implements BatchService {

	@Autowired
	FieldLabelTableCreatorBatch fieldLabelTableCreatorBatch;
	
	@Autowired
	PicklistTableCreatorBatch picklistTableCreatorBatch;
	
	@Override
	public void updateHerokuPickListTable() {
		picklistTableCreatorBatch.fillHerokuPicklistTable();
	}
	
	@Override
	public void updateHerokuFieldLabelTable() {
		fieldLabelTableCreatorBatch.fillHerokuFieldLabelTable();
	}
}