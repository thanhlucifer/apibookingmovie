package org.example.apibookingmovie.service;

import org.example.apibookingmovie.model.Movie;
import org.example.apibookingmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        if (movieRepository.existsById(id)) {
            movie.setMovieId(id);
            return movieRepository.save(movie);
        }
        return null;
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    // Các phương thức hiện có

    public List<Movie> getNowPlayingMovies() {
        LocalDate currentDate = LocalDate.now();
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMovieRelease() != null && movie.getMovieRelease().isBefore(currentDate))
                .collect(Collectors.toList());
    }

    public List<Movie> getUpcomingMovies() {
        LocalDate currentDate = LocalDate.now();
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMovieRelease() != null && movie.getMovieRelease().isAfter(currentDate))
                .collect(Collectors.toList());
    }

    // Thêm phương thức mới để lấy đường link từ trường movie_trailer
    public String getMovieTrailerLink(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            return movie.getMovieTrailer();
        }
        return null;
    }
}
