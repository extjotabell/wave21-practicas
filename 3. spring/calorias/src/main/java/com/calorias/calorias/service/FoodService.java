package com.calorias.calorias.service;

import com.calorias.calorias.dto.PlatoDTO;
import com.calorias.calorias.model.Food;
import com.calorias.calorias.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;


import java.util.List;

@Service
public class FoodService {

    @Autowired
    PlatoRepository platoRepository;




    public Integer obtenerCalorias(String name, Integer peso){
        Integer calories = 0;
        PlatoDTO platoDTO = new PlatoDTO();
        platoDTO.setNamePlato(name);
        platoDTO.setPeso(peso);

        List<Food> ingredientesPlato = platoRepository.obtenerPlato(name).getIngredients();
        platoDTO.setFood(ingredientesPlato);
        for (Food plato : platoDTO.getFood() ){
            calories+=plato.getCalories();
        }
        calories = calories*platoDTO.getPeso();
        return calories;
    }

    public Food getFoodMaxCalories(String name) {
        PlatoDTO platoDTO = new PlatoDTO();
        List<Food> ingredients = platoRepository.obtenerPlato(name).getIngredients();
        platoDTO.setFood(ingredients);

        return platoDTO.getFood().stream()
                .max(Comparator.comparingInt(Food::getCalories))
                .orElse(null);
    }



    public List<Food> listaFood(String name) {
        PlatoDTO platoDTO = new PlatoDTO();
        platoDTO.setNamePlato(name);

        List<Food> ingredientesPlato = platoRepository.obtenerPlato(name).getIngredients();
        platoDTO.setFood(ingredientesPlato);
        return platoDTO.getFood();
    }
}
