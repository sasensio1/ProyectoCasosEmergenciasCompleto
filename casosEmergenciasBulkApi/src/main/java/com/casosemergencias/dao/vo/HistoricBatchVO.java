package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salesforce.HistoricBatch")
public class HistoricBatchVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfidJob")
	private String sfidJob;
	
	@Column(name = "sfidObject")
	private String sfidObject;

	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name = "object")
	private String object;
	
	@Column(name = "operation")
	private String operation;
	
	@Column(name = "total_records")
	private Integer totalRecords;
	
	@Column(name = "processed_records")
	private Integer processedRecords;
	
	@Column(name = "success")
	private String success;
	
	@Column(name = "error_cause")
	private String errorCause;
	
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
	
	public String getSfidObject() {
		return sfidObject;
	}

	public void setSfidObject(String sfidObject) {
		this.sfidObject = sfidObject;
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
	
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
	
	public String getErrorCause() {
		return errorCause;
	}

	public void setErrorCause(String errorCause) {
		this.errorCause = errorCause;
	}

	

}
