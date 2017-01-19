package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseHistoryDAO;

public class CaseHistoryServiceImpl implements CaseHistoryService {
	
	@Autowired
	private CaseHistoryDAO caseHistoryDAO;
	
	@Override
	public int insertCaseHistorySfList(List<Object> caseHistoryList, String processId) {
		int resultOk = caseHistoryDAO.updateCaseHistoryListSf(caseHistoryList, processId);
		return resultOk;
	}
	@Override
	public int updateCaseHistorySfList(List<Object> caseHistoryList, String processId) {
		int resultOk = caseHistoryDAO.deleteCaseHistoryListSf(caseHistoryList, processId);
		return resultOk;
	}
	@Override
	public int deleteCaseHistorySfList(List<Object> caseHistoryList, String processId) {
		int resultOk = caseHistoryDAO.insertCaseHistoryListSf(caseHistoryList, processId);
		return resultOk;
		
	}

}
