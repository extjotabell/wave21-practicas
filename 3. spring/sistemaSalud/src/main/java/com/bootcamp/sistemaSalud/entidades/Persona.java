package com.bootcamp.sistemaSalud.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;

    public Persona(int id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        sintomas = new ArrayList<>();
    }

    public void agregarSintoma(Sintoma sintoma){
        sintomas.add(sintoma);
    }

    public boolean isOld(){
        return this.edad > 60;
    }

    public boolean hasAnySymptom(){
        return this.sintomas.size() > 0;
    }
}
