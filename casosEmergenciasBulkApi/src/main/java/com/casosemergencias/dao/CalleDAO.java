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
	
	
	
	
	/**
	 * Inserta un listado de Calles venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void insertStreetListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- insert Listado Calles ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			StreetVO calleToInsert = new StreetVO();
			try{
				calleToInsert=(StreetVO)object;
				session.save(calleToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertCalle ---" + calleToInsert.getSfid());
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertCalle: ---" + calleToInsert.getSfid(), e);
			}						
		}
		logger.debug("--- Fin -- insert Listado Calles ---");
		session.close();
	}
	

	/**
	 * Actualiza un listado de calles venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void updateStreetListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- update Listado Calles ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			StreetVO calleToUpdate = new StreetVO();
			try{
				calleToUpdate=(StreetVO)object;
				Query sqlUpdateQuery =session.createQuery("UPDATE StreetVO SET "
				+ "createddate= :createddate,lastmodifieddate= :lastmodifieddate,name= :name,"
				+ "recordtypeid= :recordtypeid,currencyisocode= :currencyisocode,region__c= :region__c,"
				+ "literal_region__c= :literal_region__c,municipality__c= :municipality__c,"
				+ "literal_municipality__c= :literal_municipality__c,street__c= :street__c,"
				+ "street_type__c= :street_type__c,literal_street_type__c= :literal_street_type__c,"
				+ "lastmodifiedbyid= :lastmodifiedbyid,createdbyid= :createdbyid,ownerid= :ownerid,"
				+ "country__c= :country__c,company__c= :company__c"					

				+	
				" WHERE sfid = :sfidFiltro");
				
				//Seteamos los campos a actualizar
				
				sqlUpdateQuery.setParameter("createddate", calleToUpdate.getCreatedDate());
				sqlUpdateQuery.setParameter("lastmodifieddate", calleToUpdate.getLastModifiedDate());
				sqlUpdateQuery.setParameter("name", calleToUpdate.getName());
				sqlUpdateQuery.setParameter("recordtypeid", calleToUpdate.getRecordTypeId());
				sqlUpdateQuery.setParameter("currencyisocode", calleToUpdate.getCurrencyIsoCode());
				sqlUpdateQuery.setParameter("region__c", calleToUpdate.getRegion());
				sqlUpdateQuery.setParameter("literal_region__c", calleToUpdate.getLiteralRegion());
				sqlUpdateQuery.setParameter("municipality__c", calleToUpdate.getMunicipality());
				sqlUpdateQuery.setParameter("literal_municipality__c", calleToUpdate.getLiteralMunicipality());
				sqlUpdateQuery.setParameter("street__c", calleToUpdate.getStreet());
				sqlUpdateQuery.setParameter("street_type__c", calleToUpdate.getStreetType());
				sqlUpdateQuery.setParameter("literal_street_type__c", calleToUpdate.getLiteralStreetType());
				sqlUpdateQuery.setParameter("lastmodifiedbyid", calleToUpdate.getLastModifiedById());
				sqlUpdateQuery.setParameter("createdbyid", calleToUpdate.getCreatedById());
				sqlUpdateQuery.setParameter("ownerid", calleToUpdate.getOwnerId());
				sqlUpdateQuery.setParameter("country__c", calleToUpdate.getCountry());
				sqlUpdateQuery.setParameter("company__c", calleToUpdate.getCompany());
				
				//Seteamos el campo por el que filtramos la actualizacións
				
				sqlUpdateQuery.setParameter("sfidFiltro", calleToUpdate.getSfid());
				
				//Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateCalle ---" + calleToUpdate.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en updateCalle: ---" + calleToUpdate.getSfid(), e);
			} 						
		}
		logger.debug("--- Fin -- update Listado Calles ---");
		session.close();

	}
		
	/**
	 * Borra un listado de calles venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void deleteStreetListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- delete Listado Calles ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			StreetVO calleToDelete = new StreetVO();
			try{
				calleToDelete=(StreetVO)object;
				Query sqlDeleteQuery =session.createQuery("DELETE StreetVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", calleToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteCalle ---" + calleToDelete.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en deleteCalle: ---" + calleToDelete.getSfid(), e);
			} 					
		}
		logger.debug("--- Fin -- delete Listado Calles ---");
		session.close();

	}
	
	
	
	
	

	



}