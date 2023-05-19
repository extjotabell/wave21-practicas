package com.bootcamp.wave21;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private List<Circuito> circuitos = new ArrayList<Circuito>();
    private List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

    public List<Circuito> getCircuitos() {
        return circuitos;
    }

    public void setCircuitos(List<Circuito> circuitos) {
        this.circuitos = circuitos;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void addInscripcion(Inscripcion inscripcion){

     this.inscripciones.add(inscripcion);

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   public void mostrar_totales(){

        System.out.println("TOTAL DE PARTICIPANTES POR CIRCUITO");
        //ARMAR TOTALES

       System.out.println("TOTAL RECAUDADO");
       System.out.println(this.getTotalMonto());

   }
 private double getTotalMonto(){
        int montoTotal = 0;
        for(Inscripcion inscripcion : inscripciones){

            montoTotal += inscripcion.getMonto();
        }
        return montoTotal;
 }
}
