package com.otenerdiploma.OtenerDiploma.controller;

import com.otenerdiploma.OtenerDiploma.model.StudentDTO;
import com.otenerdiploma.OtenerDiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @GetMapping("/analyzeScores/{studentId}")
    public StudentDTO analyzeScores(@PathVariable Long studentId) {
        return service.analyzeScores(studentId);
    }
}
