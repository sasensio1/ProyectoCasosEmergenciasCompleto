package com.casosemergencias.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.casosemergencias.dao.vo.DireccionVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class DireccionDAO {
	final static Logger logger = Logger.getLogger(DireccionDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	HistoricBatchDAO historicBatchDAO;

	/**
	 * Inserta un listado de Direcciones venidos de Salesforce en BBDD de
	 * Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int insertDireccionListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Direcciones ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		DireccionVO direccionToInsert = null;

		// Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();

		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_ADDRESS);
			historicoInsertRecord.setProcessId(processId);
			direccionToInsert = new DireccionVO();

			try {
				direccionToInsert = (DireccionVO) object;
				historicoInsertRecord.setSfidRecord(direccionToInsert.getSfid());
				session.save(direccionToInsert);

				logger.debug("--- Fin -- insertDireccion ---" + direccionToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en insertDireccion: ---" + direccionToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}

			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado Direcciones ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de direcciones venidos de Salesforce en BBDD de
	 * Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateDireccionListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Direcciones ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		DireccionVO direccionToUpdate = null;

		// Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();

		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_ADDRESS);
			historicoUpdateRecord.setProcessId(processId);
			direccionToUpdate = new DireccionVO();

			try {
				direccionToUpdate = (DireccionVO) object;
				historicoUpdateRecord.setSfidRecord(direccionToUpdate.getSfid());
				//1.1-Construimos la query
				Query sqlUpdateQuery = session.createQuery("UPDATE DireccionVO "
														+ "    SET createddate = :createddate"
														+ "		 , region__c = :region__c"
														+ "		 , municipality__c = :municipality__c"
														+ "		 , street_type__c = :street_type__c"
														+ "		 , streetmd__c = :streetmd__c"
														+ "		 , number__c= :number__c"
														+ "		 , department__c= :department__c"
														+ "		 , name = :name"
														+ "	     , concatenatedaddress__c = :concatenatedaddress__c"
														+ "		 , corner__c = :corner__c"
														+ "  WHERE sfid = :sfidFiltro");

				//1.2-Seteamos los campos
				sqlUpdateQuery.setTimestamp("createddate", direccionToUpdate.getCreateddate());
				sqlUpdateQuery.setString("region__c", direccionToUpdate.getRegion());
				sqlUpdateQuery.setString("municipality__c", direccionToUpdate.getComuna());
				sqlUpdateQuery.setString("street_type__c", direccionToUpdate.getTipoCalle());
				sqlUpdateQuery.setString("streetmd__c", direccionToUpdate.getCalle());
				sqlUpdateQuery.setString("number__c", direccionToUpdate.getNumero());
				sqlUpdateQuery.setString("department__c", direccionToUpdate.getDepartamento());
				sqlUpdateQuery.setString("name", direccionToUpdate.getName());
				sqlUpdateQuery.setString("concatenatedaddress__c", direccionToUpdate.getDireccionConcatenada());
				sqlUpdateQuery.setString("corner__c", direccionToUpdate.getEsquina());
				sqlUpdateQuery.setString("sfidFiltro", direccionToUpdate.getSfid());

				// 1.3-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				logger.debug("--- Fin -- updateDireccion ---" + direccionToUpdate.getSfid());

				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateDireccion: ---" + direccionToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			} 

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado Direcciones ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Borra un listado de direcciones venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteDireccionListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Direcciones ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		DireccionVO direccionToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_ADDRESS);
			historicoDeleteRecord.setProcessId(processId);
			direccionToDelete = new DireccionVO();
			
			try {
				direccionToDelete = (DireccionVO) object;
				historicoDeleteRecord.setSfidRecord(direccionToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE DireccionVO  WHERE sfid = :sfidFiltro");
				// Seteamos el campo por el que filtramos el borrado
				sqlDeleteQuery.setParameter("sfidFiltro", direccionToDelete.getSfid());
				// Ejecutamos la actualizacion
				sqlDeleteQuery.executeUpdate();
				
				logger.debug("--- Fin -- deleteDireccion ---" + direccionToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteDireccion: ---" + direccionToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			} 

			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado Direcciones ---");
		session.close();
		return processedRecords;
	}
}