package org.example;

public class Cliente {

    private String nombre;
    private String apellido;
    private  String dni;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public void mostrarDatos() {
        System.out.println("Datos de cliente");
        System.out.println(String.format("NOMBRE: %s ---- APELLIDO: %s ----- DNI: %s", nombre, apellido, dni));
    }

    public String getDni() {
        return dni;
    }
}
