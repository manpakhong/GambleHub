package com.rabbitforever.gamblehub.factories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class UtilsFactory {
	private final static Logger logger = LogManager.getLogger(getClassName());
	

	private static UtilsFactory utilsFactory;
	private UtilsFactory(){
		
	}

	private static String getClassName() {
		String className = UtilsFactory.getClassName();
		return className;
	}
	public static UtilsFactory getInstance() {
		if (utilsFactory == null) {
			utilsFactory = new UtilsFactory();
		}
		return utilsFactory;
	}
}
