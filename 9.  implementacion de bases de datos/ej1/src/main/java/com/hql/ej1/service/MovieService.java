package com.hql.ej1.service;

import com.hql.ej1.model.Genre;
import com.hql.ej1.model.Movie;
import com.hql.ej1.repository.IMovieRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovieService {

    private IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    public List<Movie> getAllByActorRating(Integer rating){
        return movieRepository.getAllByActorRating(rating);
    }

    public List<Movie> getAllByGenre(Genre genre){
        return movieRepository.getAllByGenre(genre);
    }
}

