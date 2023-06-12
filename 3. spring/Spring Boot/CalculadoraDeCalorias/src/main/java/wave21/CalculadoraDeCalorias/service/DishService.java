package wave21.CalculadoraDeCalorias.service;

import org.springframework.stereotype.Service;
import wave21.CalculadoraDeCalorias.dto.DishDTO;
import wave21.CalculadoraDeCalorias.dto.DishResponseDTO;
import wave21.CalculadoraDeCalorias.dto.IngredientDTO;
import wave21.CalculadoraDeCalorias.mapper.Mapper;
import wave21.CalculadoraDeCalorias.model.Dish;
import wave21.CalculadoraDeCalorias.model.Ingredient;
import wave21.CalculadoraDeCalorias.repository.DishRepository;
import wave21.CalculadoraDeCalorias.repository.IngredientRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishService {
    private final IngredientRepository ingredientRepository;
    private final DishRepository dishRepository;

    public DishService(IngredientRepository ingredientRepository, DishRepository dishRepository) {
        this.ingredientRepository = ingredientRepository;
        this.dishRepository = dishRepository;
    }

    public DishResponseDTO calcularCaloriasTotales(String nombrePlato) {
        //Obtengo el plato por nombre
        Dish dish = dishRepository.getDishByName(nombrePlato);
        if (dish == null) {
            throw new IllegalArgumentException("Plato no encontrado");
        }
        //Obtengo su lista de ingredientes.
        List<Ingredient> ingredientes = dish.getIngredients();

        //Calculo las calorias totales
        int totalCals =  ingredientes.stream()
                .mapToInt(Ingredient::getCalories)
                .sum();

        //Calculo e identifico el ingrediente con mayor calorias del plato
        Ingredient maxCalsIngredient = ingredientes.stream()
                .max(Comparator.comparingInt(Ingredient::getCalories))
                .orElse(null);
        IngredientDTO maxCalsIngredientDTO = Mapper.mapIngredientToDTO(maxCalsIngredient);

        //Mapeo todos los ingredientes a DTO para la respuesta
        List<IngredientDTO> ingredientsDTO = dish.getIngredients()
                .stream()
                .map(Mapper::mapIngredientToDTO)
                .collect(Collectors.toList());


        return new DishResponseDTO(totalCals, maxCalsIngredientDTO, ingredientsDTO);
    }


    /*
    public DishResponseDTO calories(DishDTO dish) {
        int totalDishCals = 0;
        int maxDishCals = 0;
        IngredientDTO maxCalsIngredientDTO = dish.getIngredients().get(0);

        for (IngredientDTO ingredientDTO : dish.getIngredients()){
            totalDishCals += ingredientDTO.getCalories();

            if(ingredientDTO.getCalories() >= maxDishCals){
                maxDishCals = ingredientDTO.getCalories();
                maxCalsIngredientDTO = ingredientDTO;
            }
        }
        return new DishResponseDTO(totalDishCals, maxCalsIngredientDTO, dish.getIngredients());
    }

     */
}
