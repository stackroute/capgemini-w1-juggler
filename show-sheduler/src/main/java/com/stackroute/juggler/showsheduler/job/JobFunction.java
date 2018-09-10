package com.stackroute.juggler.showsheduler.job;

import java.time.LocalDateTime;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.juggler.showsheduler.configuration.KafkaProducer;

//@Service
public class JobFunction implements Job {
	@Autowired
	private KafkaProducer kafkaProducer;
	// public JobFunction(KafkaProducer kafkaProducer) {
	// this.kafkaProducer = kafkaProducer;
	// }
	// String topic = KafkaProducer.getTopic();

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		String topic = KafkaProducer.getTopic();
		System.out.println("Hello" + LocalDateTime.now());

	}

}
