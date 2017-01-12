package com.casosemergencias.logic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.AssetDAO;

public class AssetServiceImpl implements AssetService  {
	
	@Autowired
	private AssetDAO assetDao;
	
	@Override
	public void insertAssetSfList(List<Object> assetList) {
		assetDao.insertAssetListSf(assetList);
	}
	
	@Override
	public void updateAssetSfList(List<Object> assetList) {
		assetDao.updateAssetListSf(assetList);
	}
	@Override
	public void deleteAssetSfList(List<Object> assetList) {
		assetDao.deleteAssetListSf(assetList);
	}
	


}
