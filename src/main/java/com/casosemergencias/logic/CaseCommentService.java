package com.casosemergencias.logic;

import java.util.List;

public interface CaseCommentService {
	
	public int insertCaseCommentSfList(List<Object> caseCommentList, String processId);
	
	public int updateCaseCommentSfList(List<Object> caseCommentList, String processId);
	
	public int deleteCaseCommentSfList(List<Object> caseCommentList, String processId);
}
