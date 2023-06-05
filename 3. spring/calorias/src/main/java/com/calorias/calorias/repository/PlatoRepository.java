package com.calorias.calorias.repository;

import com.calorias.calorias.model.Food;
import com.calorias.calorias.model.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepository {
    private final FoodRepository foodRepository;
    private final List<Plato> platos;

    @Autowired
    public PlatoRepository(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
        this.platos = initData();
    }

    private List<Plato> initData(){
        List<Plato> newPlatos = new ArrayList<>();

        List<Food> foodFideos = new ArrayList<>();
        foodFideos.add(foodRepository.obtenerFood("Pasta al huevo"));
        foodFideos.add(foodRepository.obtenerFood("Salsa de tomate en conserva"));
        foodFideos.add(foodRepository.obtenerFood("Queso parmesano"));
        Plato fideos = new Plato("Fideos con salsa", foodFideos);

        List<Food> foodCarne = new ArrayList<>();
        foodCarne.add(foodRepository.obtenerFood("Papas cocidas"));
        foodCarne.add(foodRepository.obtenerFood("Queso cheddar"));
        foodCarne.add(foodRepository.obtenerFood("Hamburguesa"));
        Plato hamburguesa = new Plato("Hamburguesa con papas", foodCarne);

        newPlatos.add(fideos);
        newPlatos.add(hamburguesa);

        return newPlatos;
    }

    public Plato obtenerPlato(String nombre){
        return this.platos.stream()
                .filter(plato -> plato.getName().equals(nombre))
                .findFirst()
                .orElse(null);
    }


    public List<Plato> obtenerPlatos(){
        return this.platos;
    }

}
