package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.UserDAO;


public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public int insertUserSfList(List<Object> userList, String processId) {
		int resultOk = userDao.insertUserListSf(userList, processId);
		return resultOk;
	}
	@Override
	public int updateUserSfList(List<Object> userList, String processId) {
		int resultOk = userDao.updateUserListSf(userList, processId);
		return resultOk;
	}
	@Override
	public int deleteUserSfList(List<Object> userList, String processId) {
		int resultOk = userDao.deleteUserListSf(userList, processId);
		return resultOk;
	}

}
