package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.model.CaseComment;
import com.casosemergencias.model.Caso;

public interface CaseCommentService {

	public List<CaseComment> obtenerListaComentariosDeUnCaso(String caseSfid);
	
	public Caso obtenerDatosCasoParaComentario(String caseSfid);
	
	//public Boolean insertCaseComment(CaseComment caseComment);
	
	public CaseComment insertSalesforceCaseComment(CaseComment caseComment)throws EmergenciasException;
	
	public void insertCaseCommentSfList(List<Object> caseCommentList);
	
	public void updateCaseCommentSfList(List<Object> caseCommentList);
	
	public void deleteCaseCommentSfList(List<Object> caseCommentList);
}
