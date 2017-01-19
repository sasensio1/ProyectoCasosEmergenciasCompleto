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
	 * Devuelve una lista con todos los HerokuUser de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<HerokuUserVO> readAllHerokuUser() {

		logger.debug("--- Inicio -- readAllHerokuUser ---");

		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from HerokuUserVO");

			List<HerokuUserVO> userList = query.list();

			logger.debug("--- Fin -- readAllHerokuUser ---");

			return userList;

		} catch (HibernateException e) {
			logger.error("--- readHerokuUser ", e);
			logger.error("--- Fin -- readAllHerokuUser ---");
		} finally {
			session.close();
		}
		return null;
	}

	/**
	 * Devuelve el HerokuUser que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un HerokuUser
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public HerokuUserVO readHerokuUserById(Integer id) {

		logger.debug("--- Inicio -- readHerokuUserById ---");

		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from HerokuUserVO as herUser WHERE herUser.id = :id");
			query.setInteger("id", id);

			List<HerokuUserVO> userList = query.list();

			if (userList != null && !userList.isEmpty()) {
				return userList.get(0);
			}

			logger.debug("--- Fin -- readHerokuUserById ---");

		} catch (HibernateException e) {
			logger.error("--- readHerokuUserById ", e);
			logger.error("--- Fin -- readHerokuUserById ---");
		} finally {
			session.close();
		}
		return null;
	}
	
	/**
	 * Devuelve el HerokuUser que tiene como sfid el pasado por parametro al metodo
	 * 
	 * @param sfid - id de un HerokuUser
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public HerokuUserVO readHerokuUserBySfid(String sfid) {

		logger.debug("--- Inicio -- readHerokuUserBySfid ---");

		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from HerokuUserVO as herUser WHERE herUser.sfid = :sfid");
			query.setString("sfid", sfid);

			List<HerokuUserVO> userList = query.list();

			if (userList != null && !userList.isEmpty()) {
				return userList.get(0);
			}

			logger.debug("--- Fin -- readHerokuUserBySfid ---");

		} catch (HibernateException e) {
			logger.error("--- readHerokuUserBySfid ", e);
			logger.error("--- Fin -- readHerokuUserBySfid ---");
		} finally {
			session.close();
		}

		return null;
	}

	/**
	 * Dado un HerokuUser, recupera una lista de HerokuUser con los mismos datos que HerokuUser
	 * 
	 * @param herokuUser
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<HerokuUserVO> readHerokuUser(HerokuUserVO herokuUser) {

		logger.debug("--- Inicio -- readHerokuUser ---");

		Session session = sessionFactory.openSession();
		boolean isFirst = true;

		try {
			// preparamos la query
			StringBuilder query = new StringBuilder("from HerokuUserVO as herUser");
			if (herokuUser.getId() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.id = :id");
					isFirst = false;
				} else {
					query.append(" AND herUser.id = :id");
				}
			}
			
			if (herokuUser.getName() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.name = :name");
					isFirst = false;
				} else {
					query.append(" AND herUser.name = :name");
				}
			}
			
			// Campo username no es case sensitive, lo convertimos a mayusculas
			// para la condicion
			if (herokuUser.getUsername() != null) {
				if (isFirst) {
					query.append(" WHERE UPPER(herUser.username) = UPPER(:username)");
					isFirst = false;
				} else {
					query.append(" AND UPPER(herUser.username) = UPPER(:username)");
				}
			}
			
			if (herokuUser.getPassword() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.password = :password");
					isFirst = false;
				} else {
					query.append(" AND herUser.password = :password");
				}
			}
			
			if (herokuUser.getEmail() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.email = :email");
					isFirst = false;
				} else {
					query.append(" AND herUser.email = :email");
				}
			}
			
			if (herokuUser.getEnvioMail() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.envioMail = :envioMail");
					isFirst = false;
				} else {
					query.append(" AND herUser.envioMail = :envioMail");
				}
			}
			
			if (herokuUser.getActivo() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.activo = :activo");
					isFirst = false;
				} else {
					query.append(" AND herUser.activo = :activo");
				}
			}
			
			if (herokuUser.getSfid() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.sfid = :sfid");
					isFirst = false;
				} else {
					query.append(" AND herUser.sfid = :sfid");
				}
			}
			
			if (herokuUser.getHcError() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.hcError = :hcError");
					isFirst = false;
				} else {
					query.append(" AND herUser.hcError = :hcError");
				}
			}
			
			if (herokuUser.getHcLastop() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.hcLastop = :hcLastop");
					isFirst = false;
				} else {
					query.append(" AND herUser.hcLastop = :hcLastop");
				}
			}
			
			if (herokuUser.getIsDeleted() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.isDeleted = :isDeleted");
					isFirst = false;
				} else {
					query.append(" AND herUser.isDeleted = :isDeleted");
				}
			}
			
			if (herokuUser.getSystemDate() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.systemDate = :systemDate");
					isFirst = false;
				} else {
					query.append(" AND herUser.systemDate = :systemDate");
				}
			}
			
			if (herokuUser.getCreatedDate() != null) {
				if (isFirst) {
					query.append(" WHERE herUser.createdDate = :createdDate");
					isFirst = false;
				} else {
					query.append(" AND herUser.createdDate = :createdDate");
				}
			}

			// añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());

			if (herokuUser.getId() != null) {
				result.setInteger("id", herokuUser.getId());
			}
			
			if (herokuUser.getName() != null) {
				result.setString("name", herokuUser.getName());
			}
			
			if (herokuUser.getUsername() != null) {
				result.setString("username", herokuUser.getUsername());
			}
			
			if (herokuUser.getPassword() != null) {
				result.setString("password", herokuUser.getPassword());
			}
			
			if (herokuUser.getEmail() != null) {
				result.setString("email", herokuUser.getEmail());
			}
			
			if (herokuUser.getEnvioMail() != null) {
				result.setBoolean("envioMail", herokuUser.getEnvioMail());
			}
			
			if (herokuUser.getActivo() != null) {
				result.setBoolean("activo", herokuUser.getActivo());
			}
			
			if (herokuUser.getSfid() != null) {
				result.setString("sfid", herokuUser.getSfid());
			}
			
			if (herokuUser.getHcError() != null) {
				result.setString("hcError", herokuUser.getHcError());
			}
			
			if (herokuUser.getHcLastop() != null) {
				result.setString("hcLastop", herokuUser.getHcLastop());
			}
			
			if (herokuUser.getIsDeleted() != null) {
				result.setBoolean("isDeleted", herokuUser.getIsDeleted());
			}
			
			if (herokuUser.getSystemDate() != null) {
				result.setDate("systemDate", herokuUser.getSystemDate());
			}
			
			if (herokuUser.getCreatedDate() != null) {
				result.setDate("createdDate", herokuUser.getCreatedDate());
			}

			List<HerokuUserVO> userList = result.list();

			logger.debug("--- Fin -- readHerokuUser ---");

			return userList;

		} catch (HibernateException e) {
			logger.error("--- readHerokuUser ", e);
			logger.error("--- Fin -- readHerokuUser ---");
		} finally {
			session.close();
		}
		return null;
	}
	
	/**
	 * Actualiza la fila de HerokuUser correspondiente al id de herokuUser. Modifica todos los campos con el valor que hay en herokuUser. 
	 * 
	 * @param herokuUser
	 * @return
	 */
	@Transactional
	public int updateHerokuUser(HerokuUserVO herokuUser) {

		logger.debug("--- Inicio -- updateHerokuUser ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(herokuUser);
			tx.commit();

			logger.debug("--- Fin -- updateHerokuUser ---");
			return 1;
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- updateHerokuUser ", e);
			logger.error("--- Fin -- updateHerokuUser ---");
			return 0;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Inserta un HerokuUser en BBDD
	 * 
	 * @param herokuUser
	 * @return
	 */
	public int insertHerokuUser(HerokuUserVO herokuUser, Session session2) {
		logger.debug("updateHerokuUser -- inicio");

		Session session = sessionFactory.openSession();

		int numModif = 0;
		session.save(herokuUser);
		session.close(); 
		return numModif;
	}
	
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
		Transaction tx = session.beginTransaction();
		
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
				tx.commit();
				
				logger.debug("--- Fin -- insertUsuarioHeroku ---" + usuarioHerokuToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				tx.rollback();
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
		Transaction tx = session.beginTransaction();
				
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
				sqlUpdateQuery.setParameter("name", usuarioHerokuToUpdate.getName());
				sqlUpdateQuery.setParameter("username__c", usuarioHerokuToUpdate.getUsername());
				sqlUpdateQuery.setParameter("password__c", usuarioHerokuToUpdate.getPassword());
				sqlUpdateQuery.setParameter("mail__c", usuarioHerokuToUpdate.getEmail());
				sqlUpdateQuery.setBoolean("sentmail__c", usuarioHerokuToUpdate.getEnvioMail());
				sqlUpdateQuery.setBoolean("active__c", usuarioHerokuToUpdate.getActivo());
				sqlUpdateQuery.setParameter("country__c", usuarioHerokuToUpdate.getCountry());
				sqlUpdateQuery.setParameter("unity__c", usuarioHerokuToUpdate.getUnidad());
				sqlUpdateQuery.setParameter("sfidFiltro", usuarioHerokuToUpdate.getSfid());
				
				//1.3-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				tx.commit();
				logger.debug("--- Fin -- updateUsuarioHeroku ---" + usuarioHerokuToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateUsuarioHeroku: ---" + usuarioHerokuToUpdate.getSfid(), e);
				tx.rollback();
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
		Transaction tx = session.beginTransaction();
		
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
				tx.commit();
				
				logger.debug("--- Fin -- deleteUsuarioHeroku ---" + usuarioHerokuToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteUsuarioHeroku: ---" + usuarioHerokuToDelete.getSfid(), e);
				tx.rollback();
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