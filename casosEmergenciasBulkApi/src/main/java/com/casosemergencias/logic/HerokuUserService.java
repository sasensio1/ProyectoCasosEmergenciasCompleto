package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.HerokuUser;

public interface HerokuUserService {

	public HerokuUser readUserPass(String user, String pass);
	
	public void insertUser();
	
	public HerokuUser readUser(String userName);
	
	public void insertHerokuUserSfList(List<Object> herokuUserList);
	
	public void updateHerokuUserSfList(List<Object> herokuUserList);
	
	public void deleteHerokuUserSfList(List<Object> herokuUserList);

	
}