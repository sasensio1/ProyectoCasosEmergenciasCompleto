package com.casosemergencias.batch.util;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;
import com.casosemergencias.util.Utils;
import com.casosemergencias.util.constants.ConstantesBulkApi;

public class BatchObjectsParser {
	final static Logger LOGGER = Logger.getLogger(BatchObjectsParser.class);
	private BatchObjectsMapper objectsMapper = null;
	private Map<String, String> classParamsMap = null;
	private Object entityObject = null;
	private String objectName = null;
	private Class<?> objectClass = null;
	private Class<?>[] paramStringClass = new Class[1];
	private List<Object> objectsToInsert = new ArrayList<Object>();
	private List<Object> objectsToUpdate = new ArrayList<Object>();
	private List<Object> objectsToDelete = new ArrayList<Object>();

	/**
	 * Populates the list of objects to be inserted, updated and deleted from
	 * Salesforce to Heroku.
	 * 
	 * @param batchInputStream
	 *            Info of objects from the Bulk API Salesforce response.
	 * @param mapper
	 *            All the class and parameter names maps from Salesforce Objects
	 *            to Heroku Objects.
	 * @return List<BulkApiInfoContainerBatch> Organized objects list.
	 * @throws Exception
	 *             Exception thrown if there has been any problem during the
	 *             populating process.
	 */
	public List<BulkApiInfoContainerBatch> populateObjectListFromXmlStream(InputStream batchInputStream, BatchObjectsMapper mapper) throws Exception {
		LOGGER.trace("Entrando en populateObjectListFromXmlStream para obtener los ");
		//0. Se inicializan los objetos a utilizar
		Document xmlDocument = null;
		paramStringClass[0] = String.class;
		objectsMapper = mapper;
		List<BulkApiInfoContainerBatch> objectsContainerList = null;
		String createdDateString = null;
		String modifyDateString = null;
		boolean isDeleted = false;
				
		//1. Se transforman los bytes en un objeto DOM
		LOGGER.info("Se convierten los bytes de la respuesta en un documento XML para su posterior parseo");
		xmlDocument = Utils.convertInputStreamToXmlDocument(batchInputStream);
		if (xmlDocument != null) {
			//2. Se obtiene el objeto a rellenar
			getNewEntityObjectInfo(xmlDocument);
			LOGGER.info("Entidad a tratar: " + objectClass.getName());
		} else {
			LOGGER.error("No se ha podido obtener la informacion de los objetos porque el documento es nulo");
		}
		//3. Se parsea el documento y se rellenan los parametros del objeto
		NodeList records = xmlDocument.getElementsByTagName("records");
		if (records != null && records.getLength() > 0) {
			System.out.println("Encontrados " + records.getLength() + " objetos");
			//3.1. Se recorren todos los objetos encontrados
			for (int i = 0; i < records.getLength(); i++) {
				Node record = records.item(i);
				if (record.getNodeType() == Node.ELEMENT_NODE) {
					NodeList recordData = records.item(i).getChildNodes();
					if (recordData != null && recordData.getLength() > 0) {
						for (int j = 0; j < recordData.getLength(); j++) {
							Node recordDataNode = recordData.item(j);
							String nodeValue = null;
							String nodeName = recordDataNode.getNodeName();
							LOGGER.info("Nombre del parametro: " + nodeName);
							//3.2. Se recupera y se rellena cada parametro del objeto
							if (!ConstantesBulkApi.OBJECT_CREATED_DATE_WHERE_CLAUSE.equals(nodeName) 
									&& !ConstantesBulkApi.OBJECT_CREATED_DATE_WHERE_CLAUSE.equals(nodeName) 
									&& !ConstantesBulkApi.OBJECT_CREATED_DATE_WHERE_CLAUSE.equals(nodeName)) {
								nodeValue = getParamValue(recordDataNode);
								setClassParameter(nodeName, nodeValue);
							} else {
								switch (nodeName) {
									/* CreatedDate esta en los beans de VO: Address, CaseComment, CaseHistory, Group, RepeatedCases y Task. */
									case ConstantesBulkApi.OBJECT_CREATED_DATE_WHERE_CLAUSE:
										createdDateString = getParamValue(recordDataNode);
										if (ConstantesBulkApi.ENTITY_ADDRESS.equals(objectName)
												|| ConstantesBulkApi.ENTITY_CASE_COMMENT.equals(objectName)
												|| ConstantesBulkApi.ENTITY_CASE_HISTORY.equals(objectName)
												|| ConstantesBulkApi.ENTITY_GROUP.equals(objectName)
												|| ConstantesBulkApi.ENTITY_REPEATED_CASES.equals(objectName)
												|| ConstantesBulkApi.ENTITY_TASK.equals(objectName)) {
											setClassParameter(nodeName, createdDateString);
										}
										break;
									/* LastModifiedDate esta en los beans de VO: CaseComment. */
									case ConstantesBulkApi.OBJECT_LAST_MODIFIED_DATE_WHERE_CLAUSE:
										modifyDateString = getParamValue(recordDataNode);
										if (ConstantesBulkApi.ENTITY_CASE_COMMENT.equals(objectName)) {
											setClassParameter(nodeName, modifyDateString);
										}
										break;
									/* IsDeleted no esta en ningun bean de VO. */ 
									case ConstantesBulkApi.OBJECT_IS_DELETED_WHERE_CLAUSE:
										isDeleted = Boolean.parseBoolean(getParamValue(recordDataNode));
										break;
								}
							}
						}
					}
					/* 
					 * 3.3. Se guarda el objeto en la lista de acciones que corresponda
					 * 3.3.1. INSERT: Aquellos registros en los que las fechas de creacion y modificacion coincidan y no se hayan marcado como borrados
					 * 3.3.2. UPDATE: Aquellos registros en los que la fecha de modificacion sea mayor que la fecha de creacion y no se hayan marcado como borrados
					 * 3.3.3. DELETE: Aquellos registros en los que la fecha de modificacion sea mayor que la fecha de creacion y se hayan marcado como borrados
					 */
					Date createdDate = Utils.parseStringToDate(createdDateString);
					Date modifyDate = Utils.parseStringToDate(modifyDateString);
					if (isDeleted) {
						objectsToDelete.add(entityObject);
					} else {
						if (createdDate.equals(modifyDate)) {
							objectsToInsert.add(entityObject);
						} else if (modifyDate.after(createdDate)) {
							objectsToUpdate.add(entityObject);
						}
					}
				}
			}
		}
		return objectsContainerList;
	}

	/**
	 * Gets all the object info to be populated.
	 * 
	 * @param xmlDocument
	 *            XML Document which contains the name of the object.
	 * @throws ClassNotFoundException
	 *             Exception thrown if the class doesn't exists.
	 * @throws InstantiationException
	 *             Exception thrown if the class cannot be instantiated.
	 * @throws IllegalAccessException
	 *             Exception thrown if the class cannot be accessed.
	 */
	private void getNewEntityObjectInfo(Document xmlDocument) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (xmlDocument.getElementsByTagName("type") != null && xmlDocument.getElementsByTagName("type").getLength() > 0) {
			classParamsMap = null;
			entityObject = null;
			objectClass = null;
			Node objectType = xmlDocument.getElementsByTagName("type").item(0);
			NodeList objectTypeTextNodes = objectType.getChildNodes();
			if (objectTypeTextNodes != null && objectTypeTextNodes.getLength() > 0) {
				for (int nodeCount = 0; nodeCount < objectTypeTextNodes.getLength(); nodeCount++) {
					if (objectTypeTextNodes.item(nodeCount).getNodeType() == Node.TEXT_NODE) {
						objectName = objectTypeTextNodes.item(nodeCount).getNodeValue();
					}
				}
			}
			if (!Utils.isNullOrEmptyString(objectName)) {
				objectClass = Class.forName("com.casosemergencias.dao.vo." + objectsMapper.getObjectNamesEquivalenceMap().get(objectName));
			}
			entityObject = objectClass.newInstance();
			classParamsMap = objectsMapper.getParamsMap(entityObject);
		}
	}
	
	/**
	 * Gets the node value of one XML Node.
	 * 
	 * @param dataNode
	 *            Node of the tocument.
	 * @return String Value of the node.
	 */
	private String getParamValue(Node dataNode) {
		String nodeValue = null;
		NodeList textNodes = dataNode.getChildNodes();
		if (textNodes != null && textNodes.getLength() > 0) {
			for (int k = 0; k < textNodes.getLength(); k++) {
				if (textNodes.item(k).getNodeType() == Node.TEXT_NODE) {
					nodeValue = textNodes.item(k).getNodeValue();
					LOGGER.info("Valor del parametro: " + nodeValue);
				}
			}
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
	 *             Exception thrown if there is any problem accessing the class
	 *             or the method.
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