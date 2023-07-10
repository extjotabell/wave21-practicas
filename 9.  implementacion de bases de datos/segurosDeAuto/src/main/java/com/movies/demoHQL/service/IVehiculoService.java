package com.movies.demoHQL.service;

import com.movies.demoHQL.model.DTO.VehiculoDTO;
import com.movies.demoHQL.model.DTO.SiniestroDTO;

import java.util.List;

public interface IVehiculoService {

    List<String> getAllPatentes();

    List<String> getAllPatentesandMarca();

/*
    List<VehiculoDTO> getAllActors();

    VehiculoDTO getActorByName(String name);

    SiniestroDTO getMovieOfActor(Integer id);

    public ActorMovieResponceDTO getActorWithfavoriteMovie(String name);

 */
}
