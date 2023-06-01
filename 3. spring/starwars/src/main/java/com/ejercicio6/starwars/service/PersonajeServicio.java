package com.ejercicio6.starwars.service;

import com.ejercicio6.starwars.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeServicio {
     List<PersonajeDTO> getPersonaje(String busqueda);
}
