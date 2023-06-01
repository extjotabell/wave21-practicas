package com.example.generico.services;

import com.example.generico.DTO.PersonaDTO;
import com.example.generico.entity.Persona;
import com.example.generico.entity.PersonaRiesgo;
import com.example.generico.entity.Sintoma;
import com.example.generico.repository.PersonaRepository;

import java.util.List;

public class PersonaService {

  public static Persona crearPersona(PersonaDTO p) {
    Persona persona = new Persona();

    persona.setNombre(p.nombre());
    persona.setApellido(p.apellido());
    persona.setEdad(p.edad());

    return PersonaRepository.save(persona);
  }

  public static void agregarSintomas(Sintoma s) {
    List<Persona> personasRiesgo = PersonaRepository.buscarPersonaRiesgo();
  }
}
