package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.casosemergencias.model.UserSessionInfo;

@Entity
@Table(name = "salesforce.user_session_info")
public class UserSessionInfoVO extends ObjectVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
		
	@Column(name = "access_token")
	private String accessToken;
	
	@Column(name = "session_id")
	private String sessionId;
	
	@Column(name = "last_connection")
	private Date lastConnection; 
	
	public UserSessionInfoVO() {
		
	}
	
	public UserSessionInfoVO(Integer id, String username, String password, String accessToken, String sessionId, Date lastConnection) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sessionId = sessionId;
		this.accessToken = accessToken;
		this.lastConnection = lastConnection;
	}

	@Override
	public Object instantiateTargetLogic() {
		UserSessionInfo sessionControl = new UserSessionInfo();
		return sessionControl;
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