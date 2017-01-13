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
	public void insertCaseCommentListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- insert Listado ComentarioCasos ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessInsert = new HistoricBatchVO();
		historicoProcessInsert.setStartDate(new Date());
		historicoProcessInsert.setOperation(ConstantesBatch.INSERT_PROCESS);
		historicoProcessInsert.setTotalRecords(objectList.size());
		historicoProcessInsert.setObject("CASECOMMENT");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			
			HistoricBatchVO historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject("CASECOMMENT");
			
			CaseCommentVO comentarioCasoToInsert = new CaseCommentVO();
			try{
				comentarioCasoToInsert=(CaseCommentVO)object;
				
				historicoInsertRecord.setSfidRecord(comentarioCasoToInsert.getSfid());
				
				session.save(comentarioCasoToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertComentarioCaso ---" + comentarioCasoToInsert.getSfid());
				
				historicoInsertRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoInsertRecord);
				cont++;
				
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertComentarioCaso: ---" + comentarioCasoToInsert.getSfid(), e);
			historicoInsertRecord.setSuccess(false);
			historicoInsertRecord.setErrorCause(ConstantesBatch.ERROR_INSERT_RECORD);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
			}						
		}
		logger.debug("--- Fin -- insert Listado ComentarioCasos ---");
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
	 * Actualiza un listado de comentarioCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void updateCaseCommentListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- update Listado ComentarioCasos ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessUpdate = new HistoricBatchVO();
		historicoProcessUpdate.setStartDate(new Date());
		historicoProcessUpdate.setOperation(ConstantesBatch.UPDATE_PROCESS);
		historicoProcessUpdate.setTotalRecords(objectList.size());
		historicoProcessUpdate.setObject("CASECOMMENT");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject("CASECOMMENT");
			
			CaseCommentVO comentarioCasoToUpdate = new CaseCommentVO();
			try{
				comentarioCasoToUpdate=(CaseCommentVO)object;
				
				historicoUpdateRecord.setSfidRecord(comentarioCasoToUpdate.getSfid());
				
				//1.1-Definimos los parámetros que no sean de tipo String
				Date createddate= null;
				Boolean ispublished=null;
				Date lastmodifieddate=null;
				
				//1.2-Construimos la query			
				Query sqlUpdateQuery =session.createQuery("UPDATE CaseCommentVO SET "
				+ "createdbyid= :createdbyid,createddate="+createddate+","
				+ "ispublished="+ispublished+",parentid= :parentid,"
				+ "commentbody= :commentbody,lastmodifieddate="+lastmodifieddate+","
				+ "lastmodifiedbyid= :lastmodifiedbyid"			
				+	
				" WHERE sfid = :sfidFiltro");
				
				//1.3-Seteamos los campos a actualizar de tipo String	
				
					//1.3.1-Seteamos el campos que no filtren la query						
					sqlUpdateQuery.setParameter("createdbyid", comentarioCasoToUpdate.getCreatedbyid());
					sqlUpdateQuery.setParameter("parentid", comentarioCasoToUpdate.getCaseid());
					sqlUpdateQuery.setParameter("commentbody", comentarioCasoToUpdate.getComment());
					sqlUpdateQuery.setParameter("lastmodifiedbyid", comentarioCasoToUpdate.getLastmodifiedbyid());
					
					//1.3.2-Seteamos el sfid,campo por el que filtramos la query				
					sqlUpdateQuery.setParameter("sfidFiltro", comentarioCasoToUpdate.getSfid());
				
				//1.4- Seteamos los campos a actualizar distintos de String				
				createddate=comentarioCasoToUpdate.getCreateddate();
				ispublished=comentarioCasoToUpdate.getIspublished();
				lastmodifieddate=comentarioCasoToUpdate.getLastmodifieddate();
				
				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateComentarioCaso ---" + comentarioCasoToUpdate.getSfid());
				
				historicoUpdateRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoUpdateRecord);
				cont++;
				
			} catch (HibernateException e) {
			logger.error("--- Error en updateComentarioCaso: ---" + comentarioCasoToUpdate.getSfid(), e);
			historicoUpdateRecord.setSuccess(false);
			historicoUpdateRecord.setErrorCause(ConstantesBatch.ERROR_UPDATE_RECORD);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
			} 						
		}
		logger.debug("--- Fin -- update Listado ComentarioCasos ---");
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
	 * Borra un listado de comentarioCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void deleteCaseCommentListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- delete Listado ComentarioCasos ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessDelete = new HistoricBatchVO();
		historicoProcessDelete.setStartDate(new Date());
		historicoProcessDelete.setOperation(ConstantesBatch.DELETE_PROCESS);
		historicoProcessDelete.setTotalRecords(objectList.size());
		historicoProcessDelete.setObject("CASECOMMENT");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject("CASECOMMENT");
			
			CaseCommentVO comentarioCasoToDelete = new CaseCommentVO();
			try{
				comentarioCasoToDelete=(CaseCommentVO)object;
				
				historicoDeleteRecord.setSfidRecord(comentarioCasoToDelete.getSfid());
				
				Query sqlDeleteQuery =session.createQuery("DELETE CaseCommentVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", comentarioCasoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteComentarioCaso ---" + comentarioCasoToDelete.getSfid());
				
				historicoDeleteRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoDeleteRecord);
				cont++;
				
			} catch (HibernateException e) {
			logger.error("--- Error en deleteComentarioCaso: ---" + comentarioCasoToDelete.getSfid(), e);
			historicoDeleteRecord.setSuccess(false);
			historicoDeleteRecord.setErrorCause(ConstantesBatch.ERROR_DELETE_RECORD);
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
			} 					
		}
		logger.debug("--- Fin -- delete Listado ComentarioCasos ---");
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
