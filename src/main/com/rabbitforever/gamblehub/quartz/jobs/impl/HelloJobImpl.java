package com.rabbitforever.gamblehub.quartz.jobs.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.rabbitforever.gamblehub.factories.PropertiesFactory;
import com.rabbitforever.gamblehub.systems.impl.InitializerImpl;

public class HelloJobImpl implements Job {
	private final Logger logger = LogManager.getLogger(getClassName());
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("Hello Quartz!");

	}
	private static String getClassName() {
		String className = HelloJobImpl.getClassName();
		return className;
	}
}
