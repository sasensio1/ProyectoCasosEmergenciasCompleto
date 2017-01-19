package com.casosemergencias.logic;

import java.util.List;

public interface CaseHistoryService {
	
	public boolean insertCaseHistorySfList(List<Object> caseHistoryList, String processId);
	
	public boolean updateCaseHistorySfList(List<Object> caseHistoryList, String processId);
	
	public boolean deleteCaseHistorySfList(List<Object> caseHistoryList, String processId);


}
