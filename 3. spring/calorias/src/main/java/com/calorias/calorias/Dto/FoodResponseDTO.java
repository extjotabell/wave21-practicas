package com.calorias.calorias.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodResponseDTO {
    private String name;
    private Integer calories;
}
