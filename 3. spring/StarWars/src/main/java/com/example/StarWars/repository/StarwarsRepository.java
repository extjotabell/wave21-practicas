package com.example.StarWars.repository;

import com.example.StarWars.dto.PersonajeDto;
import com.example.StarWars.dto.response.PersonajeResponseDto;
import com.example.StarWars.entity.Personaje;

import java.util.List;

public interface StarwarsRepository {
    public boolean saveAll(List<Personaje> model);
    public List<Personaje> findByName(String name);
}
