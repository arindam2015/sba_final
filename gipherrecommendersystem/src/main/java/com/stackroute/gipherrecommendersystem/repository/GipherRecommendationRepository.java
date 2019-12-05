package com.stackroute.gipherrecommendersystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.gipherrecommendersystem.model.GipherRecommendation;
import com.stackroute.gipherrecommendersystem.model.RecommendedGipher;

public interface GipherRecommendationRepository extends MongoRepository<RecommendedGipher, String> {
	Integer countByGipherId(String gipherId);
	void deleteByGipherId(String gipherId);
}
