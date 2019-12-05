package com.stackroute.gipherrecommendersystem.controller.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.FaviconConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.gipherrecommendersystem.controller.GipherRecommendedController;
import com.stackroute.gipherrecommendersystem.model.RecommendedGipher;
import com.stackroute.gipherrecommendersystem.service.GipherRecommendationService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class GipherRecommendedControllerTest {
	@Autowired
    private MockMvc mockMvc;
	private RecommendedGipher recommendedGipher;
	@MockBean
	private GipherRecommendationService gipherRecommendationService;
	@InjectMocks
	private GipherRecommendedController gipherRecommendedController;
	private List<RecommendedGipher> recommendedGiphersList;
	@Before
    public void setUp()
    {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(gipherRecommendedController).build();
		recommendedGipher=new RecommendedGipher();
		recommendedGipher.setGipherId("xT9IgG50Fb7Mi0prBC");
		recommendedGipher.setGipherTitle("tom hanks hello GIF");
		recommendedGipher.setGipherURL("https://media3.giphy.com/media/xT9IgG50Fb7Mi0prBC/giphy.gif?cid=f24fda11083ff7fcaca703a38ab4564714b77889fba9af29&rid=giphy.gif");
		recommendedGipher.setCount(4);
		recommendedGiphersList=new ArrayList<RecommendedGipher>();
		recommendedGiphersList.add(recommendedGipher);
		
    }
	@Test
	public void getReminderGifsWithCount() throws Exception {
		 when(gipherRecommendationService.getRecommendationWithCount()).thenReturn(recommendedGiphersList);
	        mockMvc.perform(MockMvcRequestBuilders.get("/gify/v1/reminderListCount").contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(recommendedGiphersList))).andExpect(MockMvcResultMatchers.status().isOk())
	                .andDo(MockMvcResultHandlers.print());
	}
	
	 private static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	

}
