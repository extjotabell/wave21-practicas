package com.ejercicioSincronico.EjercicioDeportistasDTOResponseEntity.Controllers;

import com.ejercicioSincronico.EjercicioDeportistasDTOResponseEntity.Classes.Deporte;
import com.ejercicioSincronico.EjercicioDeportistasDTOResponseEntity.Classes.Persona;
import com.ejercicioSincronico.EjercicioDeportistasDTOResponseEntity.DTOs.DeporteDTO;
import com.ejercicioSincronico.EjercicioDeportistasDTOResponseEntity.DTOs.PersonaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deportistas/")
public class DeportistasController {

    private List<Persona> personas = new ArrayList<>();

    private List<Deporte> deportes = new ArrayList<>();

    public DeportistasController() {
        personas.add(new Persona("Juan", "Perez", 25, 1));
        personas.add(new Persona("María", "Gomez", 30, 2));
        personas.add(new Persona("Pedro", "Lopez", 28, 3));
        personas.add(new Persona("Laura", "Fernandez", 22, 1));
        personas.add(new Persona("Carlos", "Rodriguez", 35, 2));
        deportes.add(new Deporte(1, "Fútbol", "Profesional"));
        deportes.add(new Deporte(2, "Tenis", "Amateur"));
        deportes.add(new Deporte(3, "Basket", "Profesional"));
        deportes.add(new Deporte(4, "Natacion", "Amateur"));
        deportes.add(new Deporte(5, "Atletismo", "Profesional"));
    }

    // Endpoint que retorna los deportes existentes.
    @GetMapping("findSports")
    public ResponseEntity<List<DeporteDTO>> obtenerDeportes(){

        List<DeporteDTO> deporteDtos = deportes.stream()
                .map(x -> new DeporteDTO(x.getNombre(), x.getNivel())).collect(Collectors.toList()
                );

        return ResponseEntity.status(HttpStatus.OK).body(deporteDtos);
    }
    @GetMapping("findSport/{nombre}")
    public ResponseEntity<String> obtenerDeportePorNombre(@PathVariable String nombre){

        HttpStatus status = HttpStatus.OK;
        var body = "";

        String respuesta = deportes.stream()
                            .map(Deporte::getNombre)
                            .filter(deporteNombre -> deporteNombre.equalsIgnoreCase(nombre))
                            .findFirst()
                            .orElse(null);

        if (respuesta != null){
            body = respuesta;
        }
        else{
            body = "El deporte "+ nombre +" no se encuentra cargado";
            status = HttpStatus.NOT_FOUND;
        }

        return  ResponseEntity.status(status).body(body);

        /*
        Opcion 1
        return respuesta == null
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("El deporte "+ nombre +" no se encuentra cargado")
                : ResponseEntity.ok(respuesta);
        */

        /*
        Opcion 2
        if (respuesta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El deporte " + nombre + " no se encuentra cargado");
        } else {
            return ResponseEntity.ok(respuesta);
        }*/
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> obtenerDeportistas(){
        List<PersonaDTO> deportistas = new ArrayList<>();

        // Recorros todas las personas creando PersonaDTO y agregandolos a la lista de Deportistas.
        personas.forEach(
                persona -> {
                    String d = obtenerDeportePorId(persona.getDeporteId());
                    if (d != null){
                        deportistas.add(new PersonaDTO(persona.getNombre(), persona.getApellido(), d));
                    }
                }
        );

        return  ResponseEntity.status(HttpStatus.OK).body(deportistas);
    }

    // Metodo para obtener el nombre del deporte segun su Id
    private String obtenerDeportePorId(int deporteId) {
        return deportes.stream()
                .filter(d -> d.getId() == deporteId)
                .map(Deporte::getNombre)
                .findFirst()
                .orElse(null);
    }
}
