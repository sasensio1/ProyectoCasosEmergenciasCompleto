package com.casosemergencias.logic;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseCommentDAO;

public class CaseCommentServiceImpl implements CaseCommentService{

	final static Logger logger = Logger.getLogger(CaseCommentService.class);
	
	@Autowired
	CaseCommentDAO caseCommentDAO;

	@Override
	public int insertCaseCommentSfList(List<Object> caseCommentList, String processId) {
		int processedRecords = caseCommentDAO.insertCaseCommentListSf(caseCommentList, processId);
		return processedRecords;
	}
	
	@Override
	public int updateCaseCommentSfList(List<Object> caseCommentList, String processId) {
		int processedRecords = caseCommentDAO.updateCaseCommentListSf(caseCommentList, processId);
		return processedRecords;
	}
	
	@Override
	public int deleteCaseCommentSfList(List<Object> caseCommentList, String processId) {
		int processedRecords = caseCommentDAO.deleteCaseCommentListSf(caseCommentList, processId);
		return processedRecords;
	}
}