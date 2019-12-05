/*package com.stackroute.giphermanager.repository;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.stackroute.giphermanager.model.Favourite;
import com.stackroute.giphermanager.repository.GipherRepository;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@RunWith(SpringRunner.class)
@DataMongoTest

public class GipherRepositoryTest {
	@Autowired
	private GipherRepository gipherRepository;
	private Favourite favourite;
	@Before
	public void setUp() throws Exception {
		favourite=new Favourite();
		favourite.set_id(new ObjectId("5daef95eb8ad3d49d04315e3"));
        favourite.setGipherId("xT9IgG50Fb7Mi0prBC");
        favourite.setGipherTitle("tom hanks hello GIF");
        favourite.setGipherUrl("https://media3.giphy.com/media/xT9IgG50Fb7Mi0prBC/giphy.gif?cid=f24fda11083ff7fcaca703a38ab4564714b77889fba9af29&rid=giphy.gif");
        favourite.setAddedBy("arindam");
        favourite.setCreatedDate(new Date());
	}
	
	@After
	public void tearDown() throws Exception {
            gipherRepository.deleteAll();
	}
	@Test
	public void addToBookmarkTest() {
		gipherRepository.insert(favourite);
		//Favourite favourite1 = gipherRepository.findAllById(favourite.get_id()).get();
       // gipherRepository.delete(favourite1);
       // favourite1 = gipherRepository.findById(favourite.getGipherId()).get();
	}
	 @Test
	    public void getBookmarkByUserId() {
		 Favourite favourite1=gipherRepository.insert(favourite);
	        //Favourite favourite1 = gipherRepository.findById(favourite.getGipherId()).get();
	        Assert.assertEquals("tom hanks hello GIF", favourite1.getGipherTitle());


	    }

}*/
