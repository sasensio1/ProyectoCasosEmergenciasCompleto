package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.model.CaseComment;
import com.casosemergencias.model.Caso;

public interface CaseCommentService {

	public List<CaseComment> obtenerListaComentariosDeUnCaso(String caseSfid);
	
	public Caso obtenerDatosCasoParaComentario(String caseSfid);
	
	public CaseComment insertSalesforceCaseComment(CaseComment caseComment)throws EmergenciasException;
	
	public int insertCaseCommentSfList(List<Object> caseCommentList, String processId);
	
	public int updateCaseCommentSfList(List<Object> caseCommentList, String processId);
	
	public int deleteCaseCommentSfList(List<Object> caseCommentList, String processId);
}
