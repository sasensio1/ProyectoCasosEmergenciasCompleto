package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.TaskDAO;


public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDAO taskDao;
	
	@Override
	public int insertTaskSfList(List<Object> taskList, String processId) {
		int processedRecords = taskDao.insertTaskListSf(taskList, processId);
		return processedRecords;
	}
	@Override
	public int updateTaskSfList(List<Object> taskList, String processId) {
		int processedRecords = taskDao.updateTaskListSf(taskList, processId);
		return processedRecords;
	}
	@Override
	public int deleteTaskSfList(List<Object> taskList, String processId) {
		int processedRecords = taskDao.deleteTaskListSf(taskList, processId);
		return processedRecords;
	}
}
