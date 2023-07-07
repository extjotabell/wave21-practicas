package com.example.joyeria.controller;

import com.example.joyeria.model.dto.JoyaDTO;
import com.example.joyeria.service.JoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/joya")
public class JoyaController {
    private final JoyaService joyaService;

    public JoyaController(JoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping
    public ResponseEntity<JoyaDTO> createJoya(@RequestBody JoyaDTO JoyaDTO) {
        return ResponseEntity.ok(joyaService.createJoya(JoyaDTO));
    }
}
