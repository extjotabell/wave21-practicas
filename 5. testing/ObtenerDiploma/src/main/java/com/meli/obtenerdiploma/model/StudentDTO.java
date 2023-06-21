package com.meli.obtenerdiploma.model;

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
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre del alumno debe comenzar con mayúscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista de materias no puede ser vacia.")
    List<@Valid SubjectDTO> subjects;

    public StudentDTO(String studentName, List<@Valid SubjectDTO> subjects) {
        this.studentName = studentName;
        this.subjects = subjects;
    }


}
