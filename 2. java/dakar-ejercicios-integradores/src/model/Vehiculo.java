package model;

public abstract class Vehiculo {

    double Velocidad;
    double Aceleracion;
    double AnguloDeGiro;
    String Patente;
    double Peso;
    double Ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, double ruedas) {
        Velocidad = velocidad;
        Aceleracion = aceleracion;
        AnguloDeGiro = anguloDeGiro;
        Patente = patente;
        Peso = peso;
        Ruedas = ruedas;
    }

    public Double calcularValor(){
        return (Velocidad * (Aceleracion / 2)) / (AnguloDeGiro*(Peso - Ruedas * 100));
    }

    public double getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(double velocidad) {
        Velocidad = velocidad;
    }

    public double getAceleracion() {
        return Aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        Aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return AnguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        AnguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String patente) {
        Patente = patente;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public double getRuedas() {
        return Ruedas;
    }

    public void setRuedas(double ruedas) {
        Ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "Velocidad=" + Velocidad +
                ", Aceleracion=" + Aceleracion +
                ", AnguloDeGiro=" + AnguloDeGiro +
                ", Patente='" + Patente + '\'' +
                ", Peso=" + Peso +
                ", Ruedas=" + Ruedas +
                '}';
    }
}
