package com.bootcamp.ejercicioCovid.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {
    private int code;
    private String name;
    private String severity;
}