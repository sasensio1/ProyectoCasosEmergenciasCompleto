package com.casosemergencias.dao;

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

import com.casosemergencias.dao.vo.AccountVO;
import com.casosemergencias.dao.vo.UserVO;

@Repository
public class UserDAO {

final static Logger logger = Logger.getLogger(UserDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

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
	public void insertUserListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- insert Listado Usuarios ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			UserVO usuarioToInsert = new UserVO();
			try{
				usuarioToInsert=(UserVO)object;
				session.save(usuarioToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertUsuario ---" + usuarioToInsert.getSfid());
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertUsuario: ---" + usuarioToInsert.getSfid(), e);
			}						
		}
		logger.debug("--- Fin -- insert Listado Usuarios ---");
		session.close();
	}
	

	/**
	 * Actualiza un listado de usuarios venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void updateUserListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- update Listado Usuarios ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			UserVO usuarioToUpdate = new UserVO();
			try{
				usuarioToUpdate=(UserVO)object;
				Query sqlUpdateQuery =session.createQuery("UPDATE UserVO SET "
				+ "name= :name"			
				+	
				" WHERE sfid = :sfidFiltro");
				
				//Seteamos los campos a actualizar
				
				sqlUpdateQuery.setParameter("name", usuarioToUpdate.getName());

				//Seteamos el campo por el que filtramos la actualización
				
				sqlUpdateQuery.setParameter("sfidFiltro", usuarioToUpdate.getSfid());
				
				//Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateUsuario ---" + usuarioToUpdate.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en updateUsuario: ---" + usuarioToUpdate.getSfid(), e);
			} 						
		}
		logger.debug("--- Fin -- update Listado Usuarios ---");
		session.close();

	}
		
	/**
	 * Borra un listado de usuarios venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public void deleteUserListSf(List<Object> objectList) {
		logger.debug("--- Inicio -- delete Listado Usuarios ---");

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			UserVO usuarioToDelete = new UserVO();
			try{
				usuarioToDelete=(UserVO)object;
				Query sqlDeleteQuery =session.createQuery("DELETE UserVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", usuarioToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteUsuario ---" + usuarioToDelete.getSfid());
			} catch (HibernateException e) {
			logger.error("--- Error en deleteUsuario: ---" + usuarioToDelete.getSfid(), e);
			} 					
		}
		logger.debug("--- Fin -- delete Listado Usuarios ---");
		session.close();

	}
	
	
	
	
	

}
