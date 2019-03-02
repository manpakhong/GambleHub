package com.rabbitforever.gamblehub.models.dtos;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.rabbitforever.gamblehub.models.eos.BaccaratEo;

public class BaccaratDto extends BaccaratEo{
	private Logger log = Logger.getLogger(getClassName());
	private String datetimeString;
	private String createDateString;
	private String updateDateString;
	public BaccaratDto() {
		
	}
	public BaccaratDto (BaccaratEo baccaratEo) throws Exception{
		try {
			BeanUtils.copyProperties(this, baccaratEo);
		} catch (Exception e) {
			log.error(getClassName() + ".BaccaratDto()-baccaratEo=" + baccaratEo, e);
			throw e;
		}
	}
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
	private String getClassName() {
		return this.getClass().getName();
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
