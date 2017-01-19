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
import com.casosemergencias.dao.vo.TaskVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class TaskDAO {

final static Logger logger = Logger.getLogger(TaskDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;

	/**
	 * Devuelve una lista con todas las Task de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TaskVO> readAllTask() {
		logger.debug("--- Inicio -- readAllUser ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from TaskVO");
			List<TaskVO> taskList = query.list(); 

			logger.debug("--- Fin -- readAllUser ---");
			
			return taskList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAllTask ", e); 
	    	logger.error("--- Fin -- readAllTask ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve la Task que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de una Task
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public TaskVO readTaskById(Integer id) {
		logger.debug("--- Inicio -- readTaskById ---");
		
		Session session = sessionFactory.openSession();
			
		try {
			Query query = session.createQuery("from TaskVO as task WHERE task.id = :id");
			query.setInteger("id", id);
			
			List<TaskVO> taskList = query.list(); 

			if(taskList != null && !taskList.isEmpty()){
				return taskList.get(0);
			}			
			
			logger.debug("--- Fin -- readTaskById ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readTaskById ", e); 
	    	logger.error("--- Fin -- readTaskById ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve una task que tiene como id. el pasado por parámetro al método.
	 * 
	 * @param sfid Id. del task.
	 * @return TaskVO Datos de la task.
	 */
	@SuppressWarnings("unchecked")
	public TaskVO readTaskBySfid(String sfid) {
		logger.debug("--- Inicio -- readTaskBySfid ---");
		Session session = sessionFactory.openSession();
		
		try {
			Query query = session.createQuery("from TaskVO task WHERE task.sfid = :sfid ");
			query.setString("sfid", sfid);
			List<TaskVO> taskList = query.list(); 
			
			if (taskList != null && !taskList.isEmpty()) {
				return taskList.get(0);
			}

			logger.debug("--- Fin -- readTaskBySfid ---");
	    } catch (HibernateException e) {
	    	logger.error("--- readTaskBySfid ", e); 
	    	logger.error("--- Fin -- readTaskBySfid ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}

	/**
	 * Inserta un listado de Tasks venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public boolean insertTaskListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Tareas ---");

		Integer cont = 0;
		
		HistoricBatchVO historicoProcessInsert = new HistoricBatchVO();
		historicoProcessInsert.setStartDate(new Date());
		historicoProcessInsert.setOperation(ConstantesBatch.INSERT_PROCESS);
		historicoProcessInsert.setTotalRecords(objectList.size());
		historicoProcessInsert.setObject(ConstantesBatch.OBJECT_TASK);
		historicoProcessInsert.setProcessId(processId);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			
			HistoricBatchVO historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_TASK);
			historicoInsertRecord.setProcessId(processId);
			
			TaskVO taskToInsert = new TaskVO();
			try{
				taskToInsert=(TaskVO)object;
				
				historicoInsertRecord.setSfidRecord(taskToInsert.getSfid());
				
				session.save(taskToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertTaskListSf ---" + taskToInsert.getSfid());
				
				historicoInsertRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoInsertRecord);
				cont++;
				
			} catch (HibernateException e) {
				tx.rollback();
				logger.error("--- Error en insertTaskListSf: ---" + taskToInsert.getSfid(), e);
				historicoInsertRecord.setSuccess(false);
				historicoInsertRecord.setErrorCause(ConstantesBatch.ERROR_INSERT_RECORD);
				historicBatchDAO.insertHistoric(historicoInsertRecord);
			}						
		}
		logger.debug("--- Fin -- insertTaskListSf ---");
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
	 * Actualiza un listado de tasks venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public boolean updateTaskListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Tasks ---");

		Integer cont = 0;
		
		HistoricBatchVO historicoProcessUpdate = new HistoricBatchVO();
		historicoProcessUpdate.setStartDate(new Date());
		historicoProcessUpdate.setOperation(ConstantesBatch.UPDATE_PROCESS);
		historicoProcessUpdate.setTotalRecords(objectList.size());
		historicoProcessUpdate.setObject(ConstantesBatch.OBJECT_TASK);
		historicoProcessUpdate.setProcessId(processId);
		
		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_TASK);
			historicoUpdateRecord.setProcessId(processId);
			
			TaskVO taskToUpdate = new TaskVO();
			try{
				taskToUpdate=(TaskVO)object;
				
				historicoUpdateRecord.setSfidRecord(taskToUpdate.getSfid());
				
				//1.1- Seteamos los campos a actualizar distintos de String			
				Date createddate=taskToUpdate.getCreatedDate();
				Date activitydate=taskToUpdate.getActivityDate();

				//1.2-Construimos la query							
				Query sqlUpdateQuery =session.createQuery("UPDATE TaskVO SET "
				+ "tasktype__c= :tasktype__c,activitydate="+activitydate+","
				+ "calldisposition= :calldisposition,casephone__c= :casephone__c,"
				+ "status= :status,description= :description,"
				+ "createddate="+createddate+",subject= :subject,priority= :priority,whoid= :whoid,"
				+ "accountid= :accountid,ownerid= :ownerid,tasksubtype= :tasksubtype,"					
				+ " WHERE sfid = :sfidFiltro");
							
				//1.3-Seteamos los campos a actualizar de tipo String	
				
				    //1.3.1-Seteamos los campos que no filtren la query						
					sqlUpdateQuery.setParameter("tasktype__c", taskToUpdate.getTaskType());
					sqlUpdateQuery.setParameter("calldisposition", taskToUpdate.getCallDisposition());
					sqlUpdateQuery.setParameter("casephone__c", taskToUpdate.getCasePhone());
					sqlUpdateQuery.setParameter("status", taskToUpdate.getStatus());
					sqlUpdateQuery.setParameter("description", taskToUpdate.getDescription());
					sqlUpdateQuery.setParameter("subject", taskToUpdate.getSubject());
					sqlUpdateQuery.setParameter("priority", taskToUpdate.getPriority());
					sqlUpdateQuery.setParameter("whoid", taskToUpdate.getWhoId());
					sqlUpdateQuery.setParameter("accountid", taskToUpdate.getAccountId());
					sqlUpdateQuery.setParameter("ownerid", taskToUpdate.getOwnerId());
					sqlUpdateQuery.setParameter("tasksubtype", taskToUpdate.getTaskSubtype());
					
					//1.3.2-Seteamos el sfid,campo por el que filtramos la query								
					sqlUpdateQuery.setParameter("sfidFiltro", taskToUpdate.getSfid());
					
				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateTaskListSf ---" + taskToUpdate.getSfid());
				
				historicoUpdateRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoUpdateRecord);
				cont++;
				
			} catch (HibernateException e) {
				logger.error("--- Error en updateTaskListSf: ---" + taskToUpdate.getSfid(), e);
				historicoUpdateRecord.setSuccess(false);
				historicoUpdateRecord.setErrorCause(ConstantesBatch.ERROR_UPDATE_RECORD);
				historicBatchDAO.insertHistoric(historicoUpdateRecord);
			} 						
		}
		logger.debug("--- Fin -- update Listado Tasks ---");
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
	 * Borra un listado de tasks venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public boolean deleteTaskListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Tareas ---");
		
		Integer cont = 0;
		
		HistoricBatchVO historicoProcessDelete = new HistoricBatchVO();
		historicoProcessDelete.setStartDate(new Date());
		historicoProcessDelete.setOperation(ConstantesBatch.DELETE_PROCESS);
		historicoProcessDelete.setTotalRecords(objectList.size());
		historicoProcessDelete.setObject(ConstantesBatch.OBJECT_TASK);
		historicoProcessDelete.setProcessId(processId);

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_TASK);
			historicoDeleteRecord.setProcessId(processId);
			
			TaskVO taskToDelete = new TaskVO();
			try{
				taskToDelete=(TaskVO)object;
				
				historicoDeleteRecord.setSfidRecord(taskToDelete.getSfid());
				
				Query sqlDeleteQuery =session.createQuery("DELETE TaskVO WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", taskToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteTaskListSf ---" + taskToDelete.getSfid());
				
				historicoDeleteRecord.setSuccess(true);
				historicBatchDAO.insertHistoric(historicoDeleteRecord);
				cont++;
				
			} catch (HibernateException e) {
			logger.error("--- Error en deleteTaskListSf: ---" + taskToDelete.getSfid(), e);
			historicoDeleteRecord.setSuccess(false);
			historicoDeleteRecord.setErrorCause(ConstantesBatch.ERROR_DELETE_RECORD);
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
			} 					
		}
		logger.debug("--- Fin -- delete Listado Tasks ---");
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