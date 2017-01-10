package com.casosemergencias.batch.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.casosemergencias.dao.vo.ContactVO;

public class BatchObjectsParser {
	final static Logger logger = Logger.getLogger(BatchObjectsParser.class);

	/**
	 * 
	 * @param batchstream
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public List<ContactVO> convertApiBatchResultIntoList(InputStream batchstream) throws ParserConfigurationException, SAXException, IOException {
		List<ContactVO> contactsList = new ArrayList<ContactVO>();
		// se convertirá el objeto InputStream a un objeto SAX para parsearlo en XML
		populateObjectListFromXmlStream(batchstream, contactsList);
		
		return contactsList;
	}

	/**
	 * 
	 * @param batchstream
	 * @param contactsList
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws ClassNotFoundException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void populateObjectListFromXmlStream(InputStream batchstream, List<ContactVO> contactsList) {
		System.out.println("Entrando en populateObjectListFromXmlStream");
		
		// 0. Se prepara la clase que se llamara por reflexion
		//no paramater
		Class noparams[] = {};

		//String parameter
		Class[] paramString = new Class[1];
		paramString[0] = String.class;

		//int parameter
		Class[] paramInt = new Class[1];
		paramInt[0] = Integer.TYPE;

		Class[] paramDate = new Class[1];
		paramDate[0] = Date.class;
		
		Class[] paramBoolean = new Class[1];
		paramBoolean[0] = Boolean.TYPE;
		
		ContactVO contact = new ContactVO();
		Class contactClass;
		
		try {
		
			contactClass = Class.forName("com.casosemergencias.dao.vo.ContactVO");
		
			Object object = contactClass.newInstance();
					
			// 1. Transformamos los bytes en un objeto DOM
			System.out.println("Se convierten los bytes de la respuesta en un documento XML para su posterior parseo");
			Document xmlDocument = null;
			xmlDocument = convertInputStreamToXmlDocument(batchstream);
			
			// 2. Recorremos el documento DOM
			System.out.println("Se parsea el documento XML");
			// 2.1. Se debe obtener el tipo de objeto que se quiere parsear
			BatchObjectsMapper mapper = new BatchObjectsMapper();
			Map<String, String> objectMapper = mapper.getContactMap();
			// 2.2. Según el objeto que corresponda, se debe rellenar la lista
			NodeList records = xmlDocument.getElementsByTagName("records");
			if (records != null && records.getLength() > 0) {
				for (int i = 0; i < records.getLength(); i++) {
					System.out.println("Objetos encontrados: " + records.getLength());
					object = contactClass.newInstance();
					Node record = records.item(i);
					if (record.getNodeType() == Node.ELEMENT_NODE) {
						NodeList recordData = records.item(i).getChildNodes();
						if (recordData != null && recordData.getLength() > 0) {
							System.out.println("Parametros encontrados: " + recordData.getLength());
							for (int j = 0; j < recordData.getLength(); j++) {
								String nodeName = null;
								String nodeValue = null;
								Node recordDataNode = recordData.item(j);
								nodeName = recordDataNode.getNodeName();
								NodeList textNodes = recordDataNode.getChildNodes();
								if (textNodes != null && textNodes.getLength() > 0) {
									for (int k = 0; k < textNodes.getLength(); k++) {
										if (textNodes.item(k).getNodeType() == Node.TEXT_NODE) {
											nodeValue = textNodes.item(k).getNodeValue();
											System.out.println("Nombre de parametro: " + nodeName + " con valor: " + nodeValue);
										}
									}
								}
								if (nodeValue != null && !"".equals(nodeValue) && objectMapper.containsKey(nodeName)) {
									Class[] params = new Class[1];
									if (isValidDate(nodeValue)) {
										params = paramDate;
									} else if (NumberUtils.isNumber(nodeValue)) {
										params = paramInt;
									} else if (Boolean.parseBoolean(nodeValue)) {
										params = paramBoolean;
									} else {
										params = paramString;
									}
									Method method = contactClass.getDeclaredMethod("set" + objectMapper.get(nodeName), params);
									method.invoke(object, nodeValue);
								}
							}
						}
						contact = (ContactVO) object;
						System.out.println("Datos del bean: " + contact.toString());
						contactsList.add(contact);
					}
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ParserConfigurationException | SAXException 
				| IOException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println("Error rellenando el bean" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param stream
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private Document convertInputStreamToXmlDocument(InputStream stream) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document document = null;
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		document = builder.parse(new InputSource(stream));
		return document;
	}
	
	public boolean isValidDate(String dateString) {
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        df.parse(dateString);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}
}