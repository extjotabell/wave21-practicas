package com.bootcamp.wave21;

import java.util.Date;

public class Habilidad {

    private String descripcion;
    private Date inicio;
    private Date fin;


    public Habilidad() {
    }

    public Habilidad(String descripcion) {
        this.descripcion = descripcion;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
}
