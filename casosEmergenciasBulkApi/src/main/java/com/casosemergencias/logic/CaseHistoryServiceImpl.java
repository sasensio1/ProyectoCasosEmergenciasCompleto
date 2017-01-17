package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseHistoryDAO;

public class CaseHistoryServiceImpl implements CaseHistoryService {
	
	@Autowired
	private CaseHistoryDAO caseHistoryDAO;
	
	@Override
	public void updateCaseHistorySfList(List<Object> caseHistoryList) {
		caseHistoryDAO.updateCaseHistoryListSf(caseHistoryList);
	}
	@Override
	public void deleteCaseHistorySfList(List<Object> caseHistoryList) {
		caseHistoryDAO.deleteCaseHistoryListSf(caseHistoryList);
	}
	@Override
	public void insertCaseHistorySfList(List<Object> caseHistoryList) {
		caseHistoryDAO.insertCaseHistoryListSf(caseHistoryList);
		
	}

}
