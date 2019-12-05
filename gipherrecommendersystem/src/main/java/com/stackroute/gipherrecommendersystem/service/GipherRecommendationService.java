package com.stackroute.gipherrecommendersystem.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.stackroute.gipherrecommendersystem.model.GipherRecommendation;
import com.stackroute.gipherrecommendersystem.model.RecommendedGipher;

public interface GipherRecommendationService {
	List<RecommendedGipher> getRecommendationWithCount();
	boolean createRecommandation(GipherRecommendation gipherRecommendation) throws Exception;
    boolean deleteRecommandedGipher(GipherRecommendation gipherRecommendation) throws Exception;
}
