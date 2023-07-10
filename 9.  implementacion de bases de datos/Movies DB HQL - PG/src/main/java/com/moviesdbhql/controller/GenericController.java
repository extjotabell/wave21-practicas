package com.moviesdbhql.controller;

import com.moviesdbhql.service.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {

    private GenericService service;

    public GenericController(GenericService service) {
        this.service = service;
    }

    //Listar todos los actores que tengan declarada una película favorita.
    @GetMapping("/getActorsWithFavoriteMovie")
    public ResponseEntity<?> getActorsWithFavoriteMovie(){
        return service.getActorsWithFavoriteMovie();
    }

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/getActorsRatingGreaterThanParam/{rating}")
    public ResponseEntity<?> getActorsRatingGreaterThanParam(@PathVariable Double rating){
        return service.getActorsRatingGreaterThanParam(rating);
    }

    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @GetMapping("/getActorsWorkInParam/{movieId}")
    public ResponseEntity<?> getActorsWorkInParam(@PathVariable Long movieId){
        return service.getActorsWorkInParam(movieId);
    }

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/getMoviesWithActorsWithRatingGreaterThanParam/{rating}")
    public ResponseEntity<?> getMoviesWithActorsWithRatingGreaterThanParam(@PathVariable Double rating){
        return service.getMoviesWithActorsWithRatingGreaterThanParam(rating);
    }

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @GetMapping("/getMoviesInGenreParam/{genreId}")
    public ResponseEntity<?> getMoviesInGenreParam(@PathVariable Long genreId){
        return service.getMoviesInGenreParam(genreId);
    }

    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @GetMapping("/getSeriesWithSeasonsNumberGreaterThanParam/{seasonsQuantity}")
    public ResponseEntity<?> getSeriesWithSeasonsNumberGreaterThanParam(@PathVariable int seasonsQuantity){
        return service.getSeriesWithSeasonsNumberGreaterThanParam(seasonsQuantity);
    }

    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor
    @GetMapping("/getEpisodesFromAnySeriesWhenActorParamWorks/{actorId}")
    public ResponseEntity<?> getEpisodesFromAnySeriesWhenActorParamWorks(@PathVariable Long actorId){
        return service.getEpisodesFromAnySeriesWhenActorParamWorks(actorId);
    }
}