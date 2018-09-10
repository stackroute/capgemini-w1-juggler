package com.stackroute.juggler.movieschedule.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.stackroute.juggler.kafka.domain.MovieSchedule;

@Configuration
public class KafkaProducerConfig {

	// Declaring Topic
	static final String TOPIC = "screening-details";
	static final String TOPIC1 = "screenings";

	// KafkaProducerConfig factory of kafka which will hold the configuration details
	@Bean
	public ProducerFactory<String, MovieSchedule> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(config);
	}

	// Template imports the configuration from producerfactory
	@Bean
	public KafkaTemplate<String, MovieSchedule> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	// To Send Topic 
	public static String getTopic() {
		return TOPIC;
	}
	
	// To Send Topic1
	public static String getTopic1() {
		return TOPIC1;
	}

}
