package com.example.demo.controller;

import com.example.demo.DTO.ErrorDTO;
import com.example.demo.DTO.PlatoDTO;
import com.example.demo.model.Plato;
import com.example.demo.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    PlatoService platoService;

    @RequestMapping()
    public List<Plato> findAll(){
        return platoService.findAll();
    }

    @GetMapping("/{nombrePlato}")
    public ResponseEntity<?> findPlato(@PathVariable String nombrePlato){
        try{
            return ResponseEntity.ok(platoService.findPlato(nombrePlato));
        }catch (NoSuchElementException e){
            ErrorDTO errorResponse = new ErrorDTO("El plato solicitado no existe", HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
