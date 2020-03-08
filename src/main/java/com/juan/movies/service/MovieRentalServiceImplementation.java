package com.juan.movies.service;

import com.juan.movies.model.MovieCatalog;
import com.juan.movies.model.MovieRental;
import com.juan.movies.repository.MovieRentalRepository;
import com.juan.movies.utils.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Optional;

@Service
public class MovieRentalServiceImplementation implements MovieRentalService {
    @Autowired
    private MovieRentalRepository movieRentalRepository;
    @Autowired
    private MovieCatalogService movieCatalogService;

    @Override
    public Date getAvailableDateByMovieId(int movieId) {
        Optional<Date> returnedDate = movieRentalRepository
                .findReturnedDatesByMovieId(movieId).stream().findFirst();
        return returnedDate.orElse(null);
    }

    @Override
    public MovieRental save(MovieRental movieRental) {
        // Rental logic
        Date rentalDate = movieRental.getDate();
        Date toReturnDate = DateHelper.addDays(rentalDate, 3);
        movieRental.setToReturnDate(toReturnDate);
        movieRental.setReturnedDate(null);
        MovieCatalog movieCatalog = movieCatalogService.findById(movieRental.getId());
        movieRental.setPrice(movieCatalog.getPrice());
        int copies = movieCatalog.getNumberOfCopies();
        movieCatalog.setNumberOfCopies(copies - 1);
        movieRental.setStatus("Rented");

        return movieRentalRepository.save(movieRental);
    }
}
