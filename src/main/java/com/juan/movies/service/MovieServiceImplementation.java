package com.juan.movies.service;

import com.juan.movies.controller.exception.MovieNotFoundException;
import com.juan.movies.model.Movie;
import com.juan.movies.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImplementation implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllNonDeletedMovies() {
        return movieRepository.findAllNotDeleted();
    }

    @Override
    public Movie save(Movie movie) {
        // TODO
        return movieRepository.save(movie);
    }

    @Override
    public Movie findById(int movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (!movie.isPresent()) {
            throw new MovieNotFoundException();
        }
        return movie.get();
    }
}
