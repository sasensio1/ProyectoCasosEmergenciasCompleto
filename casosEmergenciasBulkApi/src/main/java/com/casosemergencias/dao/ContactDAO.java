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

import com.casosemergencias.dao.vo.ContactVO;
import com.casosemergencias.util.datatables.DataTableColumnInfo;
import com.casosemergencias.util.datatables.DataTableProperties;

@Repository
public class ContactDAO {

	final static Logger logger = Logger.getLogger(ContactDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Devuelve una lista con todos los Suministro de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ContactVO> readAllContact() {

		logger.debug("--- Inicio -- readAllContact ---");

		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from ContactVO");

			List<ContactVO> contactList = query.list();

			logger.debug("--- Fin -- readAllContact ---");

			return contactList;

		} catch (HibernateException e) {
			logger.error("--- readAllContact " + e.getMessage() + "---");
			logger.error(e.getStackTrace());
			logger.error("--- Fin -- readAllContact ---");
		} finally {
			session.close();
		}
		return null;
	}
	
	/**
	 * Devuelve el Contacto que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id
	 *            - id de un Contacto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ContactVO readContactById(Integer id) {

		logger.debug("--- Inicio -- readContactById ---");

		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery(
					"from ContactVO as contact left join fetch contact.cuentaJoin cuenta WHERE contact.id = :id");
			query.setInteger("id", id);

			List<ContactVO> contactList = query.list();

			if (contactList != null && !contactList.isEmpty()) {
				return contactList.get(0);
			}

			logger.debug("--- Fin -- readContactById ---");

		} catch (HibernateException e) {
			logger.error("--- readContactById ", e);
			logger.error("--- Fin -- readContactById ---");
		} finally {
			session.close();
		}
		return null;
	}
	
	/**
	 * Devuelve el Contact que tiene como sfid el pasado por parametro al metodo
	 * 
	 * @param sfid
	 *            - id de un Contact
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ContactVO readContactBySfid(String sfid) {

		logger.debug("--- Inicio -- readContactBySfid ---");

		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from ContactVO as contact WHERE contact.sfid = :sfid");
			query.setString("sfid", sfid);

			List<ContactVO> contactList = query.list();

			if (contactList != null && !contactList.isEmpty()) {
				return contactList.get(0);
			}

			logger.debug("--- Fin -- readContactBySfid ---");

		} catch (HibernateException e) {
			logger.error("--- readContactBySfid ", e);
			logger.error("--- Fin -- readContactBySfid ---");
		} finally {
			session.close();
		}
		return null;
	}

	/**
	 * Dado un Contact, recupera una lista de Contact con los mismos datos que Contact
	 * 
	 * @param Contacto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ContactVO> readContact(ContactVO contact){
		
		logger.debug("--- Inicio -- readContact ---");
		
		Session session = sessionFactory.openSession();
		boolean isFirst = true;
	
		try {
			// preparamos la query
			StringBuilder query = new StringBuilder("from ContactVO as contact");
			if (contact.getId() != null) {
				if (isFirst) {
					query.append(" WHERE contact.id = :id");
					isFirst = false;
				} else {
					query.append(" AND contact.id = :id");
				}
			}
			
			if (contact.getName() != null) {
				if (isFirst) {
					query.append(" WHERE contact.name = :name");
					isFirst = false;
				} else {
					query.append(" AND contact.name = :name");
				}
			}
			
			if (contact.getFechaNacimiento() != null) {
				if (isFirst) {
					query.append(" WHERE contact.fechaNacimiento = :fechaNacimiento");
					isFirst = false;
				} else {
					query.append(" AND contact.fechaNacimiento = :fechaNacimiento");
				}
			}

			if (contact.getCanalPreferenteContacto() != null) {
				if (isFirst) {
					query.append(" WHERE contact.canalPreferenteContacto = :canalPreferenteContacto");
					isFirst = false;
				} else {
					query.append(" AND contact.canalPreferenteContacto = :canalPreferenteContacto");
				}
			}
			
			if (contact.getTipoCuentaAsociado() != null) {
				if (isFirst) {
					query.append(" WHERE contact.tipoCuentaAsociado = :tipoCuentaAsociado");
					isFirst = false;
				} else {
					query.append(" AND contact.tipoCuentaAsociado = :tipoCuentaAsociado");
				}
			}
			
			if (contact.getApellidoMaterno() != null) {
				if (isFirst) {
					query.append(" WHERE contact.apellidoMaterno = :apellidoMaterno");
					isFirst = false;
				} else {
					query.append(" AND contact.apellidoMaterno = :apellidoMaterno");
				}
			}

			if (contact.getTipoIdentidad() != null) {
				if (isFirst) {
					query.append(" WHERE contact.tipoIdentidad = :tipoIdentidad");
					isFirst = false;
				} else {
					query.append(" AND contact.tipoIdentidad = :tipoIdentidad");
				}
			}
			
			if (contact.getTelefonoSecundario() != null) {
				if (isFirst) {
					query.append(" WHERE contact.telefonoSecundario = :telefonoSecundario");
					isFirst = false;
				} else {
					query.append(" AND contact.telefonoSecundario = :telefonoSecundario");
				}
			}
			
			if (contact.getEmailSecundario() != null) {
				if (isFirst) {
					query.append(" WHERE contact.emailSecundario = :emailSecundario");
					isFirst = false;
				} else {
					query.append(" AND contact.emailSecundario = :emailSecundario");
				}
			}
			
			if (contact.getSf4twitterFcbkUsername() != null) {
				if (isFirst) {
					query.append(" WHERE contact.sf4twitterFcbkUsername = :sf4twitterFcbkUsername");
					isFirst = false;
				} else {
					query.append(" AND contact.sf4twitterFcbkUsername = :sf4twitterFcbkUsername");
				}
			}
			
			if (contact.getCasosReiterados() != null) {
				if (isFirst) {
					query.append(" WHERE contact.casosReiterados = :casosReiterados");
					isFirst = false;
				} else {
					query.append(" AND contact.casosReiterados = :casosReiterados");
				}
			}
			
			if (contact.getEmail() != null) {
				if (isFirst) {
					query.append(" WHERE contact.email = :email");
					isFirst = false;
				} else {
					query.append(" AND contact.email = :email");
				}
			}
						
			if (contact.getDirContacto() != null) {
				if (isFirst) {
					query.append(" WHERE contact.dirContacto = :dirContacto");
					isFirst = false;
				} else {
					query.append(" AND contact.dirContacto = :dirContacto");
				}
			}
			
			if (contact.getSf4twitterTwitterUserId() != null) {
				if (isFirst) {
					query.append(" WHERE contact.sf4twitterTwitterUserId = :sf4twitterTwitterUserId");
					isFirst = false;
				} else {
					query.append(" AND contact.sf4twitterTwitterUserId = :sf4twitterTwitterUserId");
				}
			}
			
			if (contact.getSf4twitterFcbkUserId() != null) {
				if (isFirst) {
					query.append(" WHERE contact.sf4twitterFcbkUserId = :sf4twitterFcbkUserId");
					isFirst = false;
				} else {
					query.append(" AND contact.sf4twitterFcbkUserId = :sf4twitterFcbkUserId");
				}
			}
			
			if (contact.getSf4twitterTwitterUsername() != null) {
				if (isFirst) {
					query.append(" WHERE contact.sf4twitterTwitterUsername = :sf4twitterTwitterUsername");
					isFirst = false;
				} else {
					query.append(" AND contact.sf4twitterTwitterUsername = :sf4twitterTwitterUsername");
				}
			}
			
			if (contact.getTipoContacto() != null) {
				if (isFirst) {
					query.append(" WHERE contact.tipoContacto = :tipoContacto");
					isFirst = false;
				} else {
					query.append(" AND contact.tipoContacto = :tipoContacto");
				}
			}
			
			if (contact.getPhone() != null) {
				if (isFirst) {
					query.append(" WHERE contact.phone = :phone");
					isFirst = false;
				} else {
					query.append(" AND contact.phone = :phone");
				}
			}
			
			if (contact.getApellidoPaterno() != null) {
				if (isFirst) {
					query.append(" WHERE contact.apellidoPaterno = :apellidoPaterno");
					isFirst = false;
				} else {
					query.append(" AND contact.apellidoPaterno = :apellidoPaterno");
				}
			}

			// añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());
			
			if (contact.getSfid() != null) {
				result.setString("sfid", contact.getSfid());
			}
			
			if (contact.getHcError() != null) {
				result.setString("hcError", contact.getHcError());
			}
			
			if (contact.getHcLastop() != null) {
				result.setString("hcLastop", contact.getHcLastop());
			}
			
			if (contact.getIsDeleted() != null) {
				result.setBoolean("isDeleted", contact.getIsDeleted());
			}
			
			if (contact.getId() != null) {
				result.setInteger("id", contact.getId());
			}
			
			if (contact.getName() != null) {
				result.setString("name", contact.getName());
			}

			if (contact.getFechaNacimiento() != null) {
				result.setDate("fechaNacimiento", contact.getFechaNacimiento());
			}

			if (contact.getCanalPreferenteContacto() != null) {
				result.setString("canalPreferenteContacto", contact.getCanalPreferenteContacto());
			}
			
			if (contact.getTipoCuentaAsociado() != null) {
				result.setString("tipoCuentaAsociado", contact.getTipoCuentaAsociado());
			}
			
			if (contact.getApellidoMaterno() != null) {
				result.setString("apellidoMaterno", contact.getApellidoMaterno());
			}
			
			if (contact.getTipoIdentidad() != null) {
				result.setString("tipoIdentidad", contact.getTipoIdentidad());
			}
			
			if (contact.getTelefonoSecundario() != null) {
				result.setString("telefonoSecundario", contact.getTelefonoSecundario());
			}
			
			if (contact.getEmailSecundario() != null) {
				result.setString("emailSecundario", contact.getEmailSecundario());
			}

			if (contact.getSf4twitterFcbkUsername() != null) {
				result.setString("sf4twitterFcbkUsername", contact.getSf4twitterFcbkUsername());
			}
			
			if (contact.getCasosReiterados() != null) {
				result.setBoolean("casosReiterados", contact.getCasosReiterados());
			}
			
			if (contact.getEmail() != null) {
				result.setString("email", contact.getEmail());
			}
			
			if (contact.getDirContacto() != null) {
				result.setString("dirContacto", contact.getDirContacto());
			}
			
			if (contact.getSf4twitterTwitterUserId() != null) {
				result.setString("sf4twitterTwitterUserId", contact.getSf4twitterTwitterUserId());
			}
			
			if (contact.getSf4twitterFcbkUserId() != null) {
				result.setString("sf4twitterFcbkUserId", contact.getSf4twitterFcbkUserId());
			}
			
			if (contact.getSf4twitterTwitterUsername() != null) {
				result.setString("sf4twitterTwitterUsername", contact.getSf4twitterTwitterUsername());
			}
			
			if (contact.getTipoContacto() != null) {
				result.setString("tipoContacto", contact.getTipoContacto());
			}
			
			if (contact.getPhone() != null) {
				result.setString("phone", contact.getPhone());
			}
			
			if (contact.getApellidoPaterno() != null) {
				result.setString("apellidoPaterno", contact.getApellidoPaterno());
			}

			List<ContactVO> contactsList = result.list();

			logger.debug("--- Fin -- readContact ---");

			return contactsList;

		} catch (HibernateException e) {
			logger.error("--- readContact ", e);
			logger.error("--- Fin -- readContact ---");
		} finally {
			session.close();
		}
		return null;
	}
	
	/**
	 * Actualiza la fila de Contact correspondiente al id de Contact. Modifica
	 * todos los campos con el valor que hay en Contact.
	 * 
	 * @param Contact
	 * @return
	 */
	@Transactional
	public int updateContact(ContactVO Contact) {
		logger.debug("--- Inicio -- updateContact ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Contact);
			tx.commit();

			logger.debug("--- Fin -- updateContact ---");
			return 1;
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- updateContact ", e);
			logger.error("--- Fin -- updateContact ---");
			return 0;

		} finally {
			session.close();
		}
	}
	
	/**
	 * Inserta un Contact en BBDD
	 * @param Contact
	 * @return
	 */
	public int insertContact(ContactVO Contact, Session session){
		
		logger.debug("updateContact -- inicio");

		int numModif = 0;

		session.save(Contact);

		return numModif;
	}	
	
	/**
	 * Devuelve una lista de suministros utilizando los parametros del datatable
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ContactVO> readContactosDataTable(DataTableProperties dataTableProperties) {
		logger.debug("--- Inicio -- readContactosDataTable ---");
		
		Session session = sessionFactory.openSession();
		String order = (String) dataTableProperties.getTableOrdering().get("orderingColumnName");
		String dirOrder = (String) dataTableProperties.getTableOrdering().get("orderingDirection");
		int numStart = dataTableProperties.getStart();
		int numLength = dataTableProperties.getLength();
		int searchParamsCounter = 0;
				
		try {
			StringBuilder query = new StringBuilder("FROM ContactVO ");
			
			if (dataTableProperties.getColumsInfo() != null && !dataTableProperties.getColumsInfo().isEmpty()) {
				query.append(" WHERE ");
				for (DataTableColumnInfo columnInfo : dataTableProperties.getColumsInfo()) {
					if ("identitynumber__c".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER("+columnInfo.getData()+")" + " LIKE UPPER('%" + columnInfo.getSearchValue() +"%'"+")");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("name".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER("+columnInfo.getData()+")" + " LIKE UPPER('%" + columnInfo.getSearchValue() +"%'"+")");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("phone".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("email".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER("+columnInfo.getData()+")" + " LIKE UPPER('%" + columnInfo.getSearchValue() +"%'"+")");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("sf4twitter__twitter_username__c".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER("+columnInfo.getData()+")" + " LIKE UPPER('%" + columnInfo.getSearchValue() +"%'"+")");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
				}
			}
			
			if (searchParamsCounter == 0) {
				query.setLength(query.length() - 7);
			} else {
				query.setLength(query.length() - 5);
			}
			
			if (order != null && !"".equals(order) && dirOrder != null && !"".equals(dirOrder)) {
				if("name".equals(order)){
					query.append(" ORDER BY  apellidoPaterno " + dirOrder + ", firstname " + dirOrder);
				}else{
					query.append(" ORDER BY " + order + " " + dirOrder);
				}
			}
			
			Query result = session.createQuery(query.toString()).setFirstResult(numStart).setMaxResults(numLength);
			List<ContactVO> contactosList = result.list();

			logger.debug("--- Fin -- readContactosDataTable ---");
			
			return contactosList;
	    } catch (HibernateException e) {
	    	logger.error("--- readContactosDataTable ", e); 
	    	logger.error("--- Fin -- readContactosDataTable ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve el número total de contactos utilizando los parametros del datatable
	 * 
	 * @return
	 */
	public Integer countContactos(DataTableProperties dataTableProperties) {
		logger.debug("--- Inicio -- countContactos ---");
		
		Session session = sessionFactory.openSession();
		int searchParamsCounter = 0;
		
		try {
			StringBuilder sqlQuery = new StringBuilder("SELECT COUNT(id) FROM ContactVO ");
			
			if (dataTableProperties.getColumsInfo() != null && !dataTableProperties.getColumsInfo().isEmpty()) {
				sqlQuery.append(" WHERE ");
				for (DataTableColumnInfo columnInfo : dataTableProperties.getColumsInfo()) {
					if ("identitynumber__c".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("name".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("phone".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("email".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("sf4twitter__twitter_username__c".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
				}
			}
			
			if (searchParamsCounter == 0) {
				sqlQuery.setLength(sqlQuery.length() - 7);
			} else {
				sqlQuery.setLength(sqlQuery.length() - 5);
			}

			Query query = session.createQuery(sqlQuery.toString());
			Long count = (Long) query.uniqueResult();
			
			logger.debug("--- Fin -- countContactos ---");
			
			return count.intValue();
			
	    } catch (HibernateException e) {
	    	logger.error("--- countContactos ", e); 
	    	logger.error("--- Fin -- countContactos ---");
	    } finally {
	    	session.close(); 
	    }
		return null;
	}
}