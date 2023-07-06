package com.bootcamp.LasPerlas.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JewelDTORequest {
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean saleOrNot;
}
