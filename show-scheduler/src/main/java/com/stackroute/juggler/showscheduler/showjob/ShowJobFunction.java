package com.stackroute.juggler.showscheduler.showjob;

import java.util.HashMap;

//import java.util.HashMap;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.Show;
import com.stackroute.juggler.showscheduler.stream.ShowStream;

import lombok.extern.slf4j.Slf4j;

@Service
public class ShowJobFunction implements Job {

	static MessageChannel messagestatus;
	static ShowStream showstream;

	public ShowJobFunction() {
		super();
	}

	public ShowJobFunction(ShowStream showstream) {
		if (ShowJobFunction.showstream == null) {
			ShowJobFunction.showstream = showstream;
		}
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		SchedulerContext schedulercontext;
		try {
			schedulercontext = context.getScheduler().getContext();
			HashMap<String, Show> show = (HashMap<String, Show>) schedulercontext.get("show");

			// String []trigger= context.getTrigger().toString().split(":");
			for (String str : trigger) {
				System.out.println(str);
			}

		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println("hello");
		
		
		
	}

}
