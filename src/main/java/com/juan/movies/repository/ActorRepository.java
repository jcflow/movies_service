package com.juan.movies.repository;

import com.juan.movies.model.Actor;
import com.juan.movies.model.Movie;
import com.juan.movies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query("SELECT a FROM Actor a WHERE a.id IN :ids")
    List<Actor> findActorsByIds(@Param("ids") List<String> ids);
}
