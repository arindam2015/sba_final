package com.stackroute.giphermanager.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.stackroute.giphermanager.controller.GipherController;
import com.stackroute.giphermanager.model.Favourite;
@Component
public class GipherMessageProducer {
	private static final Logger logger = LoggerFactory.getLogger(GipherController.class.getName());	
private RabbitTemplate rabbitTemplate;
	
	private DirectExchange exchange;
	
	public GipherMessageProducer(RabbitTemplate rabbitTemplate, DirectExchange exchange) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.exchange = exchange;
	}
	
	//@Scheduled(fixedDelay = 3000L)
	public void sendAddGipher(Favourite favourite) {
		rabbitTemplate.convertAndSend(exchange.getName(), "favourite_gipher_routing_key", favourite);
	}
	
	//@Scheduled(fixedDelay = 5000L)
		public void sendDeletedFavourites(Favourite favourite) {
			rabbitTemplate.convertAndSend(exchange.getName(), "delete_favourite_gipher_routing_key", favourite);
		}

}
