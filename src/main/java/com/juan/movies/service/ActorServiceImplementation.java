package com.juan.movies.service;

import com.juan.movies.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImplementation implements ActorService {
    @Autowired
    private ActorRepository actorRepository;
}
