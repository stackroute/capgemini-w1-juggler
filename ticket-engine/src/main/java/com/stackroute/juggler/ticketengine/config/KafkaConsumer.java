package com.stackroute.juggler.ticketengine.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.TicketDetails;

@EnableKafka
@Configuration
public class KafkaConsumer {

	@Bean
	public ConsumerFactory<String, MovieSchedule> consumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.43.174:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "ticket");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(MovieSchedule.class));
	}
	
	public ConsumerFactory<String, TicketDetails> payConsumerFactory() {
		Map<String, Object> payConfig = new HashMap<>();
		payConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.43.174:9092");
		payConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "pay");
		payConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		payConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(payConfig, new StringDeserializer(),
				new JsonDeserializer<>(TicketDetails.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MovieSchedule> kafkaListenerContainerFactory() {
		
		ConcurrentKafkaListenerContainerFactory<String, MovieSchedule> factory1 = new ConcurrentKafkaListenerContainerFactory<>();
		factory1.setConsumerFactory(consumerFactory());
		return factory1;
		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TicketDetails> payKafkaListenerContainerFactory() {
		
		ConcurrentKafkaListenerContainerFactory<String, TicketDetails> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(payConsumerFactory());
		return factory;
		
	}
	
}
