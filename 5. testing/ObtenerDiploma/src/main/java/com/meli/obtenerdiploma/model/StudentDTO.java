package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode

public class StudentDTO {

    @NotBlank(message="Nombre no puede ser vacio")
    @Size(max = 50, message = "El largo del nombre no puede ser mayor a 50")
    @Pattern(regexp = "^[A-Z]. $", message = "El nombre de estudiante debe comenzar con mayuscula")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacia")
    List<SubjectDTO> subjects;
}
