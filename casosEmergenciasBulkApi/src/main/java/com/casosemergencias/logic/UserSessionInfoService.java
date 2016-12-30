package com.casosemergencias.logic;

import com.casosemergencias.model.UserSessionInfo;

public interface UserSessionInfoService {
	public UserSessionInfo readUserSessionInfo(UserSessionInfo userSessionInfo);
	
	public Integer insertUserSessionInfo(UserSessionInfo userSessionInfo);
	
	public Integer updateUserSessionInfo(UserSessionInfo userSessionInfo);
}