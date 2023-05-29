package Ejercicio_integrador_parte1;

public class Item {
    private int codigo;
    private String nombre;
    private int cantidadcomprada;
    private double costounitario;

    public Item(int codigo, String nombre, int cantidadcomprada, double costounitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadcomprada = cantidadcomprada;
        this.costounitario = costounitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadcomprada() {
        return cantidadcomprada;
    }

    public void setCantidadcomprada(int cantidadcomprada) {
        this.cantidadcomprada = cantidadcomprada;
    }

    public double getCostounitario() {
        return costounitario;
    }

    public void setCostounitario(double costounitario) {
        this.costounitario = costounitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidadcomprada=" + cantidadcomprada +
                ", costounitario=" + costounitario +
                '}';
    }
}
