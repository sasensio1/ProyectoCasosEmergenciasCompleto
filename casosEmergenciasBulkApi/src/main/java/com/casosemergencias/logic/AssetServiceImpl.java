package com.casosemergencias.logic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.AssetDAO;

public class AssetServiceImpl implements AssetService  {
	
	@Autowired
	private AssetDAO assetDao;
	
	@Override
	public boolean insertAssetSfList(List<Object> assetList, String processId) {
		boolean resultOk = assetDao.insertAssetListSf(assetList, processId);
		return resultOk;
	}
	
	@Override
	public boolean updateAssetSfList(List<Object> assetList, String processId) {
		boolean resultOk = assetDao.updateAssetListSf(assetList, processId);
		return resultOk;
	}
	@Override
	public boolean deleteAssetSfList(List<Object> assetList, String processId) {
		boolean resultOk = assetDao.deleteAssetListSf(assetList, processId);
		return resultOk;
	}
	


}
