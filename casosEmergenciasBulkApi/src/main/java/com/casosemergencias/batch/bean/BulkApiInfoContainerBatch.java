package com.casosemergencias.batch.bean;

import java.util.List;
import java.util.Map;

public class BulkApiInfoContainerBatch {
	/** Parameters. */
	private String entityName;
	private int totalRecords;
	private Map<OperationType, List<Object>> recordsMap;

	/** Getters. */
	public String getEntityName() {
		return entityName;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public Map<OperationType, List<Object>> getRecordsMap() {
		return recordsMap;
	}

	/** Setters. */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public void setRecordsMap(Map<OperationType, List<Object>> recordsMap) {
		this.recordsMap = recordsMap;
	}
}