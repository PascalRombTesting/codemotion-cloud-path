package com.rhombusthere.codemotioncloudpath.movieservice.controller;

import com.rhombusthere.codemotioncloudpath.movieservice.model.Movie;
import com.rhombusthere.codemotioncloudpath.movieservice.service.MovieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ApiOperation(value = "Get list of all movies")
    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }
}
