package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
@Validated
public class StudentDTO {

    @NotNull(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre del alumno debe comenzar con mayúscula")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacía.")
    List<SubjectDTO> subjects;

    public StudentDTO(String studentName, List<SubjectDTO> subjects) {
        this.studentName = studentName;
        this.subjects = subjects;
    }
}
