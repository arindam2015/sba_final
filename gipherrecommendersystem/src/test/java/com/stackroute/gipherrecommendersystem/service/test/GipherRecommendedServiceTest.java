package com.stackroute.gipherrecommendersystem.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.gipherrecommendersystem.model.RecommendedGipher;
import com.stackroute.gipherrecommendersystem.repository.GipherRecommendationRepository;
import com.stackroute.gipherrecommendersystem.service.GipherRecommendationServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class GipherRecommendedServiceTest {
	@Mock
	GipherRecommendationRepository gipherRecommendationRepository;
	RecommendedGipher recommendedGipher;
	@InjectMocks
	GipherRecommendationServiceImpl gipherRecommendedService;
	List<RecommendedGipher> recommendedList;
	Optional<RecommendedGipher> options;
	 @Before
	    public void setUp()
	    {
		 MockitoAnnotations.initMocks(this);
		 recommendedGipher=new RecommendedGipher();
		 recommendedGipher.setGipherId("xT9IgG50Fb7Mi0prBC");
			recommendedGipher.setGipherTitle("tom hanks hello GIF");
			recommendedGipher.setGipherURL("https://media3.giphy.com/media/xT9IgG50Fb7Mi0prBC/giphy.gif?cid=f24fda11083ff7fcaca703a38ab4564714b77889fba9af29&rid=giphy.gif");
			recommendedGipher.setCount(4);
			recommendedList = new ArrayList<>();
			recommendedList.add(recommendedGipher);

	        options = Optional.of(recommendedGipher);
	    }
	 @Test
	    public void getAllReminders()
	    {
	        when(gipherRecommendationRepository.findAll()).thenReturn(recommendedList);
	        List<RecommendedGipher> recommendedListdata = gipherRecommendedService.getRecommendationWithCount();
	        Assert.assertEquals(recommendedList, recommendedListdata);

	    }

}
