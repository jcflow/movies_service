package com.juan.movies.service;

import com.juan.movies.repository.MovieRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

public class MovieRentalServiceImplementation implements MovieRentalService {
    @Autowired
    private MovieRentalRepository movieRentalRepository;

    @Override
    public Date getAvailableDateByMovieId(int movieId) {
        Optional<Date> returnedDate = movieRentalRepository
                .findReturnedDatesByMovieId(movieId).stream().findFirst();
        return returnedDate.orElse(null);
    }
}
