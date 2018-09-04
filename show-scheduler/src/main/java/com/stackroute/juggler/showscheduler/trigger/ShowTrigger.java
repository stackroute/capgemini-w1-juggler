package com.stackroute.juggler.showscheduler.trigger;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;
import static org.quartz.DateBuilder.futureDate;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import com.stackroute.juggler.kafka.domain.MovieScheduler;
import com.stackroute.juggler.kafka.domain.MovieScheduling;
import com.stackroute.juggler.kafka.domain.Show;
import com.stackroute.juggler.showscheduler.showjob.ShowJobFunction;

@Service
public class ShowTrigger {

	Map<String, Show> shows;

	public ShowTrigger() {
		shows = new HashMap<String, Show>();
	}

	public void trigger(MovieScheduler ieschedule) throws SchedulerException {
		List<Show> showList = movieScheduleId.getShows();

		Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
		for (Show show : showList) {
			System.out.println("shows" + show);

			// creating a jobkey value for each show and assinging the job to be performed
			JobKey jobKey = JobKey.jobKey("job1" + (show.getShowId()));
			JobDetail job1 = JobBuilder.newJob(ShowJobFunction.class).withIdentity(jobKey).build();

			// calculating current time in milliseconds
			long currentTimeInms = System.currentTimeMillis();

			// Taking showTime, showDate and calculating showTime in milliseconds
			LocalTime showTime = show.getShowTime();
			LocalDate showDate = show.getShowDate();
			LocalDateTime showDateTime = LocalDateTime.of(showDate, showTime);
			long showTimeInMilliSeconds = Timestamp.valueOf(showDateTime).getTime();

			/*
			 * taking the difference between current time and show time in milliseconds to
			 * calculate delay time. so that we can start the trigger after the delay time.
			 */
			long secondsDiff = (showTimeInMilliSeconds - currentTimeInms) / 1000;
			
			// TriggerKey triggerKey = TriggerKey.triggerKey("trigger" + show.getShowId());
			TriggerKey triggerKey = TriggerKey.triggerKey("trigger" + (show.getShowId()));
			SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
					.startAt(futureDate((int) secondsDiff, IntervalUnit.SECOND)).forJob(job1)
					.withSchedule(simpleSchedule()).build();
			shows.put(show.getShowId(), show);
			/*
			 * passing all the shows in the job class and scheduling the job
			 */

			sc.getContext().put("show", shows);
			sc.scheduleJob(job1, trigger);
		}
		sc.start();
	}

}
