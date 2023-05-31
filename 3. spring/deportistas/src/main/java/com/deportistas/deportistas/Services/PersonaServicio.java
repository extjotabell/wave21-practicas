package com.deportistas.deportistas.Services;

import com.deportistas.deportistas.DTOS.DeportistaDTO;
import com.deportistas.deportistas.DTOS.Persona;
import com.deportistas.deportistas.Repositorios.Repositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServicio {

    private final Repositorio<Persona> personaRepositorio;

    public PersonaServicio() {
        this.personaRepositorio = new Repositorio<>();
    }

    public List<DeportistaDTO> obtenerPersonas(){
        return personaRepositorio.buscarTodos().stream()
                .map(persona -> {
                    DeportistaDTO deportista = new DeportistaDTO();
                    deportista.setNombreCompleto(persona.getNombre() + " " + persona.getApellido());
                    deportista.setDeporte(persona.getDeporte().getNombre());
                    return deportista;
                })
                .collect(Collectors.toList());
    }

    public Persona obtenerPorNombre(String nombre){
        return personaRepositorio.buscarTodos().stream().filter(persona -> persona.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public void agregarPersona(Persona persona) {
        personaRepositorio.agregar(persona);
    }


}
