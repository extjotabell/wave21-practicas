package com.ejercicioSincronico.EjercicioDeportistasDTOResponseEntity.DTOs;

public class PersonaDTO {
    //region Variables Privadas
    private String nombre;
    private String apellido;
    private String deporte;
    //endregion

    //region Getters / Setters
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

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    //endregion

    //region Constructores
    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }
    //endregion
}
