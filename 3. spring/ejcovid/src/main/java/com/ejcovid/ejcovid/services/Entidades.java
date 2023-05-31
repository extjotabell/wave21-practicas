package com.ejcovid.ejcovid.services;

import com.ejcovid.ejcovid.dto.Persona;
import com.ejcovid.ejcovid.dto.PersonaRiesgoDTO;
import com.ejcovid.ejcovid.dto.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Entidades {
    private final ArrayList<Persona> personas;
    private final ArrayList<Sintoma> sintomas;

    public Entidades() {
        // Crear ArrayList de Personas
        this.personas = new ArrayList<>();
        personas.add(new Persona(1, "Juan", "Perez", 13));
        personas.add(new Persona(2, "Pedro", "Rodriguez", 15));
        personas.add(new Persona(3, "Alfonso", "Fernandez", 70));

        // Crear ArrayList de Sintomas
        this.sintomas = new ArrayList<>();
        sintomas.add(new Sintoma(1, "Mareo", "Leve"));
        sintomas.add(new Sintoma(2, "Vomito", "Grave"));
        sintomas.add(new Sintoma(3, "Dolor de Garganta", "Leve"));

    }

    public String searchSymp() {
        return sintomas.toString();
    }

    public String searchSympName(String name) {
        for (Sintoma sintoma : sintomas) {
            if (sintoma.getNombre().equals(name)) {
                return sintoma.getNivel_de_gravedad();
            }
        }

        return "Síntoma no encontrado";
    }

    public String searchPersonaRiesgo() {
        ArrayList<PersonaRiesgoDTO> personasRiesgo = new ArrayList<>();

        for (Persona persona : personas) {
            if (persona.getEdad() > 60) {
                boolean tieneSintomas = false;
                Sintoma sintomaEncontrado = null;

                for (Sintoma sintoma : sintomas) {
                    if (sintoma.getCodigo() == persona.getId()) {
                        tieneSintomas = true;
                        sintomaEncontrado = sintoma;
                        break;
                    }
                }

                if (tieneSintomas) {
                    personasRiesgo.add(new PersonaRiesgoDTO(persona, sintomaEncontrado));
                }
            }
        }

        return personasRiesgo.toString();
    }

}
