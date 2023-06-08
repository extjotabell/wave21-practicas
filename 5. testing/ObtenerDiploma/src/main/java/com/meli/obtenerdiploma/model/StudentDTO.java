package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "EL nombre de la persona no puede estar vacia")
    @Pattern(regexp="^[A-Z][a-z]*", message="La materia tiene que empezar con mayuscula")
    @Size(max = 30, message = "El nombre de la materia debe tener como màximo 50 caracteres")    String studentName;
    String message;
    Double averageScore;

    List<@Valid SubjectDTO> subjects;
}
