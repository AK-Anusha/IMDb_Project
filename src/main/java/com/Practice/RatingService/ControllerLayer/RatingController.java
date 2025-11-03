package com.Practice.RatingService.ControllerLayer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Practice.RatingService.ModelEntity.RatingEntity;
import com.Practice.RatingService.ModelEntity.RatingRequest;
import com.Practice.RatingService.ServiceLayer.RatingService_Layer;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService_Layer ratingService;
	
	@GetMapping("/{movieName}")
	public ResponseEntity<RatingEntity> getRating(@PathVariable String movieName){
		RatingEntity rating = ratingService.getRating(movieName); 
		 log.info("Returning rating for movie ", movieName);
		return ResponseEntity.ok(rating);
		
	}
	@PostMapping()
	public Map<String, Double> updateRating(@RequestBody(required=false) RatingRequest ratingRequest) {
		double newAverage = ratingService.updateAverage(ratingRequest.getMovieName(), ratingRequest.getStars());
		log.info("new Average for movie {} ",ratingRequest.getMovieName());
		return  Map.of("average", newAverage);
}
}
