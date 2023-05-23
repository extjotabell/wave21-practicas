package org.example;

import javax.print.Doc;

public class Curriculum extends Documento implements Imprimir {

    String nombre;
    String apellido;
    int edad;
    String habilidades;

    public Curriculum(String nombre, String apellido, int edad, String habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidades = habilidades;
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void tipoDocumento() {
        System.out.println("Soy un " + getClass().getName());
    }


    @Override
    public void imprimir() {
        System.out.println("Imprimiendo contenido: " + "Nombre = " + getNombre() + ", Apellido = " + getApellido() + ", Edad = " + getEdad() + ", Habilidades = " + getHabilidades());
    }
}
