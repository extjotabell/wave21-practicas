package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "EL nombre de la materia no puede estar vacia")
    @Pattern(regexp="^[A-Z][a-z]*", message="La materia tiene que empezar con mayuscula")
    @Size(max = 30, message = "El nombre de la materia debe tener como màximo 30 caracteres")
    String name;
    @PositiveOrZero(message = "La nota no puede estar vacia")
    @DecimalMin(value = "0", message = "La nota debe ser mayor a 0")
    @DecimalMax(value ="10",message = "La nota no puede ser mayor a 10"  )
    Double score;
}
