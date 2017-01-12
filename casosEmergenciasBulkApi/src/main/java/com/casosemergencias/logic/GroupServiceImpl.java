package com.casosemergencias.logic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.GrupoDAO;

public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GrupoDAO groupDao;
	
	@Override
	public void insertGroupSfList(List<Object> groupList) {
		groupDao.insertGroupListSf(groupList);
	}
	@Override
	public void updateGroupSfList(List<Object> groupList) {
		groupDao.updateGroupListSf(groupList);
	}
	@Override
	public void deleteGroupSfList(List<Object> groupList) {
		groupDao.deleteGroupListSf(groupList);
	}

}
