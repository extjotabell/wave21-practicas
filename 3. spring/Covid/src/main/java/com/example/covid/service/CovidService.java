package com.example.covid.service;

import com.example.covid.clases.PersonSymptoms;
import com.example.covid.clases.Symptom;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidService {
    public static List<Symptom> symptoms = new ArrayList<>();
    public static List<PersonSymptoms> personSymptoms = new ArrayList<>();

    public List<Symptom> findSymptom(){
        return symptoms;
    }

    public Symptom findSymptom(String name){
        return symptoms.stream()
                .filter(symptom -> symptom.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<PersonSymptoms> findRiskPerson(){
        return personSymptoms.stream()
                .filter(personSymptom -> personSymptom.getPerson().getAge() > 60)
                .collect(Collectors.toList());
    }
}
