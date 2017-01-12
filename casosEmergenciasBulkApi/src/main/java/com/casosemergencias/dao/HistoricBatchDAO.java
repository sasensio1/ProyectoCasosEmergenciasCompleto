package com.casosemergencias.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.casosemergencias.dao.vo.HistoricBatchVO;

@Repository
public class HistoricBatchDAO {
	final static Logger logger = Logger.getLogger(HistoricBatchDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Inserta el historico en BBDD
	 * @param historico
	 * @return
	 */
	@Transactional
	public Integer insertHistoric(HistoricBatchVO historico) {

		logger.debug("--- Inicio -- insertHistoric ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(historico);
			tx.commit();
			logger.debug("--- Fin -- insertHistoric ---");
			return historico.getId();
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertHistoric: ", e);
			logger.error("--- Fin -- insertHistoric---");
			return 0;
		} finally {
			session.close();
		}

	}
	
	
}