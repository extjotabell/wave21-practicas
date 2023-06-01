package com.mercadolibre.dh.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.mercadolibre.dh.model.Person;
import com.mercadolibre.dh.model.Symptom;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Getter
public class SymptomRepository {
    private List<Symptom> symptoms;
    private List<Person> people;

    public SymptomRepository() {
        symptoms = new ArrayList<>();
        people = new ArrayList<>();
        initData();
    }

    public Symptom findByName(String name){
        Symptom symptom = symptoms.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);
        return symptom;
    }

    public List<Person> findAllPersonRisk(){
        List<Person> riskPeople = people.stream()
                .filter(p -> p.isOld() && p.hasSymptoms())
                .collect(Collectors.toList());
        return riskPeople;
    }

    private void initData() {
        Symptom headache = new Symptom("S-01", "headache", "Low");
        Symptom queasiness = new Symptom("S-02", "queasiness", "Low");
        Symptom dizziness = new Symptom("S-03", "dizziness", "Low");
        Symptom fatigue = new Symptom("S-04", "fatigue", "Low");
        Symptom musclePain = new Symptom("S-05", "musclePain", "Low");

        Person lenore = new Person(1L, "Lenore", "Shilvock", 25, List.of(headache));
        Person wenona = new Person(1L, "Wenona", "Paddefield", 65, new ArrayList<>());
        Person ade = new Person(1L, "Ade", "Asple", 75, Arrays.asList(dizziness, musclePain));
        Person nicholle = new Person(1L, "Nicholle", "Abrahamsen", 61, Arrays.asList(fatigue, queasiness));

        this.people.addAll(Arrays.asList(lenore, wenona, ade, nicholle));
        this.symptoms.addAll(Arrays.asList(headache, queasiness, dizziness, fatigue, musclePain));
    }

    private List<CharacterSW> getSymptomsJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try{
            File jsonFile = ResourceUtils.getFile("classpath:json_data/symptoms.json");
            return objectMapper.readValue(jsonFile, new TypeReference<>() {});
        }catch (JsonProcessingException e){
            System.out.println("Mal formateo de JSON");
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("No se pudo leer archivo el json");
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
