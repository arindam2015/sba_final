package com.stackroute.giphermanager.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stackroute.giphermanager.model.Datum;

@FeignClient(url="http://api.giphy.com/v1/gifs", name="GIPHY-CLIENT")
public interface GipherSearch {
	
	@GetMapping("/trending?api_key=QPayNCt8xoMomlYfVdySXOEGxAxXfiV2")
	public List<Datum> getData();
}
