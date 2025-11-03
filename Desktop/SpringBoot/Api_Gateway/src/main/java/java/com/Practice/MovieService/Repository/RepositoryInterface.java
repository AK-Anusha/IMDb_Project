package com.Practice.MovieService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Practice.MovieService.model.Movie;

@Repository
public interface RepositoryInterface extends JpaRepository<Movie,Long>{

}
