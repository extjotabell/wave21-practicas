package com.hql.ej1.controller;

import com.hql.ej1.model.Genre;
import com.hql.ej1.model.Movie;
import com.hql.ej1.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {
    
    private MovieService movieService;
    
    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @GetMapping("/{rating}")
    public List<Movie> movieRating(@PathVariable Integer rating){
        return movieService.getAllByActorRating(rating);
    }

    @GetMapping("/genre")
    public List<Movie> movieGenre(@RequestBody Genre genre){
        return movieService.getAllByGenre(genre);
    }
}
