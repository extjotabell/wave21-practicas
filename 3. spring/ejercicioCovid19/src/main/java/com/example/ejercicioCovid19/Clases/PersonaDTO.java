package com.example.ejercicioCovid19.Clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> misSintomas;


}
