package com.stocksuggestion.stockrecommendationservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stocksuggestion.stockrecommendationservice.models.Rating;
import com.stocksuggestion.stockrecommendationservice.models.Stock;

@Service
public class StockInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * @param rating
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "getFallbackStockInfo")
	public Stock getStockInfo(Rating rating) {
		return restTemplate.getForObject("http://stock-info-service/stock/" + rating.getStockId(), Stock.class);
	}

	public Stock getFallbackStockInfo(Rating rating) {
		return new Stock(000,"no name");
	}

}
