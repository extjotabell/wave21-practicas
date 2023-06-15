package com.example.generico.services;

import com.example.generico.DTO.SintomaDTO;
import com.example.generico.DTO.SintomaIdDTO;
import com.example.generico.DTO.response.SintomaResponseDTO;
import com.example.generico.Exceptions.InternalErrorException;
import com.example.generico.Exceptions.NoPersonaException;
import com.example.generico.Exceptions.NoSintomaException;
import com.example.generico.entity.Sintoma;
import com.example.generico.repository.SintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SintomaService {

  @Autowired
  SintomaRepository sintomaRepository;
  public SintomaResponseDTO buscarSintoma(String nombre) {
    try {

      Optional<Sintoma> sintoma =  this.sintomaRepository.getByName(nombre);

      return sintoma.map(SintomaResponseDTO::new)
        .orElseThrow(NoSintomaException::new);
    } catch(NoSintomaException e) {
      throw new InternalErrorException("No se pudo obtener el sintoma");
    }
  }

  public List<Sintoma> buscarSintomas() {
    return sintomaRepository.getAll();
  }

  public SintomaIdDTO crearSintoma(SintomaDTO s) {
    Sintoma sintoma = new Sintoma();

    sintoma.setNombre(s.nombre());
    sintoma.setGravedad(s.gravedad());
    sintoma.setCodigo(s.codigo());

    return new SintomaIdDTO(sintomaRepository.save(sintoma));
  }
}
