package com.juan.movies.controller;

import com.juan.movies.controller.request.MovieRequest;
import com.juan.movies.controller.response.MovieResponse;
import com.juan.movies.model.Actor;
import com.juan.movies.model.Movie;
import com.juan.movies.model.MovieCatalog;
import com.juan.movies.model.User;
import com.juan.movies.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieCatalogRepository movieCatalogRepository;
    @Autowired
    private MovieRentalRepository movieRentalRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/movies")
    public List<MovieResponse> all() {
        List<MovieResponse> response = movieRepository.findAllNotDeleted().stream().map((movie) -> {
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

    @PostMapping("/movie")
    public Movie newMovie(@RequestBody MovieRequest movieRequest) {
        Optional<User> foundUser = userRepository.findByUserName(movieRequest.getRegisteringUser());
        User registeringUser = foundUser.orElse(null);

        Set<Actor> actors = new HashSet<>(actorRepository
                .findActorsByIds(movieRequest.getActors()));

        Movie movie = new Movie();
        movie.setTitle(movieRequest.getTitle());
        movie.setYear(movieRequest.getYear());
        movie.setDescription(movieRequest.getDescription());
        movie.setRate(movieRequest.getRate());
        movie.setRegisteringUser(registeringUser);
        movie.setActors(actors);
        return movieRepository.save(movie);
    }
}
