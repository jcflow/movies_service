package com.juan.movies.repository;

import com.juan.movies.model.MovieCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCatalogRepository extends JpaRepository<MovieCatalog, Integer> {
}
