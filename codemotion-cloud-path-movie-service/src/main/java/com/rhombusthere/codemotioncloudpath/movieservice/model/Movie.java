package com.rhombusthere.codemotioncloudpath.movieservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private long id;
    private String title;
    @Column(name="`year`")
    private String year;
    private String director;
    private String[] genres;
    private String actors;
    @Column(columnDefinition="TEXT")
    private String plot;
    private String posterUrl;
}
