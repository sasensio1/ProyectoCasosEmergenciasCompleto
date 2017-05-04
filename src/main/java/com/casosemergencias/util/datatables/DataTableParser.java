package com.casosemergencias.util.datatables;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class DataTableParser {
	
	final static Logger logger = Logger.getLogger(DataTableParser.class);
	
	/**
	 * Metodo que transforma el body en un DataTableProperties, clase que contiene propiedades de los DataTables 
	 * 
	 * @param body -- body recuperado del DataTable con el formato "prop1=valor&prop2=valor&prop3=valor"
	 * @return
	 */ 
	public static DataTableProperties parseBodyToDataTable(String body) {
		DataTableProperties dataTableProperties = new DataTableProperties();
		try {
			body = URLDecoder.decode(body, "UTF-8");
			Map<String, String> mappedPropertiesFromBody = mapDataTableProperties(body);
			
			dataTableProperties.setStart(Integer.parseInt(mappedPropertiesFromBody.get("start")));
			dataTableProperties.setLength(Integer.parseInt(mappedPropertiesFromBody.get("length")));
			dataTableProperties.setDraw(Integer.parseInt(mappedPropertiesFromBody.get("draw")));
			
			Map<String, Object> genericSearching = new HashMap<String, Object>();
			genericSearching.put("searchValue", mappedPropertiesFromBody.get("search[value]"));
			genericSearching.put("searchRegEx", Boolean.parseBoolean(mappedPropertiesFromBody.get("search[regex]")));
			dataTableProperties.setGenericSearching(genericSearching);
			
			Map<String, Object> tableOrdering = new HashMap<String, Object>();
			//Comprobamos si es ordenable
			if(mappedPropertiesFromBody.get("order[0][column]") != null){
				Integer orderingColumnNumber = Integer.parseInt(mappedPropertiesFromBody.get("order[0][column]"));
				//variable para recuperar el nombre de la columna, es de la forma 'columns[0][data]'
				String orderingColumnName = mappedPropertiesFromBody.get("columns[" + orderingColumnNumber+ "][data]"); 
				tableOrdering.put("orderingColumnNumber", orderingColumnNumber);
				tableOrdering.put("orderingColumnName", orderingColumnName);
				tableOrdering.put("orderingDirection", mappedPropertiesFromBody.get("order[0][dir]"));
				dataTableProperties.setTableOrdering(tableOrdering);
			}
			
			List<DataTableColumnInfo> columnsInfo = new LinkedList<DataTableColumnInfo>();
			int columnCounter = 0;
			while (mappedPropertiesFromBody.containsKey("columns[" + columnCounter + "][data]")) {
				DataTableColumnInfo columnInfo = new DataTableColumnInfo();
				columnInfo.setColumnOrder(columnCounter);
				columnInfo.setData(mappedPropertiesFromBody.get("columns[" + columnCounter + "][data]"));
				columnInfo.setName(mappedPropertiesFromBody.get("columns[" + columnCounter + "][name]"));
				columnInfo.setOrderable(Boolean.parseBoolean(mappedPropertiesFromBody.get("columns[" + columnCounter + "][orderable]")));
				columnInfo.setSearchable(Boolean.parseBoolean(mappedPropertiesFromBody.get("columns[" + columnCounter + "][searchable]")));
				columnInfo.setSearchValue(mappedPropertiesFromBody.get("columns[" + columnCounter + "][search][value]"));
				columnInfo.setSearchRegEx(Boolean.parseBoolean(mappedPropertiesFromBody.get("columns[" + columnCounter + "][search][regex]")));
				columnsInfo.add(columnInfo);
				columnCounter++;
			}
			dataTableProperties.setColumsInfo(columnsInfo);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			return null;
		}
		
		return dataTableProperties;
	}
	
	/**
	 * @param body
	 * @return
	 */
	private static Map<String, String> mapDataTableProperties(String body) {
		String[] firstPartition = body.split("&");
		Map<String, String> mapProperties = new HashMap<>();
		for (String data : firstPartition) {
			String[] secondPartition = data.split("=");
			if (secondPartition.length == 1) {
				//la propiedad no tiene valor
				mapProperties.put(secondPartition[0], "");
			} else {
				//la propiedad tiene clave y valor
				mapProperties.put(secondPartition[0], secondPartition[1]);
			}
		}
		return mapProperties;
	}
}