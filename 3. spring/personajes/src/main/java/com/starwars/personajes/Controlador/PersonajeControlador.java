package com.starwars.personajes.Controlador;

import com.starwars.personajes.Entidad.Personaje;
import com.starwars.personajes.Servicio.PersonajeServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeControlador {
    private PersonajeServicio _servicio;

    public PersonajeControlador(PersonajeServicio personajeServicio){
        this._servicio = personajeServicio;
    }

    @GetMapping("/todos")
    public List<Personaje> todos(){
        return this._servicio.todos();
    }

    @GetMapping("/buscar")
    public List<Personaje> todos(@RequestParam String nombre){
        return this._servicio.buscar(nombre);
    }
}
