package org.example.Prenda;

public abstract class Prenda {
    protected String marca;
    protected String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void imprimirInformacion() {
        System.out.println("Prenda de la marca " + marca + "del modelo " + modelo);
    }
}
