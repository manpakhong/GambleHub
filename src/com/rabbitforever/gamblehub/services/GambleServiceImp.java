package com.rabbitforever.gamblehub.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.rabbitforever.gamblehub.daos.BigSmallDao;
import com.rabbitforever.gamblehub.models.eos.BigSmallEo;

public class GambleServiceImp extends ServiceBase{
	   @Autowired
	   private BigSmallDao bigSmallDao;



}
