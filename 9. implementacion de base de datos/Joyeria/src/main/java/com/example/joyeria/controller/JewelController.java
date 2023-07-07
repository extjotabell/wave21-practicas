package com.example.joyeria.controller;

import com.example.joyeria.dto.JewelCreationDTO;
import com.example.joyeria.dto.JewelDTO;
import com.example.joyeria.service.JewelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {
    private final JewelService jewelService;
    
    public JewelController(JewelService jewelService){
        this.jewelService = jewelService;
    }
    
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody JewelCreationDTO jewelCreationDTO){
        return ResponseEntity.ok(jewelService.create(jewelCreationDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<?>> getAll(){
        return ResponseEntity.ok(jewelService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        jewelService.delete(id);
        return ResponseEntity.ok("");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody JewelDTO jewelDTO){
        return ResponseEntity.ok(jewelService.update(id, jewelDTO));
    }
}
