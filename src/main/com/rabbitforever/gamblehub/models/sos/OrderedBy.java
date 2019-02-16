package com.rabbitforever.gamblehub.models.sos;

public class OrderedBy {
	public static String ORDER_ASC = "asc";
	public static String ORDER_DESC = "desc";
	protected String dataField;
	protected Boolean isAsc;
	public String getDataField() {
		return this.dataField;
	}
	public void setAsc(String dataField) {
		this.dataField = dataField;
		isAsc = true;
	}
	public void setDesc(String dataField) {
		this.dataField = dataField;
		isAsc = false;
	}
	public Boolean getIsAsc() {
		return isAsc;
	}
	public void setIsAsc(Boolean isAsc) {
		this.isAsc = isAsc;
	}
	
}
