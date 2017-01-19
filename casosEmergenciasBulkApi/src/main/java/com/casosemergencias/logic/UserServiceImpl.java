package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.UserDAO;


public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public boolean insertUserSfList(List<Object> userList, String processId) {
		boolean resultOk = userDao.insertUserListSf(userList, processId);
		return resultOk;
	}
	@Override
	public boolean updateUserSfList(List<Object> userList, String processId) {
		boolean resultOk = userDao.updateUserListSf(userList, processId);
		return resultOk;
	}
	@Override
	public boolean deleteUserSfList(List<Object> userList, String processId) {
		boolean resultOk = userDao.deleteUserListSf(userList, processId);
		return resultOk;
	}

}
