package com.stackroute.juggler.showscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.stackroute.juggler.kafka.domain.MovieScheduler;
import com.stackroute.juggler.showscheduler.stream.ShowStream;
import com.stackroute.juggler.showscheduler.trigger.ShowTrigger;


@EnableBinding(ShowStream.class)
public class ShowListener {
	
		private ShowTrigger showTrigger;
		
	@Autowired
	public ShowListener(ShowTrigger showTrigger) {
		super();
		this.showTrigger = showTrigger;
	}

	@StreamListener(ShowStream.INPUT)
	public void (@Payload MovieScheduler movieScheduleId) {

		try {
			showTrigger.trigger(movieScheduleId);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
	
	
