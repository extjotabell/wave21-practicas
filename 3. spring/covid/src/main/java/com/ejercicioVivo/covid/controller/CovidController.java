package com.ejercicioVivo.covid.controller;

import com.ejercicioVivo.covid.dto.PersonaDTO;
import com.ejercicioVivo.covid.dto.SintomaDTO;
import com.ejercicioVivo.covid.service.Persona;
import com.ejercicioVivo.covid.service.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*Nuestra aplicación deberá contar con la siguiente funcionalidad:

Ver todos los síntomas que tenemos cargados.
PATH: /findSymptom


Consultar si existe un síntoma ingresando su nombre. De existir, se deberá mostrar el nivel de gravedad del mismo. Utilizar la clase ResponseEntity para devolver la respuesta.
PATH: /findSymptom/{name}

Visualizar a las personas que puedan ser del grupo de riesgo. Para ello, necesitamos visualizar un listado con el nombre y el apellido de aquellas personas mayores de 60 años que puedan poseer al menos un síntoma asociado. Como para la respuesta de esta consulta habrá que tener en cuenta la relación entre las dos tablas, se recomienda utilizar el patrón DTO.
PATH: /findRiskPerson
*/
@RestController
public class CovidController {
    private ArrayList<Persona> personas = new ArrayList<>();
    private ArrayList<Sintoma> sintomas = new ArrayList<>();
    private HashMap<String, String> enfermos = new HashMap<>();

    public CovidController() {
        personas.add(new Persona("Juan", "Perez", 21, 1));
        personas.add(new Persona("Jose", "Perez", 70, 2));
        personas.add(new Persona("Ricardo", "Perez", 70, 4));
        personas.add(new Persona("Pedro", "Perez", 60, 3));

        sintomas.add(new Sintoma("tos", 1, 1));
        sintomas.add(new Sintoma("fiebre", 2, 3));
        sintomas.add(new Sintoma("pulmonia", 3, 9));

        enfermos.put("Jose", "tos");
        enfermos.put("Pedro", "fiebre");

    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<String> sintomasFiltrados(@PathVariable String nombre){
        HttpStatus codigo = HttpStatus.OK;
        var cuerpo = "";

       Sintoma respuesta = sintomas.stream()
                .filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        if (respuesta != null){
            cuerpo = "El nivel de gravedad del sintoma '" + nombre + "' es de " + respuesta.getNivelDeGravedad();
        }
        else{
            cuerpo = "No se puedo encontrar un sintoma con el nombre:  " + nombre;
            codigo = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(cuerpo, codigo);
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<String> sintomas(){
        List<SintomaDTO> sintomasDTO = sintomas.stream()
                .map(sintoma -> new SintomaDTO(sintoma.getNombre(), sintoma.getCodigo(), sintoma.getNivelDeGravedad()))
                .collect(Collectors.toList());
        return new ResponseEntity(sintomasDTO, HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<String> personasRiesgo(){
        List<PersonaDTO> personasDTO = personas.stream().filter(persona -> persona.getEdad() > 60 && enfermos.containsKey(persona.getNombre()))
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido()))
                .collect(Collectors.toList());


        return new ResponseEntity(personasDTO, HttpStatus.OK);
    }
}
