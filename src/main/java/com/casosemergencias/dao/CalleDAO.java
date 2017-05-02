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
	public int insertStreetListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Calles ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		StreetVO  calleToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_STREET);
			historicoInsertRecord.setProcessId(processId);
			calleToInsert = new StreetVO();
			
			try {
				calleToInsert = (StreetVO) object;
				historicoInsertRecord.setSfidRecord(calleToInsert.getSfid());
				session.save(calleToInsert);
				
				logger.debug("--- Fin -- insertCalle ---" + calleToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en insertCalle: ---" + calleToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}

			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado Calles ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de calles venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateStreetListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Calles ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		StreetVO calleToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_STREET);
			historicoUpdateRecord.setProcessId(processId);
			calleToUpdate = new StreetVO();
			
			try {
				calleToUpdate = (StreetVO) object;
				historicoUpdateRecord.setSfidRecord(calleToUpdate.getSfid());
				//1.1-Construimos la query							
				Query sqlUpdateQuery =session.createQuery("UPDATE StreetVO "
													   + "    SET createddate = :createddate"
													   + "		, lastmodifieddate = :lastmodifieddate"
													   + "		, name = :name"
													   + "		, recordtypeid = :recordtypeid"
													   + "		, currencyisocode = :currencyisocode"
													   + "		, region__c = :region__c"
													   + "		, literal_region__c = :literal_region__c"
													   + "		, municipality__c = :municipality__c"
													   + "		, literal_municipality__c = :literal_municipality__c"
													   + "		, street__c = :street__c"
													   + "		, street_type__c = :street_type__c"
													   + "		, literal_street_type__c = :literal_street_type__c"
													   + "		, lastmodifiedbyid = :lastmodifiedbyid"
													   + "		, createdbyid = :createdbyid"
													   + "		, ownerid = :ownerid"
													   + "		, country__c = :country__c"
													   + "		, company__c = :company__c"					
													   + "  WHERE sfid = :sfidFiltro");
				
				//1.2-Seteamos los campos de la query
				sqlUpdateQuery.setTimestamp("createddate", calleToUpdate.getCreatedDate());
				sqlUpdateQuery.setTimestamp("lastmodifieddate", calleToUpdate.getLastModifiedDate());
				sqlUpdateQuery.setString("name", calleToUpdate.getName());
				sqlUpdateQuery.setString("recordtypeid", calleToUpdate.getRecordTypeId());
				sqlUpdateQuery.setString("currencyisocode", calleToUpdate.getCurrencyIsoCode());
				sqlUpdateQuery.setString("region__c", calleToUpdate.getRegion());
				sqlUpdateQuery.setString("literal_region__c", calleToUpdate.getLiteralRegion());
				sqlUpdateQuery.setString("municipality__c", calleToUpdate.getMunicipality());
				sqlUpdateQuery.setString("literal_municipality__c", calleToUpdate.getLiteralMunicipality());
				sqlUpdateQuery.setString("street__c", calleToUpdate.getStreet());
				sqlUpdateQuery.setString("street_type__c", calleToUpdate.getStreetType());
				sqlUpdateQuery.setString("literal_street_type__c", calleToUpdate.getLiteralStreetType());
				sqlUpdateQuery.setString("lastmodifiedbyid", calleToUpdate.getLastModifiedById());
				sqlUpdateQuery.setString("createdbyid", calleToUpdate.getCreatedById());
				sqlUpdateQuery.setString("ownerid", calleToUpdate.getOwnerId());
				sqlUpdateQuery.setString("country__c", calleToUpdate.getCountry());
				sqlUpdateQuery.setString("company__c", calleToUpdate.getCompany());
				sqlUpdateQuery.setString("sfidFiltro", calleToUpdate.getSfid());

				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				logger.debug("--- Fin -- updateCalle ---" + calleToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateCalle: ---" + calleToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			} 

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado Calles ---");
		session.close();
		return processedRecords;
	}
	
	/**
	 * Borra un listado de calles venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteStreetListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Calles ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		StreetVO calleToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_STREET);
			historicoDeleteRecord.setProcessId(processId);
			calleToDelete = new StreetVO();
			
			try {
				calleToDelete = (StreetVO) object;
				historicoDeleteRecord.setSfidRecord(calleToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE StreetVO  WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setString("sfidFiltro", calleToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteCalle ---" + calleToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteCalle: ---" + calleToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			} 

			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado Calles ---");
		session.close();
		return processedRecords;
	}
}