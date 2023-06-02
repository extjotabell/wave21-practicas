package com.example.generico.DTO;

import java.util.List;

public record FoodDto (String name, List<Integer> ingredientsId) {
}
