package com.ejercicio6.starwars.repository;

import com.ejercicio6.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepositorio {

    List<Personaje> findAll();
}
