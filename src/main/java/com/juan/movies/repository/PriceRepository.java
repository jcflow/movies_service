package com.juan.movies.repository;

import com.juan.movies.model.Movie;
import com.juan.movies.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
}
