package com.juan.movies.service;

import com.juan.movies.model.MovieCatalog;
import org.springframework.stereotype.Service;

@Service
public interface MovieCatalogService {
    int getNumberOfCopiesByMovieId(int movieId);

    MovieCatalog save(MovieCatalog movieCatalog);

    MovieCatalog findById(int movieId);
}
