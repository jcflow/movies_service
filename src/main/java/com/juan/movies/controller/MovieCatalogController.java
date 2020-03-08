package com.juan.movies.controller;

import com.juan.movies.model.MovieCatalog;
import com.juan.movies.repository.MovieCatalogRepository;
import com.juan.movies.service.MovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieCatalogController {
    @Autowired
    private MovieCatalogService movieCatalogService;

    @PostMapping("/catalog-entry")
    public MovieCatalog newMovieCatalog(@RequestBody MovieCatalog memberRequest) {
        // Not necessary to create a movie catalog request class.
        return movieCatalogService.save(memberRequest);
    }
}
