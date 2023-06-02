package com.bootcamp.calorias.utilitary;

import com.bootcamp.calorias.dto.PlatoDTO;
import com.bootcamp.calorias.model.Plato;

public class CrearObjectDTO {

    public static PlatoDTO  crearPlatoDTO(Plato plato){
        PlatoDTO platoDTO = new PlatoDTO();
        platoDTO.setName(plato.getName());
        platoDTO.setIngredients(plato.getIngredients());
        platoDTO.setIngredienteMasCalorico(plato.ingredienteMasCalorico());
        platoDTO.setTotalCalories(plato.calcularCalorias());
        platoDTO.setGramos(plato.getCantidadGramos());
        return platoDTO;
    }
}
