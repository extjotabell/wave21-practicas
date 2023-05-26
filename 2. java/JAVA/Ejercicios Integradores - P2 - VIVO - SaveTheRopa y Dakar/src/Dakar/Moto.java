package Dakar;

public class Moto extends Vehiculo {
    public Moto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, Integer patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = 300;
        this.ruedas = 2;
    }
}
