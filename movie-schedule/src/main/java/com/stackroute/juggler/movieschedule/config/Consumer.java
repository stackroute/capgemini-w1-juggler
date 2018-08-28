package com.stackroute.juggler.movieschedule.config;

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

import com.stackroute.juggler.kafka.domain.Registration;

@EnableKafka
@Configuration
public class Consumer {

	public class KafkaConsumerconfiguration {

		@Bean
		public ConsumerFactory<String, Registration> consumerFactory() {
			Map<String, Object> config = new HashMap<>();

			config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.238.190:9092");
			config.put(ConsumerConfig.GROUP_ID_CONFIG, "user");
			config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
			config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

			return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
					new JsonDeserializer<>(Registration.class));
		}

		@Bean
		public ConcurrentKafkaListenerContainerFactory<String, Registration> kafkaListenerContainerFactory() {
			ConcurrentKafkaListenerContainerFactory<String, Registration> factory = new ConcurrentKafkaListenerContainerFactory();
			factory.setConsumerFactory(consumerFactory());
			return factory;
		}

	}
}