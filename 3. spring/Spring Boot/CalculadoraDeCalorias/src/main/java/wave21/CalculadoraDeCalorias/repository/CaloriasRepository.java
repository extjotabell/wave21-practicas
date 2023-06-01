package wave21.CalculadoraDeCalorias.repository;

import org.springframework.stereotype.Repository;
import wave21.CalculadoraDeCalorias.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CaloriasRepository {
    private List<Ingredient> ingredients;

    public CaloriasRepository(){
        ingredients = new ArrayList<>();
    }
}
