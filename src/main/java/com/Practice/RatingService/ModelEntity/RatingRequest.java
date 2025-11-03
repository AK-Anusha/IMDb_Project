package com.Practice.RatingService.ModelEntity;

import lombok.Data;

@Data
public class RatingRequest {

	private String movieName;
	private double stars;
}
