package com.calcCalorias.calcCalorias.repository;

import com.calcCalorias.calcCalorias.model.Ingrediente;
import com.calcCalorias.calcCalorias.model.Plato;
import com.calcCalorias.calcCalorias.repository.impl.IngredienteRepositoryImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class PlatoRepository {

    @Autowired
    IngredienteRepositoryImpl ingredienteRepository;

    private List<Plato> platos;

    public PlatoRepository() {
        this.platos = loadPlato();
    }

    public List<Plato> loadPlato() {
        List<Plato> platosNuevos = new ArrayList<>();
        List<Ingrediente> ingredientesFideos = new ArrayList<>();
        ingredientesFideos.add(ingredienteRepository.obtenerIngrediente("Pasta al huevo"));
        ingredientesFideos.add(ingredienteRepository.obtenerIngrediente("Salsa de tomate en conserva"));
        ingredientesFideos.add(ingredienteRepository.obtenerIngrediente("Queso parmesano"));
        Plato fideos = new Plato("Fideos con salsa", ingredientesFideos);

        List<Ingrediente> ingredientesCarne = new ArrayList<>();
        ingredientesCarne.add(ingredienteRepository.obtenerIngrediente("Papas cocidas"));
        ingredientesCarne.add(ingredienteRepository.obtenerIngrediente("Queso cheddar"));
        ingredientesCarne.add(ingredienteRepository.obtenerIngrediente("Hamburguesa"));
        Plato hamburguesa = new Plato("Hamburguesa con papas", ingredientesCarne);

        platosNuevos.add(fideos);
        platosNuevos.add(hamburguesa);

        return platosNuevos;
    }

    public Plato obtenerPlato(String nombre){
        return this.platos.stream()
                .filter(plato -> plato.getName().equals(nombre))
                .findFirst().orElse(null);
    }

    public List<Plato> obtenerPlatos(){
        return this.platos;
    }

}
