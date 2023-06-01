package com.example.generico.services;

import com.example.generico.DTO.SintomaDTO;
import com.example.generico.DTO.response.SintomaResponseDTO;
import com.example.generico.Exceptions.InternalErrorException;
import com.example.generico.Exceptions.NoPersonaException;
import com.example.generico.Exceptions.NoSintomaException;
import com.example.generico.entity.Sintoma;
import com.example.generico.repository.SintomaRepository;

import java.util.List;

public class SintomaService {
  public static SintomaResponseDTO buscarSintoma(String nombre) {
    try {

      return SintomaRepository.getByName(nombre)
        .map(SintomaResponseDTO::new)
        .orElseThrow(NoSintomaException::new);
    } catch(NoSintomaException e) {
      throw new InternalErrorException("No se pudo obtener el sintoma");
    }
  }

  public static List<Sintoma> buscarSintomas() {
    return SintomaRepository.getAll();
  }

  public static Sintoma crearSintoma(SintomaDTO s) {
    Sintoma sintoma = new Sintoma();

    sintoma.setNombre(s.nombre());
    sintoma.setGravedad(s.gravedad());
    sintoma.setCodigo(s.codigo());

    return SintomaRepository.save(sintoma);
  }
}
