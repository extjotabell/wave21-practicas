package com.example.covid19.DTO;

import com.example.covid19.model.Symptom;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PersonaRiskDTO {
    private String id;
    private String name;
    private int age;
    private List<Symptom> symptoms;

}
