package com.calcCalorias.calcCalorias.repository;

import com.calcCalorias.calcCalorias.model.Ingrediente;
import com.calcCalorias.calcCalorias.model.Plato;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
@Repository
public class PlatoRepository {

    IngredienteRepository ingredienteRepository;

    private List<Plato> platos;

    public PlatoRepository(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
        this.platos = loadPlato();
        System.out.println(platos);
    }

    public List<Plato> loadPlato() {
        List<Plato> platosNuevos = new ArrayList<>();
        List<Ingrediente> ingredientesFideos = new ArrayList<>();
        ingredientesFideos.add(ingredienteRepository.obtenerIngrediente("Pasta al huevo"));
        ingredientesFideos.add(ingredienteRepository.obtenerIngrediente("Salsa de tomate en conserva"));
        ingredientesFideos.add(ingredienteRepository.obtenerIngrediente("Queso parmesano"));
        Plato fideos = new Plato("Fideos", ingredientesFideos);

        List<Ingrediente> ingredientesCarne = new ArrayList<>();
        ingredientesCarne.add(ingredienteRepository.obtenerIngrediente("Papas cocidas"));
        ingredientesCarne.add(ingredienteRepository.obtenerIngrediente("Queso cheddar"));
        ingredientesCarne.add(ingredienteRepository.obtenerIngrediente("Hamburguesa"));
        Plato hamburguesa = new Plato("Hamburguesa", ingredientesCarne);

        platosNuevos.add(fideos);
        platosNuevos.add(hamburguesa);

        return platosNuevos;
    }

    public Plato obtenerPlato(String nombre){
        return this.platos.stream()
                .filter(plato -> plato.getName().equalsIgnoreCase(nombre))
                .findFirst().orElse(null);
    }

    public List<Plato> obtenerPlatos(){
        return this.platos;
    }

}
