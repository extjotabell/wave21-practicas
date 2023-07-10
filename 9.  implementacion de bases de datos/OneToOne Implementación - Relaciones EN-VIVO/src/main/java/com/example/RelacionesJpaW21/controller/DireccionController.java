package com.example.RelacionesJpaW21.controller;

import com.example.RelacionesJpaW21.entity.OneToOne.Address;
import com.example.RelacionesJpaW21.repository.IDireccionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direccion")
public class DireccionController {

    private IDireccionRepository repository;

    public DireccionController(IDireccionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> createDireccion(@RequestBody Address direccion){
        return new ResponseEntity<>(repository.save(direccion), HttpStatus.CREATED);
    }
}
