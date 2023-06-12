package wave21.CalculadoraDeCalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import wave21.CalculadoraDeCalorias.model.Ingredient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepository {
    private List<Ingredient> ingredients;

    public IngredientRepository(){
        ingredients = loadDataBase();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient getIngredientByName(String name) {
        return ingredients.stream()
                .filter(x-> name.contains(x.getName()))
                .findFirst()
                .orElse(null);
    }

    private List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> toReturn = null;
        try {
            toReturn = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toReturn;
    }
}
