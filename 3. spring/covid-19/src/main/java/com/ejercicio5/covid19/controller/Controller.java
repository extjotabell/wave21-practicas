package com.ejercicio5.covid19.controller;

import com.ejercicio5.covid19.clases.Persona;
import com.ejercicio5.covid19.clases.Sintoma;
import com.ejercicio5.covid19.dto.RiesgoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    @GetMapping("/findSymptom")
    public ResponseEntity<?> findSymptom(){
        return ResponseEntity.ok(sintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomByName(@PathVariable(value = "name") String name){
        return ResponseEntity.ok(devolverNivelDeGravedad(name));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> findRiskPerson(){
        return ResponseEntity.ok(findRiskPersonByAge());
    }

    private List<RiesgoDTO> findRiskPersonByAge() {
        List<Persona> personas= personas();
        List<Sintoma> sintomas= sintomas();
        RiesgoDTO riesgoDTO= new RiesgoDTO();
        List<Persona> mayoresA60 = personas.stream().filter(persona -> persona.getEdad() > 60).collect(Collectors.toList());

        riesgoDTO.setNombre(mayoresA60.get(0).getNombre());
        riesgoDTO.setApellido(mayoresA60.get(0).getApellido());
        riesgoDTO.setSintomas(sintomas);

        return Arrays.asList(riesgoDTO);
    }

    private List<Persona> personas(){
        Persona persona1= new Persona();
        Persona persona2= new Persona();
        Persona persona3= new Persona();
        persona1.setId(1l);
        persona1.setNombre("Juan");
        persona1.setApellido("Dominguez");
        persona1.setEdad(65);
        persona2.setId(2l);
        persona2.setNombre("Julian");
        persona2.setApellido("Alvarez");
        persona2.setEdad(73);
        persona3.setId(3l);
        persona3.setNombre("Luciano");
        persona3.setApellido("Lattante");
        persona3.setEdad(21);
    }

    private String devolverNivelDeGravedad(String name){
        List<Sintoma> sintomas= sintomas();
        return sintomas.stream()
                .filter(sintoma -> sintoma.getNombre().equals(name))
                .map(sintoma -> sintoma.getNivelDeGravedad())
                .findFirst()
                .get();
    }

    private List<Sintoma> sintomas() {
        Sintoma sintoma1= new Sintoma();
        Sintoma sintoma2= new Sintoma();
        Sintoma sintoma3= new Sintoma();
        sintoma1.setCodigo("1");
        sintoma1.setNombre("Tos");
        sintoma1.setNivelDeGravedad("Casi nulo");
        sintoma2.setCodigo("2");
        sintoma2.setNombre("Fiebre");
        sintoma2.setNivelDeGravedad("Agudo");
        sintoma3.setCodigo("3");
        sintoma3.setNombre("Alucinaciones");
        sintoma3.setNivelDeGravedad("Grave");
    }
}
