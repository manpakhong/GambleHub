package com.rabbitforever.gamblehub.services;

import java.util.List;
import java.util.Map;

import com.rabbitforever.gamblehub.models.eos.BigSmallEo;

public interface GambleService {
	public List<BigSmallEo> read(Object so) throws Exception;
	public Integer create(BigSmallEo eo) throws Exception;
	public Map<String, Integer> getPatternCount(String resultString) throws Exception;
}
