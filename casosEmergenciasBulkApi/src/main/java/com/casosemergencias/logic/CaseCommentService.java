package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.CaseComment;
import com.casosemergencias.model.Caso;

public interface CaseCommentService {

	public List<CaseComment> obtenerListaComentariosDeUnCaso(String caseSfid);
	public Caso obtenerDatosCasoParaComentario(String caseSfid);
	public Boolean insertCaseComment(CaseComment caseComment);
}
