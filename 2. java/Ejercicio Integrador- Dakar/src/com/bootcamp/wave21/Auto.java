package com.bootcamp.wave21;

public class Auto extends Vehiculo{

    public Auto(){
        super(1000,4);
    }
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        super(1000,4);
        this.setAceleración(aceleracion);
        this.setPatente(patente);
        this.setVelocidad(velocidad);
        this.setAnguloDeGiro(anguloDeGiro);
    }
}
