package com.stackroute.gipherrecommendersystem.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.gipherrecommendersystem.model.GipherRecommendation;
import com.stackroute.gipherrecommendersystem.model.RecommendedGipher;
import com.stackroute.gipherrecommendersystem.repository.GipherRecommendationRepository;
@Service
public class GipherRecommendationServiceImpl implements GipherRecommendationService {
	private static final Logger logger = LoggerFactory.getLogger(GipherRecommendationServiceImpl.class.getName());
	@Autowired
	GipherRecommendationRepository gipherRecommendationRepository;
	
	public GipherRecommendationServiceImpl(GipherRecommendationRepository gipherRecommendationRepository) {
		this.gipherRecommendationRepository = gipherRecommendationRepository;
	}

	@Override
	public List<RecommendedGipher> getRecommendationWithCount() {
		// TODO Auto-generated method stub
		List<RecommendedGipher> gipherCount=new ArrayList<RecommendedGipher>();
		List<RecommendedGipher> list= this.gipherRecommendationRepository.findAll();
		for(RecommendedGipher gipher:list) {
			if(gipher.getCount()>1) {
				gipherCount.add(gipher);
			}
		}
		return gipherCount;
	}

	@Override
	public boolean createRecommandation(GipherRecommendation gipherRecommendation) throws Exception{
		// TODO Auto-generated method stub
		
		int count=1;
		logger.info("under service::"+gipherRecommendation);
		//GipherRecommendation gipherRecommendation=new ObjectMapper().readValue(message, GipherRecommendation.class);
		 RecommendedGipher gipher=new RecommendedGipher();
		 RecommendedGipher insertGipher=null;
			logger.info("------------------------");
			logger.info("id::"+gipherRecommendation.getGipherId());
			logger.info("url::"+gipherRecommendation.getGipherUrl());
			logger.info("title:"+gipherRecommendation.getGipherTitle());
			logger.info("addedBy::"+gipherRecommendation.getAddedBy());
			gipher.setGipherId(gipherRecommendation.getGipherId());
			gipher.setGipherURL(gipherRecommendation.getGipherUrl());
			gipher.setGipherTitle(gipherRecommendation.getGipherTitle());
			Optional<RecommendedGipher> gipherIsExist=this.gipherRecommendationRepository.findById(gipher.getGipherId());
			if(gipherIsExist.isPresent())
			{
				logger.info("update  "+gipherIsExist.get().getCount());
				 count=gipherIsExist.get().getCount()+1;
				logger.info("update count::"+count);
				gipher.setCount(count);
				this.gipherRecommendationRepository.save(gipher);
				
			}else {
				logger.info("insert");
				gipher.setCount(count);
				insertGipher=this.gipherRecommendationRepository.insert(gipher);
			}
		    if(insertGipher!=null) {
		    	//this.getRecommendationWithCount();
		    	return true;
		    }else {
		    	return false;
		    }
			
	}

	@Override
	public boolean deleteRecommandedGipher(GipherRecommendation gipherRecommendation ) throws Exception {
		// TODO Auto-generated method stub
		logger.info("inside delete service::"+gipherRecommendation);
		int count=0;
		RecommendedGipher updateGipher=null;
		boolean isDeleted=true;
		//GipherRecommendation gipherRecommendation=new ObjectMapper().readValue(message, GipherRecommendation.class);
		 RecommendedGipher gipher=new RecommendedGipher();
		 gipher.setGipherId(gipherRecommendation.getGipherId());
		 gipher.setGipherURL(gipherRecommendation.getGipherUrl());
		 gipher.setGipherTitle(gipherRecommendation.getGipherTitle());
		 Optional<RecommendedGipher> gipherIsExist=this.gipherRecommendationRepository.findById(gipher.getGipherId());
		 if(gipherIsExist.isPresent())
			{
			 logger.info("update  "+gipherIsExist.get().getCount());
			//update
			 if(gipherIsExist.get().getCount()>1) {
				count=gipherIsExist.get().getCount()-1;
				System.out.println("update count::"+count);
				gipher.setCount(count);
				updateGipher=this.gipherRecommendationRepository.save(gipher);
			}
			 //delete
			 else {
				 logger.info("delete gipher::");
				 this.gipherRecommendationRepository.deleteByGipherId(gipherIsExist.get().getGipherId());
			     isDeleted=true;
			 }
			}
		if(updateGipher!=null || isDeleted==true) {
			return true;
		}else {
			return false;
		}
	}

	

}
