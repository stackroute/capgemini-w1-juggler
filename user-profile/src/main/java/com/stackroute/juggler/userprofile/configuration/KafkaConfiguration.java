package com.stackroute.juggler.userprofile.configuration;

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
import com.stackroute.juggler.kafka.domain.InputUser;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class KafkaConfiguration {

	// Setting topic name
	static final String TOPIC = "details8";

	// Producer factory of kafka which will hold the configuration details
	@Bean
	public ProducerFactory<String, InputUser> producerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.238.190:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(config);
	}

	// Template imports the configuration from producerfactory
	@Bean
	public KafkaTemplate<String, InputUser> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	// To get Topic
	public String getTopic() {
		return TOPIC;
	}



}
