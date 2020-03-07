package com.juan.movies.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface MovieRentalService {
    Date getAvailableDateByMovieId(int movieId);
}
