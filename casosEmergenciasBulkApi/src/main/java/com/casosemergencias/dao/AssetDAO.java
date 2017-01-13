package com.casosemergencias.dao;

import java.util.Date;
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
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class AssetDAO {
	
	
	final static Logger logger = Logger.getLogger(AccountDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
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
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessInsert = new HistoricBatchVO();
		historicoProcessInsert.setStartDate(new Date());
		historicoProcessInsert.setOperation(ConstantesBatch.INSERT_PROCESS);
		historicoProcessInsert.setTotalRecords(objectList.size());
		historicoProcessInsert.setObject("ASSET");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			
			HistoricBatchVO historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject("ASSET");
			
			AssetVO activoToInsert = new AssetVO();
			try{
				activoToInsert=(AssetVO)object;
				
				historicoInsertRecord.setSfidRecord(activoToInsert.getSfid());
				
				session.save(activoToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertActivo ---" + activoToInsert.getSfid());
				
				historicoInsertRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoInsertRecord);
				cont++;
				
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertActivo: ---" + activoToInsert.getSfid(), e);
			
			historicoInsertRecord.setSuccess(false);
			historicoInsertRecord.setErrorCause(ConstantesBatch.ERROR_INSERT_RECORD);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
			
			}						
		}
		logger.debug("--- Fin -- insert Listado Activos ---");
		session.close();
		if(cont == objectList.size()){
			historicoProcessInsert.setEndDate(new Date());
			historicoProcessInsert.setSuccess(true);
			historicoProcessInsert.setProcessedRecords(cont);
			historicBatchDAO.insertHistoric(historicoProcessInsert);
		} else {
			historicoProcessInsert.setEndDate(new Date());
			historicoProcessInsert.setSuccess(false);
			historicoProcessInsert.setErrorCause(ConstantesBatch.ERROR_INSERT_RECORD);
			historicoProcessInsert.setProcessedRecords(cont);
			historicBatchDAO.insertHistoric(historicoProcessInsert);
		}		
	}
	

	/**
	 * Actualiza un listado de activos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void updateAssetListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- update Listado Activos ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessUpdate = new HistoricBatchVO();
		historicoProcessUpdate.setStartDate(new Date());
		historicoProcessUpdate.setOperation(ConstantesBatch.UPDATE_PROCESS);
		historicoProcessUpdate.setTotalRecords(objectList.size());
		historicoProcessUpdate.setObject("ASSET");
		
		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject("ASSET");
			
			AssetVO activoToUpdate = new AssetVO();
			try{
				activoToUpdate=(AssetVO)object;
				
				historicoUpdateRecord.setSfidRecord(activoToUpdate.getSfid());
				
				//1.1-Definimos los parámetros que no sean de tipo String				
				Date createddate= null;
				
				//1.2-Construimos la query						
				Query sqlUpdateQuery =session.createQuery("UPDATE AssetVO SET "
				+ "name= :name,contactid= :contactid,accountid= :accountid,"
				+ "pointofdelivery__c= :pointofdelivery__c,createdDate="+createddate				
				+	
				" WHERE sfid = :sfidFiltro");
				
				//1.3-Seteamos los campos a actualizar de tipo String	
				
					//1.3.1-Seteamos el campos que no filtren la query						
					sqlUpdateQuery.setParameter("name", activoToUpdate.getName());
					sqlUpdateQuery.setParameter("contactid", activoToUpdate.getContactid());
					sqlUpdateQuery.setParameter("accountid", activoToUpdate.getAccountid());
					sqlUpdateQuery.setParameter("pointofdelivery__c", activoToUpdate.getSuministroid());
					//1.3.2-Seteamos el sfid,campo por el que filtramos la query				
					sqlUpdateQuery.setParameter("sfidFiltro", activoToUpdate.getSfid());
					
				//1.4- Seteamos los campos a actualizar distintos de String				
				createddate=activoToUpdate.getCreatedDate();
								
				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateActivo ---" + activoToUpdate.getSfid());
				
				historicoUpdateRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoUpdateRecord);
				cont++;
				
			} catch (HibernateException e) {
			logger.error("--- Error en updateActivo: ---" + activoToUpdate.getSfid(), e);
			historicoUpdateRecord.setSuccess(false);
			historicoUpdateRecord.setErrorCause(ConstantesBatch.ERROR_UPDATE_RECORD);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
			} 						
		}
		logger.debug("--- Fin -- update Listado Activos ---");
		session.close();
		if(cont == objectList.size()){
			historicoProcessUpdate.setEndDate(new Date());
			historicoProcessUpdate.setSuccess(true);
			historicoProcessUpdate.setProcessedRecords(cont);
			historicBatchDAO.insertHistoric(historicoProcessUpdate);
		} else {
			historicoProcessUpdate.setEndDate(new Date());
			historicoProcessUpdate.setSuccess(false);
			historicoProcessUpdate.setErrorCause(ConstantesBatch.ERROR_UPDATE_RECORD);
			historicoProcessUpdate.setProcessedRecords(cont);
			historicBatchDAO.insertHistoric(historicoProcessUpdate);
		}

	}
		
	/**
	 * Borra un listado de activos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void deleteAssetListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- delete Listado Activos ---");
		
Integer cont = 0;
		
		HistoricBatchVO historicoProcessDelete = new HistoricBatchVO();
		historicoProcessDelete.setStartDate(new Date());
		historicoProcessDelete.setOperation(ConstantesBatch.DELETE_PROCESS);
		historicoProcessDelete.setTotalRecords(objectList.size());
		historicoProcessDelete.setObject("ASSET");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject("ASSET");
			
			AssetVO activoToDelete = new AssetVO();
			try{
				activoToDelete=(AssetVO)object;
				
				historicoDeleteRecord.setSfidRecord(activoToDelete.getSfid());
				
				Query sqlDeleteQuery =session.createQuery("DELETE AssetVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", activoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteActivo ---" + activoToDelete.getSfid());
				
				historicoDeleteRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoDeleteRecord);
				cont++;
				
			} catch (HibernateException e) {
			logger.error("--- Error en deleteActivo: ---" + activoToDelete.getSfid(), e);
			historicoDeleteRecord.setSuccess(false);
			historicoDeleteRecord.setErrorCause(ConstantesBatch.ERROR_DELETE_RECORD);
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
			} 					
		}
		logger.debug("--- Fin -- delete Listado Activos ---");
		session.close();
		if(cont == objectList.size()){
			historicoProcessDelete.setEndDate(new Date());
			historicoProcessDelete.setSuccess(true);
			historicoProcessDelete.setProcessedRecords(cont);
			historicBatchDAO.insertHistoric(historicoProcessDelete);
		} else {
			historicoProcessDelete.setEndDate(new Date());
			historicoProcessDelete.setSuccess(false);
			historicoProcessDelete.setErrorCause(ConstantesBatch.ERROR_DELETE_RECORD);
			historicoProcessDelete.setProcessedRecords(cont);
			historicBatchDAO.insertHistoric(historicoProcessDelete);
		}

	}
	
	

}
