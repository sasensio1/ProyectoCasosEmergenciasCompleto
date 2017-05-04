package com.casosemergencias.util.datatables;

public class DataTableColumnInfo {
	private int columnOrder;
	private String data;
	private String name;
	private boolean orderable;
	private boolean searchable;
	private String searchValue;
	private boolean searchRegEx;

	public int getColumnOrder() {
		return columnOrder;
	}
	
	public void setColumnOrder(int columnOrder) {
		this.columnOrder = columnOrder;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOrderable() {
		return orderable;
	}

	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public boolean getSearchRegEx() {
		return searchRegEx;
	}

	public void setSearchRegEx(boolean searchRegEx) {
		this.searchRegEx = searchRegEx;
	}
}