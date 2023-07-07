package com.movies.demoHQL.service;

import com.movies.demoHQL.model.Siniestro;
import com.movies.demoHQL.model.DTO.SiniestroDTO;
import com.movies.demoHQL.repository.ISiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiniestroService implements ISiniestroService {
/*
    @Autowired
    ISiniestroRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ModelMapper mapper;



    @Override
    public List<SiniestroDTO> getAllMovies() {
        List<Siniestro> movies = repository.findAll();       //Usando JPA
        //List<Movie> movies = repository.findAllMovies();   //Usando HQL

        return movies.stream().map(movie -> mapper.map(movie, SiniestroDTO.class)).collect(Collectors.toList());
    }


    // COMO SI HACERLO :)
    @Override
    public List<SiniestroDTO> getMoviesByTitleLike(String title) {
        List<Siniestro> movies = repository.findMoviesByTitleLike(title);

        return movies.stream().map(movie -> mapper.map(movie, SiniestroDTO.class)).collect(Collectors.toList());
    }


    // COMO NO HACERLO 1! >:c
    @Override
    public List<SiniestroDTO> getMoviesByRatingGreaterThan(Double bound) {
        List<?> movies =    entityManager.createQuery("select m from Movie m where m.rating > ?1")
                            .setParameter(1, bound)
                            .getResultList();

        return movies.stream()
                .map(movie -> mapper.map(movie, SiniestroDTO.class))
                .collect(Collectors.toList());
    }


    // COMO NO HACERLO 2! >:c
    @Override
    public List<SiniestroDTO> getMoviesByAwardsGreaterThan(Integer awards) {
        TypedQuery<Siniestro> query = entityManager.createNamedQuery("MoviesByAwardsGreaterThan", Siniestro.class);
                            query.setParameter("awards", awards);
        List<Siniestro> movies = query.getResultList();

        return movies.stream().map(movie -> mapper.map(movie, SiniestroDTO.class)).collect(Collectors.toList());
    }

     */
}
