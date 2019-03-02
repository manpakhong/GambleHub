package com.rabbitforever.gamblehub.models.dtos;

public class BaccaratReponseDto extends ReponseDto{
	private BaccaratDto baccaratDto;

	public BaccaratDto getBaccaratDto() {
		return baccaratDto;
	}

	public void setBaccaratDto(BaccaratDto baccaratDto) {
		this.baccaratDto = baccaratDto;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaccaratReponseDto [baccaratDto=");
		builder.append(baccaratDto);
		builder.append("]");
		return builder.toString();
	}
	
}
