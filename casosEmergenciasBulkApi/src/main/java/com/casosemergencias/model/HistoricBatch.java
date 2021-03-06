package com.casosemergencias.model;

import java.util.Date;

import com.casosemergencias.controller.views.HistoricBatchView;
import com.casosemergencias.dao.vo.HistoricBatchVO;

/**
 * @author MPC
 * 
 * Clase que contiene el modelo de un historic Batch. Esta clase es la que utilizaremos en el Servicio.
 *
 */

public class HistoricBatch extends ObjectLogic  {
	
	private Integer id;
	private String sfidJob;
	private String sfidRecord;
	private Date startDate;
	private Date endDate;
	private String object;
	private String operation;
	private Integer totalRecords;
	private Integer processedRecords;
	private Boolean success;
	private String errorCause;
	
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSfidJob() {
		return sfidJob;
	}
	public void setSfidJob(String sfidJob) {
		this.sfidJob = sfidJob;
	}
	public String getSfidRecord() {
		return sfidRecord;
	}
	public void setSfidRecord(String sfidRecord) {
		this.sfidRecord = sfidRecord;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Integer getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Integer getProcessedRecords() {
		return processedRecords;
	}
	public void setProcessedRecords(Integer processedRecords) {
		this.processedRecords = processedRecords;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getErrorCause() {
		return errorCause;
	}
	public void setErrorCause(String errorCause) {
		this.errorCause = errorCause;
	}

	@Override
	public Object instantiateTargetVO() {
		HistoricBatchVO historicBatch = new HistoricBatchVO();
		return historicBatch;
	}
	@Override
	public Object instantiateTargetView() {
		HistoricBatchView historicBatch = new HistoricBatchView();
		return historicBatch;
	}
	

}
