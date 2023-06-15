package com.meli.obtenerdiploma.exception;


import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class StudentNotFoundException extends ObtenerDiplomaException {

    public StudentNotFoundException(List<String> message, HttpStatus status) {
        super(message, status);
    }

    public StudentNotFoundException(Long id) {
        super(Collections.singletonList("El alumno con Id " + id + " no se encuetra registrado."), HttpStatus.NOT_FOUND);
    }

}
