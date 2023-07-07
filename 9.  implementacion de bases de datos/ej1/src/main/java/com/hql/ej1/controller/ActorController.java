package com.hql.ej1.controller;

import com.hql.ej1.model.Actor;
import com.hql.ej1.model.Movie;
import com.hql.ej1.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    ActorService actorService;

    public ActorController(ActorService actorService){
        this.actorService=actorService;
    }

    @GetMapping("/favMovie")
    public List<Actor> favMov(){
        return actorService.actorFilteredByNotNullFavMovie();
    }

    @GetMapping("/{rating}")
    public List<Actor> findByHigherRating(@PathVariable Integer rating){
        return actorService.getAllFilteredByRating(rating);
    }

    @GetMapping("/movie")
    public List<Actor> findByMovie(@RequestBody Movie movie){
        return actorService.getAllFilteredByMovie(movie);
    }
}
