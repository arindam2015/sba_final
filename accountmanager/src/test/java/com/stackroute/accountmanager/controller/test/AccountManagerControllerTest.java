package com.stackroute.accountmanager.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.accountmanager.controller.AccountManagerController;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.AccountManagerModel;
import com.stackroute.accountmanager.service.AccountManagerService;

import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountManagerControllerTest {

	  @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private AccountManagerService accountManagerService;

	    private AccountManagerModel accountManagerModel;

	    @InjectMocks
	    private AccountManagerController accountManagerController;


	    @Before
	    public void setUp() throws Exception {

	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(accountManagerController).build();

	        accountManagerModel = new AccountManagerModel();
	        accountManagerModel.setUserId("Jhon123");
	        accountManagerModel.setFirstName("Jhon");
	        accountManagerModel.setLastName("Smith");
	        accountManagerModel.setUserPassword("123456");
	        accountManagerModel.setUserRole("Admin");
	        accountManagerModel.setUserAddedDate(new Date());


	    }

	    @Test
	    public void testRegisterUser() throws Exception {

	        Mockito.when(accountManagerService.saveUser(accountManagerModel)).thenReturn(true);
	        mockMvc.perform(MockMvcRequestBuilders.post("/gifs/register").contentType(MediaType.APPLICATION_JSON).content(jsonToString(accountManagerModel)))
	                .andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());

	    }


	    @Test
	    public void testLoginUser() throws Exception {


	        String userId = "Jhon123";
	        String password = "123456";


	        Mockito.when(accountManagerService.saveUser(accountManagerModel)).thenReturn(true);
	        Mockito.when(accountManagerService.findByUserIdAndPassword(userId, password)).thenReturn(accountManagerModel);
	        mockMvc.perform(MockMvcRequestBuilders.post("/gifs/login").contentType(MediaType.APPLICATION_JSON).content(jsonToString(accountManagerModel)))
	                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	    }

	    // Parsing String format data into JSON format
	    private static String jsonToString(final Object obj) throws JsonProcessingException {
	        String result;
	        try {
	            final ObjectMapper mapper = new ObjectMapper();
	            final String jsonContent = mapper.writeValueAsString(obj);
	            result = jsonContent;
	        } catch (JsonProcessingException e) {
	            result = "Json processing error";
	        }
	        return result;
	    }
	}
