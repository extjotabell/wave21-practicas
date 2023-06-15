package com.example.generico.services;

import com.example.generico.DTO.PersonaDTO;
import com.example.generico.DTO.response.PersonaIdDTO;
import com.example.generico.entity.Persona;
import com.example.generico.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

  @Autowired
  PersonaRepository personaRepository;

  public PersonaIdDTO crearPersona(PersonaDTO p) {
    Persona persona = new Persona();

    persona.setNombre(p.nombre());
    persona.setApellido(p.apellido());
    persona.setEdad(p.edad());

    return new PersonaIdDTO(personaRepository.save(persona));
  }
}
