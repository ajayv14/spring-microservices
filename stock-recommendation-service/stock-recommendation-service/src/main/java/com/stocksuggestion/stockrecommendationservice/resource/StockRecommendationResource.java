package com.stocksuggestion.stockrecommendationservice.resource;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stocksuggestion.stockrecommendationservice.models.Rating;
import com.stocksuggestion.stockrecommendationservice.models.RecommendedItem;
import com.stocksuggestion.stockrecommendationservice.models.SectorRating;
import com.stocksuggestion.stockrecommendationservice.models.Stock;

@RestController
@RequestMapping("/recommendation")
public class StockRecommendationResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{sectorId}")
	public List<RecommendedItem> getRecommended(@PathVariable("sectorId") String sectorId){
					
		SectorRating sectorRating = restTemplate.getForObject("http://stock-ratings-service/ratings/sectors/" + sectorId, SectorRating.class);
				
		return sectorRating.getSectorRating().stream().map(rating-> {		
		
			    Stock stock = restTemplate.getForObject("http://stock-info-service/stock/" + rating.getStockId(), Stock.class);
			
				return new RecommendedItem(stock.getId(), stock.getName(),"Auto", rating.getRating());
				
		        }).collect(Collectors.toList());
		
		/*return Collections.singletonList(
				new RecommendedItem(001, "Tata Motors", "Auto", 10)
				//new RecommendedItem(002, "L&T", "Infra", 10),
				//new RecommendedItem(003, "Indian Bank", "banking", 4),
				//new RecommendedItem(004, "HDFC", "Banking", 10)
				);*/
	}
	
	
	
}
