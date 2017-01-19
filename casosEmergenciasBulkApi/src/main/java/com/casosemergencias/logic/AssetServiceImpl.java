package com.casosemergencias.logic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.AssetDAO;

public class AssetServiceImpl implements AssetService  {
	
	@Autowired
	private AssetDAO assetDao;
	
	@Override
	public int insertAssetSfList(List<Object> assetList, String processId) {
		int resultOk = assetDao.insertAssetListSf(assetList, processId);
		return resultOk;
	}
	
	@Override
	public int updateAssetSfList(List<Object> assetList, String processId) {
		int resultOk = assetDao.updateAssetListSf(assetList, processId);
		return resultOk;
	}
	@Override
	public int deleteAssetSfList(List<Object> assetList, String processId) {
		int resultOk = assetDao.deleteAssetListSf(assetList, processId);
		return resultOk;
	}
	


}
