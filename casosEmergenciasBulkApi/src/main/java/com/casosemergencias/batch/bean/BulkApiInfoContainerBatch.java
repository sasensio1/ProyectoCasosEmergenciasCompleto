package com.casosemergencias.batch.bean;

import java.util.List;
import java.util.Map;

public class BulkApiInfoContainerBatch {
	/** Parameters. */
	private OperationType operation;
	private Map<OperationType, List<Object>> objectsMap;
	private String entityName;
	private int totalObjects;

	/** Getters. */
	public OperationType getOperation() {
		return operation;
	}

	public Map<OperationType, List<Object>> getObjectsMap() {
		return objectsMap;
	}

	public int getTotalObjects() {
		return totalObjects;
	}

	public String getEntityName() {
		return entityName;
	}

	/** Setters. */
	public void setOperation(OperationType operation) {
		this.operation = operation;
	}

	public void setObjectsMap(Map<OperationType, List<Object>> objectsMap) {
		this.objectsMap = objectsMap;
	}

	public void setTotalObjects(int totalObjects) {
		this.totalObjects = totalObjects;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
}