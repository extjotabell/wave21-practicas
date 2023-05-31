package com.example.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Symptom {
    private String code;
    private String name;
    private int severity;
}
