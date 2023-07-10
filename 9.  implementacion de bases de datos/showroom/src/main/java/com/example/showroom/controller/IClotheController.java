package com.example.showroom.controller;

import com.example.showroom.model.DTO.ClotheDTO;
import com.example.showroom.model.entity.Clothe;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IClotheController {
    @PostMapping
    ResponseEntity<Clothe> save(@RequestBody Clothe clothe);

    @GetMapping
    List<Clothe> findAll();

    @GetMapping("/{id}")
    Clothe findById(@PathVariable Integer id);

    @PutMapping("/{id}")
    Clothe updateById(@PathVariable Integer id, @RequestBody Clothe clothe);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Integer id);

    @GetMapping("/size/{size}")
    List<Clothe> findBySize(@PathVariable String size);

    @GetMapping("/name")
    List<Clothe> findByName(@RequestParam String name);
}
