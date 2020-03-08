package com.juan.movies.service;

import com.juan.movies.model.Actor;
import com.juan.movies.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImplementation implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> findActorsByIds(List<Integer> actors) {
        return actorRepository.findActorsByIds(actors);
    }
}
