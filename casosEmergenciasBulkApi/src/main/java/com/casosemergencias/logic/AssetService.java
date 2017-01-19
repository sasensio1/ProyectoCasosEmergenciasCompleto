package com.casosemergencias.logic;

import java.util.List;

public interface AssetService {
	
	public boolean insertAssetSfList(List<Object> assetList, String processId);
	
	public boolean updateAssetSfList(List<Object> assetList, String processId);
	
	public boolean deleteAssetSfList(List<Object> assetList, String processId);

}
