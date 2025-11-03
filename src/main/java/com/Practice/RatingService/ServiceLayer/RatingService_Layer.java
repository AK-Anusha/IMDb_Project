package com.Practice.RatingService.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Practice.RatingService.Exception.MovieNotFoundException;
import com.Practice.RatingService.ModelEntity.RatingEntity;
import com.Practice.RatingService.Repository.RatingRepositoryInterface;

@Service
public class RatingService_Layer {

	@Autowired
	RatingRepositoryInterface ratingRepo;
	
	// when adding new rating by a person for the movie, average will be updated
	public double updateAverage(String movieName, double stars) {
		RatingEntity rating = ratingRepo.findBymovieName(movieName);
		if(rating == null) {

			rating = new RatingEntity();
			rating.setMovieName(movieName);
			rating.setExistingAvgRating(stars);
			rating.setCount(1);
		}
		else {
		int count = rating.getCount();
		double newAvgRating = (rating.getExistingAvgRating()*count+stars)/(count+1);
		rating.setExistingAvgRating(newAvgRating);
		rating.setCount(count+1);
		}
		ratingRepo.save(rating);
		return rating.getExistingAvgRating();
	}
	
	// fetch rating for the movie by finding the movie with findByName using repository
	public RatingEntity getRating(String movieName) {
		RatingEntity rating = ratingRepo.findBymovieName(movieName);
		if(rating==null) {
			throw new MovieNotFoundException("Movie not found with name "+movieName);
		}
		return rating;
	}
}
