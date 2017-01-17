package com.casosemergencias.logic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.batch.FieldLabelTableCreatorBatch;
import com.casosemergencias.batch.PicklistTableCreatorBatch;
import com.casosemergencias.batch.SalesforceSoapBulkApiInvokerBatch;
import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;
import com.casosemergencias.batch.bean.OperationType;
import com.casosemergencias.batch.util.BatchObjectsMapper;
import com.casosemergencias.dao.HistoricBatchDAO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.model.HistoricBatch;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.datatables.DataTableProperties;

public class BatchServiceImpl implements BatchService {
	
	final static Logger logger = Logger.getLogger(CaseService.class);

	@Autowired
	FieldLabelTableCreatorBatch fieldLabelTableCreatorBatch;
	
	@Autowired
	PicklistTableCreatorBatch picklistTableCreatorBatch;
	
	@Autowired
	SalesforceSoapBulkApiInvokerBatch soapBulkApiInvokerBatch;
	
	@Autowired
	private HistoricBatchDAO historicBatchDao;
	
	@Autowired
	private BatchObjectsMapper batchObjectsMapper;
	
	@Override
	public void updateHerokuPickListTable() {
		picklistTableCreatorBatch.fillHerokuPicklistTable();
	}
	
	@Override
	public void updateHerokuFieldLabelTable() {
		fieldLabelTableCreatorBatch.fillHerokuFieldLabelTable();
	}
	
	@Override
	public void getInfoToUpdateFromBulkApi(Date processStartDate, Date processEndDate) {
		soapBulkApiInvokerBatch.getAllBulkApiInfo(processStartDate, processEndDate);
	}
	
	@Override
	public void updateHerokuObjectsFromBulkApi(String objectName, BulkApiInfoContainerBatch bulkApiInfoContainer) {
		
		String objectService = batchObjectsMapper.getObjectNamesServicesMap().get(objectName);
		String objectNameServicesMethods = batchObjectsMapper.getObjectNamesServicesMethodsMap().get(objectName);
		 
		if(bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT) != null && !bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT).isEmpty()){
			Class<?> service;
			try {
				service = Class.forName(objectService);
				String methodName = "insert" + objectNameServicesMethods + "SfList";
				Method metodo = service.getDeclaredMethod(methodName);
				
				metodo.invoke(bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT));
			
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				logger.error("ERROR updateHerokuObjectsFromBulkApi INSERT");
			} catch (NoSuchMethodException | SecurityException e) {
				logger.error("ERROR updateHerokuObjectsFromBulkApi INSERT");
			} catch (ClassNotFoundException e) {
				logger.error("ERROR updateHerokuObjectsFromBulkApi INSERT");
			}
			 
		}
		if(bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE) != null && !bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE).isEmpty()){
			Class<?> service;
			try {
				service = Class.forName(objectService);
				String methodName = "update" + objectNameServicesMethods + "SfList";
				Method metodo = service.getDeclaredMethod(methodName);
				
				metodo.invoke(bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE));
			
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				logger.error("ERROR updateHerokuObjectsFromBulkApi UPDATE");
			} catch (NoSuchMethodException | SecurityException e) {
				logger.error("ERROR updateHerokuObjectsFromBulkApi UPDATE");
			} catch (ClassNotFoundException e) {
				logger.error("ERROR updateHerokuObjectsFromBulkApi UPDATE");
			}
			 
		}
		if(bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE) != null && !bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE).isEmpty()){
			Class<?> service;
			try {
				service = Class.forName(objectService);
				String methodName = "delete" + objectNameServicesMethods + "SfList";
				Method metodo = service.getDeclaredMethod(methodName);
				
				metodo.invoke(bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE));
			
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				logger.error("ERROR updateHerokuObjectsFromBulkApi DELETE");
			} catch (NoSuchMethodException | SecurityException e) {
				logger.error("ERROR updateHerokuObjectsFromBulkApi DELETE");
			} catch (ClassNotFoundException e) {
				logger.error("ERROR updateHerokuObjectsFromBulkApi DELETE");
			}
			 
		}
	}
	
	/**
	 * Metodo que devuelve una lista con todos los HistoricBatchs que hay en BBDD
	 * 
	 * @return
	 */
	@Override
	public List<HistoricBatch> readAllHistoricBatch(DataTableProperties propDatatable) {
		
		logger.debug("--- Inicio -- readAllHistoricBatch ---");
		
		List<HistoricBatch> listHistoricBatch = new ArrayList<>();
		List<HistoricBatchVO> listHistoricBatchsVO = historicBatchDao.readHistoricBatchDataTable(propDatatable);

		logger.debug("--- Inicio -- readAllHistoricBatch historicBatchs en la lista: " + listHistoricBatchsVO.size() + " ---");
		
		for (HistoricBatchVO historicBatchVO : listHistoricBatchsVO) {
			HistoricBatch historicBatch = new HistoricBatch();
			ParserModelVO.parseDataModelVO(historicBatchVO, historicBatch);
			listHistoricBatch.add(historicBatch);
		}
		
		logger.debug("--- Fin -- readAllHistoricBatch ---");
		return listHistoricBatch;
	}
	
	public Integer getNumHistoricBatchs(DataTableProperties propDatatable){
		logger.debug("--- getNumCasos ---");
		return historicBatchDao.getNumHistoricBatchs(propDatatable);
	}
	
	
}