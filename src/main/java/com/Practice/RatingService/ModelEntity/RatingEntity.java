package com.Practice.RatingService.ModelEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Data;

@Entity
@Data
public class RatingEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	private String movieName;
	private double existingAvgRating;
	private int count;
	
	public RatingEntity() {
	}

	public RatingEntity(Long id, String movieName, double existingAvgRating, int count) {
		this.id = id;
		this.movieName = movieName;
		this.existingAvgRating = existingAvgRating;
		this.count = count;
	}



}
