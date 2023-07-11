package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.dto.ActorNameDTO;
import com.bootcamp.movies.exception.ActorNotFoundException;
import com.bootcamp.movies.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService{

    private IActorRepository actorRepo;
    private ModelMapper mapper;
    public ActorServiceImpl(IActorRepository actorRepo) {
        this.actorRepo = actorRepo;
        this.mapper = new ModelMapper();
    }

    @Override
    public ActorDTO findActorByID(Long id ) {
        return mapper.map(actorRepo.findById(id).orElseThrow(()->new ActorNotFoundException("No actor")), ActorDTO.class);
    }

    @Override
    public List<ActorDTO> findAllActors() {
        return actorRepo.findAll().stream().map(m->mapper.map(m, ActorDTO.class)).toList();
    }

    @Override
    public List<ActorDTO> findActorByFirst_nameContains(String name) {
        return actorRepo.findActorByFirstNameContains(name).stream().map(m->mapper.map(m,ActorDTO.class)).toList();
    }

    @Override
    public List<ActorDTO> findActorByGoodRating() {
        return actorRepo.findActorByGoodRating().stream().map(m->mapper.map(m,ActorDTO.class)).toList();
    }

    @Override
    public List<ActorDTO> findActorByRating(Double rating) {
        return actorRepo.findActorByRatingIsAfterOrderByRating(rating).stream().map(m->mapper.map(m, ActorDTO.class)).toList();
    }
}
