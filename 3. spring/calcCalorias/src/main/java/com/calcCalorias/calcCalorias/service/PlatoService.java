package com.calcCalorias.calcCalorias.service;

import com.calcCalorias.calcCalorias.model.Ingrediente;
import com.calcCalorias.calcCalorias.repository.PlatoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PlatoService {

    @Autowired
    PlatoRepository platoRepository;

    public int obtenerCalorias(String name, int peso){
        int calorias = 0;
        List<Ingrediente> ingredientesPlato = platoRepository.obtenerPlato(name).getIngredientes();
        for (Ingrediente ingrendiente : ingredientesPlato ){
            calorias+=ingrendiente.getCalories();
        }
        calorias = calorias*peso;
    return calorias;
    }

    public List<Ingrediente> listarIngredientes(String name) {
        List<Ingrediente> ingredientesPlato = platoRepository.obtenerPlato(name).getIngredientes();
        return ingredientesPlato;
    }

    public Ingrediente obtenerIngredienteCalorico(String name) {
        List<Ingrediente> ingredientesPlato = platoRepository.obtenerPlato(name).getIngredientes();
        Optional<Ingrediente> ingrMasCalorico = ingredientesPlato.stream().max(Comparator.comparing(Ingrediente::getCalories));
        if (ingrMasCalorico.isPresent()) {
            return ingrMasCalorico.get();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No se encontró el plato");
        }
    }
}
