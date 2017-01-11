package com.casosemergencias.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.casosemergencias.dao.vo.AccountVO;
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
	
	
	
	
	/**
	 * Inserta un listado de Activos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void insertAssetListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- insert Listado Activos ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			AssetVO activoToInsert = new AssetVO();
			try{
				activoToInsert=(AssetVO)object;
				session.save(activoToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertActivo ---" + activoToInsert.getSfid());
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertActivo: ---" + activoToInsert.getSfid(), e);
			}						
		}
		logger.debug("--- Fin -- insert Listado Activos ---");
		session.close();
	}
	

	/**
	 * Actualiza un listado de activos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void updateAcountListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- update Listado Activos ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			AssetVO activoToUpdate = new AssetVO();
			try{
				activoToUpdate=(AssetVO)object;
				Query sqlUpdateQuery =session.createQuery("UPDATE AssetVO SET "
				+ "name= :name,contactid= :contactid,accountid= :accountid,"
				+ "suministroid= :suministroid"				
				+	
				" WHERE sfid = :sfidFiltro");
				
				//Seteamos los campos a actualizar
				
				sqlUpdateQuery.setParameter("name", activoToUpdate.getName());
				sqlUpdateQuery.setParameter("contactid", activoToUpdate.getContactid());
				sqlUpdateQuery.setParameter("accountid", activoToUpdate.getAccountid());
				sqlUpdateQuery.setParameter("suministroid", activoToUpdate.getSuministroid());

				
				//Seteamos el campo por el que filtramos la actualización
				
				sqlUpdateQuery.setParameter("sfidFiltro", activoToUpdate.getSfid());
				
				//Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateActivo ---" + activoToUpdate.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en updateActivo: ---" + activoToUpdate.getSfid(), e);
			} 						
		}
		logger.debug("--- Fin -- update Listado Activos ---");
		session.close();

	}
		
	/**
	 * Borra un listado de activos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void deleteAcountListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- delete Listado Activos ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			AssetVO activoToDelete = new AssetVO();
			try{
				activoToDelete=(AssetVO)object;
				Query sqlDeleteQuery =session.createQuery("DELETE AssetVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", activoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteActivo ---" + activoToDelete.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en deleteActivo: ---" + activoToDelete.getSfid(), e);
			} 					
		}
		logger.debug("--- Fin -- delete Listado Activos ---");
		session.close();

	}
	
	

}
