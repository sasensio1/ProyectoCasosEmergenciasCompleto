package com.casosemergencias.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casosemergencias.dao.vo.CasosReiteradosVO;

@Repository
public class CasosReiteradosDAO {

final static Logger logger = Logger.getLogger(CasosReiteradosDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Devuelve una lista con todas los CaseHistory de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CasosReiteradosVO> readAllCasosReiterados() {
		logger.debug("--- Inicio -- readAllCasosReiterados ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from CasosReiteradosVO");
			List<CasosReiteradosVO> casoReiteradoList = query.list(); 

			logger.debug("--- Fin -- readAllCasosReiterados ---");
			
			return casoReiteradoList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAllCasosReiterados ", e); 
	    	logger.error("--- Fin -- readAllCasosReiterados ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve una lista con todas los CaseHistory de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CasosReiteradosVO> readCasosReiterados(CasosReiteradosVO casoReiterado) {
		logger.debug("--- Inicio -- readCasosReiterados ---");
		
		Session session = sessionFactory.openSession();
		boolean isFirst = true;
				
		try {
			// preparamos la query
			StringBuilder query = new StringBuilder("from CasosReiteradosVO as casoReiterado");
			if (casoReiterado.getId() != null) {
				if (isFirst) {
					query.append(" WHERE casoReiterado.id = '" + casoReiterado.getId() + "'");
					isFirst = false;
				} else {
					query.append(" AND casoReiterado.id = '" + casoReiterado.getId() + "'");
				}
			}
			if (casoReiterado.getSfid() != null) {
				if (isFirst) {
					query.append(" WHERE casoReiterado.sfid = '" + casoReiterado.getSfid() + "'");
					isFirst = false;
				} else {
					query.append(" AND casoReiterado.sfid = '" + casoReiterado.getSfid() + "'");
				}
			}
			if (casoReiterado.getName() != null) {
				if (isFirst) {
					query.append(" WHERE casoReiterado.name = '" + casoReiterado.getName() + "'");
					isFirst = false;
				} else {
					query.append(" AND casoReiterado.name = '" + casoReiterado.getName() + "'");
				}
			}
			if (casoReiterado.getNumCasos() != null) {
				if (isFirst) {
					query.append(" WHERE casoReiterado.numCasos = " + casoReiterado.getNumCasos());
					isFirst = false;
				} else {
					query.append(" AND casoReiterado.numCasos = " + casoReiterado.getNumCasos());
				}
			}
			if (casoReiterado.getNumDias() != null) {
				if (isFirst) {
					query.append(" WHERE casoReiterado.numDias = " + casoReiterado.getNumDias());
					isFirst = false;
				} else {
					query.append(" AND casoReiterado.numDias = " + casoReiterado.getNumDias());
				}
			}
			Query result = session.createQuery(query.toString());			
			List<CasosReiteradosVO> casoReiteradoList = result.list(); 

			logger.debug("--- Fin -- readCasosReiterados ---");
			
			return casoReiteradoList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readCasosReiterados ", e); 
	    	logger.error("--- Fin -- readCasosReiterados ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve una lista con todas los CaseHistory de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public CasosReiteradosVO readCasosReiteradosByName(String name) {
		logger.debug("--- Inicio -- readCasosReiteradosByName ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			// preparamos la query
			StringBuilder query = new StringBuilder("from CasosReiteradosVO as casoReiterado "
					+ "WHERE casoReiterado.name = '"+name +"'");
		
			
			Query result = session.createQuery(query.toString());			
			List<CasosReiteradosVO> casoReiteradoList = result.list(); 

			logger.debug("--- Fin -- readCasosReiterados ---");
			
			return casoReiteradoList.get(0);
			
	    } catch (HibernateException e) {
	    	logger.error("--- readCasosReiterados ", e); 
	    	logger.error("--- Fin -- readCasosReiterados ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
}
