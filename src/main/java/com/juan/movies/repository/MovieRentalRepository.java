package com.juan.movies.repository;

import com.juan.movies.model.MovieRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieRentalRepository extends JpaRepository<MovieRental, Integer> {
    @Query("SELECT mr.returnedDate FROM MovieRental mr WHERE mr.movie = :movieId ORDER BY mr.returnedDate DESC")
    List<Date> findReturnedDatesByMovieId(@Param("movieId") int movieId);
}
