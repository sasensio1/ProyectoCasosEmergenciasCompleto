package com.casosemergencias.util.datatables;

import java.util.List;
import java.util.Map;

public class DataTableProperties {
	private int draw;
	private int start;
	private int length;
	
	/* 
	 * Claves del mapa de búsqueda genérica: 
	 * - searchValue
	 * - searchRegEx
	 */
	private Map<String, Object> genericSearching;
	
	/* 
	 * Claves del mapa de ordenación: 
	 * - orderingColumnNumber
	 * - orderingColumnName
	 * - orderingDirection 
	 */
	private Map<String, Object> tableOrdering;
	private List<DataTableColumnInfo> columnsInfo;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Map<String, Object> getGenericSearching() {
		return genericSearching;
	}

	public void setGenericSearching(Map<String, Object> genericSearching) {
		this.genericSearching = genericSearching;
	}

	public Map<String, Object> getTableOrdering() {
		return tableOrdering;
	}

	public void setTableOrdering(Map<String, Object> tableOrdering) {
		this.tableOrdering = tableOrdering;
	}

	public List<DataTableColumnInfo> getColumsInfo() {
		return columnsInfo;
	}

	public void setColumsInfo(List<DataTableColumnInfo> columnsInfo) {
		this.columnsInfo = columnsInfo;
	}
}