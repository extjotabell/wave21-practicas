package com.bootcamp.deportista.controller;

import com.bootcamp.deportista.dto.DeporteDTO;
import com.bootcamp.deportista.dto.DeportistaDTO;
import com.bootcamp.deportista.dto.PersonaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerDeportes {
    List<DeporteDTO> deportes = cargarDeportes();
    List<PersonaDTO> personas = cargarPersonas();


    @GetMapping("/findAllSports")
    public ResponseEntity<List<DeporteDTO>> findAllSports(){
        return new ResponseEntity<List<DeporteDTO>>(deportes, HttpStatus.OK);
    }


    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable("name") String name){
        String nivel = " ";
        for (DeporteDTO deporte : deportes){
            if (name.equals(deporte.getNombre())) {
                nivel = deporte.getNivel();
                break;
            }
        }
        if(nivel.equals(" ")){
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(nivel,HttpStatus.OK);
        }

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons(){
        List<DeportistaDTO> inscripciones = cargarInscripciones();
        return new ResponseEntity<List<DeportistaDTO>>(inscripciones,HttpStatus.OK);

    }

    public List<DeportistaDTO> cargarInscripciones(){

        List<DeportistaDTO> inscripciones = new ArrayList<>();
        DeportistaDTO deportista = new DeportistaDTO();
        deportista.setNombre(personas.get(0).getNombre());
        deportista.setApellido(personas.get(0).getApellido());
        deportista.setDeporte(deportes.get(0).getNombre());
        inscripciones.add(deportista);
        deportista = new DeportistaDTO();
        deportista.setNombre(personas.get(0).getNombre());
        deportista.setApellido(personas.get(0).getApellido());
        deportista.setDeporte(deportes.get(1).getNombre());
        inscripciones.add(deportista);
        deportista = new DeportistaDTO();
        deportista.setNombre(personas.get(1).getNombre());
        deportista.setApellido(personas.get(1).getApellido());
        deportista.setDeporte(deportes.get(0).getNombre());
        inscripciones.add(deportista);
        deportista = new DeportistaDTO();
        deportista.setNombre(personas.get(2).getNombre());
        deportista.setApellido(personas.get(2).getApellido());
        deportista.setDeporte(deportes.get(0).getNombre());
        inscripciones.add(deportista);

        return inscripciones;

    }

    public List<DeporteDTO> cargarDeportes(){
        List<DeporteDTO> deportes = new ArrayList<>();

        deportes.add(new DeporteDTO("futbol","4"));
        deportes.add(new DeporteDTO("gimnasio","5"));
        deportes.add(new DeporteDTO("boxeo","6"));
        deportes.add(new DeporteDTO("natacion","4"));
        deportes.add(new DeporteDTO("zumba","2"));
        return deportes;
    }

    public List<PersonaDTO> cargarPersonas(){
        List<PersonaDTO> personas = new ArrayList<>();
        personas.add(new PersonaDTO("Juan Manuel","Mora",34));
        personas.add(new PersonaDTO("Alan","Brado",33));
        personas.add(new PersonaDTO("Elsa","Bueso",44));
        personas.add(new PersonaDTO("Elton","Yom",23));
        personas.add(new PersonaDTO("Zaira","ta",24));
        return personas;
    }

}
