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

import com.casosemergencias.dao.vo.HerokuUserVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;


@Repository
public class HerokuUserDAO {
	
	final static Logger logger = Logger.getLogger(HerokuUserDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
	/**
	 * Inserta un listado de UsuarioHerokus venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int insertHerokuUserListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado UsuarioHerokus ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		HerokuUserVO usuarioHerokuToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_HEROKU_USER);
			historicoInsertRecord.setProcessId(processId);
			usuarioHerokuToInsert = new HerokuUserVO();
			
			try {
				usuarioHerokuToInsert = (HerokuUserVO) object;
				historicoInsertRecord.setSfidRecord(usuarioHerokuToInsert.getSfid());
				session.save(usuarioHerokuToInsert);
				
				logger.debug("--- Fin -- insertUsuarioHeroku ---" + usuarioHerokuToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en insertUsuarioHeroku: ---" + usuarioHerokuToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}
			
			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado UsuarioHerokus ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de usuarioHerokus venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateHerokuUserListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado UsuarioHerokus ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		HerokuUserVO usuarioHerokuToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
				
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_HEROKU_USER);
			historicoUpdateRecord.setProcessId(processId);
			usuarioHerokuToUpdate = new HerokuUserVO();
			
			try {
				usuarioHerokuToUpdate = (HerokuUserVO) object;
				historicoUpdateRecord.setSfidRecord(usuarioHerokuToUpdate.getSfid());
				//1.2-Construimos la query			
				Query sqlUpdateQuery = session.createQuery("UPDATE HerokuUserVO "
														+ "	   SET name = :name"
														+ "		 , username__c = :username__c"
														+ "		 , password__c = :password__c"
														+ "		 , mail__c = :mail__c"
														+ "		 , sentmail__c = :sentmail__c"
														+ "		 , active__c = :active__c"
														+ "		 , country__c = :country__c"
														+ "		 , unity__c = :unity__c"				
														+ "  WHERE sfid = :sfidFiltro");
				
				//1.2-Seteamos los campos
				sqlUpdateQuery.setString("name", usuarioHerokuToUpdate.getName());
				sqlUpdateQuery.setString("username__c", usuarioHerokuToUpdate.getUsername());
				sqlUpdateQuery.setString("password__c", usuarioHerokuToUpdate.getPassword());
				sqlUpdateQuery.setString("mail__c", usuarioHerokuToUpdate.getEmail());
				sqlUpdateQuery.setBoolean("sentmail__c", usuarioHerokuToUpdate.getEnvioMail());
				sqlUpdateQuery.setBoolean("active__c", usuarioHerokuToUpdate.getActivo());
				sqlUpdateQuery.setString("country__c", usuarioHerokuToUpdate.getCountry());
				sqlUpdateQuery.setString("unity__c", usuarioHerokuToUpdate.getUnidad());
				sqlUpdateQuery.setString("sfidFiltro", usuarioHerokuToUpdate.getSfid());
				
				//1.3-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				logger.debug("--- Fin -- updateUsuarioHeroku ---" + usuarioHerokuToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateUsuarioHeroku: ---" + usuarioHerokuToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			} 

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado UsuarioHerokus ---");
		session.close();
		return processedRecords;
	}
		
	/**
	 * Borra un listado de usuarioHerokus venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteHerokuUserListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado UsuarioHerokus ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		HerokuUserVO usuarioHerokuToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_HEROKU_USER);
			historicoDeleteRecord.setProcessId(processId);
			usuarioHerokuToDelete = new HerokuUserVO();
			
			try {
				usuarioHerokuToDelete = (HerokuUserVO) object;
				historicoDeleteRecord.setSfidRecord(usuarioHerokuToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE HerokuUserVO WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setString("sfidFiltro", usuarioHerokuToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
				
				logger.debug("--- Fin -- deleteUsuarioHeroku ---" + usuarioHerokuToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteUsuarioHeroku: ---" + usuarioHerokuToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			} 

			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado UsuarioHerokus ---");
		session.close();
		return processedRecords;
	}
}