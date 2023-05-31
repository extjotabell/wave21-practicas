package com.example.ejerciciocovid19pg.controllers;

import com.example.ejerciciocovid19pg.dtos.RiskResponseDTO;
import com.example.ejerciciocovid19pg.dtos.SymptomsResponseDTO;
import com.example.ejerciciocovid19pg.entities.Person;
import com.example.ejerciciocovid19pg.entities.Symptom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping
public class Convid19Controller {

    private List<Symptom> symptoms = new ArrayList<>();
    private List<Person> persons = new ArrayList<>();
    private Map<Person, List<Symptom>> personSymptomsMap = new HashMap<>();

    public Convid19Controller(){
        Symptom symptom1 =new Symptom("AAA001","Fever","High");
        symptoms.add(symptom1);
        Symptom symptom2 = new Symptom("AAA002","Cough","Medium");
        symptoms.add(symptom2);
        Symptom symptom3 = new Symptom("AAA003","Headache","Low");
        symptoms.add(symptom3);
        Symptom symptom4 = new Symptom("AAA004","Congestion","High");
        symptoms.add(symptom4);
        Symptom symptom5 = new Symptom("AAA005","Dizziness","Medium");
        symptoms.add(symptom5);

        Person person1 = new Person(1,"Jose","Gonzalez",61);
        persons.add(person1);
        Person person2 = new Person(2,"Pepito","Perez",52);
        persons.add(person2);
        Person person3 = new Person(3,"Rafa","Nadal",16);
        persons.add(person3);
        Person person4 = new Person(4,"Roger","Federer",78);
        persons.add(person4);
        Person person5 = new Person(5,"Cristiano","Ronaldo",22);
        persons.add(person5);

        personSymptomsMap.put(person1, Arrays.asList(symptom1,symptom2));
        personSymptomsMap.put(person2, Arrays.asList(symptom2,symptom3));
        personSymptomsMap.put(person3, List.of(symptom1));
        personSymptomsMap.put(person4, Arrays.asList(symptom4,symptom5));
        personSymptomsMap.put(person5, List.of());


    }

    @GetMapping("/findSymptom")
    public ResponseEntity<?> findSymptom(){
        if (!symptoms.isEmpty()){
            return new ResponseEntity<>(symptoms, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("There are no recorded symptoms.\n", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomName(@PathVariable String name){
        SymptomsResponseDTO result = new SymptomsResponseDTO();
        List<Symptom> symptomFilter = symptoms.stream().filter(s -> s.getName().equalsIgnoreCase(name)).toList();

        if (!symptomFilter.isEmpty()){
            result.setLevel(symptomFilter.get(0).getSeverityLevel());
            result.setName(symptomFilter.get(0).getName());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("There are no symptoms registered with that name.\n", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> findRiskPerson(){
        List<RiskResponseDTO> result = new ArrayList<>();
        personSymptomsMap.forEach((p, s) ->{
            if(s.size() > 0 && p.getAge() >= 60){
                result.add(new RiskResponseDTO(p.getName(),p.getLastname()));
            }
        });
        if(!result.isEmpty()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("There are no people in this category.", HttpStatus.NOT_FOUND);
        }
    }
}
