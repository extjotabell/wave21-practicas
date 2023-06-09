package com.example.validation.service;


import com.example.validation.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);
}
