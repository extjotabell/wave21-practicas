package org.parteI.model;

public class Item {
    private int codigo;
    private String nombrePro;
    private int cantidadCompra;
    private double precioUnitario;

    public Item(int codigo, String nombrePro, int cantidadCompra, double precioUnitario) {
        this.codigo = codigo;
        this.nombrePro = nombrePro;
        this.cantidadCompra = cantidadCompra;
        this.precioUnitario = precioUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombrePro='" + nombrePro + '\'' +
                ", cantidadCompra=" + cantidadCompra +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
