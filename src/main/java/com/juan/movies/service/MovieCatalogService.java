package com.juan.movies.service;

import org.springframework.stereotype.Service;

@Service
public interface MovieCatalogService {
    int getNumberOfCopiesByMovieId(int movieId);
}
