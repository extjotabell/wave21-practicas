package com.ejerciciovivo.starwars.repository;

import com.ejerciciovivo.starwars.dto.PersonajeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositorioPersonaje {

    private ArrayList<PersonajeDTO> personajes;

    public RepositorioPersonaje() {
        cargarPersonajes();
    }

    public List<PersonajeDTO> buscarPorNombre(String nombre) {
        return personajes.stream()
                .filter(personajeDTO -> personajeDTO.getName().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    private void cargarPersonajes() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<PersonajeDTO>> typeRef = new TypeReference<>() {};
        ArrayList<PersonajeDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        personajes =  characters;
    }


}
