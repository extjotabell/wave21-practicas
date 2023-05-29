package com.bootcamp.wave21;

public class Moto extends  Vehiculo{

    public Moto(){
        super(300,2);
    }
    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        super(1000,4);
        this.setAceleración(aceleracion);
        this.setPatente(patente);
        this.setVelocidad(velocidad);
        this.setAnguloDeGiro(anguloDeGiro);
    }
}

