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

import com.casosemergencias.dao.vo.CaseCommentVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class CaseCommentDAO {

	final static Logger logger = Logger.getLogger(CaseCommentDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
	/**
	 * Inserta un listado de ComentarioCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int insertCaseCommentListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado ComentarioCasos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		CaseCommentVO comentarioCasoToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_CASE_COMMENT);
			historicoInsertRecord.setProcessId(processId);
			comentarioCasoToInsert = new CaseCommentVO();
			
			try {
				comentarioCasoToInsert = (CaseCommentVO) object;
				historicoInsertRecord.setSfidRecord(comentarioCasoToInsert.getSfid());
				session.save(comentarioCasoToInsert);
				
				logger.debug("--- Insertado comentario de caso con id: " + comentarioCasoToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error Insertando comentario de caso con id: " + comentarioCasoToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}

			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);					
		}
		logger.debug("--- Fin -- insert Listado ComentarioCasos ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de comentarioCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateCaseCommentListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado ComentarioCasos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		CaseCommentVO comentarioCasoToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_CASE_COMMENT);
			historicoUpdateRecord.setProcessId(processId);
			comentarioCasoToUpdate = new CaseCommentVO();
			
			try {
				comentarioCasoToUpdate = (CaseCommentVO) object;
				historicoUpdateRecord.setSfidRecord(comentarioCasoToUpdate.getSfid());
				//1.1-Construimos la query			
				Query sqlUpdateQuery = session.createQuery("UPDATE CaseCommentVO "
														+ "    SET createdbyid = :createdbyid"
														+ "      , createddate = :createddate"
														+ "      , ispublished = :ispublished"
														+ "      , parentid = :parentid"
														+ "      , commentbody = :commentbody"
														+ "      , lastmodifieddate = :lastmodifieddate"
														+ "      , lastmodifiedbyid = :lastmodifiedbyid"
														+ "  WHERE sfid = :sfidFiltro");
				
				//1.2-Seteamos los campos de la query
				sqlUpdateQuery.setString("createdbyid", comentarioCasoToUpdate.getCreatedbyid());
				sqlUpdateQuery.setTimestamp("createddate", comentarioCasoToUpdate.getCreateddate());
				sqlUpdateQuery.setBoolean("ispublished", comentarioCasoToUpdate.getIspublished());
				sqlUpdateQuery.setString("parentid", comentarioCasoToUpdate.getCaseid());
				sqlUpdateQuery.setString("commentbody", comentarioCasoToUpdate.getComment());
				sqlUpdateQuery.setTimestamp("lastmodifieddate", comentarioCasoToUpdate.getLastmodifieddate());
				sqlUpdateQuery.setString("lastmodifiedbyid", comentarioCasoToUpdate.getLastmodifiedbyid());
				sqlUpdateQuery.setString("sfidFiltro", comentarioCasoToUpdate.getSfid());

				//1.3-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				logger.debug("--- Fin -- updateComentarioCaso ---" + comentarioCasoToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateComentarioCaso: ---" + comentarioCasoToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			}

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado ComentarioCasos ---");
		session.close();
		return processedRecords;
	}
	
	/**
	 * Borra un listado de comentarioCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteCaseCommentListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado ComentarioCasos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		CaseCommentVO comentarioCasoToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_CASE_COMMENT);
			historicoDeleteRecord.setProcessId(processId);
			comentarioCasoToDelete = new CaseCommentVO();
			
			try {
				comentarioCasoToDelete = (CaseCommentVO) object;
				historicoDeleteRecord.setSfidRecord(comentarioCasoToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE CaseCommentVO  WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setString("sfidFiltro", comentarioCasoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
				
				logger.debug("--- Fin -- deleteComentarioCaso ---" + comentarioCasoToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteComentarioCaso: ---" + comentarioCasoToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			}
			
			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado ComentarioCasos ---");
		session.close();
		return processedRecords;
	}
}