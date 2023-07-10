package com.bootcamp.autos.exception;

import com.bootcamp.autos.dto.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(VehiculoNotFoundException.class)
    public ResponseEntity<?> vehiculoNotFoundException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(SiniestroNotFoundException.class)
    public ResponseEntity<?> siniestroNotFoundException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }
}
