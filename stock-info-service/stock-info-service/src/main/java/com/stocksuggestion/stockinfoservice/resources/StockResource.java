package com.stocksuggestion.stockinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocksuggestion.stockinfoservice.models.Stock;



@RestController
@RequestMapping("/stock")
public class StockResource {
	
	@RequestMapping("/{stockId}")
	public Stock getStockInfo(@PathVariable("stockId") int stockId) {
		 return new Stock(001,"L&T");
	}
}
