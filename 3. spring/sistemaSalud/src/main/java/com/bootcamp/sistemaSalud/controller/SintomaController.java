package com.bootcamp.sistemaSalud.controller;

import com.bootcamp.sistemaSalud.dto.SintomaDTO;
import com.bootcamp.sistemaSalud.servicio.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {
    SintomaService servicio ;

    public SintomaController(SintomaService ser){
        this.servicio = ser;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> obtenerSintomas(){

        return new ResponseEntity<List<SintomaDTO>>(servicio.getAllSintoms(), HttpStatus.OK);
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> obtenerSintomaPorNombre(@PathVariable String name){
        String nivel = servicio.buscarNivelGravedadPorNombre(name);
        if(nivel.equals(" ") ||nivel == null){
            return new ResponseEntity<String>("SINTOMA NO ENCONTRADO",HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<String>(nivel, HttpStatus.OK);
        }
    }
}
