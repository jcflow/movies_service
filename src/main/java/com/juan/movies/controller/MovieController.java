package com.juan.movies.controller;

import com.juan.movies.controller.request.MovieRequest;
import com.juan.movies.controller.response.MovieResponse;
import com.juan.movies.model.Actor;
import com.juan.movies.model.Movie;
import com.juan.movies.model.MovieCatalog;
import com.juan.movies.model.User;
import com.juan.movies.repository.*;
import com.juan.movies.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieCatalogService movieCatalogService;
    @Autowired
    private MovieRentalService movieRentalService;
    @Autowired
    private UserService userService;
    @Autowired
    private ActorService actorService;

    @GetMapping("/movies")
    public List<MovieResponse> all() {
        List<MovieResponse> response = movieService.getAllNonDeletedMovies().stream().map((movie) -> {
            Date availableDate = movieRentalService.getAvailableDateByMovieId(movie.getId());
            int numberOfCopies = movieCatalogService.getNumberOfCopiesByMovieId(movie.getId());
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setTitle(movie.getTitle());
            movieResponse.setYear(movie.getYear());
            movieResponse.setRate(movie.getRate());
            movieResponse.setAvailableDate(availableDate);
            movieResponse.setNumberOfCopies(numberOfCopies);
            movieResponse.setActors(movie.getActors().stream().map(Actor::getName).collect(Collectors.toList()));
            return movieResponse;
        }).collect(Collectors.toList());
        return response;
    }

    @PostMapping("/movie")
    public ResponseEntity<String> newMovie(@RequestBody MovieRequest movieRequest) {
        User registeringUser = userService.findByUserName(movieRequest.getRegisteringUser());
        Set<Actor> actors = new HashSet<>(actorService.findActorsByIds(movieRequest.getActors()));
        Movie movie = new Movie();
        movie.setTitle(movieRequest.getTitle());
        movie.setYear(movieRequest.getYear());
        movie.setDescription(movieRequest.getDescription());
        movie.setRate(movieRequest.getRate());
        movie.setRegisteringUser(registeringUser);
        movie.setActors(actors);
        movieService.save(movie);
        return new ResponseEntity<>("Movie created.", HttpStatus.CREATED);
    }
}
