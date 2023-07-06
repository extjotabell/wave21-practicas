package com.example.excercise_crud_jpa.controller;

import com.example.excercise_crud_jpa.service.IJoyaService;
import com.example.excercise_crud_jpa.entity.Joya;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JoyaController {

    IJoyaService service;

    public JoyaController(IJoyaService service) {
        this.service = service;
    }

    @PostMapping ("/jewerly/new")
    public ResponseEntity<Long> crearJoya(@RequestBody Joya joya) {
        Joya nuevaJoya = service.saveJoya(joya);
        return ResponseEntity.ok(nuevaJoya.getNro_identificatorio());
    }

    @GetMapping("/jewerly")
    public  ResponseEntity<List<Joya>> findAllJoya() {
        List<Joya> joyaList = service.findAllJoya();
        joyaList.stream()
                .filter(n -> n.getVentaONo().equals(true))
                .collect(Collectors.toList());
        return ResponseEntity.ok(joyaList);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id) {
        Boolean isDelete = service.deleteJoya(id);
        if (isDelete) {
            return new ResponseEntity<>("Fue Borrado", HttpStatus.OK);
        }
        return new ResponseEntity<>("No fue Borrado", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/jewerly/update/{id}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id,
                                        @RequestBody
                                            String nombre,
                                            String material,
                                            Double peso,
                                            String particularidad,
                                            Boolean posee_piedra,
                                            Boolean ventaONo
                                        ) {
        Joya joya = service.findJoya(id);
        joya.setNombre(nombre);
        joya.setMaterial(material);
        joya.setPeso(peso);
        joya.setParticularidad(particularidad);
        joya.setPosee_piedra(posee_piedra);
        joya.setVentaONo(ventaONo);
        service.saveJoya(joya);
        return new ResponseEntity<>("Se actulizo", HttpStatus.OK);
    }

}
