package com.casosemergencias.logic;

import java.util.List;

public interface GroupService {
	
	public boolean insertGroupSfList(List<Object> groupList, String processId);
	
	public boolean updateGroupSfList(List<Object> groupList, String processId);
	
	public boolean deleteGroupSfList(List<Object> groupList, String processId);

}
