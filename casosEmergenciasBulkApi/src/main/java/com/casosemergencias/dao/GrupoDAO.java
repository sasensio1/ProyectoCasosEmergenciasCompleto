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

import com.casosemergencias.dao.vo.GroupVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class GrupoDAO {
	final static Logger logger = Logger.getLogger(AccountDAO.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
	/**
	 * Inserta un listado de Grupos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int insertGroupListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Grupos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		GroupVO grupoToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_GROUP);
			historicoInsertRecord.setProcessId(processId);
			grupoToInsert = new GroupVO();
			
			try {
				grupoToInsert = (GroupVO) object;
				historicoInsertRecord.setSfidRecord(grupoToInsert.getSfid());
				session.save(grupoToInsert);

				logger.debug("--- Fin -- insertGrupo ---" + grupoToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en insertGrupo: ---" + grupoToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}
			
			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado Grupos ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de grupos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateGroupListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Grupos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		GroupVO grupoToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
				
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_GROUP);
			historicoUpdateRecord.setProcessId(processId);
			grupoToUpdate = new GroupVO();
			
			try {
				grupoToUpdate = (GroupVO) object;
				historicoUpdateRecord.setSfidRecord(grupoToUpdate.getSfid());
				//1.1-Construimos la query							
				Query sqlUpdateQuery = session.createQuery("UPDATE GroupVO "
														+ "    SET name = :name"
														+ "		 , createddate = :createddate"		
														+ "  WHERE sfid = :sfidFiltro");
				
				//1.2-Seteamos los campos					
				sqlUpdateQuery.setString("name", grupoToUpdate.getName());
				sqlUpdateQuery.setTimestamp("createddate", grupoToUpdate.getCreateddate());
				sqlUpdateQuery.setString("sfidFiltro", grupoToUpdate.getSfid());
				
				//1.3-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				logger.debug("--- Fin -- updateGrupo ---" + grupoToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateGrupo: ---" + grupoToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			} 

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado Grupos ---");
		session.close();
		return processedRecords;
	}
	
	/**
	 * Borra un listado de grupos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteGroupListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Grupos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		GroupVO grupoToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_GROUP);
			historicoDeleteRecord.setProcessId(processId);
			grupoToDelete = new GroupVO();
			
			try {
				grupoToDelete = (GroupVO) object;
				historicoDeleteRecord.setSfidRecord(grupoToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE GroupVO  WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setString("sfidFiltro", grupoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
				
				logger.debug("--- Fin -- deleteGrupo ---" + grupoToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteGrupo: ---" + grupoToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			}

			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado Grupos ---");
		session.close();
		return processedRecords;
	}	
}