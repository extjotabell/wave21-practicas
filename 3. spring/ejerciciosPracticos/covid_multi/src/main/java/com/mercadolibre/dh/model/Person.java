package com.mercadolibre.dh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long          id;
    private String        name;
    private String        lastName;
    private Integer       age;
    private List<Symptom> symptoms;

    public boolean hasSymptoms () {
        return !this.symptoms.isEmpty();
    }

    @JsonIgnore
    public boolean isOld () {
        return age >= 60;
    }
}
