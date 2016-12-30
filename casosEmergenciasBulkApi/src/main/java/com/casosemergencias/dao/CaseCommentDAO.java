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

import com.casosemergencias.dao.vo.CaseCommentVO;

@Repository
public class CaseCommentDAO {

	final static Logger logger = Logger.getLogger(CaseCommentDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

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
	public Boolean insertCaseComment(CaseCommentVO caseComment) {

		logger.debug("--- Inicio -- insert ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			if(caseComment.getComment().isEmpty()==true){
				return false;
			}
			else{
				session.save(caseComment);
				tx.commit();
				logger.debug("--- Fin -- insert ---");
				return true;
			}
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertCase: ", e);
			logger.error("--- Fin -- updateCase ---");
			return false;
		} finally {
			session.close();
		}
	}
	
	
}
