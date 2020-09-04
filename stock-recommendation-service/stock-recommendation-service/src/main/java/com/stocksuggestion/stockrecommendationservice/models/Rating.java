package com.stocksuggestion.stockrecommendationservice.models;

public class Rating {
	
	private int stockId;
	private int rating;
		
	public Rating(int stockId, int rating) {
		super();
		this.stockId = stockId;
		this.rating = rating;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}	
}
