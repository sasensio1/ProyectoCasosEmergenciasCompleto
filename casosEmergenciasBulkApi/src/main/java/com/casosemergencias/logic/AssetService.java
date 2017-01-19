package com.casosemergencias.logic;

import java.util.List;

public interface AssetService {
	
	public int insertAssetSfList(List<Object> assetList, String processId);
	
	public int updateAssetSfList(List<Object> assetList, String processId);
	
	public int deleteAssetSfList(List<Object> assetList, String processId);

}
