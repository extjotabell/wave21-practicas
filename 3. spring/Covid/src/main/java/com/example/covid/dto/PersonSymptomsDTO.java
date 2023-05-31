package com.example.covid.dto;

import com.example.covid.clases.Symptom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonSymptomsDTO {
    private String name;
    private int age;
    private List<SymptomDTO> symptoms;
}
