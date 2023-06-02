package com.calcCalorias.calcCalorias.service;

import com.calcCalorias.calcCalorias.model.Ingrediente;
import com.calcCalorias.calcCalorias.repository.PlatoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {

    @Autowired
    PlatoRepository platoRepository;

    public int obtenerCalorias(String name, int peso){
        int calorias = 0;
        List<Ingrediente> ingredientesPlato = platoRepository.obtenerPlato(name).getIngredientes();
        for (Ingrediente ingrendiente : ingredientesPlato ){
            calorias+=ingrendiente.getCalorias();
        }
        calorias = calorias*peso;
    return calorias;
    }

    public List<Ingrediente> listarIngredientes() {
        return null;
    }

    public Ingrediente obtenerIngredienteCalorico() {
        return null;
    }
}
