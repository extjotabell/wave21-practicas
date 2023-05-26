package Dakar;

public class Auto extends Vehiculo {
    public Auto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, Integer patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = 1000;
        this.ruedas = 4;
    }
}
