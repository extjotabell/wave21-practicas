package com.meli.obtenerdiploma.exceptions;


import com.meli.obtenerdiploma.model.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ObtenerDiplomaException extends RuntimeException {

    private ErrorDTO error;
    private HttpStatus status;

    public ObtenerDiplomaException(List<String> message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}