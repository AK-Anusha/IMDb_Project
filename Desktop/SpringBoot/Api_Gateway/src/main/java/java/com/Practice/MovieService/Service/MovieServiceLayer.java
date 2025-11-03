package com.Practice.MovieService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Practice.MovieService.Repository.RepositoryInterface;
import com.Practice.MovieService.model.Movie;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieServiceLayer {

	@Autowired
	private RepositoryInterface repo;

	
	//CRUD Operation will be implemented here
	public Movie createMovie(Movie movie) {
		if(movie==null) {
			throw new RuntimeException("Invalid Movie");
		}
		else {
		return repo.save(movie);
		}
	}
	
	public Movie getMovie(Long id) {
		return repo.findById(id)
				   .orElseThrow(() -> new RuntimeException("MovieNotFound"));
	}
	
	public void updateMovie(Movie movie, Long id) {
		if(movie==null || id ==null) {
			throw new RuntimeException("Invalid Movie");
		}
		
		//check if movie is in db or not by id if there then update the columns for that
		if(repo.existsById(id)) {
			Movie updated_movie = repo.getReferenceById(id);
			updated_movie.setName(movie.getName());
			updated_movie.setDirector(movie.getDirector());
			updated_movie.setActors(movie.getActors());
			repo.save(updated_movie);
		}
		else {
			throw new RuntimeException("MovieNotFound");
		}
	}
		
	public void deleteMovie(Long id) {
	
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
		else {
			throw new RuntimeException("MovieNotFound");
		}
	}
	
	
	
	
	
	
	
}


