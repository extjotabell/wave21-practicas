package com.ejercicio4.deportistas.controller;

import com.ejercicio4.deportistas.clases.Deporte;
import com.ejercicio4.deportistas.clases.Persona;
import com.ejercicio4.deportistas.dto.PersonaDeportistaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {
    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){
        return ResponseEntity.ok(sports());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<?> findSportsByName(@PathVariable(value = "name")String name){
        return ResponseEntity.ok(findSportLevel(name));
    }

    @GetMapping("/findSportsPerson")
    public ResponseEntity<?> findSportPerson(){
        return ResponseEntity.ok(findSportPeople());
    }

    private List<PersonaDeportistaDTO> findSportPeople() {
        List<Deporte> deportes= sports();
        List<Persona> personas= personas();

        PersonaDeportistaDTO personaDeportista1= new PersonaDeportistaDTO(personas.get(0).getNombre(),personas.get(0).getApellido(),deportes.get(1).getNombre());
        PersonaDeportistaDTO personaDeportista2= new PersonaDeportistaDTO(personas.get(1).getNombre(),personas.get(1).getApellido(),deportes.get(0).getNombre());

        return Arrays.asList(personaDeportista1,personaDeportista2);    
    }

    private List<Persona> personas() {
        Persona persona1= new Persona("Roman","Riquelme",14);
        Persona persona2= new Persona("Martin","Palermo",32);
        Persona persona3= new Persona("Javier","Mascherano",23);
        return Arrays.asList(persona1,persona2,persona3);
    }

    private Integer findSportLevel(String name) {
        return sports().stream().filter(sport-> sport.getNombre().equals(name)).map(sport-> sport.getNivel()).findFirst().orElse(null);
    }

    private List<Deporte> sports() {
        Deporte deporte1=new Deporte("Basquet",2);
        Deporte deporte2= new Deporte("Futbol",1);
        Deporte deporte3= new Deporte("Criket",3);
        return Arrays.asList(deporte1,deporte2,deporte3);
    }
}
