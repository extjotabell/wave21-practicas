package com.bootcamp.ejercicioCovid.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Person {

    private int id;
    private String name;
    private String lastName;
    private int age;
    private List<Symptom> symptomList;

}