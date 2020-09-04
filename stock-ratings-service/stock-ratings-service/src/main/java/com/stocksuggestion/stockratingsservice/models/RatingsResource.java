package com.stocksuggestion.stockratingsservice.models;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocksuggestion.stockratingsservice.resources.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {
	
	@RequestMapping("/{stockId}")
	public Rating getStockRating(@PathVariable("stockId") int stockId) {
		return new Rating(001, 10);
	}
	

}
