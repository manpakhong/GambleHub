package com.rabbitforever.gamblehub.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.gamblehub.utils.DbUtils;
import com.rabbitforever.gamblehub.utils.HibernateUtils;
import com.rabbitforever.gamblehub.utils.MySqlDbUtils;
public class DbUtilsFactory {
	private final static Logger logger = LoggerFactory.getLogger(getClassName());

	private static DbUtils mySqlDbUtils;
	private static DbUtilsFactory dbUtilsFactory;
//	private static DbUtils db2DbUtils;
//	private static DbUtils msSqlDbUtils;
	private static HibernateUtils hibernateUtils;
	
	private DbUtilsFactory(){
		
	}
	public static DbUtilsFactory getInstanceOfDbUtilsFactory() {
		if (dbUtilsFactory == null) {
			dbUtilsFactory = new DbUtilsFactory();
		}
		return dbUtilsFactory;
	}
	public DbUtils getInstanceOfMySqlDbUtils() throws Exception{
		try {
			if (mySqlDbUtils == null){
				mySqlDbUtils = new MySqlDbUtils();
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".getInstanceOfMySqlDbUtils()", e);
			throw e;
		}
		return mySqlDbUtils;
	}
	public static String getClassName() {
		String className = DbUtilsFactory.class.getName();
		return className;
	}
	public HibernateUtils getInstanceOfHibernateUtils() throws Exception{
		try {
			if (hibernateUtils == null){
				hibernateUtils = new HibernateUtils();
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".getInstanceOfHibernateUtils()", e);
			throw e;
		}
		return hibernateUtils;
	}
//	public static DbUtils getInstanceOfDb2DbUtils() throws Exception{
//		if (db2DbUtils == null){
//			db2DbUtils = new Db2DbUtils();
//		}
//		return db2DbUtils;
//	}
//	
//	public static DbUtils getInstanceOfMsSqlDbUtils() throws Exception{
//		if (msSqlDbUtils == null){
//			msSqlDbUtils = new MsSqlDbUtils();
//		}
//		return msSqlDbUtils;
//	}
}
