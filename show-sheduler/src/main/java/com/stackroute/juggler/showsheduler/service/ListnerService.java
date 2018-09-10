package com.stackroute.juggler.showsheduler.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.stackroute.juggler.kafka.domain.MovieSchedule;

@Service
public class ListnerService {

	@KafkaListener(topics = "screeningdetails", groupId = "scheduler", containerFactory = "kafkaListenerContainerFactory")
	public void consumeKafka (MovieSchedule scheduledMovie) {
		
		System.out.println(scheduledMovie.getActors());
		
	}
}
