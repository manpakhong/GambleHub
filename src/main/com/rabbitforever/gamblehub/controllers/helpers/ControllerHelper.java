package com.rabbitforever.gamblehub.controllers.helpers;

import java.lang.reflect.Method;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.common.factories.UtilsFactory;
import com.rabbitforever.common.utils.DateUtils;

public abstract class ControllerHelper <D>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private UtilsFactory utilsFactory;
	private DateUtils dateUtils;
	public ControllerHelper() throws Exception{
		utilsFactory = UtilsFactory.getInstance();
		dateUtils = utilsFactory.getInstanceOfDateUtils();
	}
	private String getClassName(){
		return this.getClass().getName();
	}	
	public void parseCommonDateTimeStringToDate(D dto) throws Exception{
		try {
			parseCreateDateTimeStringToDate(dto);
			parseUpdateDateTimeStringToDate(dto);
		} catch (Exception e) {
			logger.error(getClassName() + ".parseCommonDateTimeStringToDate()-dto=" + dto, e);
			throw e;
		}
	}
	private void parseCreateDateTimeStringToDate(D dto) throws Exception{
		try {
			Method dtoMethod = dto.getClass().getMethod("getCreateDateString");
			Object returnObject = dtoMethod.invoke(dto);
			String createDateString = (String) returnObject;
			if (createDateString != null && !createDateString.isEmpty()) {
				Date createDate = dateUtils.parseDateTimeStringToDate(createDateString);
				Method eoMethod = dto.getClass().getMethod("setCreateDate", Date.class);
				eoMethod.invoke(dto,createDate);
			}

		} catch (Exception e) {
			logger.error(getClassName() + ".parseCreateDateTimeStringToDate()-dto=" + dto , e);
			throw e;
		}
	}
	private void parseUpdateDateTimeStringToDate(D dto) throws Exception{
		try {
			Method dtoMethod = dto.getClass().getMethod("getUpdateDateString");
			Object returnObject = dtoMethod.invoke(dto);
			String createDateString = (String) returnObject;
			if (createDateString != null && !createDateString.isEmpty()) {
				Date createDate = dateUtils.parseDateTimeStringToDate(createDateString);
				Method eoMethod = dto.getClass().getMethod("setUpdateDate", Date.class);
				eoMethod.invoke(dto,createDate);
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".parseUpdateDateTimeStringToDate()-dto=" + dto , e);
			throw e;
		}
	}
}
