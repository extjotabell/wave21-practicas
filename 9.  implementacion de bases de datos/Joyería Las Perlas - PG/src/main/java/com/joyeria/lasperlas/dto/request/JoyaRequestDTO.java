package com.joyeria.lasperlas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor @NoArgsConstructor
public class JoyaRequestDTO {
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
