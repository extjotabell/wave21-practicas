package com.moviesdbhql.service;

import com.moviesdbhql.model.dto.ActorsDTO;
import com.moviesdbhql.model.dto.EpisodesDTO;
import com.moviesdbhql.model.dto.MoviesDTO;
import com.moviesdbhql.model.dto.SeriesDTO;
import com.moviesdbhql.model.entities.Actors;
import com.moviesdbhql.model.entities.Episodes;
import com.moviesdbhql.model.entities.Movies;
import com.moviesdbhql.model.entities.Series;
import com.moviesdbhql.repository.GenericRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenericService {

    private GenericRepository repository;

    private ModelMapper mapper;

    public GenericService(GenericRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ResponseEntity<?> getActorsWithFavoriteMovie(){
        List<Actors> response = repository.getActorsWithFavoriteMovie();
        return new ResponseEntity<>(response.stream().map(item -> mapper.map(item,ActorsDTO.class)).toList(), HttpStatus.OK);
    }

    public ResponseEntity<?> getActorsRatingGreaterThanParam(Double rating){
        List<Actors> response = repository.getActorsRatingGreaterThanParam(rating);
        return new ResponseEntity<>(response.stream().map(item -> mapper.map(item,ActorsDTO.class)).toList(), HttpStatus.OK);
    }

    public ResponseEntity<?> getActorsWorkInParam(Long movieId){
        List<Actors> response = repository.getActorsWorkInParam(movieId);
        return new ResponseEntity<>(response.stream().map(item -> mapper.map(item,ActorsDTO.class)).toList(), HttpStatus.OK);
    }

    public ResponseEntity<?> getMoviesWithActorsWithRatingGreaterThanParam(Double rating){
        List<Movies> response = repository.getMoviesWithActorsWithRatingGreaterThanParam(rating);
        return new ResponseEntity<>(response.stream().map(item -> mapper.map(item,MoviesDTO.class)).toList(), HttpStatus.OK);
    }

    public ResponseEntity<?> getMoviesInGenreParam(Long genreId){
        List<Movies>response = repository.getMoviesInGenreParam(genreId);
        return new ResponseEntity<>(response.stream().map(item -> mapper.map(item,MoviesDTO.class)).toList(), HttpStatus.OK);
    }

    public ResponseEntity<?> getSeriesWithSeasonsNumberGreaterThanParam(int seasonsQuantity){
        List<Series> response = repository.getSeriesWithSeasonsNumberGreaterThanParam(seasonsQuantity);
        return new ResponseEntity<>(response.stream().map(item -> mapper.map(item,SeriesDTO.class)).toList(), HttpStatus.OK);
    }

    public ResponseEntity<?> getEpisodesFromAnySeriesWhenActorParamWorks(Long actorId){
        List<Episodes> response = repository.getEpisodesFromAnySeriesWhenActorParamWorks(actorId);
        return new ResponseEntity<>(response.stream().map(item -> mapper.map(item,EpisodesDTO.class)).toList(), HttpStatus.OK);
    }
}