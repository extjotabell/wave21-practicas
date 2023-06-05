package com.example.demo.repository;

import com.example.demo.DTO.PlatoDTO;
import com.example.demo.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepository {
    static Plato plato = new Plato("Ensalada", 100, List.of("Lechuga", "Tomates", "Cebolla"));
    static Plato plato2 = new Plato("Carne", 100, List.of("Carne"));

    static List<Plato> platos = new ArrayList<>(){{
        add(plato);
        add(plato2);
    }};

    public List<Plato> findAll(){
        return platos;
    }

    public Optional<Plato> findPlato(String nombrePlato){
        return platos.stream().filter(plato -> plato.getNombre().equalsIgnoreCase(nombrePlato)).findFirst();
    }


}
