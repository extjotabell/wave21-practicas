package com.example.validation.model;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectDTO {
    @Size(max = 30, message = "El nombre de la materia no debe contener más de 30 caracteres")
    @NotEmpty(message = "El nombre de la materia no debe estar vacío")
    @Pattern(regexp="\\b[A-Z].*?\\b", message = "El nombre de la materia debe comenzar con mayúscula")
    String name;

    @NotNull(message = "La materia debe contener una nota")
    @Max(value = 10, message = "El máximo valor permitido es 10")
    @Min(value = 0, message = "El minimo valor permitido es 0")
    Double score;
}
