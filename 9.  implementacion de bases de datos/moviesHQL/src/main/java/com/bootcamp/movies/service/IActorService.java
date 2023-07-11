package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.dto.ActorNameDTO;
import com.bootcamp.movies.entity.Actor;

import java.util.List;

public interface IActorService {

    ActorDTO findActorByID(Long id );
    List<ActorDTO> findAllActors();

    List<ActorDTO> findActorByFirst_nameContains(String name);

    List<ActorDTO> findActorByGoodRating();

    List<ActorDTO> findActorByRating(Double rating);
}
