package com.example.generico.services;

import com.example.generico.DTO.DeporteDTO;
import com.example.generico.entity.Deporte;
import com.example.generico.repository.DeporteRepository;
import com.example.generico.repository.DeportistaRepository;

import java.util.NoSuchElementException;

public class DeporteService {

  public static DeporteDTO buscarDeportePorNombre(String nombre) throws NoSuchElementException {
    return DeportistaRepository.get()
      .stream()
      .filter(d -> d.getDeporte().getNombre().equals(nombre))
      .map(DeporteDTO::new)
      .findFirst()
      .orElseThrow();
  }
  public static Deporte crearDeporte(DeporteDTO deporte) {
    Deporte d = new Deporte();
    d.setNombre(deporte.nombre());
    d.setNivel(deporte.nivel());

    return DeporteRepository.save(d);
  }
}
