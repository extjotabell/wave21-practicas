package com.example.ejercicioDeportistasDTO.Controller;

import com.example.ejercicioDeportistasDTO.Clases.Deporte;
import com.example.ejercicioDeportistasDTO.DTOS.ResponseDTO;
import com.example.ejercicioDeportistasDTO.Repository.RepositorioDeportes;
import com.example.ejercicioDeportistasDTO.Repository.RepositorioPersonas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    @Autowired
    RepositorioDeportes repositorioDeportes = new RepositorioDeportes();
    RepositorioPersonas repositorioPersonas = new RepositorioPersonas();

    @GetMapping("/findSports")
    public List<Deporte> findSports() {

        return repositorioDeportes.getListaDeportes();
    }

    @GetMapping("/findSport/{name}")

    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        Deporte deporteEncontrado = repositorioDeportes.getListaDeportes().stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);

        String fraseFinal =
                "La dificultad del Deporte: " + deporteEncontrado.getNombre() + " es: " + deporteEncontrado.getNivel();
        return new ResponseEntity(fraseFinal, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")

    public List<ResponseDTO> listaDeDeportistas() {
        List<ResponseDTO> listado = repositorioPersonas.getListaPersonas().stream()
                .filter(persona -> persona.getMiDeporte().getNombre() != null)
                .map(persona -> new ResponseDTO(persona.getNombre(), persona.getApellido(), persona.getMiDeporte().getNombre()))
                .toList();

        return listado;
    }
}
