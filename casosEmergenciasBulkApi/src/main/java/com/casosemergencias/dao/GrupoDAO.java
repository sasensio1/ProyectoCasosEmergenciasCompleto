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
import org.springframework.transaction.annotation.Transactional;
import com.casosemergencias.dao.vo.GroupVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

public class GrupoDAO {
	final static Logger logger = Logger.getLogger(AccountDAO.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
	/**
	 * Inserta un listado de Grupos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public int insertGroupListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Grupos ---");

		int cont = 0;
		boolean processOk;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		for(Object object:objectList){
			HistoricBatchVO historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_GROUP);
			historicoInsertRecord.setProcessId(processId);
			GroupVO grupoToInsert = new GroupVO();
			try{
				grupoToInsert=(GroupVO)object;
				
				historicoInsertRecord.setSfidRecord(grupoToInsert.getSfid());
				
				session.save(grupoToInsert);
				tx.commit();
				logger.debug("--- Fin -- insertGrupo ---" + grupoToInsert.getSfid());
				processOk = true;
				cont++;
			} catch (HibernateException e) {
			tx.rollback();
			logger.error("--- Error en insertGrupo: ---" + grupoToInsert.getSfid(), e);
			processOk = false;
			}
			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processOk ? null : ConstantesBatch.ERROR_INSERT_RECORD);
			historicBatchDAO.insertHistoric(historicoInsertRecord);						
		}
		logger.debug("--- Fin -- insert Listado Grupos ---");
		session.close();
		return cont;	
	}
	

	/**
	 * Actualiza un listado de grupos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public int updateGroupListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Grupos ---");

		int cont = 0;
		boolean processOk;
		
		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_GROUP);
			historicoUpdateRecord.setProcessId(processId);
			
			GroupVO grupoToUpdate = new GroupVO();
			try{
				grupoToUpdate=(GroupVO)object;
				
				historicoUpdateRecord.setSfidRecord(grupoToUpdate.getSfid());
				
				//1.1- Seteamos los campos a actualizar distintos de String				
				Date createddate=grupoToUpdate.getCreateddate();
				
				//1.2-Construimos la query							
				Query sqlUpdateQuery =session.createQuery("UPDATE GroupVO SET "
				+ "name= :name,createddate="+createddate			
				+	
				" WHERE sfid = :sfidFiltro");
				
				//1.3-Seteamos los campos a actualizar de tipo String	
				
					//1.3.1-Seteamos los campos que no filtren la query						
					sqlUpdateQuery.setParameter("name", grupoToUpdate.getName());
	
					//1.3.2-Seteamos el sfid,campo por el que filtramos la query								
					sqlUpdateQuery.setParameter("sfidFiltro", grupoToUpdate.getSfid());
					
				//1.5-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
							
				logger.debug("--- Fin -- updateGrupo ---" + grupoToUpdate.getSfid());
				processOk = true;
				cont++;
			} catch (HibernateException e) {
			logger.error("--- Error en updateGrupo: ---" + grupoToUpdate.getSfid(), e);
			processOk = false;
			} 
			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processOk ? null : ConstantesBatch.ERROR_UPDATE_RECORD);
			historicBatchDAO.insertHistoric(historicoUpdateRecord); 						
		}
		logger.debug("--- Fin -- update Listado Grupos ---");
		session.close();
		return cont;

	}
		
	/**
	 * Borra un listado de grupos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
		
	@Transactional
	public int deleteGroupListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Grupos ---");
		
		int cont = 0;
		boolean processOk;

		Session session = sessionFactory.openSession();
		for(Object object:objectList){
			
			HistoricBatchVO historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_GROUP);
			historicoDeleteRecord.setProcessId(processId);
			
			GroupVO grupoToDelete = new GroupVO();
			try{
				grupoToDelete=(GroupVO)object;
				
				historicoDeleteRecord.setSfidRecord(grupoToDelete.getSfid());
				
				Query sqlDeleteQuery =session.createQuery("DELETE GroupVO  WHERE sfid = :sfidFiltro");
				
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setParameter("sfidFiltro", grupoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
							
				logger.debug("--- Fin -- deleteGrupo ---" + grupoToDelete.getSfid());
				
				processOk = true;
				cont++;
				
			} catch (HibernateException e) {
			logger.error("--- Error en deleteGrupo: ---" + grupoToDelete.getSfid(), e);
			processOk = false;
			} 
			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setEndDate(new Date());
			historicoDeleteRecord.setErrorCause(processOk ? null : ConstantesBatch.ERROR_DELETE_RECORD);
			historicBatchDAO.insertHistoric(historicoDeleteRecord);						
		}
		logger.debug("--- Fin -- delete Listado Grupos ---");
		session.close();
		return cont;

	}
	
	
	

}
