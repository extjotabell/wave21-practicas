package com.calorias.calorias.Model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DishEntity {
    private String name;
    private List<FoodEntity> ingredients;
}
