package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseHistoryDAO;

public class CaseHistoryServiceImpl implements CaseHistoryService {
	
	@Autowired
	private CaseHistoryDAO caseHistoryDAO;
	
	@Override
	public boolean insertCaseHistorySfList(List<Object> caseHistoryList, String processId) {
		boolean resultOk = caseHistoryDAO.updateCaseHistoryListSf(caseHistoryList, processId);
		return resultOk;
	}
	@Override
	public boolean updateCaseHistorySfList(List<Object> caseHistoryList, String processId) {
		boolean resultOk = caseHistoryDAO.deleteCaseHistoryListSf(caseHistoryList, processId);
		return resultOk;
	}
	@Override
	public boolean deleteCaseHistorySfList(List<Object> caseHistoryList, String processId) {
		boolean resultOk = caseHistoryDAO.insertCaseHistoryListSf(caseHistoryList, processId);
		return resultOk;
		
	}

}
