package com.example.excercise_crud_jpa.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDTO {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo = true;
}
