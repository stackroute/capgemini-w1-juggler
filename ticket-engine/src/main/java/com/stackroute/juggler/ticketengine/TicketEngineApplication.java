package com.stackroute.juggler.ticketengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

<<<<<<< HEAD
//import com.stackroute.juggler.ticketengine.domain.Show;

=======
>>>>>>> 604ef2adb4e74ada5ad6f37b8572b2913af69664
@SpringBootApplication
@EnableRedisRepositories
public class TicketEngineApplication {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return redisTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TicketEngineApplication.class, args);
	}

}
