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

import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.dao.vo.DireccionVO;
import com.casosemergencias.dao.vo.StreetVO;

@Repository
public class CalleDAO {
	final static Logger logger = Logger.getLogger(DireccionDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Inserta una calle en BBDD.
	 * 
	 * @param Calle
	 * @return
	 */
	@Transactional
	public Integer insertCalle(StreetVO calle) {

		logger.debug("--- Inicio -- insert ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(calle);
			tx.commit();
			logger.debug("--- Fin -- insert ---");
			return calle.getId();
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertCalle: ", e);
			logger.error("--- Fin -- updateCalle---");
			return 0;
		} finally {
			session.close();
		}

	}
	
	/**
	 * Devuelve la Calle que tiene como sfid el pasado por parametro al metodo
	 * 
	 * @param sfid - id de un Direccion
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public StreetVO readCalleBySfid(String sfid) {
		
		logger.debug("--- Inicio -- readCalleBySfid ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from StreetVO as calle WHERE calle.sfid = :sfid");
			query.setString("sfid", sfid);
			
			List<StreetVO> calleList = query.list(); 

			if (calleList != null && !calleList.isEmpty()) {
				return calleList.get(0);
			}			
			
			logger.debug("--- Fin -- readCalleBySfid ---");
	    } catch (HibernateException e) {
	    	logger.error("--- readCalleBySfid ", e); 
	    	logger.error("--- Fin -- readCalleBySfid ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}

	



}