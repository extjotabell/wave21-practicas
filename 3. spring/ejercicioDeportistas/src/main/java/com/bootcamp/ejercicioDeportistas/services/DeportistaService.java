package com.bootcamp.ejercicioDeportistas.services;

import com.bootcamp.ejercicioDeportistas.dtos.DeporteDTO;
import com.bootcamp.ejercicioDeportistas.dtos.PersonaDTO;
import com.bootcamp.ejercicioDeportistas.dtos.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class DeportistaService {

    List<DeporteDTO> deportes;
    List<PersonaDTO> personas;


    public DeportistaService() {
        this.deportes = new ArrayList<>(List.of(new DeporteDTO("Basquet", "facil"),
                new DeporteDTO("Futbol", "intermedio"),
                new DeporteDTO("Ajedrez", "Dark Souls"))
        );
        this.personas = new ArrayList<>(List.of(new PersonaDTO("Jorge", "Ramirez", 20),
                new PersonaDTO("Pedro", "Gonzalez", 30),
                new PersonaDTO("Juan", "Perez", 14))
        );
    }

    public List<DeporteDTO> findSports() {
        return deportes;
    }

    public DeporteDTO findSport(String name) {
        return this.deportes.stream().filter(d -> d.getNombre().equals(name)).findFirst().orElse(null);
    }

    private String getRamdomSport(){
        String ramdomSport = deportes.get((int)Math.floor(Math.random() * deportes.size())).getNombre();
        //String ramdomSport = deportes.get(0).getNombre();
      return ramdomSport;
    }
    public List<ResponseDTO> findSportsPersons() {
        List<ResponseDTO> personasRespuesta = new ArrayList<>();
        //(int)Math.floor((Math.random() * deportes.size()) + 1)
        for (PersonaDTO persona : personas) {
                personasRespuesta.add(new ResponseDTO(persona.getNombre(), persona.getApellido(),getRamdomSport()));
        }
        return personasRespuesta;
    }

}
