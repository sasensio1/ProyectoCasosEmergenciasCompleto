package com.casosemergencias.model;

import java.util.Date;

import com.casosemergencias.controller.views.CaseCommentView;
import com.casosemergencias.dao.vo.CaseCommentVO;

//Objeto que tiene el modelo de un CaseComment, se utiliza en el Servicio
public class CaseComment extends ObjectLogic{
	
	/*ID*/                                  		private Integer id;
	/*SFID*/                                		private String sfid;
	/*Case ID*/                						private String caseid;
	/*Creador del comentario */             		private String createdbyid;
	/*Fecha de la creacion*/     					private Date createddate;
	/*comentario*/                      			private String comment;
	/*Fecha de la ultima modificacion*/     		private Date lastmodifieddate;
	/*Id user de la ultima modificacion*/   		private String lastmodifiedbyid;
	/*publico*/										private Boolean ispublished;
	/*Usuario creador comentario*/					private User userJoinCreateComment;
	/*Usuario ultima modificacion comentario*/		private User userJoinModifyComment;


	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getCaseid() {
		return caseid;
	}
	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}
	public String getCreatedbyid() {
		return createdbyid;
	}
	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getLastmodifieddate() {
		return lastmodifieddate;
	}
	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}
	public String getLastmodifiedbyid() {
		return lastmodifiedbyid;
	}
	public void setLastmodifiedbyid(String lastmodifiedbyid) {
		this.lastmodifiedbyid = lastmodifiedbyid;
	}
	public Boolean getIspublished() {
		return ispublished;
	}
	public void setIspublished(Boolean ispublished) {
		this.ispublished = ispublished;
	}	
	public User getUserJoinCreateComment() {
		return userJoinCreateComment;
	}
	public void setUserJoinCreateComment(User userJoinCreateComment) {
		this.userJoinCreateComment = userJoinCreateComment;
	}
	public User getUserJoinModifyComment() {
		return userJoinModifyComment;
	}
	public void setUserJoinModifyComment(User userJoinModifyComment) {
		this.userJoinModifyComment = userJoinModifyComment;
	}
	@Override
	public Object instantiateTargetVO() {
		CaseCommentVO caseComment = new CaseCommentVO();
		return caseComment;
	}
	@Override
	public Object instantiateTargetView() {
		CaseCommentView caseComment = new CaseCommentView();
		return caseComment;
	}
	
	
}
