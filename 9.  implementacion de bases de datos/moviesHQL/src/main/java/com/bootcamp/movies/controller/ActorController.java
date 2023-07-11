package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.service.IActorService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> getActorByID(@PathVariable Long id){
        return ResponseEntity.ok(actorService.findActorByID(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllActors(){

        return ResponseEntity.ok(actorService.findAllActors());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getActorByName(@PathVariable String name){
        return ResponseEntity.ok(actorService.findActorByFirst_nameContains(name));
    }
    @GetMapping("/goodrating")
    public ResponseEntity<?> getActorWithGoodRating(){

        return ResponseEntity.ok(actorService.findActorByGoodRating());
    }


    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> getActorWithRating(@PathVariable Double rating){

        return ResponseEntity.ok(actorService.findActorByRating(rating));
    }
}
