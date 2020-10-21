package com.ic.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.ic.ps.modal.Cart;

@Service
public class CartService {

	@Autowired
	private RedisTemplate<String, Cart> redisTemplate;
	
	@Autowired
	private ChannelTopic cartTopic;
	
	public void publishCart(Cart cart) {
		redisTemplate.convertAndSend(cartTopic.getTopic(), cart);
	}
	
}
