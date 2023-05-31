package com.bootcamp.sistemaSalud.servicio;

import com.bootcamp.sistemaSalud.dto.PersonaDTO;
import com.bootcamp.sistemaSalud.dto.PersonaRiesgoDTO;
import com.bootcamp.sistemaSalud.entidades.Persona;
import com.bootcamp.sistemaSalud.entidades.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonaService {
List<Persona> personas ;

public PersonaService(){
    personas = new ArrayList<>();
    cargarPersonas();
}

public List<PersonaRiesgoDTO> obtenerPacientesRiesgo() {
    List<PersonaRiesgoDTO> pacientes = new ArrayList<>();

    for (Persona persona : personas) {
        if (persona.getEdad() > 60 && persona.getSintomas().size() > 0) {
            pacientes.add(new PersonaRiesgoDTO(persona.getNombre(), persona.getApellido()));
        }

    }
    return pacientes;
}
public void cargarPersonas(){

    personas.add(new Persona(1,"Juan","Mora",35));
    personas.add(new Persona(2,"Ramiro","Puerta",70));
    personas.add(new Persona(3,"Pedro","Escamoso",53));
    personas.get(0).agregarSintoma(new Sintoma("001125","Dificultad Respiratoria",10));
    personas.get(0).agregarSintoma(new Sintoma("001124","Diarrea",8));
    personas.get(1).agregarSintoma(new Sintoma("001125","Dificultad Respiratoria",10));
    personas.get(1).agregarSintoma(new Sintoma("001124","Diarrea",8));
    personas.get(2).agregarSintoma(new Sintoma("001125","Dificultad Respiratoria",10));
    personas.get(2).agregarSintoma(new Sintoma("001124","Diarrea",8));

}
}
