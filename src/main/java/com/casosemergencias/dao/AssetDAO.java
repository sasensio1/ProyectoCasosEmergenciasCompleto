package com.casosemergencias.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	 * Inserta un listado de Activos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int insertAssetListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Activos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		AssetVO activoToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_ASSET);
			historicoInsertRecord.setProcessId(processId);
			activoToInsert = new AssetVO();
			
			try {
				activoToInsert = (AssetVO) object;
				historicoInsertRecord.setSfidRecord(activoToInsert.getSfid());
				session.save(activoToInsert);

				logger.debug("--- Fin -- insertActivo ---" + activoToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en insertActivo: ---" + activoToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}

			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado Activos ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de activos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateAssetListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Activos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		AssetVO activoToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_ASSET);
			historicoUpdateRecord.setProcessId(processId);
			activoToUpdate = new AssetVO();
			
			try {
				activoToUpdate = (AssetVO) object;
				historicoUpdateRecord.setSfidRecord(activoToUpdate.getSfid());
				//1.1-Construimos la query						
				Query sqlUpdateQuery =session.createQuery("UPDATE AssetVO "
													   + "    SET name = :name"
													   + "	    , contactid = :contactid"
													   + "	    , accountid = :accountid"
													   + "		, pointofdelivery__c = :pointofdelivery__c"
													   + "		, createdDate = :createddate"				
													   + "  WHERE sfid = :sfidFiltro");
				
				//1.2-Seteamos los campos de la query
				sqlUpdateQuery.setString("name", activoToUpdate.getName());
				sqlUpdateQuery.setString("contactid", activoToUpdate.getContactid());
				sqlUpdateQuery.setString("accountid", activoToUpdate.getAccountid());
				sqlUpdateQuery.setString("pointofdelivery__c", activoToUpdate.getSuministroid());
				sqlUpdateQuery.setString("sfidFiltro", activoToUpdate.getSfid());
				sqlUpdateQuery.setTimestamp("createddate", activoToUpdate.getCreatedDate());

													
				//1.3-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				logger.debug("--- Fin -- updateActivo ---" + activoToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateActivo: ---" + activoToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			}

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado Activos ---");
		session.close();
		return processedRecords;
	}
		
	/**
	 * Borra un listado de activos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteAssetListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Activos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		AssetVO activoToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_ASSET);
			historicoDeleteRecord.setProcessId(processId);
			activoToDelete = new AssetVO();
			
			try {
				activoToDelete = (AssetVO) object;
				historicoDeleteRecord.setSfidRecord(activoToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE AssetVO  WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setString("sfidFiltro", activoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
				
				logger.debug("--- Fin -- deleteActivo ---" + activoToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteActivo: ---" + activoToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			} 

			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado Activos ---");
		session.close();
		return processedRecords;
	}
}