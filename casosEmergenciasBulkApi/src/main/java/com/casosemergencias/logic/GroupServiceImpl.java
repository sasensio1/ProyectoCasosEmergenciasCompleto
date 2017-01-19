package com.casosemergencias.logic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.GrupoDAO;

public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GrupoDAO groupDao;
	
	@Override
	public int insertGroupSfList(List<Object> groupList, String processId) {
		int resultOk = groupDao.insertGroupListSf(groupList, processId);
		return resultOk;
	}
	@Override
	public int updateGroupSfList(List<Object> groupList, String processId) {
		int resultOk = groupDao.updateGroupListSf(groupList, processId);
		return resultOk;
	}
	@Override
	public int deleteGroupSfList(List<Object> groupList, String processId) {
		int resultOk = groupDao.deleteGroupListSf(groupList, processId);
		return resultOk;
	}

}
