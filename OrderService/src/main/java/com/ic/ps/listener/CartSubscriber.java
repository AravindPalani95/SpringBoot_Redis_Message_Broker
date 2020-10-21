package com.ic.ps.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class CartSubscriber implements MessageListener{
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onMessage(Message message, byte[] pattern) {
		LOG.info("Message from Cart Service -> {}",message.toString());
		LOG.info("Message Pattern -> {}",new String(pattern));
	}

	
}
