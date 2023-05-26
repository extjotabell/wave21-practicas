package org.example;

public class Vehiculo {
    private String marca;
    private String modelo;
    private double costo;

    public Vehiculo(String marca, String modelo, double costs) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costs;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosts(double costs) {
        this.costo = costs;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", costo=" + costo +
                '}';
    }
}
