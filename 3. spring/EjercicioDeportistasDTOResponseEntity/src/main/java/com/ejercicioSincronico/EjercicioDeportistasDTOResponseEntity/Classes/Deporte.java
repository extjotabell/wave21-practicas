package com.ejercicioSincronico.EjercicioDeportistasDTOResponseEntity.Classes;

import java.util.Random;

public class Deporte {
    //region Variables Privadas
    private int id;
    private String nombre;
    private String nivel;
    //endregion

    //region Getters / Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    //endregion


    //region Constructores
    public Deporte() {
    }

    public Deporte(int id, String nombre, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }
    //endregion
}
