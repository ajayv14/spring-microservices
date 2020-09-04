package com.stocksuggestion.stockrecommendationservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocksuggestion.stockrecommendationservice.models.Rating;
import com.stocksuggestion.stockrecommendationservice.models.RecommendedItem;

@RestController
@RequestMapping("/recommendation")
public class StockRecommendationResource {
	
	@RequestMapping("/{sectorId}")
	public List<RecommendedItem> getRecommended(@PathVariable("sectorId") String sectorId){
		
		//hardcoded ratings
		List<Rating> ratings = Arrays.asList(
					new Rating(001,10),
					new Rating(002,5)
				);
		
		
		return Collections.singletonList(
				new RecommendedItem(001, "Tata Motors", "Auto", 10)
				//new RecommendedItem(002, "L&T", "Infra", 10),
				//new RecommendedItem(003, "Indian Bank", "banking", 4),
				//new RecommendedItem(004, "HDFC", "Banking", 10)
				);
	}
	
	
	
}
