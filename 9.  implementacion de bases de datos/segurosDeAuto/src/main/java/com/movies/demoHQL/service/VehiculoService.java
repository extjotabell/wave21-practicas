package com.movies.demoHQL.service;

import com.movies.demoHQL.model.Vehiculo;
import com.movies.demoHQL.model.DTO.VehiculoDTO;
import com.movies.demoHQL.model.DTO.SiniestroDTO;
import com.movies.demoHQL.model.Siniestro;
import com.movies.demoHQL.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    IVehiculoRepository repository;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<String> getAllPatentes() {
        return repository.findAllPatentes();
    }
/*
    @Override
    public VehiculoDTO getActorByName(String name) {
        Vehiculo actor = repository.findByFirstName(name);

        return mapper.map(actor, VehiculoDTO.class);
    }

    @Override
    public SiniestroDTO getMovieOfActor(Integer id) {
        Siniestro movie = repository.findMovieOfActor(id);

        return mapper.map(movie, SiniestroDTO.class);
    }


    public ActorMovieResponceDTO getActorWithfavoriteMovie(String name) {
        ActorMovieResponceDTO actorMovie = new ActorMovieResponceDTO();
        VehiculoDTO actor = getActorByName(name);
        SiniestroDTO movie = getMovieOfActor(actor.getFavoriteMovieId());
        actorMovie.setActor(actor);
        actorMovie.setFavoriteMovie(movie);

        return actorMovie;

    }

 */

}