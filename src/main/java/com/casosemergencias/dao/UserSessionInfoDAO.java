package com.casosemergencias.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.casosemergencias.dao.vo.UserSessionInfoVO;

@Repository
public class UserSessionInfoDAO {
	final static Logger logger = Logger.getLogger(UserSessionInfoDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserSessionInfoVO readUserSessionInfo(UserSessionInfoVO userSessionInfo) {

		logger.debug("--- Inicio -- readCase ---");

		UserSessionInfoVO userSessionInfoVO = null;
		Session session = sessionFactory.openSession();
		boolean isFirst = true;

		try {
			// preparamos la query
			StringBuilder query = new StringBuilder("from UserSessionInfoVO as info");
			
			if (userSessionInfo.getId() != null && !"".equals(userSessionInfo.getId())) {
				if (isFirst) {
					query.append(" WHERE info.id = :id");
					isFirst = false;
				} else {
					query.append(" AND info.id = :id");
				}
			}
			
			if (userSessionInfo.getUsername() != null && !"".equals(userSessionInfo.getUsername())) {
				if (isFirst) {
					query.append(" WHERE info.username = :username");
					isFirst = false;
				} else {
					query.append(" AND info.username = :username");
				}
			}
			
			if (userSessionInfo.getPassword() != null && !"".equals(userSessionInfo.getPassword())) {
				if (isFirst) {
					query.append(" WHERE info.password = :password");
					isFirst = false;
				} else {
					query.append(" AND info.password = :password");
				}
			}
			
			if (userSessionInfo.getAccessToken() != null && !"".equals(userSessionInfo.getAccessToken())) {
				if (isFirst) {
					query.append(" WHERE info.accessToken = :accessToken");
					isFirst = false;
				} else {
					query.append(" AND info.accessToken = :accessToken");
				}
			}
			
			if (userSessionInfo.getSessionId() != null && !"".equals(userSessionInfo.getSessionId())) {
				if (isFirst) {
					query.append(" WHERE info.sessionId = :sessionId");
					isFirst = false;
				} else {
					query.append(" AND info.sessionId = :sessionId");
				}
			}
			
			if (userSessionInfo.getLastConnection() != null) {
				if (isFirst) {
					query.append(" WHERE info.lastConnection = :lastConnection");
					isFirst = false;
				} else {
					query.append(" AND info.lastConnection = :lastConnection");
				}
			}
			
			// añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());
			
			if (userSessionInfo.getId() != null && !"".equals(userSessionInfo.getId())) {
				result.setInteger("id", userSessionInfo.getId());
			}
			
			if (userSessionInfo.getUsername() != null && !"".equals(userSessionInfo.getUsername())) {
				result.setString("username", userSessionInfo.getUsername());
			}
			
			if (userSessionInfo.getPassword() != null && !"".equals(userSessionInfo.getPassword())) {
				result.setString("password", userSessionInfo.getPassword());
			}
			
			if (userSessionInfo.getAccessToken() != null && !"".equals(userSessionInfo.getAccessToken())) {
				result.setString("accessToken", userSessionInfo.getAccessToken());
			}
			
			if (userSessionInfo.getSessionId() != null && !"".equals(userSessionInfo.getSessionId())) {
				result.setString("sessionId", userSessionInfo.getSessionId());
			}
			
			if (userSessionInfo.getLastConnection() != null) {
				result.setDate("lastConnection", userSessionInfo.getLastConnection());
			}
			
			userSessionInfoVO = (UserSessionInfoVO) result.uniqueResult();
		} catch (HibernateException e) {
			logger.error("--- Error en readCase: ", e);
			logger.error("--- Fin -- readCase ---");
		} finally {
			session.close();
		}

		logger.debug("--- Fin -- readCase ---");
		return userSessionInfoVO;
	}
	
	/**
	 * Inserta los datos de sesi&oacute;n de un usuario en BBDD.
	 * 
	 * @param userSessionInfo
	 *            Datos de sesi&oacute;n del usuario.
	 * @return int Devuelve el id. del usuario si se ha insertado correctamente
	 *         o 0 si ha fallado la inserci&oacute;n.
	 */
	@Transactional
	public int insertUserSessionInfo(UserSessionInfoVO userSessionInfo) {
		logger.debug("--- Inicio -- insertUserSessionInfo ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(userSessionInfo);
			tx.commit();
			logger.debug("--- Fin -- insertUserSessionInfo ---");
			return userSessionInfo.getId();
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertUserSessionInfo: ", e);
			logger.error("--- Fin -- insertUserSessionInfo ---");
			return 0;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Actualiza la fila de UserSessionInfo correspondiente. Modifica todos los
	 * campos con el valor que hay en el bean de entrada.
	 * 
	 * @param userSessionInfo
	 *            Datos del usuario de sesi&oacute;
	 * @return int con valor 1 si ha funcionado la actualizaci&oacute;n y 0 si
	 *         no se ha actualizado correctamente.
	 */
	@Transactional
	public int updateUserSessionInfo(UserSessionInfoVO userSessionInfo) {
		logger.debug("--- Inicio -- updateUserSessionInfo ---");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.update(userSessionInfo);
			tx.commit();
			logger.debug("--- Fin -- updateUserSessionInfo ---");
			return 1;
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en updateUserSessionInfo: ", e);
			logger.error("--- Fin -- updateUserSessionInfo ---");
			return 0;
		} finally {
			session.close();
		}
	}
}