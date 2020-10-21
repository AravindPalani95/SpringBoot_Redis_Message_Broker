package com.ic.ps.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.ic.ps.listener.CartSubscriber;

@Configuration
public class RedisMQConfiguration {
	
	@Autowired
	private CartSubscriber cartSubscriber;

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
	public MessageListenerAdapter cartMessageListener() {
		return new MessageListenerAdapter(cartSubscriber);
	}
	
	@Bean
	public RedisMessageListenerContainer redisContainer() {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(jedisConnectionFactory());
		container.addMessageListener(cartMessageListener(), cartTopic());
		return container;
	}
	
}
