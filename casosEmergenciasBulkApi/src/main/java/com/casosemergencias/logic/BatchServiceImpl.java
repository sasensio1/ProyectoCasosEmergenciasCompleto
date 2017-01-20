package com.casosemergencias.logic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.batch.CaseCommentUpdaterBatch;
import com.casosemergencias.batch.FieldLabelTableCreatorBatch;
import com.casosemergencias.batch.HerokuUserUpdaterBatch;
import com.casosemergencias.batch.PicklistTableCreatorBatch;
import com.casosemergencias.batch.SalesforceRestApiInvokerBatch;
import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;
import com.casosemergencias.batch.bean.OperationType;
import com.casosemergencias.batch.util.BatchObjectsMapper;
import com.casosemergencias.dao.HistoricBatchDAO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.model.HistoricBatch;
import com.casosemergencias.util.ApplicationContextProvider;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.ConstantesBatch;
import com.casosemergencias.util.constants.ConstantesBulkApi;
import com.casosemergencias.util.datatables.DataTableProperties;

public class BatchServiceImpl implements BatchService {
	
	final static Logger LOGGER = Logger.getLogger(CaseService.class);
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
	@Autowired
	FieldLabelTableCreatorBatch fieldLabelTableCreatorBatch;
	
	@Autowired
	PicklistTableCreatorBatch picklistTableCreatorBatch;
	
	@Autowired
	SalesforceRestApiInvokerBatch restApiInvokerBatch;
	
	@Autowired
	CaseCommentUpdaterBatch caseCommentUpdaterBatch;
	
	@Autowired
	HerokuUserUpdaterBatch herokuUserUpdaterBatch;
	
	@Autowired
	private HistoricBatchDAO historicBatchDao;
	
	@Autowired
	private BatchObjectsMapper batchObjectsMapper;
	
	@Autowired
	private ApplicationContextProvider applicationContextProvider;
	
	@Override
	public void updateHerokuPickListTable() {
		picklistTableCreatorBatch.fillHerokuPicklistTable();
	}
	
	@Override
	public void updateHerokuFieldLabelTable() {
		fieldLabelTableCreatorBatch.fillHerokuFieldLabelTable();
	}
	
	@Override
	public void updateCaseCommentTable() {
		caseCommentUpdaterBatch.updateCaseCommentInfo();
	}
	
	@Override
	public void updateHerokuUserTable() {
		herokuUserUpdaterBatch.updateHerokuUserInfo();
	}
	
	@Override
	public boolean updateObjectsInfoTables(Date processStartDate, Date processEndDate,String objectName) {
		
		boolean resultProcess=false;
		
		restApiInvokerBatch.setProcessStartDate(processStartDate);
		restApiInvokerBatch.setProcessEndDate(processEndDate);
		restApiInvokerBatch.setObjectName(objectName);	
		restApiInvokerBatch.setManualProcess(true);
		
		restApiInvokerBatch.updateObjectsWithRestApiInfo();		
		resultProcess=restApiInvokerBatch.isResultProccess();
		
		return resultProcess;

	}
	
	@Override
	public boolean updateHerokuObjectsFromBulkApi(BulkApiInfoContainerBatch bulkApiInfoContainer, String processId) {
		LOGGER.trace("Entrando en updateHerokuObjectsFromBulkApi para actualizar registros");
		boolean resultOk = true;
		boolean insertOk = true;
		boolean updateOk = true;
		boolean deleteOk = true;
		String processErrorCause = null;
		
		HistoricBatchVO historicoProcess = new HistoricBatchVO();
		historicoProcess.setStartDate(new Date());
		historicoProcess.setOperation(ConstantesBatch.OBJECT_PROCESS);
		historicoProcess.setProcessId(processId);
		historicoProcess.setObject(batchObjectsMapper.getObjectHistoricNamesMap().get(bulkApiInfoContainer.getEntityName()));
		
		if (bulkApiInfoContainer != null && bulkApiInfoContainer.getRecordsMap() != null) {
			if (bulkApiInfoContainer.getTotalRecords() > 0) {
				LOGGER.info("Registros a tratar: " + bulkApiInfoContainer.getTotalRecords());
				String objectService = batchObjectsMapper.getObjectNamesServicesMap().get(bulkApiInfoContainer.getEntityName());
				String objectNameServicesMethods = batchObjectsMapper.getObjectNamesServicesMethodsMap().get(bulkApiInfoContainer.getEntityName());
				
				//Registros a insertar
				insertOk = insertRecordsIntoDatabase(bulkApiInfoContainer, processId, objectService, objectNameServicesMethods);
				
				//Registros a actualizar
				updateOk = updateRecordsIntoDatabase(bulkApiInfoContainer, processId, objectService, objectNameServicesMethods);
				
				//Registros a eliminar
				deleteOk = deleteRecordsFromDatabase(bulkApiInfoContainer, processId, objectService, objectNameServicesMethods);
				
				if (!insertOk || !updateOk || !deleteOk) {
					resultOk = false;
					processErrorCause = ConstantesBatch.ERROR_PROCESS_OBJECT;
				}
			} else {
				LOGGER.error("No hay registros a actualizar");
				resultOk = true;
			}
		} else {
			LOGGER.error("Los datos a actualizar son nulos");
			resultOk = false;
			processErrorCause = ConstantesBatch.ERROR_PROCESS_OBJECT_NULL_RECORDS;
		}
		historicoProcess.setEndDate(new Date());
		historicoProcess.setSuccess(resultOk);
		historicoProcess.setErrorCause(processErrorCause);
		historicBatchDAO.insertHistoric(historicoProcess);
		return resultOk;
	}

	/**
	 * @param bulkApiInfoContainer
	 * @param processId
	 * @param objectService
	 * @param objectNameServicesMethods
	 * @return
	 */
	private boolean insertRecordsIntoDatabase(BulkApiInfoContainerBatch bulkApiInfoContainer, String processId, String objectService, String objectNameServicesMethods) {
		boolean insertOk;
		int cont = 0;
		String processInsertErrorCause = null;
		HistoricBatchVO historicoProcessInsert = new HistoricBatchVO();
		historicoProcessInsert.setStartDate(new Date());
		historicoProcessInsert.setOperation(ConstantesBatch.INSERT_PROCESS);
		historicoProcessInsert.setProcessId(processId);
		historicoProcessInsert.setObject(batchObjectsMapper.getObjectHistoricNamesMap().get(bulkApiInfoContainer.getEntityName()));
		
		if (bulkApiInfoContainer.getRecordsMap().containsKey(OperationType.INSERT)
				&& bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT) != null
				&& !bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT).isEmpty()) {
			historicoProcessInsert.setTotalRecords(bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT).size());
			try {
				cont = callSpecificServiceByReflection(objectService, objectNameServicesMethods, OperationType.INSERT, bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT), processId);
				if (cont == bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT).size()) {
					insertOk = true;
				} else {
					insertOk = false;
					processInsertErrorCause = ConstantesBatch.ERROR_INSERT_PROCESS;
				}
			} catch (Exception exception) {
				LOGGER.error("Error tratando los registros", exception);
				insertOk = false;
				processInsertErrorCause = ConstantesBatch.ERROR_INSERT_PROCESS_EXCEPTION_REFLECTION;
			}
		} else {
			if (bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT).isEmpty()) {
				insertOk = true;
			} else {
				insertOk = false;
				processInsertErrorCause = ConstantesBatch.ERROR_INSERT_PROCESS_LIST_NULL;
			}
		}
		
		historicoProcessInsert.setEndDate(new Date());
		historicoProcessInsert.setSuccess(insertOk);
		historicoProcessInsert.setErrorCause(processInsertErrorCause);
		historicoProcessInsert.setProcessedRecords(cont);
		historicBatchDAO.insertHistoric(historicoProcessInsert);
		return insertOk;
	}

	/**
	 * @param bulkApiInfoContainer
	 * @param processId
	 * @param insertOk
	 * @param objectService
	 * @param objectNameServicesMethods
	 * @return
	 */
	private boolean updateRecordsIntoDatabase(BulkApiInfoContainerBatch bulkApiInfoContainer, String processId, String objectService, String objectNameServicesMethods) {
		boolean updateOk;
		int cont;
		cont = 0;
		String processUpdateErrorCause = null;
		HistoricBatchVO historicoProcessUpdate = new HistoricBatchVO();
		historicoProcessUpdate.setStartDate(new Date());
		historicoProcessUpdate.setOperation(ConstantesBatch.INSERT_PROCESS);
		historicoProcessUpdate.setProcessId(processId);
		historicoProcessUpdate.setObject(batchObjectsMapper.getObjectHistoricNamesMap().get(bulkApiInfoContainer.getEntityName()));
		
		if (bulkApiInfoContainer.getRecordsMap().containsKey(OperationType.UPDATE)
				&& bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE) != null
				&& !bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE).isEmpty()) {
			historicoProcessUpdate.setTotalRecords(bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT).size());
			try {
				cont = callSpecificServiceByReflection(objectService, objectNameServicesMethods, OperationType.UPDATE, bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE), processId);
				if (cont == bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE).size()) {
					updateOk = true;
				} else {
					updateOk = false;
					processUpdateErrorCause = ConstantesBatch.ERROR_UPDATE_PROCESS;
				}
			} catch (Exception exception) {
				LOGGER.error("Error tratando los registros", exception);
				updateOk = false;
				processUpdateErrorCause = ConstantesBatch.ERROR_UPDATE_PROCESS_EXCEPTION_REFLECTION;
			}
		} else {
			if (bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE).isEmpty()) {
				updateOk = true;
			} else {
				updateOk = false;
				processUpdateErrorCause = ConstantesBatch.ERROR_UPDATE_PROCESS_LIST_NULL;
			}
		}
		
		historicoProcessUpdate.setEndDate(new Date());
		historicoProcessUpdate.setSuccess(updateOk);
		historicoProcessUpdate.setErrorCause(processUpdateErrorCause);
		historicoProcessUpdate.setProcessedRecords(cont);
		historicBatchDAO.insertHistoric(historicoProcessUpdate);
		return updateOk;
	}
	/**
	 * @param bulkApiInfoContainer
	 * @param processId
	 * @param insertOk
	 * @param objectService
	 * @param objectNameServicesMethods
	 * @return
	 */
	private boolean deleteRecordsFromDatabase(BulkApiInfoContainerBatch bulkApiInfoContainer, String processId, String objectService, String objectNameServicesMethods) {
		boolean deleteOk;
		int cont;
		cont = 0;
		String processDeleteErrorCause = null;
		HistoricBatchVO historicoProcessDelete = new HistoricBatchVO();
		historicoProcessDelete.setStartDate(new Date());
		historicoProcessDelete.setOperation(ConstantesBatch.DELETE_PROCESS);
		historicoProcessDelete.setProcessId(processId);
		historicoProcessDelete.setObject(batchObjectsMapper.getObjectHistoricNamesMap().get(bulkApiInfoContainer.getEntityName()));
		
		if (bulkApiInfoContainer.getRecordsMap().containsKey(OperationType.DELETE)
				&& bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE) != null
				&& !bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE).isEmpty()) {
			historicoProcessDelete.setTotalRecords(bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT).size());
			try {
				cont = callSpecificServiceByReflection(objectService, objectNameServicesMethods, OperationType.DELETE, bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE), processId);
				if (cont == bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE).size()) {
					deleteOk = true;
				} else {
					deleteOk = false;
					processDeleteErrorCause = ConstantesBatch.ERROR_DELETE_PROCESS;
				}
			} catch (Exception exception) {
				LOGGER.error("Error tratando los registros", exception);
				deleteOk = false;
				processDeleteErrorCause = ConstantesBatch.ERROR_DELETE_PROCESS_EXCEPTION_REFLECTION;
			}
		} else {
			if (bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE).isEmpty()) {
				deleteOk = true;
			} else {
				deleteOk = false;
				processDeleteErrorCause = ConstantesBatch.ERROR_DELETE_PROCESS_LIST_NULL;
			}
		}
		
		historicoProcessDelete.setEndDate(new Date());
		historicoProcessDelete.setSuccess(deleteOk);
		historicoProcessDelete.setErrorCause(processDeleteErrorCause);
		historicoProcessDelete.setProcessedRecords(cont);
		historicBatchDAO.insertHistoric(historicoProcessDelete);
		return deleteOk;
	}
	
	/**
	 * @param bulkApiInfoContainer
	 */
	private int callSpecificServiceByReflection(String objectService, String objectNameServicesMethods, OperationType operation, List<Object> records, String processId) throws Exception {
		LOGGER.trace("Se lanza callSpecificServiceByReflection con operacion --> " + operation);
		LOGGER.trace("Registros a tratar: " + records.size());
		String insertMethodStartName = "insert";
		String updateMethodStartName = "update";
		String deleteMethodStartName = "delete";
		String methodEndName = "SfList";
		String methodName = null;
		switch (operation) {
			case INSERT:
				methodName = insertMethodStartName + objectNameServicesMethods + methodEndName;
				break;
			case UPDATE:
				methodName = updateMethodStartName + objectNameServicesMethods + methodEndName;
				break;
			case DELETE:
				methodName = deleteMethodStartName + objectNameServicesMethods + methodEndName;
				break;
		}
		Class<?> serviceClass = Class.forName(ConstantesBulkApi.REFLECTION_LOGIC_SERVICES_OBJECTS_PACKAGE + objectService);
		Class<?>[] paramListClass = {List.class, String.class};
		StringBuilder sb = new StringBuilder(objectService);
		int implIndex = sb.indexOf("Impl");
		sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
		sb.delete(implIndex, implIndex + sb.length());
		String springClassBeanName = sb.toString();
		Object serviceObject = applicationContextProvider.getApplicationContext().getBean(springClassBeanName, serviceClass);
		LOGGER.info("Clase a invocar: " + serviceClass.getName());
		Method metodo = serviceClass.getDeclaredMethod(methodName, paramListClass);
		LOGGER.info("Metodo a invocar: " + metodo.getName());
		int result = (int)metodo.invoke(serviceObject, records, processId);
		return result;
	}
	
	/**
	 * Metodo que devuelve una lista con todos los HistoricBatchs que hay en BBDD
	 * 
	 * @return
	 */
	@Override
	public List<HistoricBatch> readAllHistoricBatch(DataTableProperties propDatatable) {
		
		LOGGER.debug("--- Inicio -- readAllHistoricBatch ---");
		
		List<HistoricBatch> listHistoricBatch = new ArrayList<>();
		List<HistoricBatchVO> listHistoricBatchsVO = historicBatchDao.readHistoricBatchDataTable(propDatatable);

		LOGGER.debug("--- Inicio -- readAllHistoricBatch historicBatchs en la lista: " + listHistoricBatchsVO.size() + " ---");
		
		for (HistoricBatchVO historicBatchVO : listHistoricBatchsVO) {
			HistoricBatch historicBatch = new HistoricBatch();
			ParserModelVO.parseDataModelVO(historicBatchVO, historicBatch);
			listHistoricBatch.add(historicBatch);
		}
		
		LOGGER.debug("--- Fin -- readAllHistoricBatch ---");
		return listHistoricBatch;
	}
	
	public Integer getNumHistoricBatchs(DataTableProperties propDatatable){
		LOGGER.debug("--- getNumCasos ---");
		return historicBatchDao.getNumHistoricBatchs(propDatatable);
	}
	
	public String returnProcessResult(String processResult){
		return processResult;
				
	}
	
	
}