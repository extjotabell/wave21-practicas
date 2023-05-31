package com.ejercicioSincronico.EjercicioDeportistasDTOResponseEntity.Classes;

public class Persona {
    //region Variables Privadas
    private String nombre;
    private String apellido;
    private int edad;
    private int deporteId;
    //endregion


    //region Getters / Setter
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

    public int getDeporteId() {
        return deporteId;
    }

    public void setDeporteId(int deporteId) {
        this.deporteId = deporteId;
    }
    //endregion


    //region Constructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, int deporteId) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporteId = deporteId;
    }
    //endregion
}
