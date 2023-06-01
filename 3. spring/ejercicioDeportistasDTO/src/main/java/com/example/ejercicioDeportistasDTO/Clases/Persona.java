package com.example.ejercicioDeportistasDTO.Clases;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte miDeporte;

    public Persona(String nombre, String apellido, int edad, String nombreDeporte, String nivelDeporte) {
        this.miDeporte = new Deporte(nombreDeporte, nivelDeporte);
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    public Persona(String nombre, String apellido, int edad, Deporte unDeporte) {
        this.miDeporte = unDeporte;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    public Persona(String nombre, String apellido, int edad) {
        this.miDeporte = new Deporte();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona() {

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

    public Deporte getMiDeporte() {
        return miDeporte;
    }

    public void setMiDeporte(Deporte miDeporte) {
        this.miDeporte = miDeporte;
    }
}
