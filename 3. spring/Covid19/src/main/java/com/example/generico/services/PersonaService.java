package com.example.generico.services;

import com.example.generico.DTO.PersonaDTO;
import com.example.generico.DTO.response.PersonaIdDTO;
import com.example.generico.entity.Persona;
import com.example.generico.repository.PersonaRepository;

public class PersonaService {

  public static PersonaIdDTO crearPersona(PersonaDTO p) {
    Persona persona = new Persona();

    persona.setNombre(p.nombre());
    persona.setApellido(p.apellido());
    persona.setEdad(p.edad());

    return new PersonaIdDTO(PersonaRepository.save(persona));
  }
}
