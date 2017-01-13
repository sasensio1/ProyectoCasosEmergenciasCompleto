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

import com.casosemergencias.dao.vo.TaskVO;

@Repository
public class TaskDAO {

final static Logger logger = Logger.getLogger(TaskDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

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
	public void insertTaskListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- insert Listado Tareas ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			TaskVO taskToInsert = new TaskVO();
			try{
				taskToInsert=(TaskVO)object;
				session.save(taskToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertTaskListSf ---" + taskToInsert.getSfid());
			} catch (HibernateException e) {
				tx.rollback();
				logger.error("--- Error en insertTaskListSf: ---" + taskToInsert.getSfid(), e);
			}						
		}
		logger.debug("--- Fin -- insertTaskListSf ---");
		session.close();
	}

	/**
	 * Actualiza un listado de tasks venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public void updateTaskListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- update Listado Tasks ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			TaskVO taskToUpdate = new TaskVO();
			try{
				taskToUpdate=(TaskVO)object;
				
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
			} catch (HibernateException e) {
				logger.error("--- Error en updateTaskListSf: ---" + taskToUpdate.getSfid(), e);
			} 						
		}
		logger.debug("--- Fin -- update Listado Tasks ---");
		session.close();
	}
		
	/**
	 * Borra un listado de tasks venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public void deleteTaskListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- delete Listado Tareas ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			TaskVO taskToDelete = new TaskVO();
			try{
				taskToDelete=(TaskVO)object;
				Query sqlDeleteQuery =session.createQuery("DELETE TaskVO WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", taskToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteTaskListSf ---" + taskToDelete.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en deleteTaskListSf: ---" + taskToDelete.getSfid(), e);
			} 					
		}
		logger.debug("--- Fin -- delete Listado Tasks ---");
		session.close();

	}
}