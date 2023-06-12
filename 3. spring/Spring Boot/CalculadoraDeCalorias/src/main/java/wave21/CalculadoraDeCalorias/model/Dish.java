package wave21.CalculadoraDeCalorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    String name;
    Integer weight;
    List<Ingredient> ingredients;
}