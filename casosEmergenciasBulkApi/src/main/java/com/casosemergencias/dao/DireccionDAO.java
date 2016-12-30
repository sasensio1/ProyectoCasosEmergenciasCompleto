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

import com.casosemergencias.dao.vo.DireccionVO;
import com.casosemergencias.dao.vo.StreetVO;
import com.casosemergencias.util.datatables.DataTableColumnInfo;
import com.casosemergencias.util.datatables.DataTableProperties;

@Repository
public class DireccionDAO {
	final static Logger logger = Logger.getLogger(DireccionDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Devuelve una lista con todas las Direcciones de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DireccionVO> readAllDireccion() {
				
		logger.debug("--- Inicio -- readAllDireccion ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from DireccionVO");
			
			List<DireccionVO> direccionList = query.list(); 

			logger.debug("--- Fin -- readAllDireccion ---");
			
			return direccionList;
	    } catch (HibernateException e) {
	    	logger.error("--- readAllDireccion ", e); 
	    	logger.error("--- Fin -- readAllDireccion ---");
	    } finally {
	    	session.close(); 
	    }
		return null;
	}
	
	/**
	 * Devuelve la Direccion que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un Direcciono
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public DireccionVO readDireccionById(Integer id) {
		
		logger.debug("--- Inicio -- readDireccionById ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from DireccionVO as direccion WHERE direccion.id = :id");
			query.setInteger("id", id);
			
			List<DireccionVO> direccionList = query.list(); 

			if (direccionList != null && !direccionList.isEmpty()) {
				return direccionList.get(0);
			}			
			
			logger.debug("--- Fin -- readDireccionById ---");
	    } catch (HibernateException e) {
	    	logger.error("--- readDireccionById ", e); 
	    	logger.error("--- Fin -- readDireccionById ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve la Direccion que tiene como sfid el pasado por parametro al metodo
	 * 
	 * @param sfid - id de un Direccion
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public DireccionVO readDireccionBySfid(String sfid) {
		
		logger.debug("--- Inicio -- readDireccionBySfid ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from DireccionVO as direccion WHERE direccion.sfid = :sfid");
			query.setString("sfid", sfid);
			
			List<DireccionVO> direccionList = query.list(); 

			if (direccionList != null && !direccionList.isEmpty()) {
				return direccionList.get(0);
			}			
			
			logger.debug("--- Fin -- readDireccionBySfid ---");
	    } catch (HibernateException e) {
	    	logger.error("--- readDireccionBySfid ", e); 
	    	logger.error("--- Fin -- readDireccionBySfid ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}

	/**
	 * Dado un Direccion, recupera una lista de Direccion con los mismos datos que Direccion
	 * 
	 * @param Direcciono
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DireccionVO> readDireccion(DireccionVO direccion) {
		
		logger.debug("--- Inicio -- readDireccion ---");
		
		Session session = sessionFactory.openSession();
		boolean isFirst = true;
	
	    try {
			// preparamos la query
			StringBuilder query = new StringBuilder("from DireccionVO as direccion");
			if (direccion.getId() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.id = :id");
					isFirst = false;
				} else {
					query.append(" AND direccion.id = :id");
				}
			}

			if (direccion.getName() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.name = :name");
					isFirst = false;
				} else {
					query.append(" AND direccion.name = :name");
				}
			}

			if (direccion.getSfid() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.sfid = :sfid");
					isFirst = false;
				} else {
					query.append(" AND direccion.sfid = :sfid");
				}
			}

			if (direccion.getRegion() != null) {
				if (isFirst) {
					query.append(" WHERE Direccion.region = :region");
					isFirst = false;
				} else {
					query.append(" AND direccion.region = :region");
				}
			}

			if (direccion.getComuna() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.comuna = :comuna");
					isFirst = false;
				} else {
					query.append(" AND direccion.comuna = :comuna");
				}
			}

			if (direccion.getTipoCalle() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.tipoCalle = :tipoCalle");
					isFirst = false;
				} else {
					query.append(" AND direccion.tipoCalle = :tipoCalle");
				}
			}

			if (direccion.getCalle() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.calle = :calle");
					isFirst = false;
				} else {
					query.append(" AND direccion.calle = :calle");
				}
			}

			if (direccion.getNumero() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.numero = :numero");
					isFirst = false;
				} else {
					query.append(" AND direccion.numero = :numero");
				}
			}

			if (direccion.getDepartamento() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.departamento = :departamento");
					isFirst = false;
				} else {
					query.append(" AND direccion.departamento = :departamento");
				}
			}

			if (direccion.getName() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.name = :name");
					isFirst = false;
				} else {
					query.append(" AND direccion.name = :name");
				}
			}

			if (direccion.getDireccionConcatenada() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.direccionConcatenada = :direccionConcatenada");
					isFirst = false;
				} else {
					query.append(" AND direccion.direccionConcatenada = :direccionConcatenada");
				}
			}

			if (direccion.getEsquina() != null) {
				if (isFirst) {
					query.append(" WHERE direccion.esquina = :esquina");
					isFirst = false;
				} else {
					query.append(" AND direccion.esquina = :esquina");
				}
			}

			//Añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());
			if (direccion.getSfid() != null) {
				result.setString("sfid", direccion.getSfid());
			}
			
			if (direccion.getHcError() != null) {
				result.setString("hcError", direccion.getHcError());
			}
			
			if (direccion.getHcLastop() != null) {
				result.setString("hcLastop", direccion.getHcLastop());
			}
			
			if (direccion.getIsDeleted() != null) {
				result.setBoolean("isDeleted", direccion.getIsDeleted());
			}
			
			if (direccion.getId() != null) {
				result.setInteger("id", direccion.getId());
			}
			
			if (direccion.getName() != null) {
				result.setString("name", direccion.getName());
			}
			
			if (direccion.getRegion() != null) {
				result.setString("region", direccion.getRegion());
			}

			if (direccion.getComuna() != null) {
				result.setString("comuna", direccion.getComuna());
			}
			
			if (direccion.getTipoCalle() != null) {
				result.setString("tipoCalle", direccion.getTipoCalle());
			}
			
			if (direccion.getCalle() != null) {
				result.setString("calle", direccion.getCalle());
			}
			
			if (direccion.getNumero() != null) {
				result.setString("numero", direccion.getNumero());
			}
			
			if (direccion.getDepartamento() != null) {
				result.setString("departamento", direccion.getDepartamento());
			}
			
			if (direccion.getName() != null) {
				result.setString("name", direccion.getName());
			}

			if (direccion.getDireccionConcatenada() != null) {
				result.setString("direccionConcatenada", direccion.getDireccionConcatenada());
			}
			
			if (direccion.getEsquina() != null) {
				result.setString("esquina", direccion.getEsquina());
			}
			
			List<DireccionVO> direccionsList = result.list(); 	 
			
			logger.debug("--- Fin -- readDireccion ---");
			
			return direccionsList;

	    } catch (HibernateException e) {
	    	logger.error("--- readDireccion ", e); 
	    	logger.error("--- Fin -- readDireccion ---"); 
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Actualiza la fila de Direccion correspondiente al id de Direccion. Modifica todos los campos con el valor que hay en Direccion. 
	 * 
	 * @param Direccion
	 * @return
	 */
	@Transactional
    public int updateDireccion(DireccionVO Direccion) {
		
		logger.debug("--- Inicio -- updateDireccion ---");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Direccion);
			tx.commit();
			logger.debug("--- Fin -- updateDireccion ---");			
			return 1;
		} catch (HibernateException e) {
	    	tx.rollback();
			logger.error("--- updateDireccion ", e); 
	    	logger.error("--- Fin -- updateDireccion ---");
	    	return 0;
	    } finally {
	    	session.close(); 
	    }
    }
	
	/**
	 * Inserta un Direccion en BBDD
	 * @param Direccion
	 * @return
	 */
	@Transactional
	public Integer insertDireccion(DireccionVO Direccion) {

		logger.debug("--- Inicio -- insert ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Direccion);
			tx.commit();
			logger.debug("--- Fin -- insert ---");
			return Direccion.getId();
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertDireccion: ", e);
			logger.error("--- Fin -- updateDireccion---");
			return 0;
		} finally {
			session.close();
		}

	}
	
	/**
	 * Devuelve una lista de direcciones utilizando los parametros del datatable
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DireccionVO> readDireccionDataTable(DataTableProperties dataTableProperties) {
		logger.debug("--- Inicio -- readDireccionDataTable ---");
		
		Session session = sessionFactory.openSession();		
		String order = null;
		String dirOrder = null;
		if(dataTableProperties.getTableOrdering() != null){
			order = (String) dataTableProperties.getTableOrdering().get("orderingColumnName");
			dirOrder = (String) dataTableProperties.getTableOrdering().get("orderingDirection");
		}
		
		int numStart = dataTableProperties.getStart();
		int numLength = dataTableProperties.getLength();
		int searchParamsCounter = 0;
				
		try {
			StringBuilder query = new StringBuilder("FROM DireccionVO direccion ");
			
			if (dataTableProperties.getColumsInfo() != null && !dataTableProperties.getColumsInfo().isEmpty()) {
				query.append(" WHERE ");
				for (DataTableColumnInfo columnInfo : dataTableProperties.getColumsInfo()) {
					if ("name".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(direccion." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}					
					if ("direccionConcatenada".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(direccion." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}					
					if ("comuna".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(direccion." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("calle".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(direccion." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
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
				query.append(" ORDER BY direccion.direccionConcatenada asc" );
			}
			
			Query result = session.createQuery(query.toString()).setFirstResult(numStart).setMaxResults(numLength);
			List<DireccionVO> direccionList = result.list();

			logger.debug("--- Fin -- readDireccionDataTable ---");
			
			return direccionList;
	    } catch (HibernateException e) {
	    	logger.error("--- readDireccionDataTable ", e); 
	    	logger.error("--- Fin -- readDireccionDataTable ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve el numero de direcciones utilizando los parametros del datatable
	 * 
	 * @return
	 */
	public Integer countDireccion(DataTableProperties dataTableProperties) {
		logger.debug("--- Inicio -- countDireccion ---");
		
		Session session = sessionFactory.openSession();
		int searchParamsCounter = 0;
		
		try {
			StringBuilder sqlQuery = new StringBuilder("SELECT COUNT(id) FROM DireccionVO ");
			
			if (dataTableProperties.getColumsInfo() != null && !dataTableProperties.getColumsInfo().isEmpty()) {
				sqlQuery.append(" WHERE ");
				for (DataTableColumnInfo columnInfo : dataTableProperties.getColumsInfo()) {
					if ("comuna".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("calle".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append("UPPER("+columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
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
			
			logger.debug("--- Fin -- countDireccion ---");
			
			return count.intValue();
	    } catch (HibernateException e) {
	    	logger.error("--- countDireccion ", e); 
	    	logger.error("--- Fin -- countDireccion ---");
	    } finally {
	    	session.close(); 
	    }
		return null;
	}
}