package org.example.apibookingmovie.controller;

import org.example.apibookingmovie.model.Movie;
import org.example.apibookingmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }


    @GetMapping("/now_playing")
    public List<Movie> getNowPlayingMovies() {
        return movieService.getNowPlayingMovies();
    }

    @GetMapping("/upcoming")
    public List<Movie> getUpcomingMovies() {
        return movieService.getUpcomingMovies();
    }

    // Thêm endpoint để lấy đường link từ trường movie_trailer
    @GetMapping("/{id}/trailer")
    public String getMovieTrailerLink(@PathVariable Long id) {
        return movieService.getMovieTrailerLink(id);
    }


}
