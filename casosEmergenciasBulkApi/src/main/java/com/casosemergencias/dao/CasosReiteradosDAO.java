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

import com.casosemergencias.dao.vo.AccountVO;
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
	
	
	
	
	
	
	/**
	 * Inserta un listado de CasoReiterados venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void insertCasosReiteradosListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- insert Listado CasoReiterados ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			CasosReiteradosVO casoReiteradoToInsert = new CasosReiteradosVO();
			try{
				casoReiteradoToInsert=(CasosReiteradosVO)object;
				session.save(casoReiteradoToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertCasoReiterado ---" + casoReiteradoToInsert.getSfid());
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertCasoReiterado: ---" + casoReiteradoToInsert.getSfid(), e);
			}						
		}
		logger.debug("--- Fin -- insert Listado CasoReiterados ---");
		session.close();
	}
	

	/**
	 * Actualiza un listado de casoReiterados venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void updateCasosReiteradosListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- update Listado CasoReiterados ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			CasosReiteradosVO casoReiteradoToUpdate = new CasosReiteradosVO();
			try{
				casoReiteradoToUpdate=(CasosReiteradosVO)object;
				Query sqlUpdateQuery =session.createQuery("UPDATE CasosReiteradosVO SET "
				+ "name= :name,numbercases__c= :numbercases__c,numberdays__c= :numberdays__c,"
				+ "createddate= :createddate"				
				+	
				" WHERE sfid = :sfidFiltro");
				
				//Seteamos los campos a actualizar
				
				sqlUpdateQuery.setParameter("name", casoReiteradoToUpdate.getName());
				sqlUpdateQuery.setParameter("numbercases__c", casoReiteradoToUpdate.getNumCasos());
				sqlUpdateQuery.setParameter("numberdays__c", casoReiteradoToUpdate.getNumDias());
				sqlUpdateQuery.setParameter("createddate", casoReiteradoToUpdate.getCreatedDate());

				//Seteamos el campo por el que filtramos la actualización
				
				sqlUpdateQuery.setParameter("sfidFiltro", casoReiteradoToUpdate.getSfid());
				
				//Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateCasoReiterado ---" + casoReiteradoToUpdate.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en updateCasoReiterado: ---" + casoReiteradoToUpdate.getSfid(), e);
			} 						
		}
		logger.debug("--- Fin -- update Listado CasoReiterados ---");
		session.close();

	}
		
	/**
	 * Borra un listado de casoReiterados venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void deleteCasosReiteradosListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- delete Listado CasoReiterados ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			CasosReiteradosVO casoReiteradoToDelete = new CasosReiteradosVO();
			try{
				casoReiteradoToDelete=(CasosReiteradosVO)object;
				Query sqlDeleteQuery =session.createQuery("DELETE CasosReiteradosVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", casoReiteradoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteCasoReiterado ---" + casoReiteradoToDelete.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en deleteCasoReiterado: ---" + casoReiteradoToDelete.getSfid(), e);
			} 					
		}
		logger.debug("--- Fin -- delete Listado CasoReiterados ---");
		session.close();

	}
	
	
	
	
	
	
	
}
