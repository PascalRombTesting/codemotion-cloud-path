package com.rhombusthere.codemotioncloudpath.movieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CodemotionCloudPathMovieService {
    public static void main(String[] args) {
        SpringApplication.run(CodemotionCloudPathMovieService.class, args);
    }

}
