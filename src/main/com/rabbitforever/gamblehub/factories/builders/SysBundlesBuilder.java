package com.rabbitforever.gamblehub.factories.builders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitforever.gamblehub.bundles.SysProperties;
public class SysBundlesBuilder extends BundlesBuilder<SysProperties>{
	private final Logger logger = LogManager.getLogger(getClassName());
	private String className;
	public SysBundlesBuilder(String fileName) throws Exception{
		super(fileName);
	}
	private String getClassName(){
		if(className == null){
			className = this.getClass().getName();
		}
		return className;
	}
	@Override
	public SysProperties build() throws Exception{
		 SysProperties sysProperties= null;
		try{
			sysProperties = new SysProperties();
			String database = getPropValues("database");
			sysProperties.setDatabase(database);
			String deployType = getPropValues("deploy_type");
			sysProperties.setDeployType(deployType);
		} catch (Exception e) {
			this.logger.error(getClassName() + ".build() - this.fileName=" + this.fileName, e);
			throw e;
		}
		return sysProperties;
	}
}
