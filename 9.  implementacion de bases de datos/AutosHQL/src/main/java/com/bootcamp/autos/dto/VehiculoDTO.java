package com.bootcamp.autos.dto;

import com.bootcamp.autos.entity.Siniestro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {

    private Long id;

    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantRuedas;
    private Set<SiniestroDTO> siniestros;
    private String message;
}
