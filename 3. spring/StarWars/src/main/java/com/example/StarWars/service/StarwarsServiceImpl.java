package com.example.StarWars.service;

import com.example.StarWars.dto.PersonajeDto;
import com.example.StarWars.dto.response.PersonajeResponseDto;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
@Service
public class StarwarsServiceImpl implements StarwarsService{
    private static List<PersonajeDto> listPersonajes = new ArrayList<>();
    @Override
    public String saveAll(List<PersonajeDto> dto) {
        if(dto.size() != 0){
            listPersonajes = dto;
            return "Lista cargada con exito";
        }
        return null;
    }

    @Override
    public List<PersonajeResponseDto> findByName(String name) {
        List<PersonajeResponseDto> result = (List<PersonajeResponseDto>) listPersonajes.stream()
                .filter(p -> p.getName().equals(name))
                .map(p -> {
                    PersonajeResponseDto personaje = new PersonajeResponseDto(
                            p.getName(),
                            p.getHeight(),
                            p.getMass(),
                            p.getGender(),
                            p.getHomeworld(),
                            p.getSpecies()
                    );
                    return personaje;
                })
                .toList();

        return result;
    }
}
