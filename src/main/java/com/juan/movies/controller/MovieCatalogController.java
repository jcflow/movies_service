package com.juan.movies.controller;

import com.juan.movies.controller.request.MovieCatalogRequest;
import com.juan.movies.model.Movie;
import com.juan.movies.model.MovieCatalog;
import com.juan.movies.model.Price;
import com.juan.movies.repository.MovieCatalogRepository;
import com.juan.movies.service.MovieCatalogService;
import com.juan.movies.service.MovieService;
import com.juan.movies.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieCatalogController {
    @Autowired
    private MovieCatalogService movieCatalogService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private PriceService priceService;

    @PostMapping("/catalog-entry")
    public ResponseEntity<String> newMovieCatalog(@RequestBody MovieCatalogRequest movieCatalogRequest) {
        // Not necessary to create a movie catalog request class.
        MovieCatalog movieCatalog = new MovieCatalog();
        Movie movie = movieService.findById(movieCatalogRequest.getMovie());
        Price price = priceService.findById(movieCatalogRequest.getPrice());
        movieCatalog.setMovie(movie);
        movieCatalog.setPrice(price);
        movieCatalog.setNumberOfCopies(movieCatalogRequest.getNumberOfCopies());
        movieCatalogService.save(movieCatalog);
        return new ResponseEntity<>("Movie catalog created.", HttpStatus.CREATED);
    }
}
