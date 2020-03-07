package com.juan.movies.service;

import com.juan.movies.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> getAllNonDeletedMovies();

    Movie save(Movie movie);
}
