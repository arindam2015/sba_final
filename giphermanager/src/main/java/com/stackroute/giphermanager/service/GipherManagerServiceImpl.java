package com.stackroute.giphermanager.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.giphermanager.config.GipherMessageProducer;
import com.stackroute.giphermanager.controller.GipherController;
import com.stackroute.giphermanager.exception.GipherAlreadyExistException;
import com.stackroute.giphermanager.exception.GipherNotAddedException;
import com.stackroute.giphermanager.exception.GipherNotFoundException;
import com.stackroute.giphermanager.model.Favourite;
import com.stackroute.giphermanager.repository.GipherRepository;
@Service
public class GipherManagerServiceImpl implements GipherManagerService {
	private static final Logger logger = LoggerFactory.getLogger(GipherManagerServiceImpl.class.getName());
	@Autowired
	GipherRepository gipherRepository;
	@Autowired
	private GipherMessageProducer gipherMessageProducer;

	public GipherManagerServiceImpl(GipherRepository gipherRepository,GipherMessageProducer gipherMessageProducer) {
		this.gipherRepository = gipherRepository;
		this.gipherMessageProducer=gipherMessageProducer;
	}


	@Override
	public Favourite addToFavouriteGipher(Favourite favourite) throws GipherNotAddedException, GipherAlreadyExistException {
		// TODO Auto-generated method stub
		Favourite addFavouriteSuccess=null;
		Favourite isExist=this.gipherRepository.findAllBookmarkByGipherIdAndAddedBy(favourite.getGipherId(),favourite.getAddedBy());
		if(isExist!=null) {
			throw new GipherAlreadyExistException("Gipher Already Exist");
		}else {
			addFavouriteSuccess= this.gipherRepository.insert(favourite);
			//calling message producer
			gipherMessageProducer.sendAddGipher(addFavouriteSuccess);
		}	
		
		if(addFavouriteSuccess != null) {
			return addFavouriteSuccess;
		}
		else {
			throw new GipherNotAddedException("Gipher Not Added");
		}
		
	}


	@Override
	public List<Favourite> getAllBookmarkGipherById(String addedBy) throws GipherNotFoundException {
		// TODO Auto-generated method stub
		return gipherRepository.findAllBookmarkByAddedBy(addedBy);
	}


	@Override
	public List<Favourite> getAllBookmarkGipher() throws GipherNotFoundException {
		// TODO Auto-generated method stub
		return gipherRepository.findAll();
	}


	@Override
	public Favourite deleteBookmarkById(String gipherId,String addedBy) throws GipherNotFoundException {
		// TODO Auto-generated method stub
		boolean isDeleted=false;
		Favourite favourite=null;
		try {
			System.out.println("inside delete service");
			favourite=this.gipherRepository.findAllBookmarkByGipherIdAndAddedBy(gipherId,addedBy);
			System.out.println("id::"+favourite.getAddedBy());
			if(favourite!=null) {
				System.out.println("calling delete::");
				this.gipherRepository.deleteByGipherIdAndAddedBy(favourite.getGipherId(),favourite.getAddedBy());
				System.out.println("deleted "+isDeleted);
				gipherMessageProducer.sendDeletedFavourites(favourite);
				isDeleted=true;
			}
		}catch(Exception e) {
			//throw new GipherNotFoundException("Gipher not found");
			e.printStackTrace();
			
		}
		if(isDeleted==true) {
			return favourite;
		}else {
			throw new GipherNotFoundException("Gipher not found");
		}
			
		
	}



}
