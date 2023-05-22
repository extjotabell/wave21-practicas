package org.example;

public class NoPerecedero extends Producto{
    String tipo;

    public NoPerecedero(String tipo, String nombre, double precio) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "Producto NoPerecedero{" +
                "nombre='" + this.getNombre() + '\'' +
                ", precio=" + this.getPrecio() + '\'' +
                "tipo='" + tipo +
                '}';
    }
}
