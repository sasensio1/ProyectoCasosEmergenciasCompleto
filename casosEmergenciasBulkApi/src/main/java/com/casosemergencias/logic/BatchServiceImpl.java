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
import com.casosemergencias.util.constants.ConstantesBulkApi;
import com.casosemergencias.util.datatables.DataTableProperties;

public class BatchServiceImpl implements BatchService {
	
	final static Logger LOGGER = Logger.getLogger(CaseService.class);

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
	public void updateObjectsInfoTables(Date processStartDate, Date processEndDate,String objectName) {
		restApiInvokerBatch.setProcessStartDate(processStartDate);
		restApiInvokerBatch.setProcessEndDate(processEndDate);
		restApiInvokerBatch.setObjectName(objectName);		
		restApiInvokerBatch.updateObjectsWithRestApiInfo();
	}
	
	@Override
	public boolean updateHerokuObjectsFromBulkApi(BulkApiInfoContainerBatch bulkApiInfoContainer, String processId) {
		LOGGER.trace("Entrando en updateHerokuObjectsFromBulkApi para actualizar registros");
		boolean resultOk = true;
		boolean insertOk = true;
		boolean updateOk = true;
		boolean deleteOk = true;
		try {
			if (bulkApiInfoContainer != null && bulkApiInfoContainer.getRecordsMap() != null) {
				if (bulkApiInfoContainer.getTotalRecords() > 0) {
					LOGGER.info("Registros a tratar: " + bulkApiInfoContainer.getTotalRecords());
					String objectService = batchObjectsMapper.getObjectNamesServicesMap().get(bulkApiInfoContainer.getEntityName());
					String objectNameServicesMethods = batchObjectsMapper.getObjectNamesServicesMethodsMap().get(bulkApiInfoContainer.getEntityName());
					//Registros a insertar
					if (bulkApiInfoContainer.getRecordsMap().containsKey(OperationType.INSERT)
							&& bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT) != null
							&& !bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT).isEmpty()) {
						insertOk = callSpecificServiceByReflection(objectService, objectNameServicesMethods, OperationType.INSERT, bulkApiInfoContainer.getRecordsMap().get(OperationType.INSERT), processId);
					}
					//Registros a actualizar
					if (bulkApiInfoContainer.getRecordsMap().containsKey(OperationType.UPDATE)
							&& bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE) != null
							&& !bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE).isEmpty()) {
						updateOk = callSpecificServiceByReflection(objectService, objectNameServicesMethods, OperationType.UPDATE, bulkApiInfoContainer.getRecordsMap().get(OperationType.UPDATE), processId);
					}
					//Registros a eliminar
					if (bulkApiInfoContainer.getRecordsMap().containsKey(OperationType.DELETE)
							&& bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE) != null
							&& !bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE).isEmpty()) {
						deleteOk = callSpecificServiceByReflection(objectService, objectNameServicesMethods, OperationType.DELETE, bulkApiInfoContainer.getRecordsMap().get(OperationType.DELETE), processId);
					}
					if(insertOk == false || updateOk == false || deleteOk == false){
						resultOk = false;
					}
				} else {
					LOGGER.error("No hay registros a actualizar");
				}
			} else {
				LOGGER.error("Los datos a actualizar son nulos");
			}
		} catch (Exception exception) {
			LOGGER.error("Error tratando los registros", exception);
		}
		return resultOk;
	}

	/**
	 * @param bulkApiInfoContainer
	 */
	private boolean callSpecificServiceByReflection(String objectService, String objectNameServicesMethods, OperationType operation, List<Object> records, String processId) throws Exception {
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
		boolean resultOk = (boolean)metodo.invoke(serviceObject, records, processId);
		return resultOk;
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
	
	
}