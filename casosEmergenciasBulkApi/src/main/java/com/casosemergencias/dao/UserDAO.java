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
import com.casosemergencias.dao.vo.UserVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class UserDAO {

final static Logger logger = Logger.getLogger(UserDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;

	/**
	 * Devuelve una lista con todas los User de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserVO> readAllUser() {
		logger.debug("--- Inicio -- readAllUser ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from UserVO");
			List<UserVO> userList = query.list(); 

			logger.debug("--- Fin -- readAllUser ---");
			
			return userList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAllUser ", e); 
	    	logger.error("--- Fin -- readAllUser ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve el User que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un User
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public UserVO readUserById(Integer id) {
		
		logger.debug("--- Inicio -- readUserById ---");
		
		Session session = sessionFactory.openSession();
			
		try {
			Query query = session.createQuery("from UserVO as user WHERE user.id = :id");
			query.setInteger("id", id);
			
			List<UserVO> userList = query.list(); 

			if(userList != null && !userList.isEmpty()){
				return userList.get(0);
			}			
			
			logger.debug("--- Fin -- readUserById ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readUserById ", e); 
	    	logger.error("--- Fin -- readUserById ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve una user que tiene como id. el pasado por parámetro al método.
	 * 
	 * @param sfid Id. del user.
	 * @return UserVO Datos de la cuenta.
	 */
	@SuppressWarnings("unchecked")
	public UserVO readUserBySfid(String sfid) {
		logger.debug("--- Inicio -- readUserBySfid ---");
		Session session = sessionFactory.openSession();
		
		try {
			Query query = session.createQuery("from UserVO account WHERE account.sfid = :sfid ");
			query.setString("sfid", sfid);
			List<UserVO> userList = query.list(); 
			
			if (userList != null && !userList.isEmpty()) {
				return userList.get(0);
			}


			logger.debug("--- Fin -- readUserBySfid ---");
	    } catch (HibernateException e) {
	    	logger.error("--- readUserBySfid ", e); 
	    	logger.error("--- Fin -- readUserBySfid ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Inserta un listado de Usuarios venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int insertUserListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Usuarios ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		UserVO usuarioToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_USER);
			historicoInsertRecord.setProcessId(processId);
			usuarioToInsert = new UserVO();
			
			try {
				usuarioToInsert = (UserVO) object;
				historicoInsertRecord.setSfidRecord(usuarioToInsert.getSfid());
				session.save(usuarioToInsert);
				tx.commit();
				
				logger.debug("--- Fin -- insertUsuario ---" + usuarioToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				tx.rollback();
				logger.error("--- Error en insertUsuario: ---" + usuarioToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}

			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado Usuarios ---");
		session.close();
		return processedRecords;
	}
	
	/**
	 * Actualiza un listado de usuarios venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateUserListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Usuarios ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		UserVO usuarioToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_USER);
			historicoUpdateRecord.setProcessId(processId);
			usuarioToUpdate = new UserVO();
			
			try {
				usuarioToUpdate = (UserVO) object;
				historicoUpdateRecord.setSfidRecord(usuarioToUpdate.getSfid());
				//1.1-Construimos la query							
				Query sqlUpdateQuery =session.createQuery("UPDATE UserVO "
													   + "    SET name= :name"			
													   + "  WHERE sfid = :sfidFiltro");
				
				//1.2-Seteamos los campos
				sqlUpdateQuery.setString("name", usuarioToUpdate.getName());
				sqlUpdateQuery.setString("sfidFiltro", usuarioToUpdate.getSfid());
				
				//1.3-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				tx.commit();
				logger.debug("--- Fin -- updateUsuario ---" + usuarioToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateUsuario: ---" + usuarioToUpdate.getSfid(), e);
				tx.rollback();
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			} 

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado Usuarios ---");
		session.close();
		return processedRecords;
	}
		
	/**
	 * Borra un listado de usuarios venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteUserListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Usuarios ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		UserVO usuarioToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_USER);
			historicoDeleteRecord.setProcessId(processId);
			usuarioToDelete = new UserVO();
			
			try {
				usuarioToDelete = (UserVO) object;
				historicoDeleteRecord.setSfidRecord(usuarioToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE UserVO WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", usuarioToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
				tx.commit();
				
				logger.debug("--- Fin -- deleteUsuario ---" + usuarioToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteUsuario: ---" + usuarioToDelete.getSfid(), e);
				tx.rollback();
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			} 

			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado Usuarios ---");
		session.close();
		return processedRecords;
	}
}