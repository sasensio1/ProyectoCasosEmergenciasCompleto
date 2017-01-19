package com.casosemergencias.logic;

import java.util.List;

public interface UserService {
	
	public int insertUserSfList(List<Object> userList, String processId);

	public int updateUserSfList(List<Object> userList, String processId);
	
	public int deleteUserSfList(List<Object> userList, String processId);

}
