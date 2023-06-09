package com.example.validation.controller;

import com.example.validation.model.StudentDTO;
import com.example.validation.service.IObtenerDiplomaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @GetMapping("/name/{name}")
    public String getName(@PathVariable
                              @Size(max = 10, message = "Rango erroneo")
                              String name){
        return name;
    }

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@RequestBody @Valid StudentDTO rq) {
        return service.analyzeScores(rq);
    }
}
