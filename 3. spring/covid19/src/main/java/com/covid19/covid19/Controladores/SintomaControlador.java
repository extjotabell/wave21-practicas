package com.covid19.covid19.Controladores;

import com.covid19.covid19.DTOS.Sintoma;
import com.covid19.covid19.Servicios.SintomaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/sintoma")
public class SintomaControlador {
    private SintomaServicio servicio;

    public SintomaControlador(){
        this.servicio = new SintomaServicio();
    }

    //Agregar un nuevo sintoma
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarSintoma(@RequestBody Sintoma sintoma) {
        servicio.agregarSintoma(sintoma);
        return new ResponseEntity<>("Sintoma agregado con exito", HttpStatus.OK);
    }

    //Obtener todos los sintomas registrados
    @GetMapping("/sintomas")
    public ResponseEntity<ArrayList<Sintoma>> buscarSintomas() {
        return new ResponseEntity<>(servicio.obtenerSintomas(), HttpStatus.OK);
    }

    //Obtener un sintoma por su nombre
    @GetMapping("/buscarSintoma/{sintoma}")
    public ResponseEntity<Sintoma> buscarSintoma(@PathVariable String sintoma) {
        return new ResponseEntity<>(servicio.obtenerPorNombre(sintoma), HttpStatus.OK);
    }

}
