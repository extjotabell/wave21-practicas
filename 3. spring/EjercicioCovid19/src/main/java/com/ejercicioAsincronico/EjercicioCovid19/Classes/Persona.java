package com.ejercicioAsincronico.EjercicioCovid19.Classes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;

    public Persona() {
        sintomas = new ArrayList<>();
    }

    public Persona(int id, String nombre, String apellido, int edad, List<Sintoma> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public boolean tieneSintomas() {
        return !sintomas.isEmpty();
    }
    public boolean esMayor(){
        return edad >= 60;
    }
}


