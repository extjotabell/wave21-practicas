package com.example.generico.services;

import com.example.generico.DTO.PersonaDTO;
import com.example.generico.entity.Persona;
import com.example.generico.repository.PersonaRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class PersonaServices {
  public static List<PersonaDTO> buscarPersonas() {
    return PersonaRepository.get()
      .stream()
      .map(PersonaDTO::new)
      .toList();
  }

  public static PersonaDTO buscarPersonaPorId(Integer id) throws NoSuchElementException {
    PersonaDTO persona = PersonaRepository.findById(id)
      .map(PersonaDTO::new)
      .orElseThrow();

    return persona;
  }

  /**
   * guarda la persona en "DB" y retorna el id
   * @param pDTO
   * @return
   */
  public static Persona crearPersona(PersonaDTO pDTO) {
    Persona p = new Persona();

    p.setNombre(pDTO.nombre());
    p.setApellido(pDTO.apellido());
    p.setEdad(pDTO.edad());

    return PersonaRepository.save(p);
  }
}
