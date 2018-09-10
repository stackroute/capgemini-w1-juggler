package com.stackroute.showsheduler;

import java.io.IOException;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger.TriggerState;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.stackroute.juggler.showsheduler.job.JobFunction;

@SpringBootApplication
@EnableScheduling
public class ShowShedulerApplication {

	public static void main(String[] args) throws SchedulerException, IOException {

		SpringApplication.run(ShowShedulerApplication.class, args);

		Scheduler sc;
		try {
			sc = StdSchedulerFactory.getDefaultScheduler();

			JobKey jobKey = JobKey.jobKey("job");
			JobDetail job = JobBuilder.newJob(JobFunction.class).withIdentity(jobKey).build();

			TriggerKey triggerKey = TriggerKey.triggerKey("trigger");
			if (sc.getTriggerState(triggerKey) == TriggerState.ERROR) {
				sc.resumeTrigger(triggerKey);
			}

			SimpleTrigger trigger = TriggerBuilder.newTrigger().forJob(job).withIdentity(triggerKey)
					.withDescription("Sample trigger")
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(2))
					.build();

			sc.scheduleJob(job, trigger);

			sc.start();

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
