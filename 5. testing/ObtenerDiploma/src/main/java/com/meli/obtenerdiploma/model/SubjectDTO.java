package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotBlank(message = "El nombre no puede ser vacio")
    @Size(message = "El largo del nombre no puede ser mayor a 30", max = 30)
    @Pattern(regexp = "^[A-Z]. $", message = "El nombre de la materia debe comenzar con mayuscula")
    String name;

    @NotBlank(message = "El score no puede ser vacio")
    @Min(value=0, message = "El minimo de score a ingresar es 0")
    @Max(value=10, message = "El maximo de score a ingresar es 10")
    Double score;
}
