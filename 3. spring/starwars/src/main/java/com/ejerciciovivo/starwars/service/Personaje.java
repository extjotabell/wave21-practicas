package com.ejerciciovivo.starwars.service;

import com.ejerciciovivo.starwars.dto.PersonajeDTO;
import com.ejerciciovivo.starwars.repository.RepositorioPersonaje;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class Personaje {
    private RepositorioPersonaje repo;

    public Personaje(RepositorioPersonaje repo) {
        this.repo = repo;
    }

    public List<PersonajeDTO> buscar(String nombre) {
        return repo.buscarPorNombre(nombre);
    }
}

