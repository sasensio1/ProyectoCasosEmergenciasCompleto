package com.casosemergencias.logic;

import java.util.List;

public interface GroupService {
	
	public int insertGroupSfList(List<Object> groupList, String processId);
	
	public int updateGroupSfList(List<Object> groupList, String processId);
	
	public int deleteGroupSfList(List<Object> groupList, String processId);

}
