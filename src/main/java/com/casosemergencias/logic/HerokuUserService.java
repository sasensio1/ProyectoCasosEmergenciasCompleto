package com.casosemergencias.logic;

import java.util.List;

public interface HerokuUserService {
	
	public int insertHerokuUserSfList(List<Object> herokuUserList, String processId);
	
	public int updateHerokuUserSfList(List<Object> herokuUserList, String processId);
	
	public int deleteHerokuUserSfList(List<Object> herokuUserList, String processId);

	
}