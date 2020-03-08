package com.juan.movies.controller.exception;

import com.juan.movies.controller.exception.MovieCatalogNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieCatalogNotFoundExceptionController {
    @ExceptionHandler(value = MovieCatalogNotFoundException.class)
    public ResponseEntity<Object> exception(MovieCatalogNotFoundException exception) {
        return new ResponseEntity<>("Movie catalog not found", HttpStatus.NOT_FOUND);
    }
}
