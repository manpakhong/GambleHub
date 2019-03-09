package com.rabbitforever.gamblehub.systems.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitforever.gamblehub.systems.Initializer;

@SuppressWarnings("serial")
public class InitializerImpl extends HttpServlet implements Initializer{

	private final Logger logger = LogManager.getLogger(getClassName());
	private Initializer quartzInitializer;
	public void init() throws ServletException{
		try{
			start();
		} catch (Exception e){
			logger.error("InitializerImpl.init()", e);
		}
	}
	@Override
	public void start() throws Exception{
		try {
//			quartzInitializer = new QuartzInitializerImpl();
//			quartzInitializer.start();
//			
//			log.info("System is Initialized!");
		} catch (Exception e) {
			logger.error(InitializerImpl.class.getName() + "start()", e);
			throw e;
		}
	}
	private String getClassName(){
		return this.getClass().getName();
	}
}
