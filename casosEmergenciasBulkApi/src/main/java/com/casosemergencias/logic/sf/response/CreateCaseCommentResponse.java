package com.casosemergencias.logic.sf.response;

import java.sql.Date;

public class CreateCaseCommentResponse {
	
	private String idComentarioCaso;
	private ControlErrores controlErrores;
	private Date createdDate;


	public String getIdComentarioCaso() {
		return idComentarioCaso;
	}

	public void setIdComentarioCaso(String idComentarioCaso) {
		this.idComentarioCaso = idComentarioCaso;
	}

	public ControlErrores getControlErrores() {
		return controlErrores;
	}

	public void setControlErrores(ControlErrores controlErrores) {
		this.controlErrores = controlErrores;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
