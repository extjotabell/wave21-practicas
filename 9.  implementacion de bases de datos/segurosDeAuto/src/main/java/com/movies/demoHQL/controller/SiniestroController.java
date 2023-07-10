package com.movies.demoHQL.controller;

import com.movies.demoHQL.model.DTO.SiniestroDTO;
import com.movies.demoHQL.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SiniestroController {
/*
    @Autowired
    ISiniestroService service;

    @GetMapping("/movies")
    public List<SiniestroDTO> getMoviesByTLike(@Nullable @RequestParam String titleLike) {
        return titleLike == null ? service.getAllMovies() : service.getMoviesByTitleLike(titleLike);
    }

    @GetMapping("/moviesByRatingGreaterThan")
    public List<SiniestroDTO> getMoviesByRatingGreaterThan(@RequestParam Double lowerBound) {
        return service.getMoviesByRatingGreaterThan(lowerBound);
    }

    @GetMapping("/moviesByAwardsGreaterThan")
    public List<SiniestroDTO> getMoviesByAwardsGreaterThan(@RequestParam Integer awards) {
        return service.getMoviesByAwardsGreaterThan(awards);
    }
*/
}
