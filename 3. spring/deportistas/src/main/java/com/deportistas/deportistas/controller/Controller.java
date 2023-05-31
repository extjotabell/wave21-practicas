package com.deportistas.deportistas.controller;

import com.deportistas.deportistas.DTO.PersonaDTO;
import com.deportistas.deportistas.model.Deporte;
import com.deportistas.deportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private List<Deporte> deportes = new ArrayList<Deporte>();
    private List<Persona> personas = new ArrayList<Persona>();

    public Controller() {

        Deporte deporte1 = new Deporte("Futbol","Avanzado");
        Deporte deporte2 = new Deporte("Tenis","Intermedio");

        Persona persona1 = new Persona("Jose","Duron",24,deporte1);
        Persona persona2 = new Persona("Juan","Araujo",23,deporte2);

        deportes.add(deporte1);
        deportes.add(deporte2);
        personas.add(persona1);
        personas.add(persona2);

    }

    @GetMapping("/findSports")
    public ResponseEntity<List> getDeportes(){
        return new ResponseEntity<>(deportes,HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getDeporte(@PathVariable String name){
        for (Deporte deporte: deportes) {
            if(deporte.getNombre().equalsIgnoreCase(name)){
                return new ResponseEntity<>(deporte.getNivel(),HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("No se encontro el deporte",HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public List<PersonaDTO> getSportPersons(){
        List<PersonaDTO> personasDeportistas = new ArrayList<>();
        for (Persona persona: personas) {
            PersonaDTO personaDTO = new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre());
            personasDeportistas.add(personaDTO);
        }
        return personasDeportistas;
    }

}
