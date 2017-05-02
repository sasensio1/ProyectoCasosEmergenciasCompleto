package com.casosemergencias.model;

import java.io.Serializable;
import java.util.Date;

import com.casosemergencias.dao.vo.UserSessionInfoVO;

public class UserSessionInfo extends ObjectLogic implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private String accessToken;
	private String sessionId;
	private Date lastConnection; 

	@Override
	public Object instantiateTargetVO() {
		UserSessionInfoVO userSessionInfoVO = new UserSessionInfoVO();
		return userSessionInfoVO;
	}

	@Override
	public Object instantiateTargetView() {
		Object userSessionInfo = new Object();
		return userSessionInfo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public Date getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}
}