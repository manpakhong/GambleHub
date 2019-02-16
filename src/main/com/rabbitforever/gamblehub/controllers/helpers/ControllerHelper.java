package com.rabbitforever.gamblehub.controllers.helpers;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ControllerHelper <D, E>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}	
	public void parseCommonDateTimeStringToDate(D dto, E eo) throws Exception{
		try {
			Method method = dto.getClass().getMethod("getCreateDateString", null);
			Type[] genericParameterTypes = method.getGenericParameterTypes();
			for(Type genericParameterType : genericParameterTypes){
			    if(genericParameterType instanceof ParameterizedType){
			        ParameterizedType aType = (ParameterizedType) genericParameterType;
			        Type[] parameterArgTypes = aType.getActualTypeArguments();
			        for(Type parameterArgType : parameterArgTypes){
			            Class parameterArgClass = (Class) parameterArgType;
			            System.out.println("parameterArgClass = " + parameterArgClass);
			        }
			    }
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".parseCommonDateTimeStringToDate()-dto=" + dto + ",eo=" + eo, e);
			throw e;
		}
	}
}
