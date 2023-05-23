package clases;

public class Vehiculo {
    private String modelo;
    private String marca;
    private int precio;

    public Vehiculo(String modelo, String marca, int precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String toString(){
        return "Marca: " + this.marca + " - Precio: " + this.precio;
    }
}
