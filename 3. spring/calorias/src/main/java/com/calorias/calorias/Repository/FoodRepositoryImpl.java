package com.calorias.calorias.Repository;

import com.calorias.calorias.Dto.DishRequestDTO;
import com.calorias.calorias.Model.DishEntity;
import com.calorias.calorias.Model.FoodEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {
    private List<FoodEntity> foods;

    public FoodRepositoryImpl(){
        this.foods = getData();
    }

    private  List<FoodEntity> getData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
            File file = new ClassPathResource("food.json").getFile();
            return objectMapper.readValue(file, new TypeReference<>() {
            });
        }catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<FoodEntity> getFoods() {
        return this.foods;
    }
}
