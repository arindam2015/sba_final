package com.stackroute.giphermanager.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.giphermanager.config.GipherMessageProducer;
import com.stackroute.giphermanager.exception.GipherAlreadyExistException;
import com.stackroute.giphermanager.exception.GipherNotAddedException;
import com.stackroute.giphermanager.exception.GipherNotFoundException;
import com.stackroute.giphermanager.model.Favourite;
import com.stackroute.giphermanager.repository.GipherRepository;
import com.stackroute.giphermanager.service.GipherManagerService;
import com.stackroute.giphermanager.service.GipherManagerServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class GipherManagerServiceTest {
	@Mock
	GipherRepository gipherRepository;
	Favourite favourite;
	@InjectMocks
	GipherManagerServiceImpl gipherManagerService;
	@InjectMocks
	private GipherMessageProducer gipherMessageProducer;
	List<Favourite> bookmarkList;
    Optional<Favourite> options;
    @Before
    public void setUp()
    {
    	MockitoAnnotations.initMocks(this);
        favourite=new Favourite();
        favourite.set_id(new ObjectId("5daef95eb8ad3d49d04315e3"));
        favourite.setGipherId("xT9IgG50Fb7Mi0prBC");
        favourite.setGipherTitle("tom hanks hello GIF");
        favourite.setGipherUrl("https://media3.giphy.com/media/xT9IgG50Fb7Mi0prBC/giphy.gif?cid=f24fda11083ff7fcaca703a38ab4564714b77889fba9af29&rid=giphy.gif");
        favourite.setAddedBy("arindam");
        favourite.setCreatedDate(new Date());
        bookmarkList=new ArrayList<Favourite>();
        options = Optional.of(favourite);
    }
  /*  
    @Test
    public void createBookmarkSuccess() throws GipherNotAddedException, GipherAlreadyExistException
    {
        when(gipherRepository.insert((Favourite) any())).thenReturn(favourite);
        Favourite bookmarkSaved = gipherManagerService.addToFavouriteGipher(favourite);
        Assert.assertEquals(favourite, bookmarkSaved);

    }
    @Test(expected = GipherNotAddedException.class)
    public void createBookmarkFailure() throws GipherNotAddedException, GipherAlreadyExistException
    {
        when(gipherRepository.insert((Favourite) any())).thenReturn(null);
        Favourite favouriteSaved = gipherManagerService.addToFavouriteGipher(favourite);
        Assert.assertEquals(favourite, favouriteSaved);
    }*/
    @Test
    public void getAllBookmarkByUserId() throws GipherNotFoundException
    {
        when(gipherRepository.findAllBookmarkByAddedBy(favourite.getAddedBy())).thenReturn(bookmarkList);
        List<Favourite> fetchedFavourite = gipherManagerService.getAllBookmarkGipherById(favourite.getAddedBy());
        Assert.assertEquals(bookmarkList,fetchedFavourite );

    }

}
