package com.covid19.covid19.Servicios;

import com.covid19.covid19.DTOS.Persona;
import com.covid19.covid19.Repositorios.Repositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServicio {
    private final Repositorio<Persona> repositorio;

    public PersonaServicio(){
        this.repositorio = new Repositorio<>();
    }

    public ArrayList<Persona> obtenerPersonas(){
        return repositorio.obtenerRepositorio();
    }

    public Persona obtenerPorNombre(String nombre){
        return repositorio.obtenerRepositorio().stream().filter(persona -> persona.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }

    public List<Persona> grupoDeRiesgo(){
        return  repositorio.obtenerRepositorio().stream().filter(persona -> persona.getEdad() > 60 && persona.getSintomas().size() > 0).collect(Collectors.toList());
    }

    public void agregarPersona(Persona persona) {
        repositorio.agregar(persona);
    }
}
