package com.casosemergencias.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.dao.vo.SuministroVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class SuministroDAO {
	final static Logger logger = Logger.getLogger(SuministroDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
	/**
	 * Inserta un listado de Suministros venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int insertSuministroListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Suministros ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		SuministroVO suministroToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_POINT_OF_DELIVERY);
			historicoInsertRecord.setProcessId(processId);
			suministroToInsert = new SuministroVO();

			try {
				suministroToInsert = (SuministroVO) object;
				historicoInsertRecord.setSfidRecord(suministroToInsert.getSfid());
				session.save(suministroToInsert);

				logger.debug("--- Fin -- insertSuministro ---" + suministroToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en insertSuministro: ---" + suministroToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}
			
			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado Suministros ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de suministros venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateSuministroListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Suministros ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		SuministroVO suministroToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
				
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_POINT_OF_DELIVERY);
			historicoUpdateRecord.setProcessId(processId);
			suministroToUpdate = new SuministroVO();
			
			try {
				suministroToUpdate = (SuministroVO) object;
				historicoUpdateRecord.setSfidRecord(suministroToUpdate.getSfid());
				//1.2-Construimos la query							
				Query sqlUpdateQuery = session.createQuery("UPDATE SuministroVO "
													    + "	   SET name = :name"
													    + "		 , fullelectric__c = :fullelectric__c"
													    + "		 , opencases__c = :opencases__c"
													    + "		 , transformertype__c = :transformertype__c"
													    + "		 , cuttingdebt__c = :cuttingdebt__c"
													    + "		 , readingtype__c = :readingtype__c"
													    + "		 , readingprocess__c = :readingprocess__c"
													    + "		 , connectionstatus__c = :connectionstatus__c"
													    + "		 , metertype__c = :metertype__c"
													    + "		 , municipalityallocation__c = :municipalityallocation__c"
													    + "		 , municipality__c = :municipality__c"
													    + "		 , meternumber__c = :meternumber__c"
													    + "		 , metermodel__c = :metermodel__c"
													    + "		 , pointofdeliverynumber__c = :pointofdeliverynumber__c"
													    + "		 , transformernumber__c = :transformernumber__c"
													    + "		 , pointofdeliverystatus__c = :pointofdeliverystatus__c"
													    + "		 , meterbrand__c = :meterbrand__c"
													    + "		 , cutoffdate__c = :cutoffdate__c"
													    + "		 , meterproperty__c = :meterproperty__c"
													    + " 	 , companyid__c = :companyid__c"
													    + "		 , detailaddress__c = :detailaddress__c"
													    + "		 , paymentprocess__c = :paymentprocess__c"
													    + "		 , ballotname__c = :ballotname__c"
													    + "		 , block__c = :block__c"
													    + "		 , connectiontype__c = :connectiontype__c"
													    + "		 , electrodependant__c = :electrodependant__c"					
													    + "		 , disciplinarymeasure__c = :disciplinarymeasure__c"
													    + "		 , rationingschedule__c = :rationingschedule__c"
													    + (suministroToUpdate.getCasosReiterados() != null ? "		 , repeatedcases__c = :repeatedcases__c" : "")
													    + "		 , rate__c = :rate__c"					
													    + "		 , feedernumber__c = :feedernumber__c"
													    + "		 , distributionaddress__c = :distributionaddress__c"
													    + "		 , electricalsubstationconnection__c = :electricalsubstationconnection__c"
													    + "		 , route__c = :route__c"
													    + "		 , segmenttype__c = :segmenttype__c"
													    + "		 , pointofdeliveryaddress__c = :pointofdeliveryaddress__c"				
													    + " WHERE sfid = :sfidFiltro");
				
				//1.2-Seteamos los campos
				sqlUpdateQuery.setParameter("name", suministroToUpdate.getName());
				sqlUpdateQuery.setParameter("fullelectric__c", suministroToUpdate.getFullElectric());
				sqlUpdateQuery.setBoolean("opencases__c", suministroToUpdate.getCasosAbiertos());
				sqlUpdateQuery.setParameter("transformertype__c", suministroToUpdate.getTipoTransformador());
				sqlUpdateQuery.setBoolean("cuttingdebt__c", suministroToUpdate.getCortePorDeuda());
				sqlUpdateQuery.setParameter("readingtype__c", suministroToUpdate.getTipoLectura());
				sqlUpdateQuery.setParameter("readingprocess__c", suministroToUpdate.getProcesoLectura());
				sqlUpdateQuery.setParameter("connectionstatus__c", suministroToUpdate.getEstadoConexion());
				sqlUpdateQuery.setParameter("metertype__c", suministroToUpdate.getTipoMedida());
				sqlUpdateQuery.setParameter("municipalityallocation__c", suministroToUpdate.getComunaReparto());
				sqlUpdateQuery.setParameter("municipality__c", suministroToUpdate.getComuna());
				sqlUpdateQuery.setParameter("meternumber__c", suministroToUpdate.getNumeroMedidor());
				sqlUpdateQuery.setParameter("metermodel__c", suministroToUpdate.getModeloMedidor());
				sqlUpdateQuery.setParameter("pointofdeliverynumber__c", suministroToUpdate.getNumeroSuministro());
				sqlUpdateQuery.setParameter("transformernumber__c", suministroToUpdate.getNumeroTransformador());
				sqlUpdateQuery.setParameter("pointofdeliverystatus__c", suministroToUpdate.getEstadoSuministro());
				sqlUpdateQuery.setParameter("meterbrand__c", suministroToUpdate.getMarcaMedidor());
				sqlUpdateQuery.setTimestamp("cutoffdate__c", suministroToUpdate.getFechaCorte());
				sqlUpdateQuery.setParameter("meterproperty__c", suministroToUpdate.getPropiedadMedidor());
				sqlUpdateQuery.setParameter("companyid__c", suministroToUpdate.getIdEmpresa());
				sqlUpdateQuery.setParameter("detailaddress__c", suministroToUpdate.getDireccion());
				sqlUpdateQuery.setBoolean("paymentprocess__c", suministroToUpdate.getPagoEnProceso());
				sqlUpdateQuery.setParameter("ballotname__c", suministroToUpdate.getNombreDuenoBoleta());
				sqlUpdateQuery.setParameter("block__c", suministroToUpdate.getBloque());
				sqlUpdateQuery.setParameter("connectiontype__c", suministroToUpdate.getTipoConexion());
				sqlUpdateQuery.setParameter("electrodependant__c", suministroToUpdate.getElectrodependiente());
				sqlUpdateQuery.setParameter("disciplinarymeasure__c", suministroToUpdate.getMedidaDisciplina());
				sqlUpdateQuery.setParameter("rationingschedule__c", suministroToUpdate.getHorarioRacionamiento());
				if (suministroToUpdate.getCasosReiterados() != null) {
					sqlUpdateQuery.setDouble("repeatedcases__c", suministroToUpdate.getCasosReiterados());
				}
				sqlUpdateQuery.setParameter("rate__c", suministroToUpdate.getTarifa());
				sqlUpdateQuery.setParameter("feedernumber__c", suministroToUpdate.getAlimentador());
				sqlUpdateQuery.setParameter("distributionaddress__c", suministroToUpdate.getDireccionBoleta());
				sqlUpdateQuery.setParameter("electricalsubstationconnection__c", suministroToUpdate.getSubestacionElectricaConexion());
				sqlUpdateQuery.setParameter("route__c", suministroToUpdate.getRuta());
				sqlUpdateQuery.setParameter("segmenttype__c", suministroToUpdate.getTipoSegmento());
				sqlUpdateQuery.setParameter("pointofdeliveryaddress__c", suministroToUpdate.getDireccionConcatenada());
				sqlUpdateQuery.setParameter("sfidFiltro", suministroToUpdate.getSfid());
									
				//1.3-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				
				logger.debug("--- Fin -- updateSuministro ---" + suministroToUpdate.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateSuministro: ---" + suministroToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			} 

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado Suministros ---");
		session.close();
		return processedRecords;
	}
		
	/**
	 * Borra un listado de suministros venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteSuministroListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Suministros ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		SuministroVO suministroToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_POINT_OF_DELIVERY);
			historicoDeleteRecord.setProcessId(processId);
			suministroToDelete = new SuministroVO();
			
			try {
				suministroToDelete = (SuministroVO) object;
				historicoDeleteRecord.setSfidRecord(suministroToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE SuministroVO  WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setString("sfidFiltro", suministroToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
				
				logger.debug("--- Fin -- deleteSuministro ---" + suministroToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteSuministro: ---" + suministroToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			} 

			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);		
		}
		logger.debug("--- Fin -- delete Listado Suministros ---");
		session.close();
		return processedRecords;
	}
}