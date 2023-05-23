package org.example.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements  Documento {

    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;
    private List<String> habilitades = new ArrayList<>();

    public Curriculum(String nombre, String apellido, String direccion, int edad, List<String> habilitades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.habilitades = habilitades;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public List<String> getHabilitades() {
        return habilitades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setHabilitades(List<String> habilitades) {
        this.habilitades = habilitades;
    }

    @Override
    public void imprimir() {
        System.out.println(String.format("CV de %s %s, con domicilio en %s, de edad %d tiene las siguientes habilidades:", nombre , apellido, direccion, edad));
        for (String habilidad : habilitades) {
            System.out.println(habilidad);
        }
    }

}
