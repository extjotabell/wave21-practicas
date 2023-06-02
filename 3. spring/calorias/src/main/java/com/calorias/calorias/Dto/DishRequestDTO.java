package com.calorias.calorias.Dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DishRequestDTO {
    private String name;
    private Double weightInGrams;
}
