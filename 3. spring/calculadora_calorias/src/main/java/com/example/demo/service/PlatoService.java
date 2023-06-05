package com.example.demo.service;

import com.example.demo.DTO.PlatoDTO;
import com.example.demo.model.Ingrediente;
import com.example.demo.model.Plato;
import com.example.demo.repository.IngredienteRepository;
import com.example.demo.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PlatoService {
    @Autowired
    private PlatoRepository platoRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Plato> findAll(){
        return platoRepository.findAll();
    }

    public PlatoDTO findPlato(String nombrePlato){
        Plato plato = platoRepository.findPlato(nombrePlato).orElseThrow();
        List<String> nombreIngredientes = plato.getIngredientes();
        List<Ingrediente> ingredientes = nombreIngredientes.stream()
                .map(nombreIngrediente -> ingredienteRepository.findIngrediente(nombreIngrediente))
                .toList();

        int totalCalorias = ingredientes.stream().mapToInt(Ingrediente::getCalories).sum();
        Ingrediente ingredienteMasCalorico = ingredientes.stream()
                .max(Comparator.comparingInt(Ingrediente::getCalories))
                .orElseThrow();

        PlatoDTO platoDTO = new PlatoDTO();

        platoDTO.setTotalCalorias(totalCalorias);
        platoDTO.setIngredientes(ingredientes);
        platoDTO.setIngredienteMasCalorico(ingredienteMasCalorico);

        return platoDTO;
    }
}
