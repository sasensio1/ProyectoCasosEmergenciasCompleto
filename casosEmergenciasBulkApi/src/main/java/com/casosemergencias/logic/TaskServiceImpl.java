package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.TaskDAO;


public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDAO taskDao;
	
	@Override
	public void insertTaskSfList(List<Object> taskList) {
		taskDao.insertTaskListSf(taskList);
	}
	@Override
	public void updateTaskSfList(List<Object> taskList) {
		taskDao.updateTaskListSf(taskList);
	}
	@Override
	public void deleteTaskSfList(List<Object> taskList) {
		taskDao.deleteTaskListSf(taskList);
	}
	

}
