package com.juan.movies.controller;

import com.juan.movies.controller.exception.MemberNotFoundException;
import com.juan.movies.controller.exception.MovieCatalogNotFoundException;
import com.juan.movies.controller.exception.MovieNotFoundException;
import com.juan.movies.controller.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceNotFoundExceptionController {
    @ExceptionHandler(value = MovieCatalogNotFoundException.class)
    public ResponseEntity<Object> exception(MovieCatalogNotFoundException exception) {
        return new ResponseEntity<>("Movie catalog not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<Object> exception(MovieNotFoundException exception) {
        return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MemberNotFoundException.class)
    public ResponseEntity<Object> exception(MemberNotFoundException exception) {
        return new ResponseEntity<>("Member not found", HttpStatus.NOT_FOUND);
    }
}
