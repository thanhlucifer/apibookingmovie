package org.example.apibookingmovie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String movieName;
    private String movieDescription;
    private String movieTrailer;
    private String movieCens;
    private String movieGenres;
    private LocalDate movieRelease;
    private String movieLength;
    private String movieFormat;
    private String moviePoster;
    private int popularityScore;

}
