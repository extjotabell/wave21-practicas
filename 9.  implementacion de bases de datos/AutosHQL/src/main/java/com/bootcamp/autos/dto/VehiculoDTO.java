package com.bootcamp.autos.dto;

import com.bootcamp.autos.entity.Siniestro;
import jakarta.persistence.*;

import java.util.Set;

public class VehiculoDTO {

    private Long id;

    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantRuedas;
    private Set<Siniestro> siniestros;
}
