package com.juan.movies.service;

import com.juan.movies.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByUserName(String username);
}
