package com.juan.movies.controller;

import com.juan.movies.controller.request.MovieRentalRequest;
import com.juan.movies.model.MovieRental;
import com.juan.movies.service.MemberService;
import com.juan.movies.service.MovieRentalService;
import com.juan.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieRentalController {
    @Autowired
    private MovieRentalService movieRentalService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MovieService movieService;

    @PostMapping("/rental")
    public MovieRental newMovieRental(@RequestBody MovieRentalRequest movieRentalRequest) {
        Date rentalDate = movieRentalRequest.getDate();
        int memberId = movieRentalRequest.getMemberId();
        int movieId = movieRentalRequest.getMovieId();
        MovieRental movieRental = new MovieRental();
        movieRental.setMember(memberService.findById(memberId));
        movieRental.setMovie(movieService.findById(movieId));
        movieRental.setDate(rentalDate);
        return movieRentalService.save(movieRental);
    }
}
