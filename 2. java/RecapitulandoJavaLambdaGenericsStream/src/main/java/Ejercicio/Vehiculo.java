package Ejercicio;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int costo;

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCosto() {
        return costo;
    }

    public Vehiculo(String marca, String modelo, int costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "El vehículo es de la marca: " + this.getMarca() + " su modelo es: " + this.getModelo() +  " y su costo es de: " + this.getCosto();
    }
}
