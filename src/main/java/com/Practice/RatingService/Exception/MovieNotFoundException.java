package com.Practice.RatingService.Exception;

public class MovieNotFoundException extends RuntimeException{
	
	public MovieNotFoundException(String message) {
		super(message);
	}

}
