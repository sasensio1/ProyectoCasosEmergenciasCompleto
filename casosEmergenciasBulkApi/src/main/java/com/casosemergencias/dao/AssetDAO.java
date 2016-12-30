package com.casosemergencias.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casosemergencias.dao.vo.AssetVO;

@Repository
public class AssetDAO {
	
	
	final static Logger logger = Logger.getLogger(AccountDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Devuelve una lista con todas las Asset de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AssetVO> readAllAsset() {
		logger.debug("--- Inicio -- readAllAsset ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from AssetVO");
			List<AssetVO> assetList = query.list(); 

			logger.debug("--- Fin -- readAllAsset ---");
			
			return assetList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAllAsset ", e); 
	    	logger.error("--- Fin -- readAllAsset ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	
	/**
	 * Devuelve el los Asset que tiene como suministroid el pasado por parametro al metodo
	 * 
	 * @param id - id de un Asset
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AssetVO> readAssetBySuministroid(String suministroid) {
		
		logger.debug("--- Inicio -- readAssetBySuministroid ---");
		
		Session session = sessionFactory.openSession();
			
		try {
			Query query = session.createQuery("from AssetVO as asset WHERE asset.suministroid = :suministroid");
			query.setString("suministroid", suministroid);
			
			List<AssetVO> assetList = query.list(); 

			if(assetList != null && !assetList.isEmpty()){
				return assetList;
			}			
			
			logger.debug("--- Fin -- readAssetBySuministroid ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAssetById ", e); 
	    	logger.error("--- Fin -- readAssetBySuministroid ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}

	/**
	 * Devuelve el los Asset que tiene como suministroid el pasado por parametro al metodo
	 * 
	 * @param id - id de un Asset
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AssetVO> readAssetByAccountId(String accountId) {
		
		logger.debug("--- Inicio -- readAssetBySuministroid ---");
		
		Session session = sessionFactory.openSession();
			
		try {
			Query query = session.createQuery("from AssetVO as asset WHERE asset.accountid = :accountid");
			query.setString("accountid", accountId);
			
			List<AssetVO> assetList = query.list(); 

			if (assetList != null && !assetList.isEmpty()) {
				return assetList;
			}
			
			logger.debug("--- Fin -- readAssetBySuministroid ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAssetById ", e); 
	    	logger.error("--- Fin -- readAssetBySuministroid ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
}
