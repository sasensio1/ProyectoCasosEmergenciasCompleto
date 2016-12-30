package com.casosemergencias.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
