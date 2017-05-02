package com.casosemergencias.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.casosemergencias.controller.views.ObjectView;
import com.casosemergencias.dao.vo.ObjectVO;
import com.casosemergencias.model.ObjectLogic;

public class ParserModelVO {
	final static Logger logger = Logger.getLogger(ParserModelVO.class);
	
	/**
	 * M&eacute;todo que dado dos objetos, se pasa la informaci&oacute;n de un
	 * objeto y se vuelca en otro. Para que la conversi&oacute;n funcione
	 * correctamentem, se deben llamar igual los campos que queremos informar,
	 * es decir, si queremos que se pase la informaci&oacute;n de name,
	 * necesitamos tener un getName y en el objeto que recibe las información el
	 * metodo setName.
	 * 
	 * LIMITACI&Oacute;N: No admite tipos de datos primitivos, solo referencias.
	 * No se pasar&aacute; el m&eacutetodo con par&aacute;metros de entrada int,
	 * boolean...
	 * 
	 * @param objectWithData
	 *            Objeto a convertir.
	 * @param objectToFill
	 *            Objeto convertido.
	 */
	@SuppressWarnings("unchecked")
	public static void parseDataModelVO(Object objectWithData, Object objectToFill) {
	System.out.println("objectWithData:"+objectWithData.getClass()+":objectToFill:"+objectToFill.getClass());
		// Array de getters del objeto origen
		Method[] methodsGets = objectWithData.getClass().getMethods();
		// Array de setters del objeto destino
		Method[] methodsSets = objectToFill.getClass().getMethods();
		// Mapa de setters del objeto destino
		Map<String, Method> mapFieldSetMethod = getMapOfSetFields(methodsSets);
		// 1. Se recorre el array de getters del origen
		for (Method methodGetData : methodsGets) {
			String nameMethodGetData = methodGetData.getName();
			if (nameMethodGetData != null && nameMethodGetData.startsWith("get")) {
				String fieldData = nameMethodGetData.substring(3);
				// 2. Se comprueba que el objeto destino tiene un setter con el nombre del campo del objeto origen
				if (mapFieldSetMethod.containsKey(fieldData)) {
					Method methodSetField = mapFieldSetMethod.get(fieldData);
					try {
						// 3. Se obtiene el valor del campo mediante su getter
						Object valueToSet = methodGetData.invoke(objectWithData);
						if (valueToSet != null) {
							// 4. Se comprueba el tipo de objeto del campo
							// 4.1. Si el objeto origen es una lista, se comprueba el tipo de objetos que contiene
							if (valueToSet instanceof List) {
								if (((List<Object>) valueToSet).size() > 0) {
									List<Object> listToSet = parseListObject(objectWithData, objectToFill, valueToSet);
									methodSetField.invoke(objectToFill, listToSet);
								}
							// 4.2. Si el objeto origen es de tipo VIEW, se convierte a un objeto de tipo BL y se guarda
							} else if (valueToSet instanceof ObjectView) {
								Object objectLogic = ((ObjectView) valueToSet).instantiateTargetLogic();
								parseDataModelVO(valueToSet, objectLogic);
								methodSetField.invoke(objectToFill, objectLogic);
							// 4.3. Si el objeto origen es de tipo BL ...
							} else if (valueToSet instanceof ObjectLogic) {
								// 4.3.1. y el objeto destino es de tipo VIEW, se convierte a un objeto de tipo VIEW y se guarda
								if (objectToFill instanceof ObjectView) {
									Object objectViewToFill = ((ObjectLogic) valueToSet).instantiateTargetView();
									parseDataModelVO(valueToSet, objectViewToFill);
									methodSetField.invoke(objectToFill, objectViewToFill);
								// 4.3.2. y el objeto destino es de tipo VO, se convierte a un objeto de tipo VO y se guarda
								} else if (objectToFill instanceof ObjectVO) {
									Object objectVOToFill = ((ObjectLogic) valueToSet).instantiateTargetVO();
									parseDataModelVO(valueToSet, objectVOToFill);
									methodSetField.invoke(objectToFill, objectVOToFill);
								}
							// 4.4. Si el objeto origen es de tipo VO, se convierte a un objeto de tipo BL y se guarda
							} else if (valueToSet instanceof ObjectVO) {
								Object objectLogic = ((ObjectVO) valueToSet).instantiateTargetLogic();
								parseDataModelVO(valueToSet, objectLogic);
								methodSetField.invoke(objectToFill, objectLogic);
							// 4.5. Si el objeto origen es de otro tipo, se guarda
							} else {
								methodSetField.invoke(objectToFill, valueToSet);
							}
						}
					} catch (IllegalAccessException e) {
						logger.error(e);
					} catch (IllegalArgumentException e) {
						logger.error(e);
					} catch (InvocationTargetException e) {
						logger.error(e);
					}
				}
			}
		}
	}

	/**
	 * M&eacute;todo que ecorre una lista de objetos para parsearlos al tipo de objeto
	 * correspondiente.
	 * 
	 * @param objectWithData
	 *            Objeto origen que contiene la lista.
	 * @param objectToFill
	 *            Objeto destino donde ir&aacute; la lista modificada.
	 * @param valueToSet
	 *            Lista a modificar.
	 * @return List<Object> Lista modificada.
	 */
	@SuppressWarnings("unchecked")
	private static List<Object> parseListObject(Object objectWithData, Object objectToFill, Object valueToSet) {
		List<Object> listToSet = new ArrayList<Object>();
		boolean isFromLogic = false;
		boolean isToView = false;
		if (objectWithData instanceof ObjectLogic) {
			isFromLogic = true;
			if (objectToFill instanceof ObjectView) {
				isToView = true;
			}
		}
		// 4.1.1. Se recorre la lista para parsear sus objetos
		for (Object valueInCollection : (List<Object>) valueToSet) {
			Object objectColletionToFill = null;
			// 4.1.1.1. Si el objeto origen es de tipo BL ...
			if (isFromLogic) {
				// 4.1.1.1.1. y el objeto destino es de tipo VIEW, se convierte a un objeto de tipo VIEW y se guarda
				if (isToView) {
					objectColletionToFill = ((ObjectLogic) valueInCollection).instantiateTargetView();
					parseDataModelVO(valueInCollection, objectColletionToFill);
					listToSet.add(objectColletionToFill);
				// 4.1.1.1.2. y el objeto destino es de tipo VO, se convierte a un objeto de tipo VO y se guarda
				} else {
					objectColletionToFill = ((ObjectLogic) valueInCollection).instantiateTargetVO();
					parseDataModelVO(valueInCollection, objectColletionToFill);
					listToSet.add(objectColletionToFill);
				}
			} else {
				// 4.1.1.2. Si el objeto origen es de tipo VIEW, se convierte a un objeto de tipo BL y se guarda
				if (objectWithData instanceof ObjectView) {
					objectColletionToFill = ((ObjectView) valueInCollection).instantiateTargetLogic();
					parseDataModelVO(valueInCollection, objectColletionToFill);
					listToSet.add(objectColletionToFill);
				// 4.1.1.3. Si el objeto origen es de tipo VO, se convierte a un objeto de tipo BL y se guarda
				} else if (objectWithData instanceof ObjectVO) {
					objectColletionToFill = ((ObjectVO) valueInCollection).instantiateTargetLogic();
					parseDataModelVO(valueInCollection, objectColletionToFill);
					listToSet.add(objectColletionToFill);
				}
			}
		}
		return listToSet;
	}

	/**
	 * M&eacute;todo que devuelve un mapa con el nombre del campo como clave y su
	 * correspondiente m&eacute;todo set como valor.
	 * 
	 * @param methodsSets
	 *            Array de m&eacute;todos set.
	 * @return Map<String, Method> Mapa de campos y sus m&eacute;todos set
	 *         correspondientes.
	 */
	private static Map<String, Method> getMapOfSetFields(Method[] methodsSets) {
		Map<String, Method> mapToReturn = new HashMap<String, Method>();
		for (Method methodSet : methodsSets) {
			String nameMethodSet = methodSet.getName();
			if (nameMethodSet != null && nameMethodSet.startsWith("set")) {
				String fieldData = nameMethodSet.substring(3);
				mapToReturn.put(fieldData, methodSet);
			}
		}
		return mapToReturn;
	}
}