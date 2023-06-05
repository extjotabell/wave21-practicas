package com.example.demo.DTO;

import com.example.demo.model.Ingrediente;
import lombok.Data;

import java.util.List;

@Data
public class PlatoDTO {
    private int totalCalorias;
    List<Ingrediente> ingredientes;
    private Ingrediente ingredienteMasCalorico;
}
