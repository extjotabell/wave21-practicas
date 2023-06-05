package com.example.Deportistas.controller;

import com.example.Deportistas.Deporte;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class deportistasController {
    List <Deporte> deportesDisponibles = new ArrayList<Deporte>();
    @GetMapping("/findSports")
    public List<Deporte> findSports(){
        return this.deportesDisponibles;
    }
}
