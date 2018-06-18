package com.rabbitforever.gamblehub.daos;

import java.util.List;

import com.rabbitforever.gamblehub.models.eos.BigSmallEo;

public interface BigSmallDao {
	public  List<BigSmallEo> read(Object so) throws Exception;
	public  Integer create(BigSmallEo eo) throws Exception;
	public  Integer update(BigSmallEo eo) throws Exception;
	public  Integer delete(BigSmallEo eo) throws Exception;
}
