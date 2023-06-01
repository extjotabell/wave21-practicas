package com.example.generico.services;

import com.example.generico.DTO.PersonaDTO;
import com.example.generico.DTO.PersonaIdDTO;
import com.example.generico.entity.Persona;
import com.example.generico.entity.PersonaRiesgo;
import com.example.generico.entity.Sintoma;
import com.example.generico.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

public class PersonaService {

  public static PersonaIdDTO crearPersona(PersonaDTO p) {
    Persona persona = new Persona();

    persona.setNombre(p.nombre());
    persona.setApellido(p.apellido());
    persona.setEdad(p.edad());

    return new PersonaIdDTO(PersonaRepository.save(persona));
  }
}
