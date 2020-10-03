package com.stocksuggestion.stockratingsservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocksuggestion.stockratingsservice.models.Rating;
import com.stocksuggestion.stockratingsservice.models.SectorRating;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {
	
	@RequestMapping("/{stockId}")
	public Rating getStockRating(@PathVariable("stockId") int stockId) {
		return new Rating(001, 10);
	}
	
	@RequestMapping("/sectors/{sectorId}")
	public SectorRating getRecommendedStocksForUser(@PathVariable("sectorId") int userId){		
		List<Rating> ratings =  Arrays.asList(
		new Rating(001,10),
		new Rating(002,8));
	
	    SectorRating sectorRating = new SectorRating();
	    sectorRating.setSectorRating(ratings);
	    return sectorRating;
	}

}
