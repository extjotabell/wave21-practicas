package com.example.StarWars.service;

import com.example.StarWars.dto.PersonajeDto;
import com.example.StarWars.dto.response.PersonajeResponseDto;

import java.util.List;

public interface StarwarsService {
    public String saveAll(List<PersonajeDto> dto);
    public List<PersonajeResponseDto> findByName(String name);
}
