package com.casosemergencias.batch.bean;

import java.util.List;

public class BulkApiInfoContainerBatch {
	
	/** Paremeters. */
	public enum OperationType { INSERT, UPDATE, DELETE };
	private OperationType operation;
	private List<Object> objectList;
		
	/** Getters. */
	public OperationType getOperation() {
		return operation;
	}
	
	public List<Object> getObjectList() {
		return objectList;
	}
		
	/** Setters. */
	public void setOperation(OperationType operation) {
		this.operation = operation;
	}
	
	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}
}