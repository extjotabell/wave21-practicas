package com.example.Deportistas.controller;

import com.example.Deportistas.Deporte;
import com.example.Deportistas.Persona;
import com.example.Deportistas.DeportistaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
public class Controller {
    Deporte d1 = new Deporte("Futbol", "Principiante");
    Deporte d2 = new Deporte("Voley", "Avanzado");

    Persona p1 = new Persona("Juan", "Perez", 30, d1);
    Persona p2 = new Persona("Maria", "Gonzalez", 25, d2);

    private List<Deporte> deportes = Arrays.asList(d1, d2);
    private List<Persona> personas = Arrays.asList(p1, p2);


    @GetMapping({"/findSports"})
    public ResponseEntity<String> findSports()
    {
        String stringResponse = "";
        for (int i = 0; i < deportes.size(); i++)
        {
            stringResponse += deportes.get(i).toString() + ", ";
        }
        return new ResponseEntity<>(stringResponse, HttpStatus.OK);
    }

    @GetMapping({"/findSports/{name}"})
    public ResponseEntity<String> findSportByName (@PathVariable String name)
    {
        String stringResponse = "";
        Optional<Deporte> deporte = deportes.stream().filter(x->x.getNombre().equals(name)).findFirst();
        if (deporte.isPresent()) {
            return new ResponseEntity<>(deporte.get().getNivel(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping({"/findSportsPerson"})
    public ResponseEntity<List<DeportistaDTO>> findSportsByPerson()
    {
        List<DeportistaDTO> retorno = new ArrayList<>();
        for (int i = 0; i<personas.size(); i++)
        {
            Persona p = personas.get(i);
            DeportistaDTO dto = new DeportistaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre());
            retorno.add(dto);
        }
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
