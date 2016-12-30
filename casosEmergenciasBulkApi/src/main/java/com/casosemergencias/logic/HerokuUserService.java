package com.casosemergencias.logic;

import com.casosemergencias.model.HerokuUser;

public interface HerokuUserService {

	public HerokuUser readUserPass(String user, String pass);
	public void insertUser();
	public HerokuUser readUser(String userName);
}
