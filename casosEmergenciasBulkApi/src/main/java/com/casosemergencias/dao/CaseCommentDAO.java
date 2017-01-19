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
	 * Devuelve una lista con todas los CaseComment de un caseId
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CaseCommentVO> readCaseCommentByCaseId(String caseId) {
		logger.debug("--- Inicio -- readCaseCommentByCaseId ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from CaseCommentVO as caseComment WHERE caseComment.caseid = :caseId"
					+ " ORDER BY caseComment.createddate DESC");
			query.setString("caseId", caseId);
			
			List<CaseCommentVO> caseCommentList = query.list(); 

			logger.debug("--- Fin -- readCaseCommentByCaseId ---");
			
			return caseCommentList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readCaseCommentByCaseId ", e); 
	    	logger.error("--- Fin -- readCaseCommentByCaseId ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	/**
	 * Devuelve una lista con todas los CaseComment de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CaseCommentVO> readAllCaseComment() {
		logger.debug("--- Inicio -- readAllCaseComment ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from CaseCommentVO");
			List<CaseCommentVO> caseCommentList = query.list(); 

			logger.debug("--- Fin -- readAllCaseComment ---");
			
			return caseCommentList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAllCaseComment ", e); 
	    	logger.error("--- Fin -- readAllCaseComment ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve el CaseComment que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un CaseComment
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public CaseCommentVO readCaseCommentById(Integer id) {
		
		logger.debug("--- Inicio -- readCaseCommentById ---");
		
		Session session = sessionFactory.openSession();
			
		try {
			Query query = session.createQuery("from CaseCommentVO as caseComment WHERE caseComment.id = :id");
			query.setInteger("id", id);
			
			List<CaseCommentVO> caseCommentList = query.list(); 

			if(caseCommentList != null && !caseCommentList.isEmpty()){
				return caseCommentList.get(0);
			}			
			
			logger.debug("--- Fin -- readCaseCommentById ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readCaseCommentById ", e); 
	    	logger.error("--- Fin -- readCaseCommentById ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve una CaseComment que tiene como id. el pasado por parámetro al método.
	 * 
	 * @param sfid Id. del CaseComment.
	 * @return CaseCommentVO
	 */
	@SuppressWarnings("unchecked")
	public CaseCommentVO readCaseCommentBySfid(String sfid) {
		logger.debug("--- Inicio -- readCaseCommentBySfid ---");
		Session session = sessionFactory.openSession();
		
		try {
			Query query = session.createQuery("from CaseCommentVO caseComment WHERE caseComment.sfid = :sfid ");
			query.setString("sfid", sfid);
			List<CaseCommentVO> caseCommentList = query.list(); 
			
			if (caseCommentList != null && !caseCommentList.isEmpty()) {
				return caseCommentList.get(0);
			}
			
			logger.debug("--- Fin -- readCaseCommentBySfid ---");
	    } catch (HibernateException e) {
	    	logger.error("--- readCaseCommentBySfid ", e); 
	    	logger.error("--- Fin -- readCaseCommentBySfid ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Inserta un comentario de caso en BBDD.
	 * 
	 * @param CaseComment
	 * @return
	 */
	@Transactional
	public Boolean insertCaseComment(CaseCommentVO comentarioCaso) {

		logger.debug("--- Inicio -- insertCaseComment ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(comentarioCaso);
			tx.commit();
			logger.debug("--- Fin -- insertCaseComment ---");
			return true;
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertCaseComment: ", e);
			return false;
		} finally {
			session.close();
		}

	}
	
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
		Transaction tx = session.beginTransaction();
		
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
				tx.commit();
				
				logger.debug("--- Insertado comentario de caso con id: " + comentarioCasoToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				tx.rollback();
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
		Transaction tx = session.beginTransaction();
		
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
				tx.commit();
				logger.debug("--- Fin -- updateComentarioCaso ---" + comentarioCasoToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateComentarioCaso: ---" + comentarioCasoToUpdate.getSfid(), e);
				tx.rollback();
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
		Transaction tx = session.beginTransaction();
		
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
				tx.commit();
				
				logger.debug("--- Fin -- deleteComentarioCaso ---" + comentarioCasoToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteComentarioCaso: ---" + comentarioCasoToDelete.getSfid(), e);
				tx.rollback();
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