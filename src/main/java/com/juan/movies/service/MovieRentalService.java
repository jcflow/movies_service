package com.juan.movies.service;

import com.juan.movies.model.MovieRental;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface MovieRentalService {
    Date getAvailableDateByMovieId(int movieId);

    MovieRental save(MovieRental movieRental);
}
