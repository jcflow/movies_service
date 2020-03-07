package com.juan.movies.service;

import com.juan.movies.model.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActorService {
    List<Actor> findActorsByIds(List<Integer> actors);
}
