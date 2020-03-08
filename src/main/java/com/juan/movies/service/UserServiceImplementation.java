package com.juan.movies.service;

import com.juan.movies.controller.exception.MovieNotFoundException;
import com.juan.movies.controller.exception.UserNotFoundException;
import com.juan.movies.model.Movie;
import com.juan.movies.model.User;
import com.juan.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUserName(String username) {
        Optional<User> user = userRepository.findByUserName(username);
        if (!user.isPresent()) {
            throw new UserNotFoundException();
        }
        return user.get();
    }
}
