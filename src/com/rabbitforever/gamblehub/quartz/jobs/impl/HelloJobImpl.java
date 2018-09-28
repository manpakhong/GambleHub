package com.rabbitforever.gamblehub.quartz.jobs.impl;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.rabbitforever.gamblehub.systems.impl.InitializerImpl;

public class HelloJobImpl implements Job {
	private static final Logger log = Logger.getLogger(InitializerImpl.class);
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("Hello Quartz!");

	}
}
