package com.ic.ps.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.ic.ps.modal.Cart;

@Configuration
public class RedisMQConfig {
	
	@Value("${spring.redis.mq.channel.cart}")
	private String cartChannelName;

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	public ChannelTopic cartTopic() {
		return new ChannelTopic(cartChannelName);
	}
	
	@Bean
	public RedisTemplate<String,Cart> redisTemplate(){
		final RedisTemplate<String,Cart> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Cart.class));
		return redisTemplate;
	}
	
}
