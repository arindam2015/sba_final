package com.stackroute.giphermanager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.giphermanager.model.Favourite;
@Repository
public interface GipherRepository extends MongoRepository<Favourite,String> {
	
	List<Favourite> findAllBookmarkByAddedBy(String addedBy);
	Favourite findAllBookmarkByGipherIdAndAddedBy(String gipherId,String addedBy);
	void deleteByGipherIdAndAddedBy(String gipherId,String addedBy);
}
