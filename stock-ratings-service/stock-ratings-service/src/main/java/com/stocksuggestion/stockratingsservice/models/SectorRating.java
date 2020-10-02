package com.stocksuggestion.stockratingsservice.models;

import java.util.List;

import com.stocksuggestion.stockratingsservice.resources.Rating;

public class SectorRating {
	
	public SectorRating() {};
	
	private List<Rating> sectorRating;

	public List<Rating> getSectorRating() {
		return sectorRating;
	}

	public void setSectorRating(List<Rating> sectorRating) {
		this.sectorRating = sectorRating;
	}
	
	
}
