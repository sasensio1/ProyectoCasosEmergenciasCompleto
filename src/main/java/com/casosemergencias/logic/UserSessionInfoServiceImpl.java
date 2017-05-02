package com.casosemergencias.logic;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.UserSessionInfoDAO;
import com.casosemergencias.dao.vo.UserSessionInfoVO;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.ParserModelVO;

public class UserSessionInfoServiceImpl implements UserSessionInfoService {
	final static Logger logger = Logger.getLogger(UserSessionInfoServiceImpl.class);
	
	@Autowired
	private UserSessionInfoDAO userSessionInfoDAO;
	
	@Override
	public UserSessionInfo readUserSessionInfo(UserSessionInfo userSessionInfo) {
		UserSessionInfoVO userSessionInfoVO = new UserSessionInfoVO();
		ParserModelVO.parseDataModelVO(userSessionInfo, userSessionInfoVO);
		userSessionInfoVO = userSessionInfoDAO.readUserSessionInfo(userSessionInfoVO);
		UserSessionInfo userSessionInfoLogic = new UserSessionInfo();
		if (userSessionInfoVO != null) {
			ParserModelVO.parseDataModelVO(userSessionInfoVO, userSessionInfoLogic);
		}
		return userSessionInfoLogic;
	}

	@Override
	public Integer insertUserSessionInfo(UserSessionInfo userSessionInfo) {
		UserSessionInfoVO userSessionInfoVO = new UserSessionInfoVO();
		ParserModelVO.parseDataModelVO(userSessionInfo, userSessionInfoVO);
		Integer id = userSessionInfoDAO.insertUserSessionInfo(userSessionInfoVO);
		return id;
	}

	@Override
	public Integer updateUserSessionInfo(UserSessionInfo userSessionInfo) {
		UserSessionInfoVO userSessionInfoVO = new UserSessionInfoVO();
		ParserModelVO.parseDataModelVO(userSessionInfo, userSessionInfoVO);
		Integer id = userSessionInfoDAO.updateUserSessionInfo(userSessionInfoVO);
		return id;
	}
}