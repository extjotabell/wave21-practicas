package com.example.ejercicioCovid19.service;

import com.example.ejercicioCovid19.dto.PersonaDTO;
import com.example.ejercicioCovid19.dto.ResponseDTO;
import com.example.ejercicioCovid19.dto.SintomaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    private static List<PersonaDTO> listaPersonas = new ArrayList<>();

    public PersonaService(){
        SintomaDTO s1  = new SintomaDTO(1, "tos", "leve");
        SintomaDTO s2 = new SintomaDTO(2, "vomito", "alta");
        List<SintomaDTO> listadoS = new ArrayList<>();
        List<SintomaDTO> listadoS2 = new ArrayList<>();
        listadoS.add(s1);
        listadoS.add(s2);
        PersonaDTO p1 = new PersonaDTO(1, "pedro", "gonzalez", 32, listadoS);
        PersonaDTO p2 = new PersonaDTO(2, "Juan", "Galindez", 27, listadoS);
        PersonaDTO p3 = new PersonaDTO(3, "Romina", "Sotelo", 70,listadoS);
        PersonaDTO p4 = new PersonaDTO(4, "Roberto", "Martinez", 82, listadoS2);

        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
        listaPersonas.add(p4);
    }

    public List<ResponseDTO> findRiskPerson() {
        List<ResponseDTO> personasRiesgosas = new ArrayList<>();
        for (PersonaDTO persona : listaPersonas) {
            if (persona.getEdad() > 60 && persona.getMisSintomas().size() != 0) {
                personasRiesgosas.add(new ResponseDTO(persona.getNombre(), persona.getApellido()));
            }
        }
        return personasRiesgosas;
    }
}
