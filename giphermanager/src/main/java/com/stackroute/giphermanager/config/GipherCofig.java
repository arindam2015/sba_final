package com.stackroute.giphermanager.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GipherCofig {
	
private String exchangeName="favourite_exchange_gipher";
private String favouriteGipherQueue="bookmarkRetrival";	
private String deletedFavouriteGipherQueue="bookmarkDeletion";
	
@Bean
public Binding bindingQueues(Queue favouriteGipher, DirectExchange directExchange) {
	return BindingBuilder.bind(favouriteGipher).to(directExchange).with("favourite_gipher_routing_key");
}

@Bean
public Binding bindingDeletedQueues(Queue deletedFavouriteGipher, DirectExchange directExchange) {
	return BindingBuilder.bind(deletedFavouriteGipher).to(directExchange).with("delete_favourite_gipher_routing_key");
}

@Bean
public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
	return new Jackson2JsonMessageConverter();
}

@Bean
public DirectExchange directExchange() {
	return new DirectExchange(exchangeName);
}

@Bean
public Queue favouriteGipher() {
	return new Queue(favouriteGipherQueue,true);
}

@Bean
public Queue deletedFavouriteGipher() {
	return new Queue(deletedFavouriteGipherQueue,true);
}

@Bean
public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
	RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
	return rabbitTemplate;
}
@Bean
ConnectionFactory connectionFactory() {
    return new CachingConnectionFactory();
}



}
