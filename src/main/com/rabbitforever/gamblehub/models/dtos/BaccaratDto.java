package com.rabbitforever.gamblehub.models.dtos;

import com.rabbitforever.gamblehub.models.eos.BaccaratEo;

public class BaccaratDto extends BaccaratEo{
	private String datetimeString;
	private String createDateString;
	private String updateDateString;
	public String getDatetimeString() {
		return datetimeString;
	}
	public void setDatetimeString(String datetimeString) {
		this.datetimeString = datetimeString;
	}
	public String getCreateDateString() {
		return createDateString;
	}
	public void setCreateDateString(String createDateString) {
		this.createDateString = createDateString;
	}
	public String getUpdateDateString() {
		return updateDateString;
	}
	public void setUpdateDateString(String updateDateString) {
		this.updateDateString = updateDateString;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaccaratDto [datetimeString=");
		builder.append(datetimeString);
		builder.append(", createDateString=");
		builder.append(createDateString);
		builder.append(", updateDateString=");
		builder.append(updateDateString);
		builder.append("]");
		return builder.toString();
	}
	
}
