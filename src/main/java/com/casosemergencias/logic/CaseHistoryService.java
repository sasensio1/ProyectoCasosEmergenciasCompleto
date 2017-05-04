package com.casosemergencias.logic;

import java.util.List;

public interface CaseHistoryService {
	
	public int insertCaseHistorySfList(List<Object> caseHistoryList, String processId);
	
	public int updateCaseHistorySfList(List<Object> caseHistoryList, String processId);
	
	public int deleteCaseHistorySfList(List<Object> caseHistoryList, String processId);


}
