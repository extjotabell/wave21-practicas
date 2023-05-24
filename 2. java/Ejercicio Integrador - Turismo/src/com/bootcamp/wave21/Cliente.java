package com.bootcamp.wave21;

public class Cliente {

    private String nombre;
    private String dni;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Cliente(Cliente cliente) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\''
                ;
    }
}
