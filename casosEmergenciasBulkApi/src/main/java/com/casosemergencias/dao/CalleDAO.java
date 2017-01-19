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

import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.dao.vo.StreetVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class CalleDAO {
	final static Logger logger = Logger.getLogger(DireccionDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
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
	public boolean insertStreetListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Calles ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessInsert = new HistoricBatchVO();
		historicoProcessInsert.setStartDate(new Date());
		historicoProcessInsert.setOperation(ConstantesBatch.INSERT_PROCESS);
		historicoProcessInsert.setTotalRecords(objectList.size());
		historicoProcessInsert.setObject(ConstantesBatch.OBJECT_STREET);
		historicoProcessInsert.setProcessId(processId);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			
			HistoricBatchVO historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_STREET);
			historicoInsertRecord.setProcessId(processId);
			
			StreetVO calleToInsert = new StreetVO();
			try{
				calleToInsert=(StreetVO)object;
				
				historicoInsertRecord.setSfidRecord(calleToInsert.getSfid());
				
				session.save(calleToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertCalle ---" + calleToInsert.getSfid());
				
				historicoInsertRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoInsertRecord);
				cont++;
				
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertCalle: ---" + calleToInsert.getSfid(), e);
			historicoInsertRecord.setSuccess(false);
			historicoInsertRecord.setErrorCause(ConstantesBatch.ERROR_INSERT_RECORD);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
			}						
		}
		logger.debug("--- Fin -- insert Listado Calles ---");
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
		return historicoProcessInsert.getSuccess();
	}
	

	/**
	 * Actualiza un listado de calles venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public boolean updateStreetListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Calles ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessUpdate = new HistoricBatchVO();
		historicoProcessUpdate.setStartDate(new Date());
		historicoProcessUpdate.setOperation(ConstantesBatch.UPDATE_PROCESS);
		historicoProcessUpdate.setTotalRecords(objectList.size());
		historicoProcessUpdate.setObject(ConstantesBatch.OBJECT_STREET);
		historicoProcessUpdate.setProcessId(processId);

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_STREET);
			historicoUpdateRecord.setProcessId(processId);
			
			StreetVO calleToUpdate = new StreetVO();
			try{
				calleToUpdate=(StreetVO)object;
				
				historicoUpdateRecord.setSfidRecord(calleToUpdate.getSfid());
				
				//1.1- Seteamos los campos a actualizar distintos de String	
				Date createddate=calleToUpdate.getCreatedDate();
				Date lastmodifieddate=calleToUpdate.getLastModifiedDate();

				//1.2-Construimos la query							
				Query sqlUpdateQuery =session.createQuery("UPDATE StreetVO SET "
				+ "createddate="+createddate+",lastmodifieddate="+lastmodifieddate+",name= :name,"
				+ "recordtypeid= :recordtypeid,currencyisocode= :currencyisocode,region__c= :region__c,"
				+ "literal_region__c= :literal_region__c,municipality__c= :municipality__c,"
				+ "literal_municipality__c= :literal_municipality__c,street__c= :street__c,"
				+ "street_type__c= :street_type__c,literal_street_type__c= :literal_street_type__c,"
				+ "lastmodifiedbyid= :lastmodifiedbyid,createdbyid= :createdbyid,ownerid= :ownerid,"
				+ "country__c= :country__c,company__c= :company__c"					

				+	
				" WHERE sfid = :sfidFiltro");
				
				//1.3-Seteamos los campos a actualizar de tipo String	
				
				    //1.3.1-Seteamos los campos que no filtren la query						
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
					
					//1.3.2-Seteamos el sfid,campo por el que filtramos la query		
					sqlUpdateQuery.setParameter("sfidFiltro", calleToUpdate.getSfid());

				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateCalle ---" + calleToUpdate.getSfid());
				
				historicoUpdateRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoUpdateRecord);
				cont++;
			} catch (HibernateException e) {
			logger.error("--- Error en updateCalle: ---" + calleToUpdate.getSfid(), e);
			historicoUpdateRecord.setSuccess(false);
			historicoUpdateRecord.setErrorCause(ConstantesBatch.ERROR_UPDATE_RECORD);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
			} 						
		}
		logger.debug("--- Fin -- update Listado Calles ---");
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
		return historicoProcessUpdate.getSuccess();

	}
		
	/**
	 * Borra un listado de calles venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public boolean deleteStreetListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Calles ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessDelete = new HistoricBatchVO();
		historicoProcessDelete.setStartDate(new Date());
		historicoProcessDelete.setOperation(ConstantesBatch.DELETE_PROCESS);
		historicoProcessDelete.setTotalRecords(objectList.size());
		historicoProcessDelete.setObject(ConstantesBatch.OBJECT_STREET);
		historicoProcessDelete.setProcessId(processId);

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_STREET);
			historicoDeleteRecord.setProcessId(processId);
			
			StreetVO calleToDelete = new StreetVO();
			try{
				calleToDelete=(StreetVO)object;
				
				historicoDeleteRecord.setSfidRecord(calleToDelete.getSfid());
				
				Query sqlDeleteQuery =session.createQuery("DELETE StreetVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", calleToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteCalle ---" + calleToDelete.getSfid());
				
				historicoDeleteRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoDeleteRecord);
				cont++;
			} catch (HibernateException e) {
			logger.error("--- Error en deleteCalle: ---" + calleToDelete.getSfid(), e);
			historicoDeleteRecord.setSuccess(false);
			historicoDeleteRecord.setErrorCause(ConstantesBatch.ERROR_DELETE_RECORD);
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
			} 					
		}
		logger.debug("--- Fin -- delete Listado Calles ---");
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
		return historicoProcessDelete.getSuccess();

	}
	
	
	
	
	

	



}