package com.example.covid19.service;

import com.example.covid19.DTO.PersonaRiskDTO;
import com.example.covid19.model.Persona;
import com.example.covid19.model.Symptom;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SymptomService {
    private static final Symptom SYMPTOM1 = new Symptom("S01", "Fever", 5);
    private static final Symptom SYMPTOM2 = new Symptom("S02", "Cough", 3);
    private static final Symptom SYMPTOM3 = new Symptom("S03", "Headache", 2);
    private static final Symptom SYMPTOM4 = new Symptom("S04", "Sore Throat", 1);
    private static final Symptom SYMPTOM5 = new Symptom("S05", "Runny Nose", 1);

    private static final List<Symptom> SYMPTOMS = Arrays.asList(SYMPTOM1, SYMPTOM2, SYMPTOM3, SYMPTOM4, SYMPTOM5);

    private static final Persona PERSONA1 = new Persona("P01", "Juan", "Perez", 25);
    private static final Persona PERSONA2 = new Persona("P02", "Maria", "Gonzalez", 30);
    private static final Persona PERSONA3 = new Persona("P03", "Pedro", "Gomez", 40);
    private static final Persona PERSONA4 = new Persona("P04", "Jose", "Garcia", 70);
    private static final Persona PERSONA5 = new Persona("P05", "Ana", "Lopez", 65);

    private static final List<Persona> PERSONAS = Arrays.asList(PERSONA1, PERSONA2, PERSONA3, PERSONA4, PERSONA5);

    private static final List<Symptom> SYMPTOMS1 = Arrays.asList(SYMPTOM1, SYMPTOM2, SYMPTOM3);
    private static final List<Symptom> SYMPTOMS2 = Arrays.asList(SYMPTOM3, SYMPTOM4, SYMPTOM5);

    private static final List<PersonaRiskDTO> PERSONAS_RIESGO = Arrays.asList(
            new PersonaRiskDTO("P04", "Jose", 70, SYMPTOMS1),
            new PersonaRiskDTO("P05", "Ana", 65, SYMPTOMS2)
    );

    public List<Symptom> getAllSymptoms() {
        return SYMPTOMS;
    }

    public Symptom getSymptomByName(String name) {

        return SYMPTOMS.stream()
                .filter(symptom -> symptom.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<PersonaRiskDTO> getPersonasRiesgo() {
        return PERSONAS_RIESGO;
    }
}
