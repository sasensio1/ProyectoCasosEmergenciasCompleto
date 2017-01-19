package com.casosemergencias.batch.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;
import com.casosemergencias.batch.bean.OperationType;
import com.casosemergencias.dao.HistoricBatchDAO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.Utils;
import com.casosemergencias.util.constants.ConstantesBatch;
import com.casosemergencias.util.constants.ConstantesBulkApi;

@Resource
public class BatchObjectsParser {
	@Autowired
	HistoricBatchDAO historicBatchDao;
		
	final static Logger LOGGER = Logger.getLogger(BatchObjectsParser.class);
	private String createdDateString = null;
	private String modifyDateString = null;
	private boolean isDeleted = false;
	private BatchObjectsMapper objectsMapper = null;
	private Map<String, String> classParamsMap = null;
	private Object entityObject = null;
	private String objectName = null;
	private Class<?> objectClass = null;
	private Class<?>[] paramStringClass = {String.class};
	private List<Object> objectsToInsert = null;
	private List<Object> objectsToUpdate = null;
	private List<Object> objectsToDelete = null;

	/**
	 * Populates the list of objects to be inserted, updated and deleted from
	 * Salesforce to Heroku.
	 * 
	 * @param entityName
	 *            Name of the entity.
	 * @param entityResponse
	 *            Info of objects from the Bulk API Salesforce response.
	 * @param mapper
	 *            All the class and parameter names maps from Salesforce Objects
	 *            to Heroku Objects.
	 * @param historicProcessId
	 *            Id of the historic info process.
	 * @return BulkApiInfoContainerBatch Organized objects.
	 * @throws Exception
	 *             Exception thrown if there has been any problem during the
	 *             populating process.
	 */
	public BulkApiInfoContainerBatch populateObjectListFromJsonObject(String entityName, String entityResponse, BatchObjectsMapper mapper, String historicProcessId) throws Exception {
		LOGGER.trace("Entrando en populateObjectListFromJsonObject para obtener los registros actualizados");
		
		//Registro en tabla de historico
		HistoricBatchVO objectParsingHistoricProcessInfo = new HistoricBatchVO();
		objectParsingHistoricProcessInfo.setStartDate(new Date());
		objectParsingHistoricProcessInfo.setProcessId(historicProcessId);
		objectParsingHistoricProcessInfo.setOperation(ConstantesBatch.API_RESPONSE_PARSE_PROCESS);
		objectParsingHistoricProcessInfo.setObject(mapper.getObjectHistoricNamesMap().get(entityName));
		
		//0. Se inicializan los objetos a utilizar
		objectsMapper = mapper;
		BulkApiInfoContainerBatch containerList = new BulkApiInfoContainerBatch();
		containerList.setEntityName(entityName);
		Map<OperationType, List<Object>> containerMap = new HashMap<OperationType, List<Object>>();
		objectsToInsert = new ArrayList<Object>();
		objectsToUpdate = new ArrayList<Object>();
		objectsToDelete = new ArrayList<Object>();
		boolean processOk = false;
		String processErrorCause = "";
				
		//1. Se transforman los datos en objetos que puedan recorrerse
		if (!Utils.isNullOrEmptyString(entityResponse)) {
			LOGGER.info("Se convierte la respuesta en objetos iterables para su posterior parseo");
			JSONObject jsonResponse = new JSONObject(entityResponse);
			boolean requestDone = jsonResponse.getBoolean(ConstantesBulkApi.RESULT_STATUS_NODE);
			if (requestDone) {
				JSONArray recordsArray = jsonResponse.getJSONArray(ConstantesBulkApi.RECORDS_NODE);
				if (jsonResponse.getInt(ConstantesBulkApi.TOTAL_SIZE_NODE) > 0 && recordsArray != null && recordsArray.length() > 0) {
					containerList.setTotalRecords(jsonResponse.getInt(ConstantesBulkApi.TOTAL_SIZE_NODE));
					//2. Se obtiene el objeto a rellenar
					getNewEntityObjectInfoFromJsonDocument(recordsArray.getJSONObject(0));
					for (int i = 0; i < recordsArray.length(); i++) {
						//3. Se parsea el documento y se rellenan los parametros del objeto
						JSONObject record = recordsArray.getJSONObject(i);
						//3.1. Se recorren todos los objetos encontrados
						String[] recordParams = JSONObject.getNames(record);
						for (String paramName : recordParams) {
							LOGGER.info("Nombre del parametro: " + paramName);
							String paramValue = null;
							if (!record.isNull(paramName)) {
								//3.2. Se recupera y se rellena cada parametro del objeto
								if (!ConstantesBulkApi.OBJECT_CREATED_DATE_WHERE_CLAUSE.equals(paramName) 
										&& !ConstantesBulkApi.OBJECT_LAST_MODIFIED_DATE_WHERE_CLAUSE.equals(paramName) 
										&& !ConstantesBulkApi.OBJECT_IS_DELETED_WHERE_CLAUSE.equals(paramName)) {
									paramValue = getJsonNodeParamValue(record.get(paramName));
									setClassParameter(paramName, paramValue);
								} else {
									switch (paramName) {
										/* CreatedDate esta en los beans de VO: Address, CaseComment, CaseHistory, Group, RepeatedCases y Task. */
										case ConstantesBulkApi.OBJECT_CREATED_DATE_WHERE_CLAUSE:
											createdDateString = getJsonNodeParamValue(record.get(paramName));
											if (ConstantesBulkApi.ENTITY_ADDRESS.equals(objectName)
													|| ConstantesBulkApi.ENTITY_CASE_COMMENT.equals(objectName)
													|| ConstantesBulkApi.ENTITY_CASE_HISTORY.equals(objectName)
													|| ConstantesBulkApi.ENTITY_GROUP.equals(objectName)
													|| ConstantesBulkApi.ENTITY_REPEATED_CASES.equals(objectName)
													|| ConstantesBulkApi.ENTITY_TASK.equals(objectName)) {
												setClassParameter(paramName, createdDateString);
											}
											break;
										/* LastModifiedDate esta en los beans de VO: CaseComment. */
										case ConstantesBulkApi.OBJECT_LAST_MODIFIED_DATE_WHERE_CLAUSE:
											modifyDateString = getJsonNodeParamValue(record.get(paramName));
											if (ConstantesBulkApi.ENTITY_CASE_COMMENT.equals(objectName)) {
												setClassParameter(paramName, modifyDateString);
											}
											break;
										/* IsDeleted no esta en ningun bean de VO. */ 
										case ConstantesBulkApi.OBJECT_IS_DELETED_WHERE_CLAUSE:
											isDeleted = Boolean.parseBoolean(getJsonNodeParamValue(record.get(paramName)));
											break;
									}
								}
							} else {
								LOGGER.info("Valor del parametro: null");
							}
						}
						//3.3. Se guarda el objeto en la lista de acciones que corresponda
						Date createdDate = Utils.parseStringToDate(createdDateString);
						Date modifyDate = null;
						if (!ConstantesBulkApi.ENTITY_CASE_HISTORY.equals(objectName)) {
							modifyDate = Utils.parseStringToDate(modifyDateString);
						}
						if (isDeleted) {
							LOGGER.info("Registro guardado en borrados");
							objectsToDelete.add(entityObject);
						} else {
							if (modifyDate == null || createdDate.equals(modifyDate) || DateUtils.isSameDay(modifyDate, createdDate)) {
								LOGGER.info("Registro guardado en insertados");
								objectsToInsert.add(entityObject);
							} else if (modifyDate.after(createdDate)) {
								LOGGER.info("Registro guardado en modificados");
								objectsToUpdate.add(entityObject);
							}
						}
					}
					processOk = true;
				} else {
					LOGGER.info("No hay registros en la respuesta");
					processOk = true;
				}
			} else {
				LOGGER.error("Respuesta con resultado incorrecto");
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_RESPONSE_UNDONE;
			}
		} else {
			LOGGER.error("Datos de la respuesta vacios. No es posible actualizar el objeto");
			processOk = false;
			processErrorCause = ConstantesBatch.ERROR_RESPONSE_EMPTY;
		}
		containerMap.put(OperationType.INSERT, objectsToInsert);
		containerMap.put(OperationType.UPDATE, objectsToUpdate);
		containerMap.put(OperationType.DELETE, objectsToDelete);
		containerList.setRecordsMap(containerMap);
		
		objectParsingHistoricProcessInfo.setTotalRecords(containerList.getTotalRecords());
		objectParsingHistoricProcessInfo.setSuccess(processOk);
		objectParsingHistoricProcessInfo.setErrorCause(processOk ? null : processErrorCause);
		objectParsingHistoricProcessInfo.setEndDate(new Date());
		historicBatchDao.insertHistoric(objectParsingHistoricProcessInfo);
		
		return containerList;
	}
	
	/**
	 * Gets all the object info to be populated from JSON object.
	 * 
	 * @param record
	 *            JSON object which contains the name of the object.
	 * @throws ClassNotFoundException
	 *             Exception thrown if the class doesn't exists.
	 * @throws InstantiationException
	 *             Exception thrown if the class cannot be instantiated.
	 * @throws IllegalAccessException
	 *             Exception thrown if the class cannot be accessed.
	 */
	private void getNewEntityObjectInfoFromJsonDocument(JSONObject record) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (record.getJSONObject(ConstantesBulkApi.RECORD_ATTRIBUTES_NAME_NODE) != null) {
			classParamsMap = null;
			entityObject = null;
			objectClass = null;
			JSONObject recordAttributes = record.getJSONObject(ConstantesBulkApi.RECORD_ATTRIBUTES_NAME_NODE);
			objectName = recordAttributes.getString(ConstantesBulkApi.OBJECT_NAME_NODE);
			if (!Utils.isNullOrEmptyString(objectName)) {
				objectClass = Class.forName(ConstantesBulkApi.REFLECTION_DAO_BEAN_OBJECTS_PACKAGE + objectsMapper.getObjectNamesEquivalenceMap().get(objectName));
			}
			entityObject = objectClass.newInstance();
			classParamsMap = objectsMapper.getParamsMap(entityObject);
		}
	}
		
	/**
	 * Gets the node value of one JSON Node.
	 * 
	 * @param dataNode
	 *            Node of the tocument.
	 * @return String Value of the node.
	 */
	private String getJsonNodeParamValue(Object dataNode) {
		String nodeValue = null;
		if (dataNode != null) {
			nodeValue = String.valueOf(dataNode);
			LOGGER.info("Valor del parametro: " + nodeValue);
		}
		return nodeValue;
	}
	
	/**
	 * Sets the object parameter using reflection method.
	 * 
	 * @param paramName
	 *            Parameter name to invoke.
	 * @param paramValue
	 *            Parameter value to insert.
	 * @throws NoSuchMethodException
	 *             Exception thrown if the method doesn't exists.
	 * @throws SecurityException
	 *             Exception thrown if it has occurred any problem accessing to
	 *             the class or method.
	 * @throws IllegalAccessException
	 *             Exception thrown if the class cannot be accessed.
	 * @throws IllegalArgumentException
	 *             Exception thrown if the argument of the invoked method is
	 *             incorrect.
	 * @throws InvocationTargetException
	 *             Exception thrown if the method invocation fails.
	 */
	private void setClassParameter(String paramName, String paramValue) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (paramValue != null && !"".equals(paramValue) && classParamsMap.containsKey(paramName)) {
			Method method = objectClass.getDeclaredMethod("set" + classParamsMap.get(paramName), paramStringClass);
			method.invoke(entityObject, paramValue);
		}
	}
}