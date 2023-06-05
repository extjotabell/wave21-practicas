package com.calorias.calorias.dto;

import com.calorias.calorias.model.Food;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlatoDTO {
    private String namePlato;
    private Integer peso;
    private List<Food> food;
}
