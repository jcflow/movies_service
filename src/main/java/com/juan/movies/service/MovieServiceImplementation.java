package com.juan.movies.service;

import com.juan.movies.model.Movie;
import com.juan.movies.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return movieRepository.save(movie);
    }
}
