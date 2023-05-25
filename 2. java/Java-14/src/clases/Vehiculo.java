package clases;

public abstract class Vehiculo {
    protected double velocidad;
    protected double aceleracion;
    protected double anguloDeGiro;
    protected String patente;
    protected double peso;
    protected int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }
}
