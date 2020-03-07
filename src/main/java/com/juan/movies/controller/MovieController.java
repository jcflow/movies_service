package com.juan.movies.controller;

import com.juan.movies.controller.response.MovieResponse;
import com.juan.movies.model.MovieCatalog;
import com.juan.movies.repository.MovieCatalogRepository;
import com.juan.movies.repository.MovieRentalRepository;
import com.juan.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieCatalogRepository movieCatalogRepository;
    @Autowired
    private MovieRentalRepository movieRentalRepository;

    @GetMapping
    public List<MovieResponse> all() {
        List<MovieResponse> response = movieRepository.findAll().stream().map((movie) -> {
            Optional<MovieCatalog> movieCatalog = movieCatalogRepository.findById(movie.getId());
            Optional<Date> returnedDate = movieRentalRepository
                    .findReturnedDatesByMovieId(movie.getId()).stream().findFirst();

            int numberOfCopies = movieCatalog.map(MovieCatalog::getNumberOfCopies).orElse(0);
            Date availableDate = returnedDate.orElse(null);
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setTitle(movie.getTitle());
            movieResponse.setYear(movie.getYear());
            movieResponse.setRate(movie.getRate());
            movieResponse.setAvailableDate(availableDate);
            movieResponse.setNumberOfCopies(numberOfCopies);
            movieResponse.setActors(movie.getActors());
            return movieResponse;
        }).collect(Collectors.toList());
        return response;
    }
}
