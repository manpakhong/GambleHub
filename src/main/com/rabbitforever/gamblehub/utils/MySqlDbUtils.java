package com.rabbitforever.gamblehub.utils;



import java.sql.Connection;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitforever.gamblehub.bundles.DbProperties;
import com.rabbitforever.gamblehub.factories.PropertiesFactory;

public class MySqlDbUtils extends DbUtils{
	private final Logger logger = LogManager.getLogger(getClassName());
	private PropertiesFactory propertiesFactory;
	private String getClassName(){
	return this.getClass().getName();
}

	public MySqlDbUtils() throws Exception{
		try {
			propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();
			properties = (DbProperties) propertiesFactory.getInstanceOfMySqlDbProperties();	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public IDatabaseConnection getDataBaseConnectionWithSchema() throws Exception {
		String schema = properties.getSchema();
		Connection jdbcConnection = getConnection();

		IDatabaseConnection dataBaseConnection = new DatabaseConnection(jdbcConnection, schema);

		DatabaseConfig dbConfig = dataBaseConnection.getConfig();

		// added this line to get rid of the warning
		dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
		return dataBaseConnection;
	}

	public IDatabaseConnection getDataBaseConnectionNoSchema() throws Exception {
		Connection jdbcConnection = getConnection();
		IDatabaseConnection dataBaseConnection = new DatabaseConnection(jdbcConnection);

		DatabaseConfig dbConfig = dataBaseConnection.getConfig();

		// added this line to get rid of the warning
		dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());

		return dataBaseConnection;
	}
	public IDatabaseTester getJdbcDatabaseTester() throws Exception {
		IDatabaseTester databaseTester = null;
		try {
			String schema = properties.getSchema();
			String classForName = properties.getClassForName();
			String username = properties.getUsername();
			String password = properties.getPassword();
			String connectionString = properties.getConnectString();
			databaseTester = new JdbcDatabaseTester(classForName, connectionString, username, password);
		} catch (Exception e) {
			logger.error(getClassName() + ".getJdbcDatabaseTester() - ", e);
			throw e;
		}
		return databaseTester;
	}
	
}
