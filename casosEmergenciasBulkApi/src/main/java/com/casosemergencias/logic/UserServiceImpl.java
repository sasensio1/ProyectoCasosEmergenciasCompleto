package com.casosemergencias.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.UserDAO;


public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public void insertUserSfList(List<Object> userList) {
		userDao.insertUserListSf(userList);
	}
	@Override
	public void updateUserSfList(List<Object> userList) {
		userDao.updateUserListSf(userList);
	}
	@Override
	public void deleteUserSfList(List<Object> userList) {
		userDao.deleteUserListSf(userList);
	}

}
