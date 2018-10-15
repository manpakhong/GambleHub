package com.rabbitforever.gamblehub.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrmDaoBase <T> {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	@Autowired
	protected SessionFactory sessionFactory;
	protected Session session;
	private String getClassName(){
		return this.getClass().getName();
	}
	public abstract List<T> read(Object so) throws Exception;
	public abstract Integer create(T eo) throws Exception;
	public abstract Integer update(T eo) throws Exception;
	public abstract Integer delete(T eo) throws Exception;

}
