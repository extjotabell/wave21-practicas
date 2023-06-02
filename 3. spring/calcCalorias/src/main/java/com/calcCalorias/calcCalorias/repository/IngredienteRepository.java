package com.calcCalorias.calcCalorias.repository;

import com.calcCalorias.calcCalorias.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public interface IngredienteRepository {
    List<Ingrediente> obtenerIngredientes();


}
