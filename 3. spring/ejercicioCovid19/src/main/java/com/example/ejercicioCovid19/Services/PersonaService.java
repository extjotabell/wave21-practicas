package com.example.ejercicioCovid19.Services;

import com.example.ejercicioCovid19.Clases.PersonaDTO;
import com.example.ejercicioCovid19.Clases.ResponseDto;
import com.example.ejercicioCovid19.Clases.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    private static List<PersonaDTO> listaPersonas = new ArrayList<>();

    public PersonaService(){
        Sintoma s1  = new Sintoma(1, "tos", "leve");
        Sintoma s2 = new Sintoma(2, "vomito", "alta");
        List<Sintoma> listadoS = new ArrayList<>();
        List<Sintoma> listadoS2 = new ArrayList<>();
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

    public List<ResponseDto> findRiskPerson() {
        List<ResponseDto> personasRiesgosas = new ArrayList<>();
        for (PersonaDTO persona : listaPersonas) {
            if (persona.getEdad() > 60 && persona.getMisSintomas().size() != 0) {
                personasRiesgosas.add(new ResponseDto(persona.getNombre(), persona.getApellido()));
            }
        }
        return personasRiesgosas;
    }
}
