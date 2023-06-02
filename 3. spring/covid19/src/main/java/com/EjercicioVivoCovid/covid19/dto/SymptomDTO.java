package com.EjercicioVivoCovid.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class SymptomDTO {
    int code;
    String name;
    int level_of_gravity;
}
