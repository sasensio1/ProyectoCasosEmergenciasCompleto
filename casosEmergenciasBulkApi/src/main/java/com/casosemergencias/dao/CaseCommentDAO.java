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

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			CaseCommentVO comentarioCasoToInsert = new CaseCommentVO();
			try{
				comentarioCasoToInsert=(CaseCommentVO)object;
				session.save(comentarioCasoToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertComentarioCaso ---" + comentarioCasoToInsert.getSfid());
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertComentarioCaso: ---" + comentarioCasoToInsert.getSfid(), e);
			}						
		}
		logger.debug("--- Fin -- insert Listado ComentarioCasos ---");
		session.close();
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

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			CaseCommentVO comentarioCasoToUpdate = new CaseCommentVO();
			try{
				comentarioCasoToUpdate=(CaseCommentVO)object;
				
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
			} catch (HibernateException e) {
			logger.error("--- Error en updateComentarioCaso: ---" + comentarioCasoToUpdate.getSfid(), e);
			} 						
		}
		logger.debug("--- Fin -- update Listado ComentarioCasos ---");
		session.close();

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

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			CaseCommentVO comentarioCasoToDelete = new CaseCommentVO();
			try{
				comentarioCasoToDelete=(CaseCommentVO)object;
				Query sqlDeleteQuery =session.createQuery("DELETE CaseCommentVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", comentarioCasoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteComentarioCaso ---" + comentarioCasoToDelete.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en deleteComentarioCaso: ---" + comentarioCasoToDelete.getSfid(), e);
			} 					
		}
		logger.debug("--- Fin -- delete Listado ComentarioCasos ---");
		session.close();

	}
	
	
	
	
	
}
