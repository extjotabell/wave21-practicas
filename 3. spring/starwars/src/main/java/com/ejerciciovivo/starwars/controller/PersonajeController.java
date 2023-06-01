package com.ejerciciovivo.starwars.controller;

import com.ejerciciovivo.starwars.dto.PersonajeDTO;
import com.ejerciciovivo.starwars.service.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PersonajeController {
    @Autowired
    private Personaje personaje;

    @GetMapping("/{nombre}")
    public ResponseEntity<String> buscar(@PathVariable String nombre) {
        HttpStatus estado = HttpStatus.OK;

        String cuerpo = personaje.buscar(nombre).toString();

        if(cuerpo.equals("[]")){
            cuerpo = "No se encontro un personaje con nombre '"+ nombre+ "'";
            estado = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<String> (cuerpo, estado);
    }

}


