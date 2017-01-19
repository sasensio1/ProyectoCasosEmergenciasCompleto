package com.casosemergencias.logic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.GrupoDAO;

public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GrupoDAO groupDao;
	
	@Override
	public int insertGroupSfList(List<Object> groupList, String processId) {
		int processedRecords = groupDao.insertGroupListSf(groupList, processId);
		return processedRecords;
	}
	@Override
	public int updateGroupSfList(List<Object> groupList, String processId) {
		int processedRecords = groupDao.updateGroupListSf(groupList, processId);
		return processedRecords;
	}
	@Override
	public int deleteGroupSfList(List<Object> groupList, String processId) {
		int processedRecords = groupDao.deleteGroupListSf(groupList, processId);
		return processedRecords;
	}
}