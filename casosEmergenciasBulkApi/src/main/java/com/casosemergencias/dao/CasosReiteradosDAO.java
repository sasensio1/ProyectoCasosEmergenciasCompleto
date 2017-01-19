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

import com.casosemergencias.dao.vo.CasosReiteradosVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class CasosReiteradosDAO {

final static Logger logger = Logger.getLogger(CasosReiteradosDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
	/**
	 * Devuelve una lista con todas los CaseHistory de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CasosReiteradosVO> readAllCasosReiterados() {
		logger.debug("--- Inicio -- readAllCasosReiterados ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from CasosReiteradosVO");
			List<CasosReiteradosVO> casoReiteradoList = query.list(); 

			logger.debug("--- Fin -- readAllCasosReiterados ---");
			
			return casoReiteradoList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAllCasosReiterados ", e); 
	    	logger.error("--- Fin -- readAllCasosReiterados ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve una lista con todas los CaseHistory de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CasosReiteradosVO> readCasosReiterados(CasosReiteradosVO casoReiterado) {
		logger.debug("--- Inicio -- readCasosReiterados ---");
		
		Session session = sessionFactory.openSession();
		boolean isFirst = true;
				
		try {
			// preparamos la query
			StringBuilder query = new StringBuilder("from CasosReiteradosVO as casoReiterado");
			if (casoReiterado.getId() != null) {
				if (isFirst) {
					query.append(" WHERE casoReiterado.id = '" + casoReiterado.getId() + "'");
					isFirst = false;
				} else {
					query.append(" AND casoReiterado.id = '" + casoReiterado.getId() + "'");
				}
			}
			if (casoReiterado.getSfid() != null) {
				if (isFirst) {
					query.append(" WHERE casoReiterado.sfid = '" + casoReiterado.getSfid() + "'");
					isFirst = false;
				} else {
					query.append(" AND casoReiterado.sfid = '" + casoReiterado.getSfid() + "'");
				}
			}
			if (casoReiterado.getName() != null) {
				if (isFirst) {
					query.append(" WHERE casoReiterado.name = '" + casoReiterado.getName() + "'");
					isFirst = false;
				} else {
					query.append(" AND casoReiterado.name = '" + casoReiterado.getName() + "'");
				}
			}
			if (casoReiterado.getNumCasos() != null) {
				if (isFirst) {
					query.append(" WHERE casoReiterado.numCasos = " + casoReiterado.getNumCasos());
					isFirst = false;
				} else {
					query.append(" AND casoReiterado.numCasos = " + casoReiterado.getNumCasos());
				}
			}
			if (casoReiterado.getNumDias() != null) {
				if (isFirst) {
					query.append(" WHERE casoReiterado.numDias = " + casoReiterado.getNumDias());
					isFirst = false;
				} else {
					query.append(" AND casoReiterado.numDias = " + casoReiterado.getNumDias());
				}
			}
			Query result = session.createQuery(query.toString());			
			List<CasosReiteradosVO> casoReiteradoList = result.list(); 

			logger.debug("--- Fin -- readCasosReiterados ---");
			
			return casoReiteradoList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readCasosReiterados ", e); 
	    	logger.error("--- Fin -- readCasosReiterados ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve una lista con todas los CaseHistory de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public CasosReiteradosVO readCasosReiteradosByName(String name) {
		logger.debug("--- Inicio -- readCasosReiteradosByName ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			// preparamos la query
			StringBuilder query = new StringBuilder("from CasosReiteradosVO as casoReiterado "
					+ "WHERE casoReiterado.name = '"+name +"'");
		
			
			Query result = session.createQuery(query.toString());			
			List<CasosReiteradosVO> casoReiteradoList = result.list(); 

			logger.debug("--- Fin -- readCasosReiterados ---");
			
			return casoReiteradoList.get(0);
			
	    } catch (HibernateException e) {
	    	logger.error("--- readCasosReiterados ", e); 
	    	logger.error("--- Fin -- readCasosReiterados ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	
	
	
	
	/**
	 * Inserta un listado de CasoReiterados venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public int insertCasosReiteradosListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado CasoReiterados ---");

		int cont = 0;
		boolean processOk;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			
			HistoricBatchVO historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_REPEATED_CASES);
			historicoInsertRecord.setProcessId(processId);
			
			CasosReiteradosVO casoReiteradoToInsert = new CasosReiteradosVO();
			try{
				casoReiteradoToInsert=(CasosReiteradosVO)object;
				
				historicoInsertRecord.setSfidRecord(casoReiteradoToInsert.getSfid());
				
				session.save(casoReiteradoToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertCasoReiterado ---" + casoReiteradoToInsert.getSfid());
				
				processOk = true;
				cont++;
				
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertCasoReiterado: ---" + casoReiteradoToInsert.getSfid(), e);
			processOk = false;
			}
			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processOk ? null : ConstantesBatch.ERROR_INSERT_RECORD);
			historicBatchDAO.insertHistoric(historicoInsertRecord);						
		}
		logger.debug("--- Fin -- insert Listado CasoReiterados ---");
		session.close();
		return cont;
	}
	

	/**
	 * Actualiza un listado de casoReiterados venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public int updateCasosReiteradosListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado CasoReiterados ---");
		
		int cont = 0;
		boolean processOk;
		
		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_REPEATED_CASES);
			historicoUpdateRecord.setProcessId(processId);
			
			CasosReiteradosVO casoReiteradoToUpdate = new CasosReiteradosVO();
			try{
				casoReiteradoToUpdate=(CasosReiteradosVO)object;
				
				historicoUpdateRecord.setSfidRecord(casoReiteradoToUpdate.getSfid());
				
				//1.1- Seteamos los campos a actualizar distintos de String				
				Double	numbercases__c=casoReiteradoToUpdate.getNumCasos();
				Double	numberdays__c=casoReiteradoToUpdate.getNumDias();
				Date createddate=casoReiteradoToUpdate.getCreatedDate();
				
				//1.2-Construimos la query							
				Query sqlUpdateQuery =session.createQuery("UPDATE CasosReiteradosVO SET "
				+ "name= :name,numbercases__c="+numbercases__c+",numberdays__c="+numberdays__c+","
				+ "createddate="+createddate				
				+	
				" WHERE sfid = :sfidFiltro");
				
				//1.3-Seteamos los campos a actualizar de tipo String	
				
				    //1.3.1-Seteamos los campos que no filtren la query						
					sqlUpdateQuery.setParameter("name", casoReiteradoToUpdate.getName());
	
					//1.3.2-Seteamos el sfid,campo por el que filtramos la query							
					sqlUpdateQuery.setParameter("sfidFiltro", casoReiteradoToUpdate.getSfid());
				
				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateCasoReiterado ---" + casoReiteradoToUpdate.getSfid());
				
				processOk = true;
				cont++;
				
			} catch (HibernateException e) {
			logger.error("--- Error en updateCasoReiterado: ---" + casoReiteradoToUpdate.getSfid(), e);
			processOk = false;
			} 
			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processOk ? null : ConstantesBatch.ERROR_UPDATE_RECORD);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);					
		}
		logger.debug("--- Fin -- update Listado CasoReiterados ---");
		session.close();
		return cont;

	}
		
	/**
	 * Borra un listado de casoReiterados venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public int deleteCasosReiteradosListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado CasoReiterados ---");
		
		int cont = 0;
		boolean processOk;
		
		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_REPEATED_CASES);
			historicoDeleteRecord.setProcessId(processId);
			
			CasosReiteradosVO casoReiteradoToDelete = new CasosReiteradosVO();
			try{
				casoReiteradoToDelete=(CasosReiteradosVO)object;
				
				historicoDeleteRecord.setSfidRecord(casoReiteradoToDelete.getSfid());
				
				Query sqlDeleteQuery =session.createQuery("DELETE CasosReiteradosVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", casoReiteradoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteCasoReiterado ---" + casoReiteradoToDelete.getSfid());
				
				processOk = true;
				cont++;
				
			} catch (HibernateException e) {
			logger.error("--- Error en deleteCasoReiterado: ---" + casoReiteradoToDelete.getSfid(), e);
			processOk = false;
			} 
			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setEndDate(new Date());
			historicoDeleteRecord.setErrorCause(processOk ? null : ConstantesBatch.ERROR_DELETE_RECORD);
			historicBatchDAO.insertHistoric(historicoDeleteRecord);					
		}
		logger.debug("--- Fin -- delete Listado CasoReiterados ---");
		session.close();
		return cont;

	}
	
	
	
	
	
	
	
}
