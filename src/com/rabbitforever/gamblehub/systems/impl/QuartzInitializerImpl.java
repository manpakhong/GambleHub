package com.rabbitforever.gamblehub.systems.impl;

import org.jboss.logging.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.rabbitforever.gamblehub.quartz.jobs.impl.HelloJobImpl;
import com.rabbitforever.gamblehub.systems.Initializer;

public class QuartzInitializerImpl implements Initializer{
	private static final Logger log = Logger.getLogger(QuartzInitializerImpl.class);
	@Override
	public void start() throws Exception {
		try {
	        createAndRunJob();
		} catch (Exception e) {
			log.error(QuartzInitializerImpl.class.getName() + "start()", e);
			throw e;
		}
	}
	private void createAndRunJob() throws Exception {
		try {
			  // define the job and tie it to our HelloJob class
			  JobDetail job = JobBuilder.newJob(HelloJobImpl.class)
			      .withIdentity("job1", "group1")
			      .build();

			  // Trigger the job to run now, and then repeat every 40 seconds
			  Trigger trigger = TriggerBuilder.newTrigger()
			      .withIdentity("trigger1", "group1")
			      .startNow()
			            .withSchedule(SimpleScheduleBuilder.simpleSchedule()
			              .withIntervalInSeconds(40)
			              .repeatForever())            
			      .build();

			  // Tell quartz to schedule the job using our trigger
			  Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		    	scheduler.start();
		
			  scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {
			log.error(QuartzInitializerImpl.class.getName() + "routineJob()", e);
			throw e;
		}
	}
	
}
