package wave21.CalculadoraDeCalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishResponseDTO {
    private Integer totalCalories;
    private IngredientDTO maxCalsIngredient;
    private List<IngredientDTO> ingredients;

}
