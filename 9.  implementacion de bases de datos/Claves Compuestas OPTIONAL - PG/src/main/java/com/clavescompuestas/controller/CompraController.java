package com.clavescompuestas.controller;

import com.clavescompuestas.dto.CompraDTO;
import com.clavescompuestas.model.Compra;
import com.clavescompuestas.repository.CompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private CompraRepository repository;

    private ModelMapper mapper;

    public CompraController(CompraRepository repository, ModelMapper mapper) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @PostMapping("/save")
    public ResponseEntity<?> createCompra(@RequestBody CompraDTO compraDTO){
        Compra compra = mapper.map(compraDTO, Compra.class);
        Compra result = repository.save(compra);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}