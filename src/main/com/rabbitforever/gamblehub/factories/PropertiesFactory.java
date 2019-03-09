package com.rabbitforever.gamblehub.factories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitforever.gamblehub.bundles.MysqlDbProperties;
import com.rabbitforever.gamblehub.bundles.SysProperties;
import com.rabbitforever.gamblehub.factories.builders.BundlesBuilder;
import com.rabbitforever.gamblehub.factories.builders.MysqlDbBundlesBuilder;
import com.rabbitforever.gamblehub.factories.builders.SysBundlesBuilder;

public class PropertiesFactory {
	private final static Logger logger = LogManager.getLogger(getClassName());

	
	
	private BundlesBuilder<SysProperties> sysBundlesBuilder;
	private final String SYS_PROPERTIES_FILE = "sys.properties";
	private final String MYSQL_DB_PROPERTIES_FILE = "mysql.db.properties";

	private static PropertiesFactory propertiesFactory;
	private static MysqlDbProperties mysqlDbProperties;
	private static SysProperties sysProperties;
	

	private static String getClassName() {
		String className = PropertiesFactory.class.getName();
		return className;
	}
	private PropertiesFactory() throws Exception{
		try {
			init();
		} catch (Exception e) {
			logger.error(getClassName() + ".PropertiesFactory()", e);
		}
	}

	private void init() throws Exception {
		try {


		} catch (Exception e) {
			logger.error(getClassName() + ".BundlesFactory()", e);
		}
	}
	
	public static PropertiesFactory getInstanceOfPropertiesFactory() throws Exception {
		try {
			if (propertiesFactory == null) {
				propertiesFactory = new PropertiesFactory();
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".getInstanceOfPropertiesFactory() - ", e);
		}
		return propertiesFactory;
	}
	
	public MysqlDbProperties getInstanceOfMySqlDbProperties() throws Exception {
		try {
			if (mysqlDbProperties == null) {
				BundlesBuilder<MysqlDbProperties> mysqlDbBundlesBuilder = new MysqlDbBundlesBuilder(MYSQL_DB_PROPERTIES_FILE);
				mysqlDbProperties = mysqlDbBundlesBuilder.build();
			}

		} catch (Exception e) {
			logger.error(getClassName() + ".getInstanceOfMySqlDbProperties() - ", e);
		}
		return mysqlDbProperties;
	}
	
	public SysProperties getInstanceOfSysProperties() throws Exception {
		try {
			if(sysBundlesBuilder == null) {
				sysBundlesBuilder = new SysBundlesBuilder(SYS_PROPERTIES_FILE);
			}
			sysProperties = (SysProperties) sysBundlesBuilder.build();
			if (sysProperties == null) {
				throw new Exception(SYS_PROPERTIES_FILE + " does not exist!");
			}

		} catch (Exception ex) {
			logger.error(getClassName() + ".getInstanceOfSysProperties() - ", ex);
			throw ex;
		}
		return sysProperties;
	}
	

}
