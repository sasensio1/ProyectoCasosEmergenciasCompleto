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

import com.casosemergencias.dao.vo.CaseHistoryVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class CaseHistoryDAO {
	
	final static Logger logger = Logger.getLogger(CaseHistoryDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;

	/**
	 * Devuelve una lista con todas los CaseHistory de un caseId. No se recuperan los registros que en newvalue tiene longitud 18 y no tienen espacios ni puntos (suponemos que 
	 * es un sfid y no lo tenemos que tener en cuenta)
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CaseHistoryVO> readCaseHistoryByCaseId(String caseId, Integer limiteRegistros) {
		logger.debug("--- Inicio -- readCaseHistoryByCaseId ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from CaseHistoryVO as caseHistory "
					+ " left join fetch caseHistory.fieldPickList fieldPick "
					+ " left join fetch caseHistory.newValuePickList newValuePick  "
					+ " left join fetch caseHistory.oldValuePickList oldValuePick  "
					+ " left join fetch caseHistory.fieldLabel fielLabelDesc  "					
					+ " WHERE caseHistory.caseid = :caseId and "
					+ " caseHistory.sfid not in(SELECT sfid FROM CaseHistoryVO as subhistorial "
					+ " WHERE subhistorial.caseid = :caseId AND (LENGTH(subhistorial.newvalue) = 18 and LOCATE(subhistorial.newvalue, ' ') = 0 and  LOCATE(subhistorial.newvalue, '.') = 0))"
					+ " ORDER BY caseHistory.caseid, caseHistory.createddate DESC, fieldPick.valor DESC, caseHistory.field DESC");
			query.setString("caseId", caseId);
			
			
			if(limiteRegistros != null){
				query = query.setMaxResults(limiteRegistros);
			}
			
			List<CaseHistoryVO> caseHistoryList = query.list(); 

			logger.debug("--- Fin -- readCaseHistoryByCaseId ---");
			
			return caseHistoryList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readCaseHistoryByCaseId ", e); 
	    	logger.error("--- Fin -- readCaseHistoryByCaseId ---");
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
	public List<CaseHistoryVO> readAllCaseHistory() {
		logger.debug("--- Inicio -- readAllCaseHistory ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from CaseHistoryVO");
			List<CaseHistoryVO> caseHistoryList = query.list(); 

			logger.debug("--- Fin -- readAllCaseHistory ---");
			
			return caseHistoryList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAllCaseHistory ", e); 
	    	logger.error("--- Fin -- readAllCaseHistory ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve el CaseHistory que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un CaseHistory
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public CaseHistoryVO readCaseHistoryById(Integer id) {
		
		logger.debug("--- Inicio -- readCaseHistoryById ---");
		
		Session session = sessionFactory.openSession();
			
		try {
			Query query = session.createQuery("from CaseHistoryVO as caseHistory WHERE caseHistory.id = :id");
			query.setInteger("id", id);
			
			List<CaseHistoryVO> caseHistoryList = query.list(); 

			if(caseHistoryList != null && !caseHistoryList.isEmpty()){
				return caseHistoryList.get(0);
			}			
			
			logger.debug("--- Fin -- readCaseHistoryById ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readCaseHistoryById ", e); 
	    	logger.error("--- Fin -- readCaseHistoryById ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve una CaseHistory que tiene como id. el pasado por parámetro al método.
	 * 
	 * @param sfid Id. del CaseHistory.
	 * @return CaseHistoryVO
	 */
	@SuppressWarnings("unchecked")
	public CaseHistoryVO readCaseHistoryBySfid(String sfid) {
		logger.debug("--- Inicio -- readCaseHistoryBySfid ---");
		Session session = sessionFactory.openSession();
		
		try {
			Query query = session.createQuery("from CaseHistoryVO caseHistory WHERE caseHistory.sfid = :sfid ");
			query.setString("sfid", sfid);
			List<CaseHistoryVO> caseHistoryList = query.list(); 
			
			if (caseHistoryList != null && !caseHistoryList.isEmpty()) {
				return caseHistoryList.get(0);
			}
			
			logger.debug("--- Fin -- readCaseHistoryBySfid ---");
	    } catch (HibernateException e) {
	    	logger.error("--- readCaseHistoryBySfid ", e); 
	    	logger.error("--- Fin -- readCaseHistoryBySfid ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve el número de entradas en el historia de un caso. Tenemos que tener cuidado con los casos en los que se modifica el user, en estos casoso
	 * se guardan dos registors, una con el sfid y otra con el nombre, no contamos los campos que tienen longitud 18 y no tienen ni espacios ni puntos
	 * 
	 * @return
	 */
	public Integer countHistoriaDeCaso(String sfidCaso) {
		logger.debug("--- Inicio -- countHistoriaDeCaso ---");
		
		Session session = sessionFactory.openSession();
		
		try {
			/*
			 select field, casehistory.newvalue, createdbyid, createddate
			from salesforce.casehistory
			where caseid = '5005B000000zEo3QAE' 
					and sfid not in(SELECT sfid
					FROM casehistory
					WHERE caseid = '5005B000000zEo3QAE' 
							AND (LENGTH(newvalue) = 18 and POSITION(' ' IN newvalue) = 0 and  POSITION('.' IN newvalue) = 0));
			*/

			StringBuilder sqlQuery = new StringBuilder("SELECT count(sfid) FROM CaseHistoryVO as historial ");
			sqlQuery.append(" WHERE historial.caseid = :sfidCaso "
					+ " and historial.sfid not in(SELECT sfid FROM CaseHistoryVO as subhistorial "
					+ " WHERE caseid = :sfidCaso AND (LENGTH(subhistorial.newvalue) = 18 and LOCATE(subhistorial.newvalue, ' ') = 0 and  LOCATE(subhistorial.newvalue, '.') = 0))");
					
			Query query = session.createQuery(sqlQuery.toString());
			query.setString("sfidCaso", sfidCaso);
			
			Long count = (Long) query.uniqueResult();
			
//			StringBuilder sqlQuery = new StringBuilder("SELECT count(distinct(historial.field || historial.createdbyid || historial.createddate)) FROM salesforce.casehistory as historial ");
//			sqlQuery.append(" WHERE historial.caseid = '" + sfidCaso + "'");
//			
//			Query query = session.createSQLQuery(sqlQuery.toString());
//						
//			BigInteger count = (BigInteger) query.uniqueResult();
			
			logger.debug("--- Fin -- countHistoriaDeCaso ---");
			
			return count.intValue();
			
	    } catch (HibernateException e) {
	    	logger.error("--- countHistoriaDeCaso ", e); 
	    	logger.error("--- Fin -- countHistoriaDeCaso ---");
	    } finally {
	    	session.close(); 
	    }
		return null;
	}
	
	
	
	
	
	
	/**
	 * Inserta un listado de HistorialCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public boolean insertCaseHistoryListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado HistorialCasos ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessInsert = new HistoricBatchVO();
		historicoProcessInsert.setStartDate(new Date());
		historicoProcessInsert.setOperation(ConstantesBatch.INSERT_PROCESS);
		historicoProcessInsert.setTotalRecords(objectList.size());
		historicoProcessInsert.setObject(ConstantesBatch.OBJECT_CASE_HISTORY);
		historicoProcessInsert.setProcessId(processId);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			
			HistoricBatchVO historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_CASE_HISTORY);
			historicoInsertRecord.setProcessId(processId);
			
			CaseHistoryVO historialCasoToInsert = new CaseHistoryVO();
			try{
				historialCasoToInsert=(CaseHistoryVO)object;
				
				historicoInsertRecord.setSfidRecord(historialCasoToInsert.getSfid());
				
				session.save(historialCasoToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertHistorialCaso ---" + historialCasoToInsert.getSfid());
				
				historicoInsertRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoInsertRecord);
				cont++;
				
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertHistorialCaso: ---" + historialCasoToInsert.getSfid(), e);
			historicoInsertRecord.setSuccess(false);
			historicoInsertRecord.setErrorCause(ConstantesBatch.ERROR_INSERT_RECORD);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
			}						
		}
		logger.debug("--- Fin -- insert Listado HistorialCasos ---");
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
	 * Actualiza un listado de historialCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public boolean updateCaseHistoryListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado HistorialCasos ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessUpdate = new HistoricBatchVO();
		historicoProcessUpdate.setStartDate(new Date());
		historicoProcessUpdate.setOperation(ConstantesBatch.UPDATE_PROCESS);
		historicoProcessUpdate.setTotalRecords(objectList.size());
		historicoProcessUpdate.setObject(ConstantesBatch.OBJECT_CASE_HISTORY);
		historicoProcessUpdate.setProcessId(processId);
		
		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_CASE_HISTORY);
			historicoUpdateRecord.setProcessId(processId);
			
			CaseHistoryVO historialCasoToUpdate = new CaseHistoryVO();
			//1.1- Seteamos los campos a actualizar distintos de String				
			Date createddate=historialCasoToUpdate.getCreateddate();
			
			//1.2-Construimos la query							
			try{
				historialCasoToUpdate=(CaseHistoryVO)object;
				
				historicoUpdateRecord.setSfidRecord(historialCasoToUpdate.getSfid());
				
				Query sqlUpdateQuery =session.createQuery("UPDATE CaseHistoryVO SET "
				+ "createdbyid= :createdbyid,createddate="+createddate+",newvalue= :newvalue,"
				+ "oldvalue= :oldvalue,field= :field,caseid= :caseid"
				+
				
				" WHERE sfid = :sfidFiltro");
				
				//1.3-Seteamos los campos a actualizar de tipo String	
				
					//1.3.1-Seteamos el campos que no filtren la query						
					sqlUpdateQuery.setParameter("createdbyid", historialCasoToUpdate.getCreatedbyid());
					sqlUpdateQuery.setParameter("newvalue", historialCasoToUpdate.getNewvalue());
					sqlUpdateQuery.setParameter("oldvalue", historialCasoToUpdate.getOldvalue());
					sqlUpdateQuery.setParameter("field", historialCasoToUpdate.getField());
					sqlUpdateQuery.setParameter("caseid", historialCasoToUpdate.getCaseid());
					
					//1.3.2-Seteamos el sfid,campo por el que filtramos la query				
					sqlUpdateQuery.setParameter("sfidFiltro", historialCasoToUpdate.getSfid());					
								
				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateHistorialCaso ---" + historialCasoToUpdate.getSfid());
				
				historicoUpdateRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoUpdateRecord);
				cont++;
				
			} catch (HibernateException e) {
			logger.error("--- Error en updateHistorialCaso: ---" + historialCasoToUpdate.getSfid(), e);
			historicoUpdateRecord.setSuccess(false);
			historicoUpdateRecord.setErrorCause(ConstantesBatch.ERROR_UPDATE_RECORD);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
			} 						
		}
		logger.debug("--- Fin -- update Listado HistorialCasos ---");
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
	 * Borra un listado de historialCasos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public boolean deleteCaseHistoryListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado HistorialCasos ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessDelete = new HistoricBatchVO();
		historicoProcessDelete.setStartDate(new Date());
		historicoProcessDelete.setOperation(ConstantesBatch.DELETE_PROCESS);
		historicoProcessDelete.setTotalRecords(objectList.size());
		historicoProcessDelete.setObject(ConstantesBatch.OBJECT_CASE_HISTORY);
		historicoProcessDelete.setProcessId(processId);

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_CASE_HISTORY);
			historicoDeleteRecord.setProcessId(processId);
			
			CaseHistoryVO historialCasoToDelete = new CaseHistoryVO();
			try{
				historialCasoToDelete=(CaseHistoryVO)object;
				
				historicoDeleteRecord.setSfidRecord(historialCasoToDelete.getSfid());
				
				Query sqlDeleteQuery =session.createQuery("DELETE CaseHistoryVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", historialCasoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteHistorialCaso ---" + historialCasoToDelete.getSfid());
				
				historicoDeleteRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoDeleteRecord);
				cont++;
				
			} catch (HibernateException e) {
			logger.error("--- Error en deleteHistorialCaso: ---" + historialCasoToDelete.getSfid(), e);
			historicoDeleteRecord.setSuccess(false);
			historicoDeleteRecord.setErrorCause(ConstantesBatch.ERROR_DELETE_RECORD);
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
			} 					
		}
		logger.debug("--- Fin -- delete Listado HistorialCasos ---");
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
