package com.otenerdiploma.OtenerDiploma.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import jakarta.validation.constraints.Size;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacía")
    List<@Valid SubjectDTO> subjects;
}
