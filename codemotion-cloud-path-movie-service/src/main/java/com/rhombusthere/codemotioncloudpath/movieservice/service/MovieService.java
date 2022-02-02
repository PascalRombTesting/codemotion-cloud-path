package com.rhombusthere.codemotioncloudpath.movieservice.service;

import com.rhombusthere.codemotioncloudpath.movieservice.model.Movie;
import com.rhombusthere.codemotioncloudpath.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}
