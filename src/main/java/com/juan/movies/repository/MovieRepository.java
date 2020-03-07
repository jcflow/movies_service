package com.juan.movies.repository;

import com.juan.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m WHERE m.deleted = false")
    List<Movie> findAllNotDeleted();
}
