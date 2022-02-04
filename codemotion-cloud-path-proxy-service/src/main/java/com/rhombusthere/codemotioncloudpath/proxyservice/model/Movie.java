package com.rhombusthere.codemotioncloudpath.proxyservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private long id;
    private String title;
    private String year;
    private String director;
    private String[] genres;
    private String actors;
    private String plot;
    private String posterUrl;
}

