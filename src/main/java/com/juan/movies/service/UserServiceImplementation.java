package com.juan.movies.service;

import com.juan.movies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserService userService;
    @Override
    public User findByUserName(String username) {
        return userService.findByUserName(username);
    }
}
