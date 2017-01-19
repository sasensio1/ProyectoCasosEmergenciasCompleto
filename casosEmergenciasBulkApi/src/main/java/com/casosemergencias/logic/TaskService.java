package com.casosemergencias.logic;

import java.util.List;

public interface TaskService {
	
	public boolean insertTaskSfList(List<Object> taskList, String processId);
	
	public boolean updateTaskSfList(List<Object> taskList, String processId);
	
	public boolean deleteTaskSfList(List<Object> taskList, String processId);

}
