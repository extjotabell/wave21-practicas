package com.movies.demoHQL.controller;

import com.movies.demoHQL.model.DTO.VehiculoDTO;
import com.movies.demoHQL.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculoController {

    @Autowired
    IVehiculoService service;

    @GetMapping("/patentes")
    public List<String> getPatentes(){
        return service.getAllPatentes();
    }

    @GetMapping("/patentesymarcas")
    public List<String> getPatentesymarcas(){
        return service.getAllPatentesandMarca();
    }
/*
    @GetMapping("/actorbyname")
    public VehiculoDTO getActorByName(@RequestParam String name){
        return service.getActorByName(name);
    }

    @GetMapping("/actormovie")
    public

    ActorMovieResponceDTO getActorWithfavoriteMovie (@RequestParam String name){

        return service.getActorWithfavoriteMovie(name);
    }
*/


}
