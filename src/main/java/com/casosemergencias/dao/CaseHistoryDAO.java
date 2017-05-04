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

import com.casosemergencias.dao.vo.CaseHistoryVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class CaseHistoryDAO {
	
	final static Logger logger = Logger.getLogger(CaseHistoryDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;

	
	/**
	 * Inserta un listado de HistorialCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int insertCaseHistoryListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado HistorialCasos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		CaseHistoryVO historialCasoToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_CASE_HISTORY);
			historicoInsertRecord.setProcessId(processId);
			historialCasoToInsert = new CaseHistoryVO();
			 
			try {
				historialCasoToInsert = (CaseHistoryVO) object;
				historicoInsertRecord.setSfidRecord(historialCasoToInsert.getSfid());
				session.save(historialCasoToInsert);

				logger.debug("--- Fin -- insertHistorialCaso ---" + historialCasoToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en insertHistorialCaso: ---" + historialCasoToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}

			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado HistorialCasos ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de historialCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateCaseHistoryListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado HistorialCasos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		CaseHistoryVO historialCasoToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
				
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_CASE_HISTORY);
			historicoUpdateRecord.setProcessId(processId);
			historialCasoToUpdate = new CaseHistoryVO();
			
			try {
				historialCasoToUpdate = (CaseHistoryVO) object;
				historicoUpdateRecord.setSfidRecord(historialCasoToUpdate.getSfid());
				//1.1-Construimos la query							
				Query sqlUpdateQuery = session.createQuery("UPDATE CaseHistoryVO "
														+ "    SET createdbyid = :createdbyid"
														+ "		 , createddate = :createddate"
														+ "		 , newvalue = :newvalue"
														+ "		 , oldvalue = :oldvalue"
														+ "		 , field = :field"
														+ "		 , caseid = :caseid"
														+ "  WHERE sfid = :sfidFiltro");
				
				//1.2-Seteamos los campos
				sqlUpdateQuery.setString("createdbyid", historialCasoToUpdate.getCreatedbyid());
				sqlUpdateQuery.setTimestamp("createddate", historialCasoToUpdate.getCreateddate());
				sqlUpdateQuery.setString("newvalue", historialCasoToUpdate.getNewvalue());
				sqlUpdateQuery.setString("oldvalue", historialCasoToUpdate.getOldvalue());
				sqlUpdateQuery.setString("field", historialCasoToUpdate.getField());
				sqlUpdateQuery.setString("caseid", historialCasoToUpdate.getCaseid());
				sqlUpdateQuery.setString("sfidFiltro", historialCasoToUpdate.getSfid());					
				
				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				logger.debug("--- Fin -- updateHistorialCaso ---" + historialCasoToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateHistorialCaso: ---" + historialCasoToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			} 

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado HistorialCasos ---");
		session.close();
		return processedRecords;
	}
		
	/**
	 * Borra un listado de historialCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteCaseHistoryListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado HistorialCasos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		CaseHistoryVO historialCasoToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_CASE_HISTORY);
			historicoDeleteRecord.setProcessId(processId);
			historialCasoToDelete = new CaseHistoryVO();
			
			try {
				historialCasoToDelete = (CaseHistoryVO) object;
				historicoDeleteRecord.setSfidRecord(historialCasoToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE CaseHistoryVO  WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", historialCasoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
				
				logger.debug("--- Fin -- deleteHistorialCaso ---" + historialCasoToDelete.getSfid());
				
				processOk = true;
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteHistorialCaso: ---" + historialCasoToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			} 

			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado HistorialCasos ---");
		session.close();
		return processedRecords;
	}
}