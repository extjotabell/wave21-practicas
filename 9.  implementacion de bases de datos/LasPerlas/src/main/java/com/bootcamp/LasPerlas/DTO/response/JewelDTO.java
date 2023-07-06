package com.bootcamp.LasPerlas.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JewelDTO {
    private long nro_identificador;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean saleOrNot;
}
