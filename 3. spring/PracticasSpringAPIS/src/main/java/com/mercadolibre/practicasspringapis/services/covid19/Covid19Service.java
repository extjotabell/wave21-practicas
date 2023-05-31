package com.mercadolibre.practicasspringapis.services.covid19;

import com.mercadolibre.practicasspringapis.dtos.covid19.RiskPersonDTO;
import com.mercadolibre.practicasspringapis.dtos.covid19.SymptomDTO;
import com.mercadolibre.practicasspringapis.models.Person;
import com.mercadolibre.practicasspringapis.models.Symptom;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Covid19Service {

    private List<Symptom> symptoms;
    private List<Person> persons;

    public Covid19Service(){
        this.symptoms = new ArrayList<>(List.of(
                new Symptom(1,"Fiebre","grave"),
                new Symptom(2,"Tos", "leve"),
                new Symptom(3, "Dolor corporal", "intermedia")
        ));
        this.persons = new ArrayList<>(List.of(
                new Person(1,"Gaston","Barro",40, List.of(symptoms.get(0))),
                new Person(2,"Fabrizzio","Camera",25, List.of(symptoms.get(0),symptoms.get(1))),
                new Person(3,"Juan","Perez",76, List.of(symptoms.get(0),symptoms.get(1),symptoms.get(2))),
                new Person(4,"Raul","Fernandez",61, List.of()),
                new Person(5,"Julian","Alvarez",65, List.of(symptoms.get(0),symptoms.get(1),symptoms.get(2))),
                new Person(6,"Gabriel","Batistuta",80, List.of(symptoms.get(0),symptoms.get(1),symptoms.get(2)))
                ));
    }

    public List<SymptomDTO> getSymptoms(){
        return symptoms.stream().map(s -> new SymptomDTO(s.getCode(),s.getName(),s.getSeverity())).collect(Collectors.toList());
    }

    public String getSymptomByName(String name){
        Symptom foundSymptom = symptoms.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        return foundSymptom == null ? "No se encontro el sintoma" : foundSymptom.getSeverity();
    }

    public List<RiskPersonDTO> getRiskPersons(){
        List<Person> foundRiskPersons = persons.stream().filter(p -> p.getAge() >= 60 &&  p.getSymptomList().size() > 0).toList();
        return foundRiskPersons.stream().map(p -> new RiskPersonDTO(p.getName() + " " + p.getLastName())).collect(Collectors.toList());
    }


}
