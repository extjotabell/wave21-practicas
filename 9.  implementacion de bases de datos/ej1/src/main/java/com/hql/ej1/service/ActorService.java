package com.hql.ej1.service;

import com.hql.ej1.model.Actor;
import com.hql.ej1.model.Movie;
import com.hql.ej1.repository.IActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private IActorRepository actorRepository;

    public ActorService(IActorRepository actorRepository){
        this.actorRepository=actorRepository;
    }

    public List<Actor> actorFilteredByNotNullFavMovie(){
        return actorRepository.getAllByNotNullFavoriteMovie();
    }

    public List<Actor> getAllFilteredByRating(Integer rating){
        return actorRepository.getAllFilteredByHighestRating(rating);
    }

    public List<Actor> getAllFilteredByMovie(Movie movie){
        return actorRepository.getAllByMovie(movie);
    }
}
