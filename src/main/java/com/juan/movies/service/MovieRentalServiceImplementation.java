package com.juan.movies.service;

import com.juan.movies.controller.exception.InvalidRentalDateException;
import com.juan.movies.controller.exception.MovieRentalNotFoundException;
import com.juan.movies.controller.exception.MovieRentalStatusNotValidException;
import com.juan.movies.controller.exception.NoAvailableCopiesException;
import com.juan.movies.model.MovieCatalog;
import com.juan.movies.model.MovieRental;
import com.juan.movies.repository.MovieRentalRepository;
import com.juan.movies.utils.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MovieRentalServiceImplementation implements MovieRentalService {
    public static String RENTED_STATUS = "Rented";
    public static String RETURNED_STATUS = "Returned";

    @Autowired
    private MovieRentalRepository movieRentalRepository;
    @Autowired
    private MovieCatalogService movieCatalogService;

    @Override
    public Date getAvailableDateByMovieId(int movieId) {
        Optional<Date> returnedDate = Optional.of(new Date());
        return returnedDate.orElse(null);
    }

    @Override
    public MovieRental save(MovieRental movieRental) {
        // Rental logic
        Date rentalDate = movieRental.getDate();
        if (rentalDate.before(new Date())) {
            throw new InvalidRentalDateException();
        }
        Date toReturnDate = DateHelper.addDays(rentalDate, 3);
        movieRental.setToReturnDate(toReturnDate);
        movieRental.setReturnedDate(null);
        MovieCatalog movieCatalog = movieCatalogService.findById(movieRental.getMovie().getId());
        movieRental.setPrice(movieCatalog.getPrice());
        int copies = movieCatalog.getNumberOfCopies();
        if (copies <= 0) {
            throw new NoAvailableCopiesException();
        }
        movieCatalog.setNumberOfCopies(copies - 1);
        movieRental.setStatus("Rented");

        return movieRentalRepository.save(movieRental);
    }

    @Override
    public MovieRental updateStatusById(int id, String status) {
        Optional<MovieRental> requiredRental = movieRentalRepository.findById(id);
        if (!requiredRental.isPresent()) {
            throw new MovieRentalNotFoundException();
        }
        if (!status.equals(RENTED_STATUS) && !status.equals(RETURNED_STATUS)) {
            throw new MovieRentalStatusNotValidException();
        }

        MovieRental movieRental = requiredRental.get();
        if (movieRental.getStatus() == null
                || movieRental.getStatus().equals(RENTED_STATUS)
                || movieRental.getStatus().equals(RETURNED_STATUS)) {
            movieRental.setStatus(status);
            if (status.equals(RETURNED_STATUS)) {
                int movieId = movieRental.getMovie().getId();
                MovieCatalog movieCatalog = movieCatalogService.findById(movieId);
                movieCatalog.setNumberOfCopies(movieCatalog.getNumberOfCopies() + 1);
                movieCatalogService.save(movieCatalog);
                movieRental.setReturnedDate(new Date());
            }
        }
        return movieRentalRepository.save(movieRental);
    }
}
