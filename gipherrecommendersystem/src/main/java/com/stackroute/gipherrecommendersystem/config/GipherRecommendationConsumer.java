package com.stackroute.gipherrecommendersystem.config;

import org.springframework.stereotype.Component;

import com.stackroute.gipherrecommendersystem.controller.GipherRecommendedController;
import com.stackroute.gipherrecommendersystem.model.GipherRecommendation;
import com.stackroute.gipherrecommendersystem.model.RecommendedGipher;
import com.stackroute.gipherrecommendersystem.service.GipherRecommendationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class GipherRecommendationConsumer {
	private static final Logger logger = LoggerFactory.getLogger(GipherRecommendationConsumer.class.getName());
	@Autowired
	private GipherRecommendationService gipherRecommendationService;
	
	
	
	public GipherRecommendationConsumer( GipherRecommendationService gipherRecommendationService) {
		super();
		// TODO Auto-generated constructor stub
		this.gipherRecommendationService=gipherRecommendationService;
		
	}

	
	@RabbitListener(queues = "bookmarkRetrival")
	public void consumeFavouriteGipher(GipherRecommendation gipherRecommendation) throws Exception {
		logger.info("inside consumer code "+gipherRecommendation);
		gipherRecommendationService.createRecommandation(gipherRecommendation);
	}

	
	@RabbitListener(queues = "bookmarkDeletion")
	public void consumeDeletedFavouriteMusic(GipherRecommendation recommendedGipher) throws Exception {
		logger.info("inside delete consumer::"+recommendedGipher);
		this.gipherRecommendationService.deleteRecommandedGipher(recommendedGipher);
	}

}
