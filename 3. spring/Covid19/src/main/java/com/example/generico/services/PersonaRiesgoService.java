package com.example.generico.services;

import com.example.generico.DTO.PersonaRiesgoDTO;
import com.example.generico.DTO.PersonaRiesgoIdDTO;
import com.example.generico.DTO.SintomaDTO;
import com.example.generico.Exceptions.InternalErrorException;
import com.example.generico.Exceptions.NoPersonaException;
import com.example.generico.entity.Persona;
import com.example.generico.entity.PersonaRiesgo;
import com.example.generico.entity.Sintoma;
import com.example.generico.repository.PersonaRepository;
import com.example.generico.repository.PersonaRiesgoRepository;
import com.example.generico.repository.SintomaRepository;

import java.util.List;

public class PersonaRiesgoService {
  public static PersonaRiesgoIdDTO crearPersonaRiesgo(PersonaRiesgoDTO pr) throws InternalErrorException {
    try {
      Persona p = PersonaRepository.getById(pr.personaId()).orElseThrow(NoPersonaException::new);
      List<Sintoma> sintomas = SintomaRepository.obtenerSintomas(pr.sintomasId());

      PersonaRiesgo personaRiesgo = new PersonaRiesgo(p, sintomas);

      return new PersonaRiesgoIdDTO(PersonaRiesgoRepository.save(personaRiesgo));
    } catch(NoPersonaException e) {
      throw new InternalErrorException("No se encontro la persona");
    } catch(IndexOutOfBoundsException e) {
      throw new InternalErrorException("No se encontro algun sintoma");
    }
  }
}
