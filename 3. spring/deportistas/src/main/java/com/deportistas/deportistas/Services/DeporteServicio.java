package com.deportistas.deportistas.Services;

import com.deportistas.deportistas.DTOS.Deporte;
import com.deportistas.deportistas.Repositorios.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeporteServicio {
    private final Repositorio<Deporte> deporteRepositorio;

    public DeporteServicio() {
        this.deporteRepositorio = new Repositorio<>();
    }

    public ArrayList<Deporte> obtenerDeportes(){
        return deporteRepositorio.buscarTodos();
    }

    public Deporte obtenerPorNombre(String nombre){
        return deporteRepositorio.buscarTodos().stream().filter(persona -> persona.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }

    public void agregarDeporte(Deporte deporte) {
        deporteRepositorio.agregar(deporte);
    }
}
