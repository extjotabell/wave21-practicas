package com.meli.obtenerdiploma.model;



import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    /*Que el campo no esté vacío.
    Que empiece con mayúscula.
    Longitud máxima de 50 caracteres.
     ------
    El nombre del alumno no puede estar vacío.
    El nombre del alumno debe comenzar con mayúscula.
    La longitud del nombre no puede superar los 50 caracteres.
*/
    @NotBlank(message = "El nombre del estudiante no puede estar vacío.")
    //no considere que el nombre pueda tener numeros
    @Pattern(regexp = "[A-Z |Á|Ó|É|Í|Ú][\\s|a-z|A-Z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del alumno debe comenzar con mayúsculas.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    List<SubjectDTO> subjects;
}
