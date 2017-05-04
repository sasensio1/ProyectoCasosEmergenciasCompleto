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

import com.casosemergencias.dao.vo.CasosReiteradosVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class CasosReiteradosDAO {

final static Logger logger = Logger.getLogger(CasosReiteradosDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
	/**
	 * Inserta un listado de CasoReiterados venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int insertCasosReiteradosListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado CasoReiterados ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		CasosReiteradosVO casoReiteradoToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_REPEATED_CASES);
			historicoInsertRecord.setProcessId(processId);
			casoReiteradoToInsert = new CasosReiteradosVO();
			
			try {
				casoReiteradoToInsert = (CasosReiteradosVO) object;
				historicoInsertRecord.setSfidRecord(casoReiteradoToInsert.getSfid());
				session.save(casoReiteradoToInsert);

				logger.debug("--- Fin -- insertCasoReiterado ---" + casoReiteradoToInsert.getSfid());
				
				processOk = true;
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en insertCasoReiterado: ---" + casoReiteradoToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}
			
			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado CasoReiterados ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de casoReiterados venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateCasosReiteradosListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado CasoReiterados ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		CasosReiteradosVO casoReiteradoToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
				
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_REPEATED_CASES);
			historicoUpdateRecord.setProcessId(processId);
			casoReiteradoToUpdate = new CasosReiteradosVO();
			
			try {
				casoReiteradoToUpdate=(CasosReiteradosVO)object;
				historicoUpdateRecord.setSfidRecord(casoReiteradoToUpdate.getSfid());
				//1.1-Construimos la query							
				Query sqlUpdateQuery =session.createQuery("UPDATE CasosReiteradosVO "
													   + "	  SET name = :name"
													   + (casoReiteradoToUpdate.getNumCasos() != null ? "		, numbercases__c = :numbercases__c" : "")
													   + (casoReiteradoToUpdate.getNumDias() != null ? "		, numberdays__c = :numberdays__c" : "")
													   + "		, createddate = :createddate"				
													   + "  WHERE sfid = :sfidFiltro");
				
				//1.2-Seteamos los campos
				sqlUpdateQuery.setString("name", casoReiteradoToUpdate.getName());
				if (casoReiteradoToUpdate.getNumCasos() != null) {
					sqlUpdateQuery.setDouble("numbercases__c", casoReiteradoToUpdate.getNumCasos());
				}
				if (casoReiteradoToUpdate.getNumDias() != null) {
					sqlUpdateQuery.setDouble("numberdays__c", casoReiteradoToUpdate.getNumDias());
				}
				sqlUpdateQuery.setTimestamp("createddate", casoReiteradoToUpdate.getCreatedDate());
				sqlUpdateQuery.setString("sfidFiltro", casoReiteradoToUpdate.getSfid());
				
				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				logger.debug("--- Fin -- updateCasoReiterado ---" + casoReiteradoToUpdate.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateCasoReiterado: ---" + casoReiteradoToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			} 

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado CasoReiterados ---");
		session.close();
		return processedRecords;
	}
		
	/**
	 * Borra un listado de casoReiterados venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteCasosReiteradosListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado CasoReiterados ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		CasosReiteradosVO casoReiteradoToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_REPEATED_CASES);
			historicoDeleteRecord.setProcessId(processId);
			casoReiteradoToDelete = new CasosReiteradosVO();

			try {
				casoReiteradoToDelete = (CasosReiteradosVO) object;
				historicoDeleteRecord.setSfidRecord(casoReiteradoToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE CasosReiteradosVO  WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setString("sfidFiltro", casoReiteradoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
				
				logger.debug("--- Fin -- deleteCasoReiterado ---" + casoReiteradoToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteCasoReiterado: ---" + casoReiteradoToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			}
			
			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado CasoReiterados ---");
		session.close();
		return processedRecords;
	}
}