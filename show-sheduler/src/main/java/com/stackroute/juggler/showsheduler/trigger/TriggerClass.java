//package com.stackroute.juggler.showsheduler.trigger;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//import org.quartz.DateBuilder.IntervalUnit;
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.JobKey;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.SimpleScheduleBuilder;
//import org.quartz.SimpleTrigger;
//import org.quartz.Trigger.TriggerState;
//import org.quartz.TriggerBuilder;
//import org.quartz.TriggerKey;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Service;
//
//import com.stackroute.juggler.showsheduler.job.JobFunction;
//
//@Service
//public class TriggerClass {
//
//	// public JobDetail job =
//	// JobBuilder.newJob().ofType(JobFunction.class).storeDurably().withIdentity("Qrtz_Job_Detail")
//	// .withDescription("Invoke Job service...").build();
//	//
//	// public Trigger trigger =
//	// TriggerBuilder.newTrigger().forJob(job).withIdentity("Qrtz_Trigger")
//	// .withDescription("Sample trigger")
//	// .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(5)).build();
//	//
//	// public Scheduler sai = scheduler(trigger,job);
//	//
//	// public Scheduler scheduler(Trigger trigger, JobDetail job) throws
//	// SchedulerException, IOException {
//	// StdSchedulerFactory factory = new StdSchedulerFactory();
//	// factory.initialize(new
//	// ClassPathResource("quartz.properties").getInputStream());
//	// Scheduler scheduler = factory.getScheduler();
//	// // scheduler.setJobFactory(springBeanJobFactory());
//	// scheduler.scheduleJob(job, trigger);
//	// scheduler.start();
//	// return scheduler;
//	// }
//	public static void main(String[] args) {
//		System.out.println(1);
//		// StdSchedulerFactory factory = new StdSchedulerFactory();
//		// factory.initialize(new
//		// ClassPathResource("quartz.properties").getInputStream());
//		// Scheduler sc = factory.getScheduler();
//		Scheduler sc;
//		try {
//			sc = StdSchedulerFactory.getDefaultScheduler();
//			System.out.println(2);
//			JobKey jobKey = JobKey.jobKey("job");
//			System.out.println(3);
//			JobDetail job = JobBuilder.newJob(JobFunction.class).withIdentity(jobKey).build();
//			System.out.println(4);
//			TriggerKey triggerKey = TriggerKey.triggerKey("trigger");
//			if (sc.getTriggerState(triggerKey) == TriggerState.ERROR) {
//				sc.resumeTrigger(triggerKey);
//			}
//			System.out.println(5);
//			SimpleTrigger trigger =
//					// TriggerBuilder.newTrigger().withIdentity(triggerKey)
//					// .startAt(futureDate((int) secondsDiff, IntervalUnit.SECOND)).forJob(job)
//					// .withSchedule(simpleSchedule()).build();
//					TriggerBuilder.newTrigger().forJob(job).withIdentity(triggerKey).withDescription("Sample trigger")
//							// .withSchedule(simpleSchedule()).build();
//							.withSchedule(
//									SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(5))
//							.build();
//			System.out.println(6);
//			sc.scheduleJob(job, trigger);
//			System.out.println(7);
//			sc.start();
//			System.out.println(8);
//
//		} catch (SchedulerException e) {
//			e.printStackTrace();
//		}
//
//	}
//}
