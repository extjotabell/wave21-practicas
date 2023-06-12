package wave21.CalculadoraDeCalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wave21.CalculadoraDeCalorias.model.Ingredient;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    String name;
    Integer weight;
    List<IngredientDTO> ingredients;
}
