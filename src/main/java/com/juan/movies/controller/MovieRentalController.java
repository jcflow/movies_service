package com.juan.movies.controller;

import com.juan.movies.controller.request.MovieRentalRequest;
import com.juan.movies.controller.request.MovieRentalStatusRequest;
import com.juan.movies.model.MovieCatalog;
import com.juan.movies.model.MovieRental;
import com.juan.movies.model.Price;
import com.juan.movies.repository.MemberRepository;
import com.juan.movies.repository.MovieCatalogRepository;
import com.juan.movies.repository.MovieRentalRepository;
import com.juan.movies.repository.MovieRepository;
import com.juan.movies.utils.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieRentalController {
    @Autowired
    private MovieRentalRepository movieRentalRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieCatalogRepository movieCatalogRepository;

    @PostMapping("/rental")
    public MovieRental newMovieRental(@RequestBody MovieRentalRequest movieRentalRequest) {
        Date rentalDate = movieRentalRequest.getDate();
        int memberId = movieRentalRequest.getMemberId();
        int movieId = movieRentalRequest.getMovieId();
        MovieRental movieRental = new MovieRental();
        movieRental.setMember(memberRepository.findById(memberId).orElse(null));
        movieRental.setMovie(movieRepository.findById(movieId).orElse(null));
        movieRental.setDate(rentalDate);

        // Rental logic
        Date toReturnDate = DateHelper.addDays(rentalDate, 3);
        Optional<MovieCatalog> foundCatalog = movieCatalogRepository.findById(movieId);
        movieRental.setToReturnDate(toReturnDate);
        movieRental.setReturnedDate(null);
        foundCatalog.ifPresent(movieCatalog -> {
            movieRental.setPrice(movieCatalog.getPrice());
            int copies = movieCatalog.getNumberOfCopies();
            movieCatalog.setNumberOfCopies(copies - 1);
        });
        movieRental.setStatus("Rented");

        return movieRentalRepository.save(movieRental);
    }
}
