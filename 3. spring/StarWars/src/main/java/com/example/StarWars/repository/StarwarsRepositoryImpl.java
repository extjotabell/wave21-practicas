package com.example.StarWars.repository;

import com.example.StarWars.dto.PersonajeDto;
import com.example.StarWars.dto.response.PersonajeResponseDto;
import com.example.StarWars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StarwarsRepositoryImpl implements StarwarsRepository{
    private static List<Personaje> listPersonajes = new ArrayList<>();

    @Override
    public boolean saveAll(List<Personaje> model) {
        if(model.size() != 0){
            listPersonajes = model;
            return true;
        }
        return false;
    }

    @Override
    public List<Personaje> findByName(String name) {
        List<Personaje> result = listPersonajes.stream()
                .filter(p -> {
                    String nameP = p.getName().split(" ")[0];
                    return nameP.toLowerCase().equals(name.toLowerCase());
                })
                .toList();
        return result;
    }
}
