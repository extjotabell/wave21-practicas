package com.example.generico.services;

import com.example.generico.DTO.DeporteDTO;
import com.example.generico.DTO.DeportistaDTO;
import com.example.generico.DTO.PersonaDTO;
import com.example.generico.entity.Deporte;
import com.example.generico.entity.Deportista;
import com.example.generico.entity.Persona;
import com.example.generico.repository.DeportistaRepository;

import java.util.List;

public class DeportistaService {
  public static List<DeportistaDTO> buscarDeportista() {
    return DeportistaRepository.get()
      .stream()
      .map(DeportistaDTO::new)
      .toList();
  }

  public static List<DeportistaDTO> buscarDeportista(String nombre) {
    return DeportistaRepository.get()
      .stream()
      .filter(d -> d.getDeporte().getNombre().equals(nombre))
      .map(DeportistaDTO::new)
      .toList();
  }

  public static Deportista crearDeportista(Persona p, Deporte d) {
    Deportista deportista = new Deportista(p, d);

    return DeportistaRepository.save(deportista);
  }

}
