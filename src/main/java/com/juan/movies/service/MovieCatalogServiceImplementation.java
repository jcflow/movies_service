package com.juan.movies.service;

import com.juan.movies.controller.exception.MovieCatalogNotFoundException;
import com.juan.movies.controller.exception.MovieNotFoundException;
import com.juan.movies.model.Movie;
import com.juan.movies.model.MovieCatalog;
import com.juan.movies.repository.MovieCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MovieCatalogServiceImplementation implements MovieCatalogService {
    @Autowired
    private MovieCatalogRepository movieCatalogRepository;

    @Override
    public int getNumberOfCopiesByMovieId(int movieId) {
        Optional<MovieCatalog> movieCatalog = movieCatalogRepository.findById(movieId);
        return movieCatalog.map(MovieCatalog::getNumberOfCopies).orElse(0);
    }

    @Override
    public MovieCatalog save(MovieCatalog movieCatalog) {
        // TODO
        return movieCatalogRepository.save(movieCatalog);
    }

    @Override
    public MovieCatalog findById(int movieId) {
        Optional<MovieCatalog> movieCatalog = movieCatalogRepository.findById(movieId);
        if (!movieCatalog.isPresent()) {
            throw new MovieCatalogNotFoundException();
        }
        return movieCatalog.get();
    }
}
