package com.ejercicio5.covid19.dto;

import com.ejercicio5.covid19.clases.Sintoma;

import java.util.List;

public class RiesgoDTO {
    private String nombre;
    private String apellido;
    private List<Sintoma> sintomas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }
}
