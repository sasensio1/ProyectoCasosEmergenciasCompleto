package com.casosemergencias.logic.sf.bean;

import com.casosemergencias.model.CaseComment;

public class ComentarioCasoSalesforce {
	
	private String comment ;
	private Boolean isPublished ;
	private String caseid ;
	
	//Getters y Setters
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Boolean getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}
	public String getCaseid() {
		return caseid;
	}
	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}
	
	
	public static ComentarioCasoSalesforce copyFieldsFromHerokuToSalesForceCaseCommentBean(CaseComment caseCommentHeroku) {
		ComentarioCasoSalesforce caseCommentSF = new ComentarioCasoSalesforce();
		if (caseCommentHeroku != null && caseCommentHeroku != null) {
			caseCommentSF.setCaseid((caseCommentHeroku.getCaseid()!= null && !"".equals(caseCommentHeroku.getCaseid()) ? caseCommentHeroku.getCaseid(): ""));
			caseCommentSF.setComment((caseCommentHeroku.getComment()!= null && !"".equals(caseCommentHeroku.getComment()) ? caseCommentHeroku.getComment() : ""));
			caseCommentSF.setIsPublished((caseCommentHeroku.getIspublished() != null));
		}
		return caseCommentSF;
	}
	

		

}
