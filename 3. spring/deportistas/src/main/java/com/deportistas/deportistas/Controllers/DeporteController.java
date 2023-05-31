package com.deportistas.deportistas.Controllers;

import com.deportistas.deportistas.DTOS.Deporte;
import com.deportistas.deportistas.Services.DeporteServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/deporte")
public class DeporteController {
    private DeporteServicio servicio;

    public DeporteController(){
        this.servicio = new DeporteServicio();
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarDeporte(@RequestBody Deporte deporte) {
        System.out.println(deporte);
        servicio.agregarDeporte(deporte);
        return new ResponseEntity<>("Deporte agregado con exito", HttpStatus.OK);
    }

    @GetMapping("/findSports")
    public ResponseEntity<ArrayList<Deporte>> buscarDeportes() {
        return new ResponseEntity<>(servicio.obtenerDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<Deporte> buscarDeportes(@PathVariable String nombre) {
        return new ResponseEntity<>(servicio.obtenerPorNombre(nombre), HttpStatus.OK);
    }

}
