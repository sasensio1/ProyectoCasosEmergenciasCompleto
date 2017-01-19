package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.TaskDAO;


public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDAO taskDao;
	
	@Override
	public boolean insertTaskSfList(List<Object> taskList, String processId) {
		boolean resultOk = taskDao.insertTaskListSf(taskList, processId);
		return resultOk;
	}
	@Override
	public boolean updateTaskSfList(List<Object> taskList, String processId) {
		boolean resultOk = taskDao.updateTaskListSf(taskList, processId);
		return resultOk;
	}
	@Override
	public boolean deleteTaskSfList(List<Object> taskList, String processId) {
		boolean resultOk = taskDao.deleteTaskListSf(taskList, processId);
		return resultOk;
	}
	

}
