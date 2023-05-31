package com.example.covid;

import com.example.covid.clases.Person;
import com.example.covid.clases.PersonSymptoms;
import com.example.covid.clases.Symptom;
import com.example.covid.service.CovidService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CovidApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidApplication.class, args);

        Person person = new Person(1, "Matias", "Tato", 23);
        Person person1 = new Person(2, "Pepe", "Gomez", 75);

        Symptom symptom = new Symptom("code1", "Fiebre", 1);
        Symptom symptom1 = new Symptom("code2", "Tos", 3);

        CovidService.symptoms.add(symptom);
        CovidService.symptoms.add(symptom1);
        CovidService.personSymptoms.add(new PersonSymptoms(person, List.of(symptom1)));
        CovidService.personSymptoms.add(new PersonSymptoms(person1, List.of(symptom, symptom1)));
    }

}
