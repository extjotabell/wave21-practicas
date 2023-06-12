package wave21.CalculadoraDeCalorias.mapper;

import wave21.CalculadoraDeCalorias.dto.IngredientDTO;
import wave21.CalculadoraDeCalorias.model.Ingredient;

public class Mapper {
    public static IngredientDTO mapIngredientToDTO(Ingredient ingredient){
        return new IngredientDTO(ingredient.getName(), ingredient.getCalories());
    }
}
