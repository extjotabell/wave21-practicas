package com.covid19.covid19.controller;

import com.covid19.covid19.DTO.PersonaDTO;
import com.covid19.covid19.model.Persona;
import com.covid19.covid19.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private List<Sintoma> sintoma = new ArrayList<Sintoma>();
    private List<Persona> personas = new ArrayList<Persona>();

    public Controller() {
        Sintoma sintoma1 = new Sintoma("12345","Fiebre","Bajo");
        Sintoma sintoma2 = new Sintoma("12367","Falta del gusto","Intermedio");
        Sintoma sintoma3 = new Sintoma("12378","Diarrea","Avanzado");

        Persona persona1 = new Persona("123","Jose","Duron",24,sintoma1);
        Persona persona2 = new Persona("134","Juan","Araujo",70,sintoma3);

        sintoma.add(sintoma1);
        sintoma.add(sintoma2);
        sintoma.add(sintoma3);
        personas.add(persona1);
        personas.add(persona2);
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List> getSymptom(){
        return new ResponseEntity<>(sintoma,HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSymptom(@PathVariable String name){
        for (Sintoma sintoma: sintoma) {
            if(sintoma.getNombre().equalsIgnoreCase(name)){
                return new ResponseEntity<>(sintoma.getNivelGravedad(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("No se encontro el sintoma",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List> getRiskPerson(){
        List<PersonaDTO> personasEnRiesgo = new ArrayList<>();
        for (Persona persona: personas) {
            if(persona.getEdad() >= 60){
                PersonaDTO personaDTO = new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getSintoma().getNombre());
                personasEnRiesgo.add(personaDTO);
            }
        }
        return new ResponseEntity<>(personasEnRiesgo,HttpStatus.OK);
    }

}
