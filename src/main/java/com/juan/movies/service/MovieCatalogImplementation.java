package com.juan.movies.service;

import com.juan.movies.model.MovieCatalog;
import com.juan.movies.repository.MovieCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MovieCatalogImplementation implements MovieCatalogService {
    @Autowired
    private MovieCatalogRepository movieCatalogRepository;

    @Override
    public int getNumberOfCopiesByMovieId(int movieId) {
        Optional<MovieCatalog> movieCatalog = movieCatalogRepository.findById(movieId);
        return movieCatalog.map(MovieCatalog::getNumberOfCopies).orElse(0);
    }
}
