package com.rabbitforever.gamblehub.models.dtos;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.rabbitforever.gamblehub.models.eos.BaccaratEo;

public class BaccaratDto extends BaccaratEo {
//	private Logger log = Logger.getLogger(getClassName());
	private String datetimeString;
	private String createDateString;
	private String updateDateString;
	private String resultFirstCharString;
	private String oddEvenAbbreviation;
	private String displayOddBankerPlayerPBAbbreviationResult;
	private String displayOddBankerPlayerResult;
	private String displayEvenBankerPlayerPBAbbreviationResult;
	private String displayEvenBankerPlayerResult;

	public BaccaratDto() {
	}

	public BaccaratDto(BaccaratEo baccaratEo) throws Exception {
		BeanUtils.copyProperties(this, baccaratEo);

	}



	public String getDisplayOddBankerPlayerPBAbbreviationResult() {
		return displayOddBankerPlayerPBAbbreviationResult;
	}

	public void setDisplayOddBankerPlayerPBAbbreviationResult(String displayOddBankerPlayerPBAbbreviationResult) {
		this.displayOddBankerPlayerPBAbbreviationResult = displayOddBankerPlayerPBAbbreviationResult;
	}

	public String getDisplayEvenBankerPlayerPBAbbreviationResult() {
		return displayEvenBankerPlayerPBAbbreviationResult;
	}

	public void setDisplayEvenBankerPlayerPBAbbreviationResult(String displayEvenBankerPlayerPBAbbreviationResult) {
		this.displayEvenBankerPlayerPBAbbreviationResult = displayEvenBankerPlayerPBAbbreviationResult;
	}

	public String getDisplayOddBankerPlayerResult() {
		return displayOddBankerPlayerResult;
	}

	public void setDisplayOddBankerPlayerResult(String displayOddBankerPlayerResult) {
		this.displayOddBankerPlayerResult = displayOddBankerPlayerResult;
	}


	public String getDisplayEvenBankerPlayerResult() {
		return displayEvenBankerPlayerResult;
	}

	public void setDisplayEvenBankerPlayerResult(String displayEvenBankerPlayerResult) {
		this.displayEvenBankerPlayerResult = displayEvenBankerPlayerResult;
	}

	public String getResultFirstCharString() {
		return resultFirstCharString;
	}

	public void setResultFirstCharString(String resultFirstCharString) {
		this.resultFirstCharString = resultFirstCharString;
	}

	public String getOddEvenAbbreviation() {
		return oddEvenAbbreviation;
	}

	public void setOddEvenAbbreviation(String oddEvenAbbreviation) {
		this.oddEvenAbbreviation = oddEvenAbbreviation;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaccaratDto [datetimeString=");
		builder.append(datetimeString);
		builder.append(", createDateString=");
		builder.append(createDateString);
		builder.append(", updateDateString=");
		builder.append(updateDateString);
		builder.append(", resultFirstCharString=");
		builder.append(resultFirstCharString);
		builder.append(", oddEvenAbbreviation=");
		builder.append(oddEvenAbbreviation);
		builder.append(", displayOddBankerPlayerPBAbbreviationResult=");
		builder.append(displayOddBankerPlayerPBAbbreviationResult);
		builder.append(", displayOddBankerPlayerResult=");
		builder.append(displayOddBankerPlayerResult);
		builder.append(", displayEvenBankerPlayerPBAbbreviationResult=");
		builder.append(displayEvenBankerPlayerPBAbbreviationResult);
		builder.append(", displayEvenBankerPlayerResult=");
		builder.append(displayEvenBankerPlayerResult);
		builder.append("]");
		return builder.toString();
	}




}
