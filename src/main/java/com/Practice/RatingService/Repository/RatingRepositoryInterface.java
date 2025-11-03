package com.Practice.RatingService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Practice.RatingService.ModelEntity.RatingEntity;

@Repository
public interface RatingRepositoryInterface extends JpaRepository<RatingEntity, Long>{
	
	// spring will implement the logic to fetch based on name with findByName() method -> benefit of spring for JPARepo
	public RatingEntity findBymovieName(String movieName);
	
	// Again Benefit of spring for fetching data based on between values like Movie/MovieDetails with AvgRating between min and max values
	List<RatingEntity> findAllByExistingAvgRatingBetween(double Min, double Max);
	
}
 
