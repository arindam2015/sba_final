package com.stackroute.giphermanager.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.giphermanager.config.GipherMessageProducer;
import com.stackroute.giphermanager.exception.GipherAlreadyExistException;
import com.stackroute.giphermanager.exception.GipherNotAddedException;
import com.stackroute.giphermanager.exception.GipherNotFoundException;
import com.stackroute.giphermanager.model.Favourite;
import com.stackroute.giphermanager.rabbitmq.GipherBookmarkSource;
import com.stackroute.giphermanager.service.GipherManagerService;

@CrossOrigin
@RestController
@EnableBinding(GipherBookmarkSource.class)
@RequestMapping("/gify/v1")
public class GipherController {
	private static final Logger logger = LoggerFactory.getLogger(GipherController.class.getName());	
	@Autowired
	private GipherManagerService gipherManagerService;
	
	/*@Autowired
	private GipherBookmarkSource gipherBookmarkSource;*/
	public GipherController(GipherManagerService gipherManagerService) {
		this.gipherManagerService=gipherManagerService;
		
		// TODO Auto-generated constructor stub
	}
	//GipherMessageProducer gipherMessageProducer;
	@Value("${gipher.api.key}")
	private String API_KEY;
	@Value("${gipher.trending.url}")
	private String gipher_trending_url;
	
	
	
	/*@GetMapping("/findAllGipher")
    public void getAllGipher() throws JsonParseException, JsonMappingException, IOException{
		System.out.println("inside controller");
		System.out.println(API_KEY);
		RestTemplate restTemplate=new RestTemplate();
		final String url=gipher_trending_url+"?api_key="+API_KEY;
		String dataList=restTemplate.getForObject(url,String.class);
		/*JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(stringToParse);*/
		/*DataModel dataModel = new ObjectMapper().readValue(dataList, DataModel.class);
		List<Datum> al=dataModel.getData();
		for(Datum data:al) {
			System.out.println(data.getId());
			
		}
    	//return gipherSearch.getData();
    	
    }*/
	
	//Add to Bookmark
	@PostMapping("/addFavourite")
	public ResponseEntity<String> addToFavourite(@RequestBody Favourite favourite) throws GipherNotAddedException, GipherAlreadyExistException{
		logger.info("----Backend AddToFavourite started");
		try {
			favourite.setCreatedDate(new Date());
			Favourite addFavouriteSuccess=this.gipherManagerService.addToFavouriteGipher(favourite);
			if(addFavouriteSuccess!=null) {
				//gipherBookmarkSource.bookmarkRetrival().send(MessageBuilder.withPayload(addFavouriteSuccess).build());
				//gipherMessageProducer.sendAddGipher(addFavouriteSuccess);
				logger.info(favourite.toString());
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}catch(GipherNotAddedException ex) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	//Get bookmark List
	
	@GetMapping("/allBookmarkGipher/{addedBy}")
	public List<Favourite> getAllBookmark(@PathVariable("addedBy") String addedBy) throws GipherNotFoundException{
		logger.info("---------------------GetAllBookmarkGipher Started---------------------");
		//List<Favourite> bookmarkList=gipherManagerService.getAllBookmarkGipher();		
		//gipherBookmarkSource.bookmarkRetrival().send(MessageBuilder.withPayload(bookmarkList).build());
		return gipherManagerService.getAllBookmarkGipherById(addedBy);
		//return bookmarkList;
		
		
		
	}
	
	//delete bookmark by gipher id
	@DeleteMapping("/bookmark/{addedBy}/{gipherId}")
	public ResponseEntity<String> deleteBookmarkByUserName(@PathVariable("addedBy") String addedBy,@PathVariable("gipherId") String gipheId) throws GipherNotFoundException {
		try {
			logger.info("---------------------deleteBookmarkByUserName Started---------------------");
			logger.info("Gipher Id::"+gipheId);
			logger.info("added By::"+addedBy);
			Favourite deleteSuccess = this.gipherManagerService.deleteBookmarkById(gipheId,addedBy);
			if (deleteSuccess!=null) {
				logger.info("delete gipher:::"+deleteSuccess);
				//gipherMessageProducer.sendDeletedFavourites(deleteSuccess);
				//gipherBookmarkSource.bookmarkDeletion().send(MessageBuilder.withPayload(deleteSuccess).build());
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(GipherNotFoundException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
