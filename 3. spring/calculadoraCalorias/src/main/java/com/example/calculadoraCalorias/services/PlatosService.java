package com.example.calculadoraCalorias.services;

import com.example.calculadoraCalorias.entitys.Plato;
import com.example.calculadoraCalorias.exceptions.PlatoNotFoundException;
import com.example.calculadoraCalorias.repository.IngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatosService {

    @Autowired
    IngredientesRepository ingredientesRepository;

    private PlatosService(){

    }


    public ResponseDTO dataPlato(String plato, int gramos){
        try {


            Plato platoFiltrado = ingredientesRepository.getListaPlatos().stream()
                    .filter(unplato -> unplato.getNombrePlato().toLowerCase().equalsIgnoreCase(plato))
                    .findFirst()
                    .orElse(null);
        }catch( PlatoNotFoundException e){
            throw new PlatoNotFoundException("no se encuentra el plato ingresado");
        }
    }


}
