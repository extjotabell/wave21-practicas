package com.bootcamp.sistemaSalud.servicio;

import com.bootcamp.sistemaSalud.dto.PersonaDTO;
import com.bootcamp.sistemaSalud.dto.PersonaRiesgoDTO;
import com.bootcamp.sistemaSalud.entidades.Persona;
import com.bootcamp.sistemaSalud.entidades.Sintoma;
import com.bootcamp.sistemaSalud.repository.SymptomRepo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonaService {
SymptomRepo repo;


public PersonaService(SymptomRepo repo){
 repo = new SymptomRepo();
}

public List<PersonaRiesgoDTO> obtenerPacientesRiesgo() {
    List<PersonaRiesgoDTO> pacientes = new ArrayList<>();

    for (Persona persona : repo.getPersonas()) {
        if (persona.isOld() && persona.hasAnySymptom()) {
            pacientes.add(new PersonaRiesgoDTO(persona.getNombre(), persona.getApellido()));
        }

    }
    return pacientes;
}

}
