package com.stocksuggestion.stockrecommendationservice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stocksuggestion.stockrecommendationservice.models.Rating;
import com.stocksuggestion.stockrecommendationservice.models.SectorRating;

@Service
public class SectorRatingInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod = "getFallbackRatings")
	public SectorRating getRatings(String sectorId) {
		return restTemplate.getForObject("http://stock-ratings-service/ratings/sectors/" + sectorId, SectorRating.class);
	}	
		
	public SectorRating getFallbackRatings(String sectorId) {
		SectorRating sectorRating = new SectorRating();
		sectorRating.setSectorRating(Arrays.asList(new Rating(000, 0)));
		return sectorRating;
	}
	
}
