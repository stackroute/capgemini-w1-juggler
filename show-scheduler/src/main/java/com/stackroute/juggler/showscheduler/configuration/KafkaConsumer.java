//package com.stackroute.juggler.showscheduler.configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import com.stackroute.juggler.kafka.domain.MovieScheduling;
//
////Kafka Consumer for MovieSchedule Details
//
//@EnableKafka
//@Configuration
//public class KafkaConsumer {
//
//	public class KafkaConsumerconfiguration {
//
//		@Bean
//		public ConsumerFactory<String, MovieSchedule> consumerFactory() {
//			Map<String, Object> config = new HashMap<>();
//
//			config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.238.190:9092");
//			config.put(ConsumerConfig.GROUP_ID_CONFIG, "show");
//			config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//			config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//
//			return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
//					new JsonDeserializer<>(MovieSchedule.class));
//		}
//
//		@Bean
//		public ConcurrentKafkaListenerContainerFactory<String, MovieSchedule> kafkaListenerContainerFactory() {
//			ConcurrentKafkaListenerContainerFactory<String, MovieSchedule> factory = new ConcurrentKafkaListenerContainerFactory();
//			factory.setConsumerFactory(consumerFactory());
//			return factory;
//		}
//
//	}
//}