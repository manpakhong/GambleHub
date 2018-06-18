package com.rabbitforever.gamblehub.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitforever.gamblehub.daos.BigSmallDao;
import com.rabbitforever.gamblehub.daos.DaoBase;
import com.rabbitforever.gamblehub.models.eos.BigSmallEo;
@Service
public class GambleServiceImp extends ServiceBase implements GambleService{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}

	@Autowired
	private DaoBase dao;
	   
	@Override
	public List<BigSmallEo> read(Object so) throws Exception {
		List<BigSmallEo> bigSmallEoList = null;
		try{
			bigSmallEoList = dao.read(so);
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		return bigSmallEoList;
	}



}
