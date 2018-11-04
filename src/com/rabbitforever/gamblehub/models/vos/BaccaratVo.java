package com.rabbitforever.gamblehub.models.vos;

import java.util.List;

import com.rabbitforever.gamblehub.models.eos.BaccaratEo;

public class BaccaratVo {
	private List<BaccaratEo> baccaratEoList;
	private Integer round;
	public List<BaccaratEo> getBaccaratEoList() {
		return baccaratEoList;
	}
	public void setBaccaratEoList(List<BaccaratEo> baccaratEoList) {
		this.baccaratEoList = baccaratEoList;
	}
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
	}
}
