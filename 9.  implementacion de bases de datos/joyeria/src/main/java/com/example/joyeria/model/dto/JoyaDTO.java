package com.example.joyeria.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoyaDTO {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
