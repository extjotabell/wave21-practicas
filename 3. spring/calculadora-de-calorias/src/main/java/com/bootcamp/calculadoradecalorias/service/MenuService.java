package com.bootcamp.calculadoradecalorias.service;

import com.bootcamp.calculadoradecalorias.dto.IngredientDTO;
import com.bootcamp.calculadoradecalorias.dto.DishRequestDTO;
import com.bootcamp.calculadoradecalorias.dto.MenuDTO;
import com.bootcamp.calculadoradecalorias.dto.MenuMultiResponseDTO;
import com.bootcamp.calculadoradecalorias.model.Dish;
import com.bootcamp.calculadoradecalorias.repository.IDishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MenuService implements IMenuService{

    @Autowired
    IDishesRepository dishesRepository;

    @Override
    public MenuDTO getNutritionalFacts(String name, String weight) {
        MenuDTO result = new MenuDTO();
        Dish dish = dishesRepository.dishes().stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
        List<IngredientDTO> ingredientDTOS = new ArrayList<>();
        AtomicReference<Double> maxRegisteredValue = new AtomicReference<>((double) 0);
        AtomicReference<IngredientDTO> mostCaloricIngredient = new AtomicReference<>(new IngredientDTO());
        assert dish != null;
        dish.getIngredients().forEach(ingredient -> {
            IngredientDTO ingredientDTOTemp = new IngredientDTO(ingredient.getName(),ingredient.getCalories());
            ingredientDTOS.add(ingredientDTOTemp);
            if(ingredient.getCalories() > maxRegisteredValue.get()){
                maxRegisteredValue.set(ingredient.getCalories());
                mostCaloricIngredient.set(ingredientDTOTemp);
            }
        });
        result.setIngredients(ingredientDTOS);
        result.setTotalCalories(ingredientDTOS.stream().mapToDouble(IngredientDTO::getCalories).sum());
        result.setMostCaloricIngredient(mostCaloricIngredient.get());
        return result;
    }

    @Override
    public List<MenuMultiResponseDTO> getNutritionalFactsMulti(List<DishRequestDTO> dishes) {
        List<MenuMultiResponseDTO> result = new ArrayList<>();
        dishes.forEach(dish -> {
            MenuDTO menuDTO = getNutritionalFacts(dish.getName(), dish.getWeight());
            MenuMultiResponseDTO menuMultiResponseDTO = new MenuMultiResponseDTO();
            menuMultiResponseDTO.setDish(dish.getName());
            menuMultiResponseDTO.setIngredients(menuDTO.getIngredients());
            menuMultiResponseDTO.setMostCaloricIngredient(menuDTO.getMostCaloricIngredient());
            menuMultiResponseDTO.setTotalCalories(menuDTO.getTotalCalories());
            result.add(menuMultiResponseDTO);
        });

        return result;
    }
}
