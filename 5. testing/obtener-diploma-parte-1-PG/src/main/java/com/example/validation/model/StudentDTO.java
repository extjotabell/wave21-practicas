package com.example.validation.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Data
public class StudentDTO {

    @Size(max = 50, message = "El nombre del alumno no debe contener más de 50 caracteres")
    @NotBlank(message = "El nombre del alumno no debe estar vacío")
    @Pattern(regexp="\\b[A-Z].*?\\b", message = "El nombre del alumno debe comenzar con mayúscula")
    String studentName;
    String message;
    Double averageScore;

    @NotEmpty(message = "Lista de materias no debe estar vacia")
    List<@Valid SubjectDTO> subjects;
}
