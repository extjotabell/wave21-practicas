package com.example.generico.controller;

import com.example.generico.DTO.DeportistaDTO;
import com.example.generico.entity.Deporte;
import com.example.generico.entity.Deportista;
import com.example.generico.entity.Persona;
import com.example.generico.services.DeporteService;
import com.example.generico.services.DeportistaService;
import com.example.generico.services.PersonaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DeportistaController {
  @GetMapping("/deportistas")
  public ResponseEntity<List<DeportistaDTO>> buscarDeportistas(@RequestParam Optional<String> deporte) {

    List<DeportistaDTO> dd = deporte
      .map(DeportistaService::buscarDeportista)
      .orElseGet(DeportistaService::buscarDeportista);

    return new ResponseEntity<>(dd, HttpStatus.OK);
  }

  @PostMapping("/deportista")
  public ResponseEntity<Integer> crearDeportista(@RequestBody DeportistaDTO deportista) {
    // TODO validar datos de la persona y deporte

    Persona p = PersonaServices.crearPersona(deportista.persona());
    Deporte d = DeporteService.crearDeporte(deportista.deporte());

    Deportista dep = DeportistaService.crearDeportista(p, d);

    return new ResponseEntity<>(dep.getId(), HttpStatus.OK);
  }
}
