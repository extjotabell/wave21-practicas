package com.practicaSpring.ejercicioCovid.controllers;

import com.practicaSpring.ejercicioCovid.model.Persona;
import com.practicaSpring.ejercicioCovid.model.Sintoma;
import com.practicaSpring.ejercicioCovid.dto.SintomaXPersonaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final List<Sintoma> sintomas = new ArrayList<>();
    private final List<Persona> personas = new ArrayList<>();

    public Controller() {
        //Listado de Sintomas
        Sintoma sintoma1 = new Sintoma(1235, "Fiebre", "Alto");
        Sintoma sintoma2 = new Sintoma(1235, "Diarrea", "Medio");
        Sintoma sintoma3 = new Sintoma(2346, "Tos Seca", "Bajo");
        Sintoma sintoma4 = new Sintoma(1234, "Perdida de olfato", "Medio");
        sintomas.add(sintoma1);
        sintomas.add(sintoma2);
        sintomas.add(sintoma3);
        sintomas.add(sintoma4);

        //Listado de Personas
        personas.add(new Persona(123456, "Manuel", "Garcia", 20, sintoma4));
        personas.add(new Persona(456789, "Lorna", "Cepeda", 45, sintoma2));
        personas.add(new Persona(789098, "Julio", "Perez", 66, sintoma1));
        personas.add(new Persona(345673,"Marcela","Lopez",89,sintoma3));

    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> listarSitomas() {
        return new ResponseEntity<>(sintomas, HttpStatus.OK);
    }


    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<String> listarSintomas(@PathVariable String nombre) {

        Sintoma sintomaAEncontrar = sintomas.stream().filter(sintoma -> sintoma.getNombre().equals(nombre)).findFirst().orElse(null);
        if (sintomaAEncontrar != null) {
            return new ResponseEntity<>("El sintoma: " + sintomaAEncontrar.getNombre() +
                    " cuenta con un nivel de gravedad: " + sintomaAEncontrar.getNivelDeGravedad(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El sintoma no fue encontrado!!", HttpStatus.NOT_FOUND);
        }
    }

    //findRiskPerson
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<SintomaXPersonaDTO>> listarSintomasXPersona() {

        List<SintomaXPersonaDTO> personaEnRiesgo = new ArrayList<>();

        for (Persona persona : personas) {
            if (persona.getEdad() >= 60) {
                SintomaXPersonaDTO listaPersona = new SintomaXPersonaDTO(persona.getNombre(),persona.getApellido(),persona.getSintoma().getNombre());
                personaEnRiesgo.add(listaPersona);
            }
        }

        return new ResponseEntity<>(personaEnRiesgo, HttpStatus.OK);
    }

}
