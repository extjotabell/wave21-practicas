package com.bootcamp.autos.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PatenteModeloVehiculoDTO {
    private String patente;
    private String modelo;
    private int anioFabricacion;

}
