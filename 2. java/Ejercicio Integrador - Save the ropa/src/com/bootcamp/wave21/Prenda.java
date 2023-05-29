package com.bootcamp.wave21;

public abstract class Prenda {

    protected String marca;
    protected String modelo;

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

    @Override
    public String toString() {
        return
                marca  +"\t\t"
                 + modelo ;
    }
}
