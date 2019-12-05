package com.stackroute.giphermanager.service;

import java.util.List;

import com.stackroute.giphermanager.exception.GipherAlreadyExistException;
import com.stackroute.giphermanager.exception.GipherNotAddedException;
import com.stackroute.giphermanager.exception.GipherNotFoundException;
import com.stackroute.giphermanager.model.Favourite;

public interface GipherManagerService {
	Favourite addToFavouriteGipher(Favourite favourite) throws GipherNotAddedException, GipherAlreadyExistException;
	List<Favourite> getAllBookmarkGipher() throws GipherNotFoundException;
	List<Favourite> getAllBookmarkGipherById(String addedBy) throws GipherNotFoundException;
	Favourite deleteBookmarkById(String gipherId,String addedBy) throws GipherNotFoundException;
}
