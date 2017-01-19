package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.HerokuUser;

public interface HerokuUserService {

	public HerokuUser readUserPass(String user, String pass);
	
	public void insertUser();
	
	public HerokuUser readUser(String userName);
	
	public boolean insertHerokuUserSfList(List<Object> herokuUserList, String processId);
	
	public boolean updateHerokuUserSfList(List<Object> herokuUserList, String processId);
	
	public boolean deleteHerokuUserSfList(List<Object> herokuUserList, String processId);

	
}