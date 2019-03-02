package com.rabbitforever.gamblehub.models.dtos;

public class BaccaratRequestDto extends RequestDto {
	private BaccaratDto dataInstance;

	public BaccaratDto getDataInstance() {
		return dataInstance;
	}

	public void setDataInstance(BaccaratDto dataInstance) {
		this.dataInstance = dataInstance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaccaratRequestDto [dataInstance=");
		builder.append(dataInstance);
		builder.append("]");
		return builder.toString();
	}
	
}
