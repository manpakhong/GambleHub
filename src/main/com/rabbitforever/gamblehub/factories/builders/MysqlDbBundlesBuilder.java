package com.rabbitforever.gamblehub.factories.builders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitforever.gamblehub.bundles.MysqlDbProperties;
public class MysqlDbBundlesBuilder extends BundlesBuilder<MysqlDbProperties>{
	private final Logger logger = LogManager.getLogger(getClassName());
	private String className;
	public MysqlDbBundlesBuilder(String fileName) throws Exception{
		super(fileName);
	}
	private String getClassName(){
		if(className == null){
			className = this.getClass().getName();
		}
		return className;
	}
	@Override
	public MysqlDbProperties build() throws Exception{
		 MysqlDbProperties mysqlDbProperties= null;
		try{
			mysqlDbProperties = new MysqlDbProperties();
			String connectionString = getPropValues("connection_string");
			mysqlDbProperties.setConnectionString(connectionString);
			String classForName = getPropValues("class_for_name");
			mysqlDbProperties.setClassForName(classForName);
			String host = getPropValues("host");
			mysqlDbProperties.setHost(host);
			String port = getPropValues("port");
			mysqlDbProperties.setPort(port);
			String schema = getPropValues("schema");
			mysqlDbProperties.setSchema(schema);
			String username = getPropValues("username");
			mysqlDbProperties.setUsername(username);
			String password = getPropValues("password");
			mysqlDbProperties.setPassword(password);
			String systemSchema = getPropValues("system_schema");
			mysqlDbProperties.setSystemSchema(systemSchema);
		} catch (Exception e) {
			this.logger.error(getClassName() + ".build() - this.fileName=" + this.fileName, e);
			throw e;
		}
		return mysqlDbProperties;
	}
}
