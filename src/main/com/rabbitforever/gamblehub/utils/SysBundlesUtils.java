package com.rabbitforever.gamblehub.utils;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.rabbitforever.gamblehub.bundles.SysProperties;

public class SysBundlesUtils extends BundlesUtils <SysProperties>{
	private final Logger logger = LogManager.getLogger(getClassName());
	public SysBundlesUtils(String fileName) throws Exception {
		super(fileName);
	}


	private String getClassName(){
		String className = this.getClass().getName();
		return className;
	}
	@Override
	public SysProperties getProperties() throws Exception{
		SysProperties sysProperties = null;
		try{
			
			sysProperties = new SysProperties();
			String database = getPropValues("database");
			sysProperties.setDatabase(database);

			
			
		} catch (Exception e){
			logger.error(getClassName() + ".getSysProperties()", e);
			throw e;
		}
		return sysProperties;
	}







}
