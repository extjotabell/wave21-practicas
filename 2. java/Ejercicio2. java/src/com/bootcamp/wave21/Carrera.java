package com.bootcamp.wave21;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private List<Circuito> circuitos = new ArrayList<Circuito>();
    private List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
    private int cantidadParticipantes ;


    public Carrera() {
        this.cantidadParticipantes = 0;
    }

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

    public int getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(int cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   public void mostrar_totales(){
        List<Inscripcion> inscriptosC1 = new ArrayList<Inscripcion>();
       List<Inscripcion> inscriptosC2 = new ArrayList<Inscripcion>();
       List<Inscripcion> inscriptosC3 = new ArrayList<Inscripcion>();
        System.out.println("TOTAL DE PARTICIPANTES POR CIRCUITO");
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getCircuito().getId() == 0){
                inscriptosC1.add(inscripcion);
            }else if (inscripcion.getCircuito().getId() == 1){
                inscriptosC2.add(inscripcion);
            }else{
                inscriptosC3.add(inscripcion);
            }

        }
        System.out.println("CIRCUITO CHICO");
        for(Inscripcion inscripcion: inscriptosC1){
            System.out.println(inscripcion.mostrarInscripcion());
        }

       System.out.println("CIRCUITO MEDIO");
       for(Inscripcion inscripcion: inscriptosC2){
           System.out.println(inscripcion.mostrarInscripcion());

       }

       System.out.println("CIRCUITO GRANDE");
       for(Inscripcion inscripcion: inscriptosC3){
           System.out.println(inscripcion.mostrarInscripcion());

       }

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
