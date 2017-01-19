package com.casosemergencias.logic;

import java.util.List;

public interface UserService {
	
	public boolean insertUserSfList(List<Object> userList, String processId);

	public boolean updateUserSfList(List<Object> userList, String processId);
	
	public boolean deleteUserSfList(List<Object> userList, String processId);

}
