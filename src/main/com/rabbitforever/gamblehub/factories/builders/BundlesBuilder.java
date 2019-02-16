package com.rabbitforever.gamblehub.factories.builders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.common.factories.UtilsFactory;
import com.rabbitforever.common.utils.CommonUtils;
import com.rabbitforever.common.utils.DateUtils;
import com.rabbitforever.common.utils.FileUtils;
import com.rabbitforever.gamblehub.factories.PropertiesFactory;

public abstract class BundlesBuilder <T> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private Properties properties;
	protected String fileName;
	protected PropertiesFactory propertiesFactory;

	protected UtilsFactory utilsFactory;
	protected CommonUtils commonUtils;
	protected FileUtils fileUtils;
	protected DateUtils dateUtils;
	private static int initCount;
	
	public BundlesBuilder(String fileName) throws Exception{
		this.fileName = fileName;
		init();
	}
	private String getClassName(){
		String className = this.getClassName();
		return className;
	}
	private void init() throws IOException{
		InputStream inputStream = null;
		properties = new Properties();
		try {
			
			propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();
			utilsFactory = UtilsFactory.getInstance();
			
			
			inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".init()", e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				logger.error(getClassName() + ".init()", e);
				throw e;
			}
		}
	}
	
	protected String getPropValues(String paramName) throws Exception{
		String result = null;
		try {
			if (properties != null){
				result = properties.getProperty(paramName);
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".getPropValues() - paramName=" + paramName, e);
			throw e;
		} finally {
		}
		return result;
	}
	abstract public T build() throws Exception;
	
}
