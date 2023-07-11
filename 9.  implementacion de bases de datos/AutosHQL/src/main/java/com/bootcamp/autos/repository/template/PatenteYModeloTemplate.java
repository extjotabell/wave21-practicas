package com.bootcamp.autos.repository.template;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatenteYModeloTemplate {

    private String patente;
    private String modelo;
    private int anioFabricacion;
}
