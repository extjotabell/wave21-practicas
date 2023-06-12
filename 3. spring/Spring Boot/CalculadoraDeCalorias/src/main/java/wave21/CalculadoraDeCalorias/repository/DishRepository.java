package wave21.CalculadoraDeCalorias.repository;

import org.springframework.stereotype.Repository;
import wave21.CalculadoraDeCalorias.model.Dish;
import wave21.CalculadoraDeCalorias.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository {
    private List<Dish> dishes = new ArrayList<>();

    public DishRepository(){

        Dish dish1 = new Dish("Ensalada", 100, List.of(
                new Ingredient("Cebolla",50),
                new Ingredient("Zanahoria",30),
                new Ingredient("Lechuga",20)
        ));
        dishes.add(dish1);


    }

    public List<Dish> getIngredients() {
        return dishes;
    }

    public Dish getDishByName(String name) {
        return dishes.stream()
                .filter(x-> name.contains(x.getName()))
                .findFirst()
                .orElse(null);
    }
}
