package com.stackroute.juggler.showsheduler.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.showsheduler.configuration.KafkaProducer;
import com.stackroute.juggler.showsheduler.domain.TriggerMessage;

@Service
public class JobFunction implements Job {

	public static String NAME;
	public static String SLOT;

	private static KafkaTemplate<String, TriggerMessage> objectKafkaTemplate;
	private static KafkaTemplate<String, String> kafkaTemplate;

	public JobFunction() {
	}

	@Autowired
	public JobFunction(KafkaTemplate<String, String> kafkaTemplate,
			KafkaTemplate<String, TriggerMessage> objectKafkaTemplate) {
		if (JobFunction.kafkaTemplate == null) {
			JobFunction.kafkaTemplate = kafkaTemplate;
		}
		if (JobFunction.objectKafkaTemplate == null) {
			JobFunction.objectKafkaTemplate = objectKafkaTemplate;
		}
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		System.out.println("000000000000000000000");
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		String name = dataMap.getString("theatreName");
//		System.out.println("1111111" + name);
		String slot = dataMap.getString("slot");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String dateString = dateFormat.format(date);
		System.out.println(dateString);
		TriggerMessage message = new TriggerMessage(name,dateString,slot);
//		System.out.println("message is " + message);
		String messageStr = message.toString();
		String topic = KafkaProducer.TOPIC;
		// objectKafkaTemplate.send(topic, message);
//		 kafkaTemplate.send(topic, messageStr);
		objectKafkaTemplate.send(topic, message);
	}
}
