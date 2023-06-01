package com.example.StarWars.service;

import com.example.StarWars.dto.PersonajeDto;
import com.example.StarWars.dto.response.PersonajeResponseDto;
import com.example.StarWars.entity.Personaje;
import com.example.StarWars.repository.StarwarsRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StarwarsServiceImpl implements StarwarsService{
    StarwarsRepositoryImpl repository;

    public StarwarsServiceImpl(StarwarsRepositoryImpl repository) {
        this.repository = repository;
    }

    private static List<PersonajeDto> listPersonajes = new ArrayList<>();
    @Override
    public String saveAll(List<PersonajeDto> dto) {
        List<Personaje> model = dto.stream().map(p -> {
            var personaje = new Personaje();
            personaje.setBirthYear(p.getBirth_year());
            personaje.setGender(p.getGender());
            personaje.setHeight(p.getHeight());
            personaje.setName(p.getName());
            personaje.setSpecies(p.getSpecies());
            personaje.setHomeworld(p.getHomeworld());
            personaje.setSkinColor(p.getSkin_color());
            personaje.setEyeColor(p.getEye_color());
            return personaje;
        }).toList();
        if(repository.saveAll(model)){
            return "Lista cargada con exito";
        }
        return null;
    }

    @Override
    public List<PersonajeResponseDto> findByName(String name) {
        List<Personaje> result = repository.findByName(name);
        return result.stream()
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
    }
}
