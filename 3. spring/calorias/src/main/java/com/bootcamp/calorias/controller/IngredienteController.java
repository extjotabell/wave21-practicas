package com.bootcamp.calorias.controller;

import com.bootcamp.calorias.dto.PlatoDTO;
import com.bootcamp.calorias.exceptions.NotFoundException;
import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.model.Plato;
import com.bootcamp.calorias.service.IngredienteServiceImpl;
import com.bootcamp.calorias.service.PlatoService;
import com.bootcamp.calorias.utilitary.CrearObjectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@RestController
public class IngredienteController {


    IngredienteServiceImpl servicioIngrediente;
    PlatoService servicioPlato;

    public IngredienteController(IngredienteServiceImpl servicioIngrediente,PlatoService servicioPlato){
        this.servicioIngrediente = servicioIngrediente;
        this.servicioPlato = servicioPlato;
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Ingrediente>> getAllIngredients(){
                return new ResponseEntity<List<Ingrediente>>(servicioIngrediente.findAll(), HttpStatus.OK);

    }
    @GetMapping("/find/{name}")
    public ResponseEntity<?> findPlato(@PathVariable String name){

        PlatoDTO platoDTO = new PlatoDTO();
        Plato plato = servicioPlato.findPlato(name);
        if(plato == null){
            throw new NotFoundException("PLato no encontrado");
        }
        CrearObjectDTO.crearPlatoDTO(plato);

        return  ResponseEntity.status(HttpStatus.OK).body(platoDTO);
    }

    @GetMapping("/find/platos/{platos}")
    public ResponseEntity<?> findPlato(@PathVariable List<String> platos){
    List<PlatoDTO> response = new ArrayList<>();
        for(String platoName : platos){
        Plato plato = servicioPlato.findPlato(platoName);
        if(plato == null){
            throw new NotFoundException("PLato " + platoName + "no encontrado");
        }
        response.add(CrearObjectDTO.crearPlatoDTO(plato));
        }
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
