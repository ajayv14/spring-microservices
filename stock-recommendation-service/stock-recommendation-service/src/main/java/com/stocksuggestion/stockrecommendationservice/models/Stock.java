package com.stocksuggestion.stockrecommendationservice.models;

public class Stock {
	
	private int stockId;
	private String name;
	
	
	public Stock() {	
	}
	
	public Stock(int stockId, String name) {
		//super();
		this.stockId = stockId;
		this.name = name;
	}
	
	public int getId() {
		return stockId;
	}
	public void setId(int stockId) {
		this.stockId = stockId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
