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

import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.dao.vo.SuministroVO;
import com.casosemergencias.util.datatables.DataTableColumnInfo;
import com.casosemergencias.util.datatables.DataTableProperties;

@Repository
public class HistoricBatchDAO {
	final static Logger logger = Logger.getLogger(HistoricBatchDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Inserta el historico en BBDD
	 * @param historico
	 * @return
	 */
	@Transactional
	public Integer insertHistoric(HistoricBatchVO historico) {

		logger.debug("--- Inicio -- insertHistoric ---");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(historico);
			tx.commit();
			logger.debug("--- Fin -- insertHistoric ---");
			return historico.getId();
		} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertHistoric: ", e);
			logger.error("--- Fin -- insertHistoric---");
			return 0;
		} finally {
			session.close();
		}

	}
	
	
	

	/**
	 * Devuelve una lista de historicBatchs utilizando los parametros del datatable
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<HistoricBatchVO> readHistoricBatchDataTable(DataTableProperties dataTableProperties) {
		logger.debug("--- Inicio -- readHistoricBatchDataTable ---");
		
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
			StringBuilder query = new StringBuilder("FROM HistoricBatchVO historicbatch ");
			
			if (dataTableProperties.getColumsInfo() != null && !dataTableProperties.getColumsInfo().isEmpty()) {
				query.append(" WHERE ");
				
				String startDate =new String();
				String endDate =new String();
				String startDateFilter =new String();
				String endDateFilter =new String();

				for (DataTableColumnInfo columnInfo : dataTableProperties.getColumsInfo()) {
					if ("object".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(historicbatch." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}					
					if ("operation".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(historicbatch." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}					
					if ("sfidRecord".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(historicbatch." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}							
					if ("success".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append(columnInfo.getData()+"="+columnInfo.getSearchValue());
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					if ("errorCause".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							query.append("UPPER(historicbatch." + columnInfo.getData() + ") LIKE UPPER('%" + columnInfo.getSearchValue() +"%')");
							query.append(" AND ");
							searchParamsCounter++;
						}
					}
					if ("startDate".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							startDate=columnInfo.getSearchValue();
						}
					}
					if ("endDate".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							endDate=columnInfo.getSearchValue();
						}
					}
					if ("startDateFilter".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							startDateFilter=columnInfo.getSearchValue();
						}
					}
					if ("endDateFilter".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							endDateFilter=columnInfo.getSearchValue();
						}
					}
				}
				
				//Seteamos filtrados de fechas a la query								
				if(startDate!= null && !"".equals(startDate)){
					if(startDateFilter!= null && !"".equals(startDateFilter)){
						//Conversion de fecha DATETIME a TIMESTAMP
						startDate=startDate.replace("T", " ");
						String dateFilter="";
						switch (startDateFilter) {
							case "equal":  dateFilter = "=";break;
							case "greaterOrEqual":  dateFilter = ">=";break;
							case "lessOrEqual":  dateFilter = "<=";break;
							case "greater":  dateFilter = ">";break;
							case "less":  dateFilter = "<";break;
						}
						query.append("start_date"+dateFilter+"'"+startDate+"'");
						query.append(" AND ");
						searchParamsCounter=searchParamsCounter+1;
					}					
				}
				
				if(endDate!= null && !"".equals(endDate)){
					if(endDateFilter!= null && !"".equals(endDateFilter)){
						//Conversion de fecha DATETIME a TIMESTAMP
						endDate=endDate.replace("T", " ");
						String dateFilter="";
						switch (endDateFilter) {
							case "equal":  dateFilter = "=";break;
							case "greaterOrEqual":  dateFilter = ">=";break;
							case "lessOrEqual":  dateFilter = "<=";break;
							case "greater":  dateFilter = ">";break;
							case "less":  dateFilter = "<";break;
						}
						query.append("end_date"+dateFilter+"'"+endDate+"'");
						query.append(" AND ");
						searchParamsCounter=searchParamsCounter+1;
					}					
				}				
			}
			
			if (searchParamsCounter == 0) {
				query.setLength(query.length() - 7);
			} else {
				query.setLength(query.length() - 5);
			}
			
			if (order != null && !"".equals(order) && dirOrder != null && !"".equals(dirOrder)) {
				query.append(" ORDER BY historicbatch." + order + " " + dirOrder);
			}else{
				query.append(" ORDER BY historicbatch.object desc" );

			}
			
			
			
			Query result = session.createQuery(query.toString()).setFirstResult(numStart).setMaxResults(numLength);
			logger.debug("--- Query de Historicos---" + result.list());
			
			List<HistoricBatchVO> historicBatchList = result.list();

			logger.info("--- Fin -- readHistoricBatchDataTable ---");
			
			return historicBatchList;
	    } catch (HibernateException e) {
	    	logger.error("--- readHistoricBatchDataTable ", e); 
	    	logger.error("--- Fin -- readHistoricBatchDataTable ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	
	public Integer getNumHistoricBatchs(DataTableProperties dataTableProperties) {
		logger.debug("--- Inicio -- getNumHistoricBatchs ---");

		Session session = sessionFactory.openSession();
		String startDate =new String();
		String endDate =new String();
		String startDateFilter =new String();
		String endDateFilter =new String();

		int searchParamsCounter = 0;

		try {
			StringBuilder sqlQuery = new StringBuilder("SELECT COUNT(id) FROM HistoricBatchVO  as historicbatch ");

			if (dataTableProperties.getColumsInfo() != null && !dataTableProperties.getColumsInfo().isEmpty()) {
				sqlQuery.append(" WHERE ");
				for (DataTableColumnInfo columnInfo : dataTableProperties.getColumsInfo()) {
					if ("object".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("operation".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
										
					if ("sfidRecord".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					
					if ("success".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					if ("errorCause".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							sqlQuery.append(columnInfo.getData() + " LIKE '%" + columnInfo.getSearchValue() +"%'");
							sqlQuery.append(" AND ");
							searchParamsCounter++;
						}
					}
					if ("startDate".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							startDate=columnInfo.getSearchValue();
						}
					}
					if ("endDate".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							endDate=columnInfo.getSearchValue();
						}
					}
					if ("startDateFilter".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							startDateFilter=columnInfo.getSearchValue();
						}
					}
					if ("endDateFilter".equals(columnInfo.getData())) {
						if (columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
							endDateFilter=columnInfo.getSearchValue();
						}
					}
				}
				//Seteamos filtrados de fechas a la query								
				if(startDate!= null && !"".equals(startDate)){
					if(startDateFilter!= null && !"".equals(startDateFilter)){
						//Conversion de fecha DATETIME a TIMESTAMP
						startDate=startDate.replace("T", " ");
						String dateFilter="";
						switch (startDateFilter) {
							case "equal":  dateFilter = "=";break;
							case "greaterOrEqual":  dateFilter = ">=";break;
							case "lessOrEqual":  dateFilter = "<=";break;
							case "greater":  dateFilter = ">";break;
							case "less":  dateFilter = "<";break;
						}
						sqlQuery.append("start_date"+dateFilter+"'"+startDate+"'");
						sqlQuery.append(" AND ");
						searchParamsCounter=searchParamsCounter+1;
					}					
				}
				
				if(endDate!= null && !"".equals(endDate)){
					if(endDateFilter!= null && !"".equals(endDateFilter)){
						//Conversion de fecha DATETIME a TIMESTAMP
						endDate=endDate.replace("T", " ");
						String dateFilter="";
						switch (endDateFilter) {
							case "equal":  dateFilter = "=";break;
							case "greaterOrEqual":  dateFilter = ">=";break;
							case "lessOrEqual":  dateFilter = "<=";break;
							case "greater":  dateFilter = ">";break;
							case "less":  dateFilter = "<";break;
						}
						sqlQuery.append("end_date"+dateFilter+"'"+endDate+"'");
						sqlQuery.append(" AND ");
						searchParamsCounter=searchParamsCounter+1;
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

			logger.debug("--- Fin -- getNumHistoricBatchs ---");

			return count.intValue();

		} catch (HibernateException e) {
			logger.error("--- Error en getNumHistoricBatchs: ", e);
			logger.error("--- Fin -- getNumHistoricBatchs ---");
		} finally {
			session.close();
		}
		return 0;
	}
	
	
	
	
	
	
}