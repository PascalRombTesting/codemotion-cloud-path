package com.rhombusthere.codemotioncloudpath.movieservice.repository;

import com.rhombusthere.codemotioncloudpath.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
