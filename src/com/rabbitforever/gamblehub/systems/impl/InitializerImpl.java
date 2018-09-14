package com.rabbitforever.gamblehub.systems.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.jboss.logging.Logger;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.rabbitforever.gamblehub.systems.Initializer;

@SuppressWarnings("serial")
public class InitializerImpl extends HttpServlet implements Initializer{
	private static final Logger log = Logger.getLogger(InitializerImpl.class);
	private Initializer quartzInitializer;
	public void init() throws ServletException{
		try{
			start();
		} catch (Exception e){
			log.error("InitializerImpl.init()", e);
		}
	}
	@Override
	public void start() throws Exception{
		try {
			quartzInitializer = new QuartzInitializerImpl();
			quartzInitializer.start();
			
			log.info("System is Initialized!");
		} catch (Exception e) {
			log.error(InitializerImpl.class.getName() + "start()", e);
			throw e;
		}
	}
}
