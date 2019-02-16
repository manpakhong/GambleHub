package com.rabbitforever.gamblehub.controllers.helpers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.gamblehub.models.dtos.BaccaratDto;
import com.rabbitforever.gamblehub.models.eos.BaccaratEo;
import com.rabbitforever.gamblehub.models.eos.BigSmallEo;

public class GambleControllerHelper extends ControllerHelper<BaccaratDto, BaccaratEo>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}	
	public String getStringFromBigSmallEoList(List<BigSmallEo> bigSmallEoList) throws Exception{
		StringBuilder s = null;
		try {
			s = new StringBuilder();
			for (BigSmallEo eo: bigSmallEoList) {
				String result = eo.getResult();
				s.append(result);
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".getStringFromBigSmallEoList() - bigSmallEoList=" + bigSmallEoList, e);
			throw e; 
		}
		return s.toString();
	}
}
