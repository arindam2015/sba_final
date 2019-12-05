package com.stackroute.giphermanager.controller.test;


import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.giphermanager.controller.GipherController;
import com.stackroute.giphermanager.exception.GipherNotAddedException;
import com.stackroute.giphermanager.exception.GipherNotFoundException;
import com.stackroute.giphermanager.model.Favourite;
import com.stackroute.giphermanager.service.GipherManagerService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class GipherControllerTest {
	 @Autowired
	    private MockMvc mockMvc;
	    private Favourite favourite;
	 @InjectMocks
	 private GipherController gipherController;
	 @MockBean
	 private GipherManagerService gipherManagerService;
	 private List<Favourite> bookmarkList;
	 
	 @Before
	 public void setUp() {
		 MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(gipherController).build();
	        favourite=new Favourite();
	        favourite.set_id(new ObjectId("5daef95eb8ad3d49d04315e3"));
	        favourite.setGipherId("xT9IgG50Fb7Mi0prBC");
	        favourite.setGipherTitle("tom hanks hello GIF");
	        favourite.setGipherUrl("https://media3.giphy.com/media/xT9IgG50Fb7Mi0prBC/giphy.gif?cid=f24fda11083ff7fcaca703a38ab4564714b77889fba9af29&rid=giphy.gif");
	        favourite.setAddedBy("arindam");
	        favourite.setCreatedDate(new Date());
	        bookmarkList=new ArrayList<Favourite>();
	        bookmarkList.add(favourite);
	        
		 
	 }

	/* @Test
	 public void addBookmarkSuccess() throws Exception{
		 when(gipherManagerService.addToFavouriteGipher(any())).thenReturn(favourite);
	        mockMvc.perform(MockMvcRequestBuilders.post("/gify/v1/addFavourite").contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(favourite)))
	                .andExpect(MockMvcResultMatchers.status().isCreated())
	                .andDo(MockMvcResultHandlers.print());
		 
	 }*/
	 
	 @Test
	    public void addBookmarkFailure() throws Exception {
	        when(gipherManagerService.addToFavouriteGipher(any())).thenThrow(GipherNotAddedException.class);
	        mockMvc.perform(MockMvcRequestBuilders.post("/gify/v1/addFavourite").contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(favourite)))
	                .andExpect(MockMvcResultMatchers.status().isConflict())
	                .andDo(MockMvcResultHandlers.print());

	    }
	 
	 @Test
	 public void getAllBookmarkListSuccess() throws Exception{
		 when(gipherManagerService.getAllBookmarkGipherById(favourite.getAddedBy())).thenReturn(bookmarkList);
	        mockMvc.perform(MockMvcRequestBuilders.get("/gify/v1/allBookmarkGipher/arindam").contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(bookmarkList))).andExpect(MockMvcResultMatchers.status().isOk())
	                .andDo(MockMvcResultHandlers.print());
		 
	 }
	 
	/* @Test
	    public void getAllBookmarkListFailure() throws Exception
	    {
	        when(gipherManagerService.getAllBookmarkGipherById(favourite.getAddedBy())).thenThrow(GipherNotFounfException.class);
	        mockMvc.perform(MockMvcRequestBuilders.get("/gify/v1/allBookmarkGipher/arindam").
	                contentType(MediaType.APPLICATION_JSON).content(asJsonString(bookmarkList)))
	                .andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());

	    }*/
	 
	 private static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
