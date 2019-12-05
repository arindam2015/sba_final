package com.stackroute.gipherrecommendersystem.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.gipherrecommendersystem.model.RecommendedGipher;
import com.stackroute.gipherrecommendersystem.service.GipherRecommendationService;


@RestController
@CrossOrigin
@RequestMapping("/gify/v1")
public class GipherRecommendedController {
	private static final Logger logger = LoggerFactory.getLogger(GipherRecommendedController.class.getName());
	@Autowired
	GipherRecommendationService gipherRecommendationService;
	
	
	public GipherRecommendedController(GipherRecommendationService gipherRecommendationService) {
		System.out.println("reminder construtor");
		this.gipherRecommendationService = gipherRecommendationService;
	}
	
	@GetMapping("/reminderListCount")
	public List<RecommendedGipher> getReminderGifsWithCount(){
		logger.info("inside count reminder:"+this.gipherRecommendationService.getRecommendationWithCount().size());
		return this.gipherRecommendationService.getRecommendationWithCount();
		
	}
	
	

}
