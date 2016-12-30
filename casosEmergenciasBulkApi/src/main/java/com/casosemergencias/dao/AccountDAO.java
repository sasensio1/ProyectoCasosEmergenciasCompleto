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
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.dao.vo.ContactVO;
import com.casosemergencias.util.datatables.DataTableColumnInfo;
import com.casosemergencias.util.datatables.DataTableProperties;

@Repository
public class AccountDAO {
	final static Logger logger = Logger.getLogger(AccountDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Devuelve una lista con todas las Cuentas de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AccountVO> readAllAccount() {
		logger.debug("--- Inicio -- readAllAccount ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from AccountVO");
			List<AccountVO> accountList = query.list(); 

			logger.debug("--- Fin -- readAllAccount ---");
			
			return accountList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAllAccount ", e); 
	    	logger.error("--- Fin -- readAllAccount ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	/**
	 * Devuelve el Accounto que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un Accounto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public AccountVO readAccountById(Integer id) {
		
		logger.debug("--- Inicio -- readAccountById ---");
		
		Session session = sessionFactory.openSession();
			
		try {
			Query query = session.createQuery("from AccountVO as account WHERE account.id = :id");
			query.setInteger("id", id);
			
			List<AccountVO> accountList = query.list(); 

			if(accountList != null && !accountList.isEmpty()){
				return accountList.get(0);
			}			
			
			logger.debug("--- Fin -- readAccountById ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAccountById ", e); 
	    	logger.error("--- Fin -- readAccountById ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve una cuenta que tiene como id. el pasado por parámetro al método.
	 * 
	 * @param sfid Id. de la cuenta.
	 * @return AccountVO Datos de la cuenta.
	 */
	@SuppressWarnings("unchecked")
	public AccountVO readAccountBySfid(String sfid, Integer limiteSuministros, Integer limiteContacto, Integer limiteCasos) {
		logger.debug("--- Inicio -- readAccountBySfid ---");
		Session session = sessionFactory.openSession();
		AccountVO account;
		
		try {
			Query query = session.createQuery("from AccountVO account WHERE account.sfid = :sfid ");
			query.setString("sfid", sfid);
			List<AccountVO> accountList = query.list(); 

			Query contactsQuery = session.createQuery("from ContactVO as contacto WHERE contacto.accountid = :sfid "); 
			contactsQuery.setString("sfid", sfid);
			List<ContactVO> accountContactsList;
			if(limiteContacto != null){
				accountContactsList = contactsQuery.setMaxResults(limiteContacto).list();
			}else{
				accountContactsList = contactsQuery.list();
			}
		
			Query casosQuery = session.createQuery("from CaseVO as contacto WHERE contacto.nombreCuenta = :sfid "); 
			casosQuery.setString("sfid", sfid);
			List<CaseVO> accountCasosList;
			if(limiteCasos != null){
				accountCasosList = casosQuery.setMaxResults(limiteCasos).list();
			}else{
				accountCasosList = casosQuery.list();
			}
			
			//Metemos las listas en los objetos, ya que al estar a lazy no les devolvería
			if (accountList != null && !accountList.isEmpty()) {
				account = accountList.get(0);
				/*if (accountSuppliesList != null && !accountSuppliesList.isEmpty()) {
					for (SuministroVO sum: accountSuppliesList) {
						//Anulamos la cuenta para que no entre en bucle.
						sum.setCuentaJoin(null);
					}					
					account.setSuministros(accountSuppliesList);
				}*/
				if (accountContactsList != null && !accountContactsList.isEmpty()) {
					for (ContactVO cont: accountContactsList) {
						//Anulamos la cuenta para que no entre en bucle.
						cont.setCuentaJoin(null);
					}
					account.setContactos(accountContactsList);
				}
				
				if (accountCasosList != null && !accountCasosList.isEmpty()) {
					for (CaseVO cas: accountCasosList) {
						//Anulamos la cuenta y suministro para que no entre en bucle.
						cas.setCuentaJoin(null);
						cas.setSuministroJoin(null);
					}
					account.setCasos(accountCasosList);
				}
				return account;
			}			
			
			logger.debug("--- Fin -- readAccountBySfid ---");
	    } catch (HibernateException e) {
	    	logger.error("--- readAccountBySfid ", e); 
	    	logger.error("--- Fin -- readAccountBySfid ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}

	/**
	 * Dado un Account, recupera una lista de Account con los mismos datos que Account
	 * 
	 * @param Accounto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AccountVO> readAccount(AccountVO account) {

		logger.debug("--- Inicio -- readAccount ---");

		Session session = sessionFactory.openSession();
		boolean isFirst = true;

		try {
			// preparamos la query
			StringBuilder query = new StringBuilder("from AccountVO as account");
			if (account.getId() != null) {
				if (isFirst) {
					query.append(" WHERE account.id = :id");
					isFirst = false;
				} else {
					query.append(" AND account.id = :id");
				}
			}
			
			if (account.getSfid() != null) {
				if (isFirst) {
					query.append(" WHERE account.sfid = :sfid");
					isFirst = false;
				} else {
					query.append(" AND account.sfid = :sfid");
				}
			}
			
			if (account.getName() != null) {
				if (isFirst) {
					query.append(" WHERE account.name = :name");
					isFirst = false;
				} else {
					query.append(" AND account.name = :name");
				}
			}
			
			if (account.getApellidoPaterno() != null) {
				if (isFirst) {
					query.append(" WHERE account.apellidoPaterno = :apellidoPaterno");
					isFirst = false;
				} else {
					query.append(" AND account.apellidoPaterno = :apellidoPaterno");
				}
			}

			if (account.getApellidoMaterno() != null) {
				if (isFirst) {
					query.append(" WHERE account.apellidoMaterno = :apellidoMaterno");
					isFirst = false;
				} else {
					query.append(" AND account.apellidoMaterno = :apellidoMaterno");
				}
			}
			
			if (account.getTipoIdentidad() != null) {
				if (isFirst) {
					query.append(" WHERE account.tipoIdentidad = :tipoIdentidad");
					isFirst = false;
				} else {
					query.append(" AND account.tipoIdentidad = :tipoIdentidad");
				}
			}
			
			if (account.getParentRutEmpresa() != null) {
				if (isFirst) {
					query.append(" WHERE account.parentRutEmpresa = :parentRutEmpresa");
					isFirst = false;
				} else {
					query.append(" AND account.parentRutEmpresa = :parentRutEmpresa");
				}
			}

			if (account.getAccountRun() != null) {
				if (isFirst) {
					query.append(" WHERE account.accountRun = :accountRun");
					isFirst = false;
				} else {
					query.append(" AND account.accountRun = :accountRun");
				}
			}

			if (account.getFechaNacimiento() != null) {
				if (isFirst) {
					query.append(" WHERE account.fechaNacimiento = :fechaNacimiento");
					isFirst = false;
				} else {
					query.append(" AND account.fechaNacimiento = :fechaNacimiento");
				}
			}
			
			if (account.getPhone() != null) {
				if (isFirst) {
					query.append(" WHERE account.phone = :phone");
					isFirst = false;
				} else {
					query.append(" AND account.phone = :phone");
				}
			}
			
			
			if (account.getTelefonoPrincipal() != null) {
				if (isFirst) {
					query.append(" WHERE account.telefonoPrincipal = :telefonoPrincipal");
					isFirst = false;
				} else {
					query.append(" AND account.telefonoPrincipal = :telefonoPrincipal");
				}
			}
			
			if (account.getTelefonoSecundario() != null) {
				if (isFirst) {
					query.append(" WHERE account.telefonoSecundario = :telefonoSecundario");
					isFirst = false;
				} else {
					query.append(" AND account.telefonoSecundario = :telefonoSecundario");
				}
			}
			
			if (account.getEmailPrincipal() != null) {
				if (isFirst) {
					query.append(" WHERE account.email = :email");
					isFirst = false;
				} else {
					query.append(" AND account.email = :email");
				}
			}
			
			if (account.getEmailSecundario() != null) {
				if (isFirst) {
					query.append(" WHERE account.emailSecundario = :emailSecundario");
					isFirst = false;
				} else {
					query.append(" AND account.emailSecundario = :emailSecundario");
				}
			}
			
			if (account.getDireccion() != null) {
				if (isFirst) {
					query.append(" WHERE account.direccion = :direccion");
					isFirst = false;
				} else {
					query.append(" AND account.direccion = :direccion");
				}
			}
			
			if (account.getAccountsource() != null) {
				if (isFirst) {
					query.append(" WHERE account.accountsource = :accountsource");
					isFirst = false;
				} else {
					query.append(" AND account.accountsource = :accountsource");
				}
			}
			
			if (account.getIdEmpresa() != null) {
				if (isFirst) {
					query.append(" WHERE account.idEmpresa = :idEmpresa");
					isFirst = false;
				} else {
					query.append(" AND account.idEmpresa = :idEmpresa");
				}
			}

			// añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());
			
			if (account.getSfid() != null) {
				result.setString("sfid", account.getSfid());
			}
			
			if (account.getHcError() != null) {
				result.setString("hcError", account.getHcError());
			}
			
			if (account.getHcLastop() != null) {
				result.setString("hcLastop", account.getHcLastop());
			}
			
			if (account.getIsDeleted() != null) {
				result.setBoolean("isDeleted", account.getIsDeleted());
			}
			
			if (account.getId() != null) {
				result.setInteger("id", account.getId());
			}
			
			if (account.getName() != null) {
				result.setString("name", account.getName());
			}
			
			if (account.getApellidoPaterno() != null) {
				result.setString("apellidoPaterno", account.getApellidoPaterno());
			}

			if (account.getApellidoMaterno() != null) {
				result.setString("apellidoMaterno", account.getApellidoMaterno());
			}

			if (account.getTipoIdentidad() != null) {
				result.setString("tipoIdentidad", account.getTipoIdentidad());
			}
			
			if (account.getParentRutEmpresa() != null) {
				result.setString("parentRutEmpresa", account.getParentRutEmpresa());
			}
			
			if (account.getAccountRun() != null) {
				result.setString("accountRun", account.getAccountRun());
			}
			
			if (account.getFechaNacimiento() != null) {
				result.setDate("fechaNacimiento", account.getFechaNacimiento());
			}
			
			if (account.getPhone() != null) {
				result.setString("phone", account.getPhone());
			}
			
			if (account.getTelefonoPrincipal() != null) {
				result.setString("telefonoPrincipal", account.getTelefonoPrincipal());
			}
			
			if (account.getTelefonoSecundario() != null) {
				result.setString("telefonoSecundario", account.getTelefonoSecundario());
			}

			if (account.getEmailPrincipal() != null) {
				result.setString("email", account.getEmailPrincipal());
			}
			
			if (account.getEmailSecundario() != null) {
				result.setString("emailSecundario", account.getEmailSecundario());
			}
			
			if (account.getDireccion() != null) {
				result.setString("direccion", account.getDireccion());
			}
			
			if (account.getAccountsource() != null) {
				result.setString("accountsource", account.getAccountsource());
			}
			
			if (account.getIdEmpresa() != null) {
				result.setString("idEmpresa", account.getIdEmpresa());
			}

			List<AccountVO> accountsList = result.list();

			logger.debug("--- Fin -- readAccount ---");

			return accountsList;

		} catch (HibernateException e) {
			logger.error("--- readAccount ", e);
			logger.error("--- Fin -- readAccount ---");
		} finally {
			session.close();
		}
		return null;
	}
		
	/**
	 * Actualiza la fila de Account correspondiente al id de Account. Modifica
	 * todos los campos con el valor que hay en Account.
	 * 
	 * @param Account
	 * @return
	 */
	@Transactional
	public int updateAccount(AccountVO Account) {

		logger.debug("--- Inicio -- updateAccount ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {

			session.update(Account);
			tx.commit();

			logger.debug("--- Fin -- updateAccount ---");
			return 1;
		} catch (HibernateException e) {

			tx.rollback();
			logger.error("--- updateAccount ", e);
			logger.error("--- Fin -- updateAccount ---");
			return 0;

		} finally {
			session.close();
		}
	}
	
	/**
	 * Inserta un Account en BBDD
	 * @param Account
	 * @return
	 */
	public int insertAccount(AccountVO Account, Session session){
		
		logger.debug("updateAccount -- inicio");

		int numModif = 0;

		session.save(Account);

		return numModif;
	}
	
	/**
	 * Devuelve una lista de suministros utilizando los parametros del datatable
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AccountVO> readCuentaDataTable(DataTableProperties dataTableProperties) {
		logger.debug("--- Inicio -- readCuentaDataTable ---");
		
		Session session = sessionFactory.openSession();
		String order = (String) dataTableProperties.getTableOrdering().get("orderingColumnName");
		String dirOrder = (String) dataTableProperties.getTableOrdering().get("orderingDirection");
		int numStart = dataTableProperties.getStart();
		int numLength = dataTableProperties.getLength();
		int searchParamsCounter = 0;
		
		try {
			StringBuilder query = new StringBuilder("FROM AccountVO ");
			
			if (dataTableProperties.getColumsInfo() != null && !dataTableProperties.getColumsInfo().isEmpty()) {
				query.append(" WHERE ");
				for (DataTableColumnInfo columnInfo : dataTableProperties.getColumsInfo()) {
					if ("name".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER("+columnInfo.getData()+")" + " LIKE UPPER('%" + columnInfo.getSearchValue() +"%'"+")");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("mainphone__c".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("primaryemail__c".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER("+columnInfo.getData()+")" + " LIKE UPPER('%" + columnInfo.getSearchValue() +"%'"+")");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("identitynumber__c".equals(columnInfo.getData())) {
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
				query.append(" ORDER BY " + order + " " + dirOrder);
			}
			
			Query result = session.createQuery(query.toString()).setFirstResult(numStart).setMaxResults(numLength);
			List<AccountVO> cuentasList = result.list();

			logger.debug("--- Fin -- readCuentaDataTable ---");
			
			return cuentasList;
	    } catch (HibernateException e) {
	    	logger.error("--- readCuentaDataTable ", e); 
	    	logger.error("--- Fin -- readCuentaDataTable ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve el número de direcciones utilizando los parametros del datatable
	 * 
	 * @return
	 */
	public Integer countCuentas(DataTableProperties dataTableProperties) {
		logger.debug("--- Inicio -- countCuentas ---");
		
		Session session = sessionFactory.openSession();
		int searchParamsCounter = 0;
		
		try {
			StringBuilder sqlQuery = new StringBuilder("SELECT COUNT(id) FROM AccountVO ");
			
			if (dataTableProperties.getColumsInfo() != null && !dataTableProperties.getColumsInfo().isEmpty()) {
				sqlQuery.append(" WHERE ");
				for (DataTableColumnInfo columnInfo : dataTableProperties.getColumsInfo()) {
					if ("name".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("mainphone__c".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("primaryemail__c".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("identitynumber__c".equals(columnInfo.getData())) {
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
			
			logger.debug("--- Fin -- countCuentas ---");
			
			return count.intValue();
			
	    } catch (HibernateException e) {
	    	logger.error("--- countCuentas ", e); 
	    	logger.error("--- Fin -- countCuentas ---");
	    } finally {
	    	session.close(); 
	    }
		return null;
	}
}