package com.example.demo.repository;

import com.example.demo.model.People;
import com.example.demo.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SymptomRepository {
    private List<Symptom> symptoms;
    private List<People> people;

    public SymptomRepository(List<Symptom> symptoms, List<People> people) {
        this.symptoms = symptoms;
        this.people = people;
        initData();
    }

    public List<Symptom> getSymptoms(){
        return this.symptoms;
    }

    public Symptom findByName(String name){
        // Symptom symptom = symptoms.stream()... y después el return symptom;
        return symptoms.stream().filter(symptom -> symptom.getName().equals(name)).findFirst().orElse(null);
    }

    private void initData(){
        symptoms.add(new Symptom(1, "Dolor muela", 0));
        symptoms.add(new Symptom(2, "Dolor de cabeza", 0));
        symptoms.add(new Symptom(3, "Dolor de garganta", 2));
        symptoms.add(new Symptom(4, "Dolor muscular", 3));
        symptoms.add(new Symptom(5, "Dolor de estómago", 5));
    }
}
