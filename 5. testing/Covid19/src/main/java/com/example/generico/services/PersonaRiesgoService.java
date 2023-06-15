package com.example.generico.services;

import com.example.generico.DTO.*;
import com.example.generico.DTO.response.PersonaRiesgoIdDTO;
import com.example.generico.DTO.response.PersonaRiesgoResponseDTO;
import com.example.generico.Exceptions.InternalErrorException;
import com.example.generico.Exceptions.NoPersonaException;
import com.example.generico.entity.Persona;
import com.example.generico.entity.PersonaRiesgo;
import com.example.generico.entity.Sintoma;
import com.example.generico.repository.PersonaRepository;
import com.example.generico.repository.PersonaRiesgoRepository;
import com.example.generico.repository.SintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaRiesgoService {

  @Autowired
  PersonaRepository personaRepository;

  @Autowired
  PersonaRiesgoRepository personaRiesgoRepository;

  @Autowired
  SintomaRepository sintomaRepository;

  public List<PersonaRiesgoResponseDTO> buscarPersonaRiesgo() {
    return personaRiesgoRepository.getAll()
      .stream()
      .map(PersonaRiesgoResponseDTO::new)
      .toList();
  }

  public List<PersonaRiesgoResponseDTO> buscarPersonaRiesgo(String sintoma) {

    return personaRiesgoRepository.findBySintoma(sintoma)
      .stream()
      .map(PersonaRiesgoResponseDTO::new)
      .toList();
  }

  public PersonaRiesgoIdDTO crearPersonaRiesgo(PersonaRiesgoDTO pr) throws InternalErrorException {
    try {

      Persona p = personaRepository.getByIdRiesgo(pr.personaId()).orElseThrow(NoPersonaException::new);

      List<Sintoma> sintomas = sintomaRepository.obtenerSintomas(pr.sintomasId());
      PersonaRiesgo personaRiesgo = new PersonaRiesgo(p, sintomas);

      return new PersonaRiesgoIdDTO(personaRiesgoRepository.save(personaRiesgo));
    } catch(NoPersonaException e) {
      throw new InternalErrorException("No se encontro la persona");
    } catch(IndexOutOfBoundsException e) {
      throw new InternalErrorException("No se encontro algun sintoma");
    }
  }
}
