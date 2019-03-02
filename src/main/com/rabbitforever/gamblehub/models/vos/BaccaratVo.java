package com.rabbitforever.gamblehub.models.vos;

import java.util.List;

import com.rabbitforever.gamblehub.models.dtos.BaccaratDto;

public class BaccaratVo {
	private BaccaratDto baccaratDto;
	private List<BaccaratDto> baccaratDtoList;
	private Integer round;
	public List<BaccaratDto> getBaccaratDtoList() {
		return baccaratDtoList;
	}
	public void setBaccaratDtoList(List<BaccaratDto> baccaratDtoList) {
		this.baccaratDtoList = baccaratDtoList;
	}
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
	}
	public BaccaratDto getBaccaratDto() {
		return baccaratDto;
	}
	public void setBaccaratDto(BaccaratDto baccaratDto) {
		this.baccaratDto = baccaratDto;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaccaratVo [baccaratDto=");
		builder.append(baccaratDto);
		builder.append(", baccaratDtoList=");
		builder.append(baccaratDtoList);
		builder.append(", round=");
		builder.append(round);
		builder.append("]");
		return builder.toString();
	}

	
}
