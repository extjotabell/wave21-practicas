package com.example.ContadorCalorias.service;
import com.example.ContadorCalorias.dto.dto_ingrediente;
import com.example.ContadorCalorias.dto.dto_platoCaloriasTotales;
import com.example.ContadorCalorias.entity.Ingrediente;
import com.example.ContadorCalorias.entity.Plato;
import org.springframework.stereotype.Service;
import com.example.ContadorCalorias.repository.DishRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ServicePlatos {
    DishRepository repositorio;

    public ServicePlatos (DishRepository repositorio) {
        this.repositorio = repositorio;
    }

    public dto_ingrediente obtenerIngredienteMasCalorias (String plato)
    {
        Plato p = findPlato(plato);
        dto_ingrediente retorno = new dto_ingrediente();
        int cantMaximaCalorias = -1;
        if (p != null) {
            Map<Ingrediente, Integer> ingredientes = p.getIndredients();
            for (Map.Entry<Ingrediente, Integer> entry : ingredientes.entrySet()) {
                Ingrediente i = entry.getKey();
                if (i.getCalories() > cantMaximaCalorias) {
                    retorno = new dto_ingrediente(i.getName(), i.getCalories());
                    cantMaximaCalorias = i.getCalories();
                }
            }
            return retorno;
        }
        else
            return null;
    }

    public List<dto_ingrediente> ingredientesDelPlato (String plato)
    {
        Plato p = findPlato(plato);
        List<dto_ingrediente> ingredientes = new ArrayList<>();
        if (p != null) {
            Map<Ingrediente, Integer> ing = p.getIndredients();
            for (Map.Entry<Ingrediente, Integer> entry : ing.entrySet())
            {
                Ingrediente i = entry.getKey();
                dto_ingrediente ingALista = new dto_ingrediente(i.getName(), i.getCalories());
                ingredientes.add(ingALista);
            }
            return ingredientes;
        }
       else
           return null;
    }

    private Plato findPlato(String nombre)
    {
        for (Plato p : repositorio.platos)
        {
            if(p.getName().equals(nombre))
            {
                return p;
            }
        }
        return null;
    }

    public dto_platoCaloriasTotales caloriasTotales (String nombre)
    {
        dto_platoCaloriasTotales dto = null;
        Plato p = findPlato(nombre);
        if (p != null)
        {
            dto_platoCaloriasTotales dtoRetorno = new dto_platoCaloriasTotales(nombre, p.totalCalories());
            return dtoRetorno;
        }
        else
            return null;
    }
}
