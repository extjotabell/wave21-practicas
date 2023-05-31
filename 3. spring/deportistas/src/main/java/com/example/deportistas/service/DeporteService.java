package com.example.deportistas.service;

import com.example.deportistas.DTO.PersonaDeporteDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteService {

    private List<Deporte> crearDeportes() {
        Deporte futbol = new Deporte("Futbol", "Basico");
        Deporte tenis = new Deporte("Tenis", "Medio");
        Deporte natacion = new Deporte("Natación", "Avanzado");
        List<Deporte> listaDeportes = new ArrayList<>() {{
            add(futbol);
            add(tenis);
            add(natacion);
        }};

        return listaDeportes;
    }

    public List<PersonaDeporteDTO> personaDeporte(){
        List<Deporte> listaDeportes = crearDeportes();
        Persona persona1 = new Persona("Juan", "Perez", 20);
        Persona persona2 = new Persona("Maria", "Gomez", 30);
        Persona persona3 = new Persona("Pedro", "Gonzalez", 40);

        return new ArrayList<>(){{
            add(new PersonaDeporteDTO(persona1.getNombre(), persona1.getApellido(), listaDeportes.get(0).getNombre()));
            add(new PersonaDeporteDTO(persona2.getNombre(), persona2.getApellido(), listaDeportes.get(1).getNombre()));
            add(new PersonaDeporteDTO(persona3.getNombre(), persona3.getApellido(), listaDeportes.get(2).getNombre()));
        }};

    }

    public List<Deporte> mostrarDeportes() {
        return crearDeportes();
    }

    public String verNivelDeporte(String deporte){
        List<Deporte> deportes = crearDeportes();
        return deportes.stream()
                .filter(deporte1 -> deporte1.getNombre().equals(deporte))
                .map(Deporte::getNivel)
                .findFirst()
                .orElse(null);

    }
}
