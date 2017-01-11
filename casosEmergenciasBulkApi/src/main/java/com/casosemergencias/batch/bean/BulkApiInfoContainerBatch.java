package com.casosemergencias.batch.bean;

import java.util.List;

public class BulkApiInfoContainerBatch {
	
	/** Bean params. */
	public enum OperationType { INSERT, UPDATE, DELETE };
	private OperationType operation;
	private List<Object> objectList;
		
	/** GETTERS */
	public OperationType getOperation() {
		return operation;
	}
	
	public List<Object> getObjectList() {
		return objectList;
	}
		
	/** SETTERS */
	public void setOperation(OperationType operation) {
		this.operation = operation;
	}
	
	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}
}