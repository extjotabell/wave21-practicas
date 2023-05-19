package org.example;

public class Persona {
    private int númeroDeParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int númeroDeEmergencia;
    private String grupoSanguíneo;

    public Persona(int númeroDeParticipante, int dni, String nombre, String apellido, int edad, int celular, int númeroDeEmergencia, String grupoSanguíneo) {
        this.númeroDeParticipante = númeroDeParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.númeroDeEmergencia = númeroDeEmergencia;
        this.grupoSanguíneo = grupoSanguíneo;
    }

    public Persona() {
    }

    public int getNúmeroDeParticipante() {
        return númeroDeParticipante;
    }

    public void setNúmeroDeParticipante(int númeroDeParticipante) {
        this.númeroDeParticipante = númeroDeParticipante;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNúmeroDeEmergencia() {
        return númeroDeEmergencia;
    }

    public void setNúmeroDeEmergencia(int númeroDeEmergencia) {
        this.númeroDeEmergencia = númeroDeEmergencia;
    }

    public String getGrupoSanguíneo() {
        return grupoSanguíneo;
    }

    public void setGrupoSanguíneo(String grupoSanguíneo) {
        this.grupoSanguíneo = grupoSanguíneo;
    }
}
