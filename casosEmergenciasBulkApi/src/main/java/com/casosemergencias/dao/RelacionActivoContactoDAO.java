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

import com.casosemergencias.dao.vo.RelacionActivoContactoVO;

@Repository
public class RelacionActivoContactoDAO {
	
	final static Logger logger = Logger.getLogger(RelacionActivoContactoDAO.class);
		
	@Autowired
	private  SessionFactory sessionFactory;
	
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
	
	
	/**
	 * Inserta un listado de RelacionActivoContactos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void insertRelacionActivoContactoListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- insert Listado RelacionActivoContactos ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			RelacionActivoContactoVO relacionActivoContactoToInsert = new RelacionActivoContactoVO();
			try{
				relacionActivoContactoToInsert=(RelacionActivoContactoVO)object;
				session.save(relacionActivoContactoToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertRelacionActivoContacto ---" + relacionActivoContactoToInsert.getSfid());
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertRelacionActivoContacto: ---" + relacionActivoContactoToInsert.getSfid(), e);
			}						
		}
		logger.debug("--- Fin -- insert Listado RelacionActivoContactos ---");
		session.close();
	}
	

	/**
	 * Actualiza un listado de relacionActivoContactos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void updateRelacionActivoContactoListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- update Listado RelacionActivoContactos ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			RelacionActivoContactoVO relacionActivoContactoToUpdate = new RelacionActivoContactoVO();
			try{
				relacionActivoContactoToUpdate=(RelacionActivoContactoVO)object;
				
				//1.1- Seteamos los campos a actualizar distintos de String				
				Date createddate=relacionActivoContactoToUpdate.getCreatedDate();
				Boolean principal__c=relacionActivoContactoToUpdate.getPrincipal();

				//1.2-Construimos la query							
				Query sqlUpdateQuery =session.createQuery("UPDATE RelacionActivoContactoVO SET "
				+ "name= :name,createddate="+createddate+",contact__c= :contact__c,"
				+ "principal__c="+principal__c+",asset__c= :asset__c,"
				+ "typeofrelationship__c= :typeofrelationship__c"
				+
				" WHERE sfid = :sfidFiltro");
				
				//1.3-Seteamos los campos a actualizar de tipo String	
				
				    //1.3.1-Seteamos los campos que no filtren la query						
					sqlUpdateQuery.setParameter("name", relacionActivoContactoToUpdate.getName());
					sqlUpdateQuery.setParameter("contact__c", relacionActivoContactoToUpdate.getContactoId());
					sqlUpdateQuery.setParameter("asset__c", relacionActivoContactoToUpdate.getActivoId());
					sqlUpdateQuery.setParameter("typeofrelationship__c", relacionActivoContactoToUpdate.getTipoRelacionActivoClave());
				
					//1.3.2-Seteamos el sfid,campo por el que filtramos la query								
					sqlUpdateQuery.setParameter("sfidFiltro", relacionActivoContactoToUpdate.getSfid());

				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateRelacionActivoContacto ---" + relacionActivoContactoToUpdate.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en updateRelacionActivoContacto: ---" + relacionActivoContactoToUpdate.getSfid(), e);
			} 						
		}
		logger.debug("--- Fin -- update Listado RelacionActivoContactos ---");
		session.close();

	}
		
	/**
	 * Borra un listado de relacionActivoContactos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void deleteRelacionActivoContactoListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- delete Listado RelacionActivoContactos ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			RelacionActivoContactoVO relacionActivoContactoToDelete = new RelacionActivoContactoVO();
			try{
				relacionActivoContactoToDelete=(RelacionActivoContactoVO)object;
				Query sqlDeleteQuery =session.createQuery("DELETE RelacionActivoContactoVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", relacionActivoContactoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteRelacionActivoContacto ---" + relacionActivoContactoToDelete.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en deleteRelacionActivoContacto: ---" + relacionActivoContactoToDelete.getSfid(), e);
			} 					
		}
		logger.debug("--- Fin -- delete Listado RelacionActivoContactos ---");
		session.close();

	}
	
	
	
	
	

	
}