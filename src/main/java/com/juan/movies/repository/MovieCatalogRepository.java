package com.juan.movies.repository;

import com.juan.movies.model.MovieCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCatalogRepository extends JpaRepository<MovieCatalog, Integer> {
}
