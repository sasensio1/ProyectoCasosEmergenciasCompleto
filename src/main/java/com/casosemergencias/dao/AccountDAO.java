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

import com.casosemergencias.dao.vo.AccountVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class AccountDAO {
	final static Logger logger = Logger.getLogger(AccountDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
	/**
	 * Inserta un listado de Cuentas venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public int insertAccountListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Cuentas ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		AccountVO cuentaToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_ACCOUNT);
			historicoInsertRecord.setProcessId(processId);
			cuentaToInsert = new AccountVO();
			
			try {
				cuentaToInsert = (AccountVO) object;
				historicoInsertRecord.setSfidRecord(cuentaToInsert.getSfid());
				session.save(cuentaToInsert);
				
				logger.debug("--- Fin -- insertCuenta ---" + cuentaToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en insertCuenta: ---" + cuentaToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}
			
			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado Cuentas ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de cuentas venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateAccountListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Cuentas ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		AccountVO cuentaToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
				
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_ACCOUNT);
			historicoUpdateRecord.setProcessId(processId);
			cuentaToUpdate = new AccountVO();
			
			try {
				cuentaToUpdate = (AccountVO) object;
				historicoUpdateRecord.setSfidRecord(cuentaToUpdate.getSfid());
				//1.1-Construimos la query			
				Query sqlUpdateQuery =session.createQuery("UPDATE AccountVO "
													   + "    SET name = :name"
													   + "	    , fatherslastname__c = :fatherslastname__c"
													   + "		, motherslastname__c = :motherslastname__c"
													   + "		, identitytype__c = :identitytype__c"
													   + "		, parent__identityNumber__c = :parent__identityNumber__c"
													   + "		, masterrecord__identitynumber__c = :masterrecord__identitynumber__c"
													   + "		, identitynumber__c = :identitynumber__c"
													   + "		, birthdate__c = :birthdate__c"
													   + "		, phone = :phone"
													   + "		, mainphone__c = :mainphone__c"
													   + "		, secondaryphone__c = :secondaryphone__c"
													   + "		, primaryemail__c = :primaryemail__c"
													   + "		, secondaryemail__c = :secondaryemail__c"
													   + "		, address__c = :address__c"
													   + "		, accountsource = :accountsource"
													   + "		, companyid__c = :companyid__c"
													   + "		, type = :type"
													   + "		, parentid = :parentid"	
													   + "		, recordtypeid = :recordtypeid"	
													   + "  WHERE sfid = :sfidFiltro");
				
				//1.2-Seteamos los campos
				sqlUpdateQuery.setString("name", cuentaToUpdate.getName());
				sqlUpdateQuery.setString("fatherslastname__c", cuentaToUpdate.getApellidoPaterno());
				sqlUpdateQuery.setString("motherslastname__c", cuentaToUpdate.getApellidoMaterno());
				sqlUpdateQuery.setString("identitytype__c", cuentaToUpdate.getTipoIdentidad());
				sqlUpdateQuery.setString("parent__identityNumber__c", cuentaToUpdate.getParentRutEmpresa());
				sqlUpdateQuery.setString("masterrecord__identitynumber__c", cuentaToUpdate.getAccountRun());
				sqlUpdateQuery.setString("identitynumber__c", cuentaToUpdate.getRun());
				sqlUpdateQuery.setTimestamp("birthdate__c", cuentaToUpdate.getFechaNacimiento());
				sqlUpdateQuery.setString("phone", cuentaToUpdate.getPhone());
				sqlUpdateQuery.setString("mainphone__c", cuentaToUpdate.getTelefonoPrincipal());
				sqlUpdateQuery.setString("secondaryphone__c", cuentaToUpdate.getTelefonoSecundario());
				sqlUpdateQuery.setString("primaryemail__c", cuentaToUpdate.getEmailPrincipal());
				sqlUpdateQuery.setString("secondaryemail__c", cuentaToUpdate.getEmailSecundario());
				sqlUpdateQuery.setString("address__c", cuentaToUpdate.getDireccion());
				sqlUpdateQuery.setString("accountsource", cuentaToUpdate.getAccountsource());
				sqlUpdateQuery.setString("companyid__c", cuentaToUpdate.getIdEmpresa());
				sqlUpdateQuery.setString("type", cuentaToUpdate.getTipo());
				sqlUpdateQuery.setString("parentid", cuentaToUpdate.getParentid());
				sqlUpdateQuery.setString("recordtypeid", cuentaToUpdate.getRecordTypeId());
				sqlUpdateQuery.setString("sfidFiltro", cuentaToUpdate.getSfid());
									
				//1.3-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				logger.debug("--- Fin -- updateCuenta ---" + cuentaToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateCuenta: ---" + cuentaToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			} 

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado Cuentas ---");
		session.close();
		return processedRecords;
	}
		
	/**
	 * Borra un listado de cuentas venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteAccountListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Cuentas ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		AccountVO cuentaToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_ACCOUNT);
			historicoDeleteRecord.setProcessId(processId);
			cuentaToDelete = new AccountVO();
			
			try {
				cuentaToDelete = (AccountVO) object;
				historicoDeleteRecord.setSfidRecord(cuentaToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE AccountVO  WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setString("sfidFiltro", cuentaToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
				
				logger.debug("--- Fin -- deleteCuenta ---" + cuentaToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteCuenta: ---" + cuentaToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			} 

			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado Cuentas ---");
		session.close();
		return processedRecords;
	}
}