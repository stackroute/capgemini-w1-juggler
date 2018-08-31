package com.stackroute.juggler.showscheduler.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ShowStream {

	String INPUT = "Show-Started for the movie";
	String OUTPUT = "Show-ended for the movie";

	// method for defining the inbound stream to read from kafka
	@Input(INPUT)
	SubscribableChannel inboundShowStream();

	// method for defining the outbound stream to write to kafka
	@Output(OUTPUT)
	MessageChannel outboundShowStream();

}
