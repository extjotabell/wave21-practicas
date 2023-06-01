package com.example.demo.controller;

import com.example.demo.DTO.PlatoDTO;
import com.example.demo.model.Plato;
import com.example.demo.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    PlatoService platoService;

    @RequestMapping("/all")
    public List<Plato> findAll(){
        return platoService.findAll();
    }

    @GetMapping("/{nombrePlato}")
    public ResponseEntity<PlatoDTO> findPlato(@PathVariable String nombrePlato){
        return ResponseEntity.ok(platoService.findPlato(nombrePlato));
    }
}
