package com.covid19.covid19.DTOS;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private ArrayList<Sintoma> sintomas;

}
