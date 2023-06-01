package com.covid19.covid;

import com.covid19.covid.DTO.PersonaDTO;
import com.covid19.covid.DTO.SintomaDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class Controlador {


    List<Sintoma> sintomas = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    {
        System.out.println("---- CARGA DE DATOS ----- ");

        Persona p1 = new Persona(1, "Mercedes", "Magnelli", 23, new ArrayList<>());
        Persona p2 = new Persona(2, "Pepito", "Suarez", 67, new ArrayList<>());
        Persona p3 = new Persona(3, "Lolo", "Perez", 45, new ArrayList<>());

        Sintoma s1 = new Sintoma(1, "tos", 1);
        Sintoma s2 = new Sintoma(2, "mocos", 2);
        Sintoma s3 = new Sintoma(3, "fiebre", 4);
        Sintoma s4 = new Sintoma(3, "picazon", 3);


        personas.addAll(Arrays.asList(p1,p2,p3));
        sintomas.addAll(Arrays.asList(s1,s2,s3,s4));

        p1.getSintomas().add(s1);
        p1.getSintomas().add(s3);

        p2.getSintomas().add(s2);

        p3.getSintomas().add(s1);
        p3.getSintomas().add(s4);





    }

    @GetMapping("/sintomas")
    public ResponseEntity<List<SintomaDTO>> encontrarSintomas(){

       List<SintomaDTO> sintomasDTO = new ArrayList<>();
        for (int i = 0; i < sintomas.size()-1; i++) {
            Sintoma sintomaAux = sintomas.get(i);
            sintomasDTO.add(new SintomaDTO(sintomaAux.getCodigo(), sintomaAux.getNombre(), sintomaAux.getNivel_de_gravedad()));
        }
        return ResponseEntity.ok(sintomasDTO);

    }

    @GetMapping("/sintomas/{nombre}")
    public ResponseEntity<String> encontrarNivelGravedad(@PathVariable String nombre) {

        Optional<Sintoma> sintomaEncontrado = sintomas.stream().filter(s -> s.getNombre() == nombre).findAny();

        String nivelGravedad = "NO SE ENCONTRO EL SINTOMA";

        if(sintomaEncontrado.isPresent()) nivelGravedad = String.valueOf(sintomaEncontrado.get().getNivel_de_gravedad());


        return ResponseEntity.ok(nivelGravedad);
    }

    @GetMapping("/personasRiesgo")
    public ResponseEntity<List<PersonaDTO>> obtenerPersonasRiesgo() {

        List<PersonaDTO> personasDeRiesgo = new ArrayList<>();

        for (int i = 0; i < personas.size()-1; i++) {

            Persona aux = personas.get(i);
            if(aux.getEdad() >=60 && aux.getSintomas().size() >=1 ) {
                PersonaDTO riesgosa = new PersonaDTO(aux.getNombre(), aux.getApellido());
                personasDeRiesgo.add(riesgosa);
            }


        }

        return ResponseEntity.ok(personasDeRiesgo);
    }


}
