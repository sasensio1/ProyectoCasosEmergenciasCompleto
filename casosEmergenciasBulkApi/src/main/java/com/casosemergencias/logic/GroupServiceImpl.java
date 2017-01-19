package com.casosemergencias.logic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.GrupoDAO;

public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GrupoDAO groupDao;
	
	@Override
	public boolean insertGroupSfList(List<Object> groupList, String processId) {
		boolean resultOk = groupDao.insertGroupListSf(groupList, processId);
		return resultOk;
	}
	@Override
	public boolean updateGroupSfList(List<Object> groupList, String processId) {
		boolean resultOk = groupDao.updateGroupListSf(groupList, processId);
		return resultOk;
	}
	@Override
	public boolean deleteGroupSfList(List<Object> groupList, String processId) {
		boolean resultOk = groupDao.deleteGroupListSf(groupList, processId);
		return resultOk;
	}

}
