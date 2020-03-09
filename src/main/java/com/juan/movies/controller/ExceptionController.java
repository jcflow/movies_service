package com.juan.movies.controller;

import com.juan.movies.controller.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = MovieCatalogNotFoundException.class)
    public ResponseEntity<Object> exception(MovieCatalogNotFoundException exception) {
        return new ResponseEntity<>("Movie catalog not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<Object> exception(MovieNotFoundException exception) {
        return new ResponseEntity<>("Movie not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MemberNotFoundException.class)
    public ResponseEntity<Object> exception(MemberNotFoundException exception) {
        return new ResponseEntity<>("Member not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidRentalDateException.class)
    public ResponseEntity<Object> exception(InvalidRentalDateException exception) {
        return new ResponseEntity<>("Invalid rental date.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoAvailableCopiesException.class)
    public ResponseEntity<Object> exception(NoAvailableCopiesException exception) {
        return new ResponseEntity<>("No available copies for this movie.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MovieRentalNotFoundException.class)
    public ResponseEntity<Object> exception(MovieRentalNotFoundException exception) {
        return new ResponseEntity<>("Movie rental not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MovieRentalStatusNotValidException.class)
    public ResponseEntity<Object> exception(MovieRentalStatusNotValidException exception) {
        return new ResponseEntity<>("Movie rental status not valid.", HttpStatus.BAD_REQUEST);
    }
}
