package com.juan.movies.service;

import com.juan.movies.controller.exception.InvalidRentalDateException;
import com.juan.movies.controller.exception.MovieCatalogNotFoundException;
import com.juan.movies.controller.exception.NoAvailableCopiesException;
import com.juan.movies.model.Movie;
import com.juan.movies.model.MovieCatalog;
import com.juan.movies.model.MovieRental;
import com.juan.movies.model.Price;
import com.juan.movies.repository.MovieCatalogRepository;
import com.juan.movies.repository.MovieRentalRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class MovieRentalServiceTest {

    private Movie movie;
    private Price price;
    private MovieCatalog movieCatalog;

    private MovieRentalService movieRentalService;
    private MovieCatalogRepository movieCatalogRepository;

    @BeforeEach
    public void setUp() {
        movie = new Movie();
        movie.setId(1);
        movie.setTitle("Blade RunnerBlade RunnerBlade RunnerBlade RunnerBlade Runner");
        movie.setYear(new Date(1997, 4, 15));
        movie.setDescription("A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.");

        price = new Price();
        price.setId(123);
        price.setPrice(10);
        price.setDate(new Date());

        movieCatalog = new MovieCatalog();
        movieCatalog.setMovie(movie);
        movieCatalog.setPrice(price);
        movieCatalog.setNumberOfCopies(7);

        movieRentalService = new MovieRentalServiceImplementation();
        MovieCatalogService movieCatalogService = new MovieCatalogServiceImplementation();

        // WORKAROUND: Due mockito and @TestConfiguration did not work.
        MovieRentalRepository movieRentalRepository = Mockito.mock(MovieRentalRepository.class);
        when(movieRentalRepository.save(any())).thenReturn(null);

        movieCatalogRepository = Mockito.mock(MovieCatalogRepository.class);
        when(movieCatalogRepository.save(any())).thenReturn(null);
        try {
            Field field = MovieRentalServiceImplementation.class.getDeclaredField("movieRentalRepository");
            field.setAccessible(true);
            field.set(movieRentalService, movieRentalRepository);

            field = MovieCatalogServiceImplementation.class.getDeclaredField("movieCatalogRepository");
            field.setAccessible(true);
            field.set(movieCatalogService, movieCatalogRepository);

            field = MovieRentalServiceImplementation.class.getDeclaredField("movieCatalogService");
            field.setAccessible(true);
            field.set(movieRentalService, movieCatalogService);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail();
        }
        when(movieCatalogRepository.findById(eq(1))).thenReturn(Optional.of(movieCatalog));
    }

    @Test
    public void invalidDate() throws Exception {
        Exception exception = assertThrows(InvalidRentalDateException.class, () -> {
            MovieRental movieRental = new MovieRental();
            movieRental.setDate(new Date(new Date().getYear() - 1, 1, 1));
            movieRentalService.save(movieRental);
        });
    }

    @Test
    public void movieCatalogNotFound() throws Exception {
        when(movieCatalogRepository.findById(eq(1))).thenReturn(Optional.empty());
        Exception exception = assertThrows(MovieCatalogNotFoundException.class, () -> {
            MovieRental movieRental = new MovieRental();
            movieRental.setDate(new Date(new Date().getYear() + 1, 1, 1));
            movieRental.setMovie(movie);
            movieRentalService.save(movieRental);
        });
    }

    @Test
    public void noMoreCopies() throws Exception {
        movieCatalog.setNumberOfCopies(0);
        Exception exception = assertThrows(NoAvailableCopiesException.class, () -> {
            MovieRental movieRental = new MovieRental();
            movieRental.setDate(new Date(new Date().getYear() + 1, 1, 1));
            movieRental.setMovie(movie);
            movieRentalService.save(movieRental);
        });
    }
}
