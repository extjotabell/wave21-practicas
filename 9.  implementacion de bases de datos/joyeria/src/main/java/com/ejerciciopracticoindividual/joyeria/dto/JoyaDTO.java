package com.ejerciciopracticoindividual.joyeria.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoyaDTO {
    private Integer id;
    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(max=40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp =  "[\\w\\s]+", message = "El nombre no puede contener caracteres especiales.")
    private String nombre;
    @NotEmpty(message = "El material no puede estar vacío")
    @Size(max=40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp =  "[\\w\\s]+", message = "El material no puede contener caracteres especiales.")
    private String material;
    @Min(value = 0,message = "El peso no puede ser menor a 0")
    private Integer peso;
    @NotEmpty(message = "La particularidad no puede estar vacía.")
    @Size(max=120, message = "La longitud no puede superar los 120 caracteres.")
    @Pattern(regexp =  "[\\w\\s]+", message = "La particularidad no puede contener caracteres especiales.")
    private String particularidad;
    @NotNull(message = "Inserte un valor valido para saber si la joya posee piedra o no.")
    private Boolean posee_piedra;
    @NotNull(message = "Inserte un valor valido para saber si la joya está en venta o no.")
    private Boolean ventaONo;
}
