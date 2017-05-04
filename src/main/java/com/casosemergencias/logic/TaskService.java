package com.casosemergencias.logic;

import java.util.List;

public interface TaskService {
	
	public int insertTaskSfList(List<Object> taskList, String processId);
	
	public int updateTaskSfList(List<Object> taskList, String processId);
	
	public int deleteTaskSfList(List<Object> taskList, String processId);

}
