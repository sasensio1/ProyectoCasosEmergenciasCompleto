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

import com.casosemergencias.dao.vo.RelacionActivoContactoVO;

@Repository
public class RelacionActivoContactoDAO {
	
	final static Logger logger = Logger.getLogger(RelacionActivoContactoDAO.class);
		
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Devuelve una lista con todos las RelacionesActivoContacto de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RelacionActivoContactoVO> getSuministrosRelacionesPorContacto(String idContacto){
				
		logger.debug("--- Inicio -- getSuministrosRelacionesPorContacto ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from RelacionActivoContactoVO rel where rel.contactoId = :idContacto");
			query.setString("idContacto", idContacto);

			List<RelacionActivoContactoVO> relacionList = query.list(); 

			logger.debug("--- Fin -- getSuministrosRelacionesPorContacto ---");
			return relacionList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- getSuministrosRelacionesPorContacto ", e); 
	    	logger.error("--- Fin -- getSuministrosRelacionesPorContacto ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<RelacionActivoContactoVO> getContactosRelacionadosPorSuministro(String idSuministro){
				
		logger.debug("--- Inicio -- getContactosRelacionadosPorSuministro ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from RelacionActivoContactoVO rel where rel.activo.suministroid = :idSuministro");
			query.setString("idSuministro", idSuministro);

			List<RelacionActivoContactoVO> relacionList = query.list(); 

			logger.debug("--- Fin -- getRelacionesPorContacto ---");
			return relacionList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- getRelacionesPorContacto ", e); 
	    	logger.error("--- Fin -- getRelacionesPorContacto ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	
	/**
	 * Devuelve el los RelacionActivoContacto que tiene como suministroid el pasado por parametro al metodo
	 * 
	 * @param id - id de un RelacionActivoContacto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RelacionActivoContactoVO> readRelacionActivoContactoByActivoIdAndContact(String activoId,String contactSfid) {
		
		logger.debug("--- Inicio -- readRelacionActivoContactoByActivoIdAndContact ---");
		
		Session session = sessionFactory.openSession();
			
		try {
			Query query = session.createQuery("from RelacionActivoContactoVO as rel WHERE rel.activoId = :activoId AND rel.contactoId=:contactSfid");
			query.setString("activoId", activoId);
			query.setString("contactSfid", contactSfid);
			
			List<RelacionActivoContactoVO> relacionList = query.list(); 

			if(relacionList != null && !relacionList.isEmpty()){
				return relacionList;
			}			
			
			logger.debug("--- Fin -- readRelacionActivoContactoByActivo ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readRelacionActivoContactoByActivoIdAndContact ", e); 
	    	logger.error("--- Fin -- readRelacionActivoContactoByActivoIdAndContact ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Inserta un RelacionActivo en BBDD.
	 * 
	 * @param Case
	 * @return
	 */
	@Transactional
	public Integer insertRelacionActivoContacto(RelacionActivoContactoVO relacionActivoContacto) {

		logger.debug("--- Inicio -- insert ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(relacionActivoContacto);
			tx.commit();
			logger.debug("--- Fin -- insert ---");
			return relacionActivoContacto.getId();
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertRelacionActivoContacto: ", e);
			logger.error("--- Fin -- updateRelacionActivoContacto ---");
			return 0;
		} finally {
			session.close();
		}

	}

	
}