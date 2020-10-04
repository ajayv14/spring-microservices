package com.stocksuggestion.stockrecommendationservice.resources;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stocksuggestion.stockrecommendationservice.models.Rating;
import com.stocksuggestion.stockrecommendationservice.models.RecommendedItem;
import com.stocksuggestion.stockrecommendationservice.models.SectorRating;
import com.stocksuggestion.stockrecommendationservice.models.Stock;
import com.stocksuggestion.stockrecommendationservice.services.SectorRatingInfo;
import com.stocksuggestion.stockrecommendationservice.services.StockInfo;

@RestController
@RequestMapping("/recommendation")
public class StockRecommendationResource {
			
	@Autowired
	private StockInfo stockInfo;
	
	@Autowired
	private SectorRatingInfo sectorRatingInfo;
	
	//@HystrixCommand(fallbackMethod = "getFallbackRecommended")
	@RequestMapping("/{sectorId}")
	public List<RecommendedItem> getRecommended(@PathVariable("sectorId") String sectorId){
					
		SectorRating sectorRating = sectorRatingInfo.getRatings(sectorId);
				
		return sectorRating.getSectorRating().stream().map(rating-> {		
		
			    Stock stock = stockInfo.getStockInfo(rating);
			
				return new RecommendedItem(stock.getId(), stock.getName(),"Auto", rating.getRating());
				
		        }).collect(Collectors.toList());
		
		/*return Collections.singletonList(
				new RecommendedItem(001, "Tata Motors", "Auto", 10)
				//new RecommendedItem(002, "L&T", "Infra", 10),
				//new RecommendedItem(003, "Indian Bank", "banking", 4),
				//new RecommendedItem(004, "HDFC", "Banking", 10)
				);*/
	}
	
	/**
	 * @param sectorId
	 * @return
	 */	
	public List<RecommendedItem> getFallbackRecommended(@PathVariable("sectorId") String sectorId){
			return Arrays.asList(new RecommendedItem(000, "no stock recommendation available","N/A", 0));			
	}
	
	
} 
