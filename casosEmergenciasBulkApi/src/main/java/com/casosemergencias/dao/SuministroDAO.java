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

import com.casosemergencias.dao.vo.SuministroVO;
import com.casosemergencias.util.datatables.DataTableColumnInfo;
import com.casosemergencias.util.datatables.DataTableProperties;

@Repository
public class SuministroDAO {
	final static Logger logger = Logger.getLogger(SuministroDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Devuelve una lista con todos los Suministro de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SuministroVO> readAllSuministro() {
				
		logger.debug("--- Inicio -- readAllSuministro ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from SuministroVO");
			
			List<SuministroVO> suministroList = query.list(); 

			logger.debug("--- Fin -- readAllSuministro ---");
			
			return suministroList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAllSuministro ", e);
	    	logger.error("--- Fin -- readAllSuministro ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve el Suministro que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un Suministro
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SuministroVO readSuministroById(Integer id) {
		
		logger.debug("--- Inicio -- readSuministroById ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from SuministroVO as suministro WHERE suministro.id = :id");
			query.setInteger("id", id);
			
			List<SuministroVO> suministroList = query.list(); 

			if(suministroList != null && !suministroList.isEmpty()){
				return suministroList.get(0);
			}			
			
			logger.debug("--- Fin -- readSuministroById ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readSuministroById ", e);
	    	logger.error("--- Fin -- readSuministroById ---");
	    } finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}
	
	/**
	 * Devuelve el Suministro que tiene como sfid el pasado por parametro al metodo
	 * 
	 * @param sfid - id de un Suministro
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SuministroVO readSuministroBySfid(String sfid) {
		
		logger.debug("--- Inicio -- readSuministroBySfid ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from SuministroVO as suministro WHERE suministro.sfid = :sfid");
			query.setString("sfid", sfid);
			
			List<SuministroVO> suministroList = query.list(); 

			if(suministroList != null && !suministroList.isEmpty()){
				return suministroList.get(0);
			}			
			
			logger.debug("--- Fin -- readSuministroBySfid ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readSuministroBySfid ", e); 
	    	logger.error("--- Fin -- readSuministroBySfid ---");
	    } finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}

	/**
	 * Dado un Suministro, recupera una lista de Suministro con los mismos datos que Suministro
	 * 
	 * @param SuministroVO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SuministroVO> readSuministro(SuministroVO suministro, Integer numeroSuministros) {
		
		logger.debug("--- Inicio -- readSuministro ---");
		
		Session session = sessionFactory.openSession();
		boolean isFirst = true;
	
	    try {
	    	//preparamos la query
	    	StringBuilder query = new StringBuilder("from SuministroVO as suministro");
	    	
			if (suministro.getId() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.id = :id");
					isFirst = false;
				} else {
					query.append(" AND suministro.id = :id");
				}
			}
			
			if (suministro.getName() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.name = :name");
					isFirst = false;
				} else {
					query.append(" AND suministro.name = :name");
				}
			}
			
			// Campo username no es case sensitive, lo convertimos a mayusculas
			// para la condicion
			if (suministro.getFullElectric() != null) {
				if (isFirst) {
					query.append(" WHERE UPPER(suministro.fullElectric) = UPPER(:fullElectric)");
					isFirst = false;
				} else {
					query.append(" AND UPPER(suministro.fullElectric) = UPPER(:fullElectric)");
				}
			}
			
			if (suministro.getCasosAbiertos() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.casosAbiertos = :casosAbiertos");
					isFirst = false;
				} else {
					query.append(" AND suministro.casosAbiertos = :casosAbiertos");
				}
			}
			
			if (suministro.getTipoTransformador() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.tipoTransformador = :tipoTransformador");
					isFirst = false;
				} else {
					query.append(" AND suministro.tipoTransformador = :tipoTransformador");
				}
			}
			
			if (suministro.getCortePorDeuda() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.cortePorDeuda = :cortePorDeuda");
					isFirst = false;
				} else {
					query.append(" AND suministro.cortePorDeuda = :cortePorDeuda");
				}
			}
			
			if (suministro.getSfid() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.sfid = :sfid");
					isFirst = false;
				} else {
					query.append(" AND suministro.sfid = :sfid");
				}
			}
			
			if (suministro.getHcError() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.hcError = :hcError");
					isFirst = false;
				} else {
					query.append(" AND suministro.hcError = :hcError");
				}
			}
			
			if (suministro.getHcLastop() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.hcLastop = :hcLastop");
					isFirst = false;
				} else {
					query.append(" AND suministro.hcLastop = :hcLastop");
				}
			}
			
			if (suministro.getIsDeleted() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.isDeleted = :isDeleted");
					isFirst = false;
				} else {
					query.append(" AND suministro.isDeleted = :isDeleted");
				}
			}
			
			if (suministro.getTipoLectura() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.tipoLectura = :tipoLectura");
					isFirst = false;
				} else {
					query.append(" AND suministro.tipoLectura = :tipoLectura");
				}
			}
			
			if (suministro.getEstadoConexion() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.estadoConexion = :estadoConexion");
					isFirst = false;
				} else {
					query.append(" AND suministro.estadoConexion = :estadoConexion");
				}
			}
			
			if (suministro.getTipoMedida() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.tipoMedida = :tipoMedida");
					isFirst = false;
				} else {
					query.append(" AND suministro.tipoMedida = :tipoMedida");
				}
			}
			
			if (suministro.getComunaReparto() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.comunaReparto = :comunaReparto");
					isFirst = false;
				} else {
					query.append(" AND suministro.comunaReparto = :comunaReparto");
				}
			}
			
			if (suministro.getComuna() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.comuna = :comuna");
					isFirst = false;
				} else {
					query.append(" AND suministro.comuna = :comuna");
				}
			}
			
			if (suministro.getNumeroMedidor() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.numeroMedidor = :numeroMedidor");
					isFirst = false;
				} else {
					query.append(" AND suministro.numeroMedidor = :numeroMedidor");
				}
			}
			
			if (suministro.getModeloMedidor() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.modeloMedidor = :modeloMedidor");
					isFirst = false;
				} else {
					query.append(" AND suministro.modeloMedidor = :modeloMedidor");
				}
			}
			
			if (suministro.getNumeroSuministro() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.numeroSuministro = :numeroSuministro");
					isFirst = false;
				} else {
					query.append(" AND suministro.numeroSuministro = :numeroSuministro");
				}
			}
			
			if (suministro.getNumeroTransformador() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.numeroTransformador = :numeroTransformador");
					isFirst = false;
				} else {
					query.append(" AND suministro.numeroTransformador = :numeroTransformador");
				}
			}

			if (suministro.getEstadoSuministro() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.estadoSuministro = :estadoSuministro");
					isFirst = false;
				} else {
					query.append(" AND suministro.estadoSuministro = :estadoSuministro");
				}
			}
			
			if (suministro.getMarcaMedidor() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.marcaMedidor = :marcaMedidor");
					isFirst = false;
				} else {
					query.append(" AND suministro.marcaMedidor = :marcaMedidor");
				}
			}
			
			if (suministro.getFechaCorte() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.fechaCorte = :fechaCorte");
					isFirst = false;
				} else {
					query.append(" AND suministro.fechaCorte = :fechaCorte");
				}
			}
			
			if (suministro.getPropiedadMedidor() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.propiedadMedidor = :propiedadMedidor");
					isFirst = false;
				} else {
					query.append(" AND suministro.propiedadMedidor = :propiedadMedidor");
				}
			}

			if (suministro.getIdEmpresa() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.idEmpresa = :idEmpresa");
					isFirst = false;
				} else {
					query.append(" AND suministro.idEmpresa = :idEmpresa");
				}
			}
			
			if (suministro.getDireccion() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.direccion = :direccion");
					isFirst = false;
				} else {
					query.append(" AND suministro.direccion = :direccion");
				}
			}

			if (suministro.getPagoEnProceso() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.pagoEnProceso = :pagoEnProceso");
					isFirst = false;
				} else {
					query.append(" AND suministro.pagoEnProceso = :pagoEnProceso");
				}
			}
			
			if (suministro.getNombreDuenoBoleta() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.nombreDuenoBoleta = :nombreDuenoBoleta");
					isFirst = false;
				} else {
					query.append(" AND suministro.nombreDuenoBoleta = :nombreDuenoBoleta");
				}
			}
			
			if (suministro.getBloque() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.bloque = :bloque");
					isFirst = false;
				} else {
					query.append(" AND suministro.bloque = :bloque");
				}
			}
			
			if (suministro.getTipoConexion() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.tipoConexion = :tipoConexion");
					isFirst = false;
				} else {
					query.append(" AND suministro.tipoConexion = :tipoConexion");
				}
			}

			/*if (suministro.getDireccionCliente() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.direccionCliente = :direccionCliente");
					isFirst = false;
				} else {
					query.append(" AND suministro.direccionCliente = :direccionCliente");
				}
			}*/
			
			if (suministro.getElectrodependiente() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.electrodependiente = :electrodependiente");
					isFirst = false;
				} else {
					query.append(" AND suministro.electrodependiente = :electrodependiente");
				}
			}
			
			if (suministro.getMedidaDisciplina() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.medidaDisciplina = :medidaDisciplina");
					isFirst = false;
				} else {
					query.append(" AND suministro.medidaDisciplina = :medidaDisciplina");
				}
			}
			
			if (suministro.getHorarioRacionamiento() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.horarioRacionamiento = :horarioRacionamiento");
					isFirst = false;
				} else {
					query.append(" AND suministro.horarioRacionamiento = :horarioRacionamiento");
				}
			}
			
			if (suministro.getCasosReiterados() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.casosReiterados = :casosReiterados");
					isFirst = false;
				} else {
					query.append(" AND suministro.casosReiterados = :casosReiterados");
				}
			}

			if (suministro.getTarifa() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.tarifa = :tarifa");
					isFirst = false;
				} else {
					query.append(" AND suministro.tarifa = :tarifa");
				}
			}

			if (suministro.getAlimentador() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.alimentador = :alimentador");
					isFirst = false;
				} else {
					query.append(" AND suministro.alimentador = :alimentador");
				}
			}
			
			if (suministro.getDireccionBoleta() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.direccionBoleta = :direccionBoleta");
					isFirst = false;
				} else {
					query.append(" AND suministro.direccionBoleta = :direccionBoleta");
				}
			}
			
			if (suministro.getSubestacionElectricaConexion() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.subestacionElectricaConexion = :subestacionElectricaConexion");
					isFirst = false;
				} else {
					query.append(" AND suministro.subestacionElectricaConexion = :subestacionElectricaConexion");
				}
			}
			
			if (suministro.getRuta() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.ruta = :ruta");
					isFirst = false;
				} else {
					query.append(" AND suministro.ruta = :ruta");
				}
			}
			
			if (suministro.getTipoSegmento() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.tipoSegmento = :tipoSegmento");
					isFirst = false;
				} else {
					query.append(" AND suministro.tipoSegmento = :tipoSegmento");
				}
			}

			if (suministro.getSystemDate() != null) {
				if (isFirst) {
					query.append(" WHERE suministro.systemDate = :systemDate");
					isFirst = false;
				} else {
					query.append(" AND suministro.systemDate = :systemDate");
				}
			}

			// añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());

			if (suministro.getId() != null) {
				result.setInteger("id", suministro.getId());
			}
			
			if (suministro.getName() != null) {
				result.setString("name", suministro.getName());
			}
			
			if (suministro.getFullElectric() != null) {
				result.setString("fullElectric", suministro.getFullElectric());
			}
			
			if (suministro.getCasosAbiertos() != null) {
				result.setBoolean("casosAbiertos", suministro.getCasosAbiertos());
			}
			
			if (suministro.getTipoTransformador() != null) {
				result.setString("tipoTransformador", suministro.getTipoTransformador());
			}

			if (suministro.getCortePorDeuda() != null) {
				result.setBoolean("cortePorDeuda", suministro.getCortePorDeuda());
			}
			
			if (suministro.getSfid() != null) {
				result.setString("sfid", suministro.getSfid());
			}
			
			if (suministro.getHcError() != null) {
				result.setString("hcError", suministro.getHcError());
			}
			
			if (suministro.getHcLastop() != null) {
				result.setString("hcLastop", suministro.getHcLastop());
			}
			
			if (suministro.getIsDeleted() != null) {
				result.setBoolean("isDeleted", suministro.getIsDeleted());
			}
			
			if (suministro.getTipoLectura() != null) {
				result.setString("tipoLectura", suministro.getTipoLectura());
			}
			
			if (suministro.getEstadoConexion() != null) {
				result.setString("estadoConexion", suministro.getEstadoConexion());
			}

			if (suministro.getTipoMedida() != null) {
				result.setString("tipoMedida", suministro.getTipoMedida());
			}
			
			if (suministro.getComunaReparto() != null) {
				result.setString("comunaReparto", suministro.getComunaReparto());
			}
			
			if (suministro.getComuna() != null) {
				result.setString("comuna", suministro.getComuna());
			}
			
			if (suministro.getNumeroMedidor() != null) {
				result.setString("numeroMedidor", suministro.getNumeroMedidor());
			}

			if (suministro.getModeloMedidor() != null) {
				result.setString("modeloMedidor", suministro.getModeloMedidor());
			}
			
			if (suministro.getNumeroSuministro() != null) {
				result.setString("numeroSuministro", suministro.getNumeroSuministro());
			}
			
			if (suministro.getNumeroTransformador() != null) {
				result.setString("numeroTransformador", suministro.getNumeroTransformador());
			}

			if (suministro.getFechaCorte() != null) {
				result.setDate("propiedadMedidor", suministro.getFechaCorte());
			}
			
			if (suministro.getPropiedadMedidor() != null) {
				result.setString("propiedadMedidor", suministro.getPropiedadMedidor());
			}

			if (suministro.getIdEmpresa() != null) {
				result.setString("idEmpresa", suministro.getIdEmpresa());
			}
			
			if (suministro.getDireccion() != null) {
				result.setString("direccion", suministro.getDireccion());
			}

			if (suministro.getPagoEnProceso() != null) {
				result.setBoolean("pagoEnProceso", suministro.getPagoEnProceso());
			}
			
			if (suministro.getNombreDuenoBoleta() != null) {
				result.setString("nombreDuenoBoleta", suministro.getNombreDuenoBoleta());
			}
			
			if (suministro.getBloque() != null) {
				result.setString("bloque", suministro.getBloque());
			}
			
			if (suministro.getTipoConexion() != null) {
				result.setString("tipoConexion", suministro.getTipoConexion());
			}

			/*if (suministro.getDireccionCliente() != null) {
				result.setString("direccionCliente", suministro.getDireccionCliente());
			}*/
			
			if (suministro.getElectrodependiente() != null) {
				result.setString("electrodependiente", suministro.getElectrodependiente());
			}
			
			if (suministro.getMedidaDisciplina() != null) {
				result.setString("medidaDisciplina", suministro.getMedidaDisciplina());
			}
			
			if (suministro.getHorarioRacionamiento() != null) {
				result.setString("horarioRacionamiento", suministro.getHorarioRacionamiento());
			}
			
			if (suministro.getCasosReiterados() != null) {
				result.setDouble("casosReiterados", suministro.getCasosReiterados());
			}

			if (suministro.getTarifa() != null) {
				result.setString("tarifa", suministro.getTarifa());
			}

			if (suministro.getAlimentador() != null) {
				result.setString("alimentador", suministro.getAlimentador());
			}
			
			if (suministro.getDireccionBoleta() != null) {
				result.setString("direccionBoleta", suministro.getDireccionBoleta());
			}
			
			if (suministro.getSubestacionElectricaConexion() != null) {
				result.setString("subestacionElectricaConexion", suministro.getSubestacionElectricaConexion());
			}
			
			if (suministro.getRuta() != null) {
				result.setString("ruta", suministro.getRuta());
			}
			
			if (suministro.getTipoSegmento() != null) {
				result.setString("tipoSegmento", suministro.getTipoSegmento());
			}

			if (suministro.getSystemDate() != null) {
				result.setDate("systemDate", suministro.getSystemDate());
			}

			List<SuministroVO> suministrosList;
			if(numeroSuministros == null){
				suministrosList = result.list(); 	 
			}else{

				suministrosList = result.setMaxResults(numeroSuministros).list(); 	 
			}
			
			logger.debug("--- Fin -- readSuministro ---");
			
			return suministrosList;

	    } catch (HibernateException e) {
	    	logger.error("--- readSuministro ", e); 
	    	logger.error("--- Fin -- readSuministro ---"); 
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Actualiza la fila de Suministro correspondiente al id de Suministro. Modifica todos los campos con el valor que hay en Suministro. 
	 * 
	 * @param Suministro
	 * @return
	 */
	@Transactional
    public int updateSuministro(SuministroVO Suministro) {
		
		logger.debug("--- Inicio -- updateSuministro ---");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Suministro);
			tx.commit();
			
			logger.debug("--- Fin -- updateSuministro ---");			
			return 1;
		} catch (HibernateException e) {
	    	tx.rollback();
			logger.error("--- updateSuministro ", e); 
	    	logger.error("--- Fin -- updateSuministro ---");
	    	return 0;
	    } finally {
	     	session.close(); 
	    }

    }
	
	/**
	 * Inserta un Suministro en BBDD
	 * @param Suministro
	 * @return
	 */
	public int insertSuministro(SuministroVO Suministro, Session session) {
		logger.debug("updateSuministro -- inicio");
		int numModif = 0;
		session.save(Suministro);
		return numModif;
	}
	
	/**
	 * Devuelve una lista de suministros utilizando los parametros del datatable
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SuministroVO> readSuministroDataTable(DataTableProperties dataTableProperties) {
		logger.debug("--- Inicio -- readSuministroDataTable ---");
		
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
			//DESCOMENTAR Y PROBAR, NO ESTA FUNCIONANDO, PERO LA IDEA ES ADAPTARLO PARA USARLO EN EL DIALOG DE ASOCIAR SUMINISTRO
			StringBuilder query = new StringBuilder("FROM SuministroVO suministro "
					+ "LEFT JOIN FETCH suministro.estadoConexionPickList estadoConexion "
					+ "LEFT JOIN FETCH suministro.estadoSuministroPickList estadoSuministro "
					+ "LEFT JOIN FETCH suministro.dirSuministroJoin direccionSumi ");
			
			if (dataTableProperties.getColumsInfo() != null && !dataTableProperties.getColumsInfo().isEmpty()) {
				query.append(" WHERE ");
				for (DataTableColumnInfo columnInfo : dataTableProperties.getColumsInfo()) {
					if ("name".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(suministro." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}					
					if ("direccionConcatenada".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(suministro." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}					
					if ("comuna".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(suministro." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("calle".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(direccionSumi." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}							
					if ("numero".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(direccionSumi." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
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
				if("estadoConexion".equals(order) || "estadoSuministro".equals(order)){
					query.append(" ORDER BY " + order + ".valor " + dirOrder);
				}else{
					query.append(" ORDER BY suministro." + order + " " + dirOrder);
				}
			}else{
				query.append(" ORDER BY suministro.name desc" );
			}
			
			Query result = session.createQuery(query.toString()).setFirstResult(numStart).setMaxResults(numLength);
			List<SuministroVO> suministroList = result.list();

			logger.debug("--- Fin -- readSuministroDataTable ---");
			
			return suministroList;
	    } catch (HibernateException e) {
	    	logger.error("--- readSuministroDataTable ", e); 
	    	logger.error("--- Fin -- readSuministroDataTable ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve el número de suministros utilizando los parametros del datatable
	 * 
	 * @return
	 */
	public Integer countSuministro(DataTableProperties dataTableProperties) {
		logger.debug("--- Inicio -- countSuministro ---");
		
		Session session = sessionFactory.openSession();
		int searchParamsCounter = 0;
		
		try {
			StringBuilder sqlQuery = new StringBuilder("SELECT COUNT(id) FROM SuministroVO suministro");
			
			if (dataTableProperties.getColumsInfo() != null && !dataTableProperties.getColumsInfo().isEmpty()) {
				sqlQuery.append(" WHERE ");
				for (DataTableColumnInfo columnInfo : dataTableProperties.getColumsInfo()) {
					if ("name".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append("UPPER(suministro." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("direccionConcatenada".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append("UPPER(suministro." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("comuna".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append("UPPER(suministro." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
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
			
			logger.debug("--- Fin -- countSuministro ---");
			
			return count.intValue();
			
	    } catch (HibernateException e) {
	    	logger.error("--- countSuministro ", e); 
	    	logger.error("--- Fin -- countSuministro ---");
	    } finally {
	    	session.close(); 
	    }
		return null;
	}
}