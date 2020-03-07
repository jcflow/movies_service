package com.juan.movies.repository;

import com.juan.movies.model.Movie;
import com.juan.movies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT m FROM Movie m WHERE m.deleted = false")
    List<Movie> findAllNotDeleted();

    @Query("SELECT u FROM User u WHERE u.name = :username")
    Optional<User> findByUserName(@Param("username") String username);
}
