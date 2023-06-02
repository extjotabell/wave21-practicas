package com.calcCalorias.calcCalorias.dto;

import lombok.Getter;
import lombok.Setter;
import com.calcCalorias.calcCalorias.model.Ingrediente;

import java.util.List;

@Getter @Setter
public class PlatoDTO {
    private String nombre;
    private Integer peso;
    private List<Ingrediente> ingredientes;
}
