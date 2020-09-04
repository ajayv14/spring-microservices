package com.stocksuggestion.stockrecommendationservice.models;

public class RecommendedItem {
	
	private int id;
	private String name;
	private String description;
	private int rating;
		
	public RecommendedItem(int id, String name, String description, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	 

}
