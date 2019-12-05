package com.stackroute.accountmanager.repository.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.accountmanager.model.AccountManagerModel;
import com.stackroute.accountmanager.repository.AccountManagerRepository;

import javax.persistence.Query;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountManagerRepositoryTest {
	
	 @Autowired
	    private AccountManagerRepository accountManagerRepository;

	    private AccountManagerModel accountManagerModel;


	    @Before
	    public void setUp() throws Exception {
	    	accountManagerModel = new AccountManagerModel();
	    	accountManagerModel.setUserId("Jhon123");
	    	accountManagerModel.setFirstName("Jhon123");
	    	accountManagerModel.setLastName("Smith");
	    	accountManagerModel.setUserRole("Admin");
	    	accountManagerModel.setUserPassword("123456");
	    	accountManagerModel.setUserAddedDate(new Date());
	    }

	    @After
	    public void tearDown() throws Exception {
	    	accountManagerRepository.deleteAll();
	    }

	    @Test
	    public void testRegisterUserSuccess() {
	    	accountManagerRepository.save(accountManagerModel);
	    	AccountManagerModel object = accountManagerRepository.findById(accountManagerModel.getUserId()).get();
	        Assert.assertEquals(accountManagerModel.getUserId(), object.getUserId());
	    }

	    @Test
	    public void testLoginUserSuccess() {
	    	accountManagerRepository.save(accountManagerModel);
	    	AccountManagerModel object = accountManagerRepository.findById(accountManagerModel.getUserId()).get();
	        Assert.assertEquals(accountManagerModel.getUserId(), object.getUserId());
	    }
	    
}
	



