package com.rabbitforever.gamblehub.daos;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabbitforever.common.factories.UtilsFactory;
import com.rabbitforever.common.utils.DateUtils;
import com.rabbitforever.common.utils.MiscUtils;
import com.rabbitforever.gamblehub.factories.DbUtilsFactory;
import com.rabbitforever.gamblehub.utils.DbUtils;
import com.rabbitforever.gamblehub.utils.HibernateUtils;

public abstract class OrmDaoBase <T> {
	private final Logger logger = LogManager.getLogger(getClassName());
	@Autowired
	protected SessionFactory sessionFactory;
	protected Session session;
	protected DbUtilsFactory dbUtilsFactory;
	protected DbUtils dbUtils;
	protected HibernateUtils hibernateUtils;
	protected DateUtils dateUtils;
	protected UtilsFactory generalUtilsFactory;
	protected MiscUtils miscUtils;
	public OrmDaoBase() throws Exception{
		init();
	}
	private String getClassName(){
		return this.getClass().getName();
	}
	public void init() throws Exception {
		try {
			dbUtilsFactory = DbUtilsFactory.getInstanceOfDbUtilsFactory();
			dbUtils = dbUtilsFactory.getInstanceOfMySqlDbUtils();
			hibernateUtils = dbUtilsFactory.getInstanceOfHibernateUtils();
			generalUtilsFactory = UtilsFactory.getInstance();
			miscUtils = generalUtilsFactory.getInstanceOfMiscUtils();
			dateUtils = generalUtilsFactory.getInstanceOfDateUtils();
			
			sessionFactory = hibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();

		} catch (Exception e) {
			logger.error(getClassName() + ".init()", e);
			throw e;
		}
	}
	public abstract List<T> read(Object so) throws Exception;
	public abstract void create(T eo) throws Exception;
	public abstract void update(T eo) throws Exception;
	public abstract void delete(T eo) throws Exception;

}
