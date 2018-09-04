//package com.stackroute.juggler.showscheduler.trigger;
//
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.SimpleScheduleBuilder;
//import org.quartz.SimpleTrigger;
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
//import org.quartz.impl.StdSchedulerFactory;
//
//import com.stackroute.juggler.showscheduler.showjob.ShowJobFunction;
//
//public class TriggerExample {
//
//	public static void main(String[] args) throws SchedulerException{
//		
//	
//	JobDetail jc= JobBuilder.newJob(ShowJobFunction.class).build();
//	        
//	    Trigger tc = TriggerBuilder.newTrigger().withIdentity("simple Trigger")   
//	                  .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(02)
//	                  .repeatForever()).build();
//	    
//	    
//	    Scheduler sc= StdSchedulerFactory.getDefaultScheduler();
//	    sc.start();
//	    sc.scheduleJob(jc,tc);
//}
//}