package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    /*
    * Que el campo no esté vacío.
    Que empiece con mayúscula.
    Longitud máxima de 30 caracteres.
    El nombre de la materia no puede estar vacío.
    El nombre de la materia debe comenzar con mayúscula.
    La longitud del nombre no puede superar los 30 caracteres.
    */
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    //no considere que el nombre pueda tener numeros
    @Pattern(regexp = "[A-Z|Á|Ó|É|Í|Ú][\\s | a-z|A-Z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| 0-9 ]*$", message = "El nombre de la materia debe comenzar con mayúsculas.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 50 caracteres.")
    String name;
    /*Que el campo no esté vacío.
    Mínimo 0.0
    Máximo 10-0
    La nota no puede estar vacía.
    La mínima nota es 0.0.
    La máxima nota es 10.0.
*/
    @NotNull(message = "La nota de la materia no puede estar vacía.")
    @DecimalMax(value = "10.0", message = "La nota máxima de la materia es de 10 puntos.")
    @DecimalMin(value = "0.0", message = "La nota mínima de la materia es de 0 puntos.")
    Double score;
}
